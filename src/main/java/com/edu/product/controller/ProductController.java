package com.edu.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;
import com.edu.product.model.ProductDto;
import com.edu.product.service.ProductService;
import com.edu.util.Paging;

@Controller
public class ProductController {

private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/productList.do",
			method= {RequestMethod.GET, RequestMethod.POST})
	public String productList(HttpSession session, Model model
			, @RequestParam(defaultValue = "1") int curPage
			, @RequestParam(defaultValue="name") String searchOption
			, @RequestParam(defaultValue="") String keyword) {
		
		logger.info("Welcome ProductController productList! {} {}", curPage,keyword);
		
		
		if("name".equals(searchOption)) {
			searchOption = "product_name";
		}
		
		int totalCount = productService.productSelectTotalCount(searchOption, keyword);
		
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();
		
		List<ProductDto> productList = 
				productService.productSelectList(searchOption, keyword, start, end);
		
		if("product_name".equals(searchOption)) {
			searchOption = "name";
		}
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyword", keyword);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);
		
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("productList",productList);
		return "product/ProductList";
	}
	
	@RequestMapping(value="/productListAdmin.do",
			method= {RequestMethod.GET, RequestMethod.POST})
	public String productListAdmin(HttpSession session, Model model
			, @RequestParam(defaultValue = "1") int curPage
			, @RequestParam(defaultValue="name") String searchOption
			, @RequestParam(defaultValue="") String keyword) {
		
		logger.info("Welcome ProductController productList! {} {}", curPage,keyword);
		
		
		if("name".equals(searchOption)) {
			searchOption = "product_name";
		}
		
		int totalCount = productService.productSelectTotalCount(searchOption, keyword);
		
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();
		
		List<ProductDto> productList = 
				productService.productSelectList(searchOption, keyword, start, end);
		
		if("product_name".equals(searchOption)) {
			searchOption = "name";
		}
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyword", keyword);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);
		
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("productList",productList);
		return "product/ProductAdminList";
	}
	
	
	
	@RequestMapping(value="/productAdd.do", method = RequestMethod.GET)
	public String productAdd(Model model) {
		return "product/ProductAdd";
		
	}
	
	@RequestMapping(value="/productAddCtr.do", method=RequestMethod.POST)
	public String productAddCtr(ProductDto productDto, 
			MultipartHttpServletRequest mulRequest,	Model model) {
		logger.info("Welcome ProductController productAddCtr! {}", productDto);
		
		try {
			String backId  = UUID.randomUUID().toString().replace("-", "").
					substring(0, 4);
			System.out.println(backId);
			productDto.setId("P12" + backId);
			productDto.setSales_rate(0);
			productDto.setState(1);
			
			productService.productInsertOne(productDto, mulRequest);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return "redirect:/productList.do";
		}
	
	@RequestMapping(value="/productDetail.do", method = RequestMethod.GET)
	public String productDetail(int no, Model model) {
		
		logger.info("Welcome ProductController productDetail! - "
				+ "no: {}", no);
		
		Map<String, Object> map = productService.productSelectOne(no);
		
		ProductDto productDto = (ProductDto) map.get("productDto");
		List<Map<String, Object>> fileList = 
				(List<Map<String, Object>>) map.get("fileList");
		
		model.addAttribute("productDto", productDto);
		model.addAttribute("fileList", fileList);
		logger.info("Welcome ProductController productDetail! - "
				+ "model: {}", model);
		
		return "product/ProductDetail";
	}
	
	
	@RequestMapping(value="/productUpdate.do", method=RequestMethod.GET)
	public String productUpdate(int no, Model model) {
		logger.info("Welcome ProductController productupdate! no: {}", no);
		Map<String, Object> map = productService.productSelectOne(no);
		
		ProductDto productDto = (ProductDto) map.get("productDto");
		List<Map<String, Object>> fileList = 
				(List<Map<String, Object>>) map.get("fileList");
		
		model.addAttribute("productDto", productDto);
		model.addAttribute("fileList", fileList);

		return "product/ProductUpdate";
	}
	


	@RequestMapping(value="/productUpdateCtr.do", method=RequestMethod.POST)
	public String productUpdateCtr(ProductDto productDto
			, @RequestParam(value="fileIdx", defaultValue="-1") int fileIdx
			, MultipartHttpServletRequest multipartHttpServletRequest
			, Model model) {
		logger.info("Welcome ProductController productUpdateCtr! {}"
				, productDto);
		int resultNum = 0;
		
		try {
			resultNum = productService.productUpdateOne(productDto,
							multipartHttpServletRequest, fileIdx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		model.addAttribute("productDto",productDto);
		return "common/UpdateSuccess";
	}
	
	
	@RequestMapping(value = "/productDeleteCtr.do", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String memberDeleteCtr(int no
			, Model model) {
		logger.info("Welcome MemberController memberDeleteCtr! {} ", no);

		productService.productDeleteOne(no);
		
		return "redirect:/productList.do";
	}
	
}
