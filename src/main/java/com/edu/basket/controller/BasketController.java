package com.edu.basket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.basket.model.BasketDto;
import com.edu.basket.service.BasketService;
import com.edu.member.model.MemberDto;
import com.edu.product.model.ProductDto;

@Controller
public class BasketController {

	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);

	@Autowired
	private BasketService basketService;
	
	@RequestMapping(value="/basketAdd.do", method = RequestMethod.GET)
	public String addBasket(ProductDto productDto
			,Model model
			,HttpSession session
			,@RequestParam(defaultValue = "1") int count) {
		
		logger.info("Welcome OrderController orderaddCtr {} {}", productDto);
		
		//회원 확인
		MemberDto sessMemberDto = (MemberDto)session.getAttribute("memberDto");
		int memNo = sessMemberDto.getNo();
		MemberDto memberDto = basketService.selectMemberOne(memNo);
	
		//상품상세-> 장바구니/ 장바구니 (삭제) 구별
		int productNo = productDto.getNo();
		if(productNo != 0) {
			Map<String,Object> proDto = basketService.selectProduct(productNo);
			ProductDto productDt = (ProductDto) proDto.get("productDto");
			int totalPrice = productDt.getPrice() * count;
			int productCount = count;
			
			int checkCart = basketService.searchSameProduct(productNo,memNo);
			int checkBasket = basketService.searchBasketExist(memNo);
			
			// 0 = 없다. 1 = 있다 
			if(checkBasket !=0 ) {
				//장바구니가 있다.
				if (checkCart != 0) {
					basketService.updateProductBasket(productCount, totalPrice, productNo, memNo);
				}else {
					//최근 장바구니 번호 get
//					int basketGroupNum = basketService.checkBasketGroup(memNo);
					//장바구니 존재 하지 않을시
					basketService.insertProductBasketExist(productCount, totalPrice, 
							productNo, memNo);
				}
			}else {
				//장바구니가 없을시
				if (checkCart != 0) {
					basketService.updateProductBasket(productCount, totalPrice, productNo, memNo);
				}else {

					//장바구니 존재 하지 않을시
					basketService.insertProductBasketNew(productCount, totalPrice, productNo, memNo);
				}
			}
			model.addAttribute("productDt",productDt);
		}
		
		//회원 장바구니 
		List<BasketDto> basketList =  basketService.selectBasketList(memNo);
				
		model.addAttribute("memberDto",memberDto);
		model.addAttribute("productNo",productNo);
		model.addAttribute("sessMemberDto",sessMemberDto);
		model.addAttribute("basketList",basketList);
		
		return "basket/Basket";
	}
	
	@RequestMapping(value="/buyBasket.do", method = RequestMethod.POST)
	public String buyBasket(int no
			,@RequestParam(defaultValue="1") String requestDetail
			,Model model) {
		
		logger.info("Welcome OrderController orderaddCtr {} {}");
		
		List<BasketDto> basketList = basketService.selectBasketListPrice(no);
		MemberDto memberDto = basketService.selectMemberOne(no);
		
	
		
		model.addAttribute("requestDetail",requestDetail);		
		model.addAttribute("memberDto",memberDto);
		model.addAttribute("basketList",basketList);
		
		return "order/OrderBasket";
	}
	
	
	@RequestMapping(value="/deleteBasketOneCtr.do", method = RequestMethod.POST)
	public String deleteBasketOne(int id, Model model) {
		logger.info("Welcome OrderController deleteBasketOneCtr {} {}",id);
		
		basketService.deleteBasketOneCtr(id);
		
		return "redirect:basketAdd.do";
	}
}
