package com.edu.orders.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.orderrequest.model.OrderRequestDto;
//import com.edu.orders.model.AllOrdersDto;
import com.edu.orders.model.OrdersDto;
import com.edu.orders.service.OrdersService;
import com.edu.product.model.ProductDto;
import com.edu.requestdetail.model.RequestDetailDto;
import com.edu.util.Paging;

@Controller
public class OrdersController {

private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping(value="/orderOne.do", method = RequestMethod.GET)
	public String orderOne(@RequestParam(defaultValue = "1") int count,
			HttpSession session
			,@RequestParam(defaultValue="1") String requestDetail
			,int no
			,Model model) {
		
		logger.info("Welcome OrderController orderOne {} {}");
		
		MemberDto sessMemberDto = (MemberDto)session.getAttribute("memberDto");
		int memNo = sessMemberDto.getNo();
		Map<String, Object> memMap = ordersService.selectOneMember(memNo);
		MemberDto memberDto = (MemberDto) memMap.get("memberDto");
		Map<String, Object> map = ordersService.selectOneProduct(no);
		ProductDto productDto = (ProductDto) map.get("productDto");

		int totalPrice = productDto.getPrice();
		totalPrice = totalPrice * count;
		
		Map<String, Object> selectRequest = new HashMap<String, Object>();
		selectRequest.put("requestDetail", requestDetail);
		
		model.addAttribute("selectRequest",selectRequest);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("productDto", productDto);
		model.addAttribute("count",count);
		model.addAttribute("totalPrice",totalPrice);
		
		return "order/OrderOne";
	}
	
	@RequestMapping(value="/orderAddCtr.do", method = RequestMethod.POST)
	public String orderAdd(MemberDto memberDto
			,@RequestParam(defaultValue = "1") int count
			,@RequestParam(defaultValue = "1") String requestDetail
			,String addressDetail
			,String addressMain
			,String orderPhone
			, int totalPrice
			, int productNo 
			, Model model) {
		
		logger.info("Welcome OrderController orderaddCtr {} {}");
		String url = "order/OrderOneDetail";
		
		//????????????
		Map<String, Object> proMap = ordersService.selectOneProduct(productNo);
		ProductDto checkProductDto = (ProductDto) proMap.get("productDto");
		int checkStock = checkProductDto.getStock();
		
		//?????? ??????	 //?????? ??????
		int memNo = memberDto.getNo();
		Map<String, Object> memMap = ordersService.selectOneMember(memNo);
		memberDto = (MemberDto) memMap.get("memberDto");
		
		//?????? ????????? ??????
		int checkUserPoint = memberDto.getPoint();
		
		if(count > checkStock) {
			//?????? ??????
			url = "common/OrderFail";
			model.addAttribute("productNo",productNo);
		}else {
			if(checkUserPoint < totalPrice) {
			//??????
				url = "member/MyPage";
//				break;
			}else {
				//??????, ?????? ?????? ?????? ??????
				ordersService.updateProductOrder(productNo, count);
				ordersService.updateUserPoint(memNo, totalPrice);
				
				//?????? ??????
				int orderState  = 1;
				ordersService.orderInsertOne(totalPrice, memNo, productNo, count, orderState);
				
				//?????? ?????? ?????? ?????? ??????
				Map<String, Object> ordersMap =  ordersService.selectRecentOrder(memNo);
				OrdersDto ordersDto = (OrdersDto) ordersMap.get("ordersDto");

				//?????? ?????? ??????
				int orderNum = ordersDto.getNo();
				Map<String, Object> orderMap =  ordersService.selectOrderOne(orderNum);
				OrdersDto orders = (OrdersDto) orderMap.get("ordersDto");
				
				//?????? ?????? orderrequest ??????
				ordersService.insertOrderOneReq(orderNum, memNo, requestDetail
							, addressMain, addressDetail, orderPhone);
				
				//?????? ?????? req ????????????
				OrderRequestDto recentOrder = ordersService.selectRecentOrderReq(orderNum,memNo);
				int requestDetailNum = recentOrder.getReqNo();
				
				RequestDetailDto reqDetailDto = ordersService.selectOneReq(requestDetailNum);
				

				model.addAttribute("totalPrice",totalPrice);
				model.addAttribute("reqDetailDto",reqDetailDto);
				model.addAttribute("recentOrder",recentOrder);
				model.addAttribute("ordersMap",ordersMap);
				model.addAttribute("count",count);
				model.addAttribute("productDto",checkProductDto);
				
			}
		}
		model.addAttribute("memberDto",memberDto);
		return url;
	}
	
	@RequestMapping(value="/orderBasketAddCtr.do", method = RequestMethod.POST)
	public String orderBasket( int no
			,@RequestParam(defaultValue="1") String requestDetail
			,int sum
			,String addressDetail
			,String addressMain
			,String orderPhone
			,Model model) {
	
		logger.info("Welcome OrderController orderBasketAddCtr {} {}", no, sum);
		String url = "redirect:/orderHistoryList.do";
		
		int totalPriceSum = 0;
		int orderState = 1;
		
		//?????? ???????????? ?????? ????????????
		List<BasketDto> basketList = ordersService.selectBasketList(no);
		
		//??????no, ???????????? ?????? ?????????
		Map<String, Object> memMap = ordersService.selectOneMember(no);
		MemberDto memberDto = (MemberDto) memMap.get("memberDto");
		int checkUserPoint = memberDto.getPoint();
		

		for (int i = 0; i < basketList.size(); i++) {
			//???????????? ???????????? ??????
			int productNo = basketList.get(i).getProductNo();
			Map<String, Object> proMap = ordersService.selectOneProduct(productNo);
			ProductDto checkProductDto = (ProductDto) proMap.get("productDto");
			int checkStock = checkProductDto.getStock();
			
			int productBuyCount = basketList.get(i).getProductCount();
			
			//????????? ??????
			totalPriceSum += basketList.get(i).getTotalPrice();
	
			if(productBuyCount > checkStock) {
				url = "common/OrderFail";
				model.addAttribute("productNo", productNo);
				break;	
			}else {
//				????????? ????????? < ???????????????
				if(checkUserPoint < sum){
					url = "member/MyPage";
					break;
				}else {
					//????????? ?????? ????????? , ?????? ?????? ??????
					ordersService.updateProductOrder(productNo, productBuyCount);
					ordersService.updateUserPoint(no, totalPriceSum);
					
					
					
					OrdersDto ordersDto = new OrdersDto(no, orderState);
					ordersDto.setTotalPrice(basketList.get(i).getTotalPrice());
					ordersDto.setProductNo(basketList.get(i).getProductNo());
					ordersDto.setProductCount(basketList.get(i).getProductCount());
					
					
					if(i == 0) {						
						ordersService.setOrdersBasketFirst(ordersDto);
						
					}else {
						int groupNo = ordersService.selectMaxGroupNum(no);
						ordersDto.setOrderGroup(groupNo);
						ordersService.setOrdersBasket(ordersDto);
					}
					
					Map<String, Object> ordersMap =  ordersService.selectRecentOrder(no);
					OrdersDto recentOrdersDto = (OrdersDto) ordersMap.get("ordersDto");
					int recentOrderNum = recentOrdersDto.getNo();
					
					ordersService.insertOrderOneReq(recentOrderNum, no, requestDetail
							, addressMain, addressDetail, orderPhone);
					
					
				}
			}
		}
		ordersService.deleteBasket(no);
		
//		Map<String, Object> getGroupNum =  ordersService.selectRecentOrder(no);
//		int groupNum = ((OrdersDto) getGroupNum.get("ordersDto")).getOrderGroup();
//		
//		//?????????????????? ????????? ?????? ??????(?????? ?????????)
//		List<Integer> ordersList = ordersService.selectByOrdersGroup(groupNum);
//		
//		List<OrderRequestDto> orderRequestList = new ArrayList<OrderRequestDto>();
//		
//		for (int j = 0; j < ordersList.size(); j++) {
//			
//			int getOrdersno = ordersList.get(j);
//			orderRequestList = ordersService.selectOrdersRequest(getOrdersno);
//		}
//		
//		
//		model.addAttribute("memberDto", memberDto);
//		model.addAttribute("orderRequestList", orderRequestList);
//		model.addAttribute("ordersList",ordersList);
//		
		
		model.addAttribute("memberDto",memberDto);
		return url;
	}
	
	
	@RequestMapping(value="/orderHistoryList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String orderHistory(
			@DateTimeFormat(pattern="yyyy-MM-dd")  Date startDate
			,@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate
			,@RequestParam(defaultValue = "1") int curPage
			,HttpSession session
			,Model model) {
//		@RequestParam(defaultValue="") 
		
		logger.info("Welcome OrderController orderHistoryList {} {}", model, endDate);
		logger.info("Welcome OrderController orderHistoryList {} {}", curPage, startDate);
		
		MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
		int membersNo = memberDto.getNo();
		
		Map<String, Object> memMap = ordersService.selectOneMember(membersNo);
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date exdate = new Date();
		String sDate = "";
		String eDate = "";
		
		if(startDate == null && endDate == null) {
			String dateEx = transFormat.format(exdate);
			sDate = dateEx.substring(0,4);
			eDate = dateEx.substring(5,7);
			
			String yearMonth = sDate + "-" + eDate + "-";
			sDate = yearMonth + "01";
			
			GregorianCalendar today = new GregorianCalendar ( );
			int maxday = today.getActualMaximum ( ( today.DAY_OF_MONTH ) );
			
			eDate = yearMonth +  maxday;
		}
		else {
			sDate = transFormat.format(startDate);
			eDate = transFormat.format(endDate);
		}
		
		
		
		int totalCount = ordersService.ordersTotalcount(membersNo, sDate, eDate);
		
		Paging ordersPaging = new Paging(totalCount,curPage);
		int start = ordersPaging.getPageBegin();
		int end = ordersPaging.getPageEnd();
		
		List<Map<String,Object>> ordersMemberList = 
				ordersService.selectOrderHistory(membersNo, start,
									end, sDate, eDate);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", ordersPaging);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("startDate", sDate);
		searchMap.put("endDate", eDate);
		
		model.addAttribute("memberDto", memMap);
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("ordersMemberList", ordersMemberList);
		return "order/OrdersHistoryList";
	}
	
	
	
	@RequestMapping(value="/orderGroupDetail.do", method= RequestMethod.GET)
	public String orderGroupHistory(int no
			,int curPage
			,@DateTimeFormat(pattern="yyyy-MM-dd")  Date startDate
			,@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate
			,HttpSession session
			,Model model) {
		
		logger.info("Welcome OrderController orderGroupDetail! - "
				+ "orderNum:  curPage {} {}", no , curPage);
		
		Map<String, Object> groupDto = ordersService.selectOrderOne(no);
		OrdersDto orderGroup =  (OrdersDto) groupDto.get("ordersDto");
		int groupNum = orderGroup.getOrderGroup();
		
		List<Map<String, Object>> orderGroupList 
					= ordersService.selectOrderListByGroup(groupNum);
	
		MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
		int membersNo = memberDto.getNo();
		Map<String, Object> memMap = ordersService.selectOneMember(membersNo);
		MemberDto lastMem = (MemberDto) memMap.get("memberDto");
		
		Map<String, Object> orderRequest = ordersService.selectOneRequest(no);
	
		
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date exdate = new Date();
		String sDate = "";
		String eDate = "";
		
		if(startDate == null && endDate == null) {
			String dateEx = transFormat.format(exdate);
			sDate = dateEx.substring(0,4);
			eDate = dateEx.substring(5,7);
			
			String yearMonth = sDate + "-" + eDate + "-";
			sDate = yearMonth + "01";
			
			GregorianCalendar today = new GregorianCalendar ( );
			int maxday = today.getActualMaximum ( ( today.DAY_OF_MONTH ) );
			
			eDate = yearMonth +  maxday;
		}
		else {
			sDate = transFormat.format(startDate);
			eDate = transFormat.format(endDate);
		}
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("startDate", sDate);
		searchMap.put("endDate", eDate);
		
		model.addAttribute("orderRequest", orderRequest);
		model.addAttribute("orderGroupList", orderGroupList);
		model.addAttribute("lastMem",lastMem);
		model.addAttribute("curPage",curPage);
		model.addAttribute("searchMap", searchMap);
		
		return "order/OrderGroupDetail";
		
	}
	
	
//	?????? ?????? ???????????? ??????
	
	
	@RequestMapping(value = "/memberOrderAllHistory.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectOrderAllHistory(@RequestParam(defaultValue = "1") int curPage
//			,@DateTimeFormat(pattern="yyyy-MM-dd")  Date startDate
//			,@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate
			,@RequestParam(defaultValue = "id") String searchOption
			,@RequestParam(defaultValue = "") String keyword,
			Model model) {
		logger.info("Welcome MemberController memberList! : {} {}", searchOption, keyword);
		
		if("id".equals(searchOption)){
			searchOption = "members_id";
		}
		
		// ?????? ????????? ??????
//		int totalCount = ordersService.selectOrderHistoryCount(searchOption, keyword, 
//					startDate, endDate);
		int totalCount = ordersService.selectOrderHistoryCount(searchOption, keyword);
		
		


//		 ????????? ????????? ?????? ??????
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();

//		List<Map<String, Object>> allOrdersList = 
//				ordersService.selectOrderAllHistory(searchOption, keyword, start,
//				end, startDate, endDate);
		
		List<Map<String, Object>> allOrdersList = 
				ordersService.selectOrderAllHistory(searchOption, keyword, start, end);
		
		
		
		if("members_id".equals(searchOption)){
			searchOption = "id";
		}
		

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyword", keyword);

		
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("allOrdersList", allOrdersList);
		model.addAttribute("pagingMap", pagingMap);
//		
		return "admin/MemberOrderAllHistory";
	}
	
}
