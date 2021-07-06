package com.edu.orders.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.patterns.OrSignaturePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.orderrequest.model.OrderRequestDto;
import com.edu.orders.dao.OrdersDao;
//import com.edu.orders.model.AllOrdersDto;
import com.edu.orders.model.OrdersDto;
import com.edu.product.model.ProductDto;
import com.edu.requestdetail.model.RequestDetailDto;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	public OrdersDao ordersDao;

	@Override
	public Map<String, Object> selectOneProduct(int no) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ProductDto productDto = ordersDao.selectOneProduct(no);
		resultMap.put("productDto", productDto);

		return resultMap;
		
	}

	@Override
	public Map<String, Object> selectOneMember(int no) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		MemberDto memberDto = ordersDao.selectOneMember(no);
		resultMap.put("memberDto", memberDto);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectRecentOrder(int memNo) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		OrdersDto ordersDto = ordersDao.selectRecentOrder(memNo);
		
		resultMap.put("ordersDto", ordersDto);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectOrderOne(int orderNum) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		OrdersDto ordersDto = ordersDao.selectOrderOne(orderNum);
		
		resultMap.put("ordersDto", ordersDto);
		
		return resultMap;
	}

//	@Override
//	public void insertOrderDetail(OrderDetailDto orderDetailDto) {
//		// TODO Auto-generated method stub
//		ordersDao.insertOrderDetail(orderDetailDto);
//	}

//	@Override
//	public Map<String, Object> selectOrderDetailOne(int orderNum) {
//		// TODO Auto-generated method stub
//		Map<String, Object> resultMap = new HashMap<String, Object>();
////		OrderDetailDto ordersDetailDto = ordersDao.selectOrderDetailOne(orderNum);
//		resultMap.put("ordersDetailDto", ordersDetailDto);
//		
//		
//		return resultMap;
//	}

	@Override
	public void updateProductOrder(int no, int salesRate) {
		// TODO Auto-generated method stub
		ordersDao.updateProductOrder(no, salesRate);
		
	}

	@Override
	public void updateUserPoint(int no, int totalPrice) {
		// TODO Auto-generated method stub
		ordersDao.updateUserPoint(no,totalPrice);
	}

	@Override
	public List<BasketDto> selectBasketList(int membersNo) {
		// TODO Auto-generated method stub
		return ordersDao.selectBasketList(membersNo);
	}

	@Override
	public void orderInsertOne(int totalPrice, int memNo, int productNo,
				int count, int orderState) {
		// TODO Auto-generated method stub
		
		ordersDao.orderInsertOne(totalPrice, memNo, productNo, count, orderState);
		
	}

	@Override
	public void orderAddrequest(int basketnum, String request,int no) {
		// TODO Auto-generated method stub
		ordersDao.orderAddrequest(basketnum, request, no);	
	}

	@Override
	public int checkBasketGroup(int memNo) {
		// TODO Auto-generated method stub
		return ordersDao.checkBasketGroup(memNo);
	}

	@Override
	public List<BasketDto> selectBasketGroup(int membersNo) {
		// TODO Auto-generated method stub
		return ordersDao.selectBasketGroup(membersNo);
	}

	@Override
	public void setOrdersBasketFirst(OrdersDto ordersDto) {
		// TODO Auto-generated method stub
		ordersDao.setOrdersBasketFirst(ordersDto);
	}

	@Override
	public List<OrdersDto> selectOrdersBasketOneList(int basketnum, int no) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrdersBasketOneList(basketnum,no);
	}

	@Override
	public OrderRequestDto findOrderRequest(int basketnum, int no) {
		// TODO Auto-generated method stub
		return ordersDao.findOrderRequest(basketnum, no);
	}

	@Override
	public void insertOrderOneReq(int orderNum, int memNo, String requestDetail, String addressMain, String addressDetail,
			String phone) {
		ordersDao.insertOrderOneReq(orderNum, memNo, requestDetail, addressMain, addressDetail, phone);
		
	}

	@Override
	public OrderRequestDto selectRecentOrderReq(int orderNum, int memNo) {
		// TODO Auto-generated method stub
		return ordersDao.selectRecentOrderReq(orderNum, memNo);
	}

	@Override
	public RequestDetailDto selectOneReq(int requestDetailNum) {
		// TODO Auto-generated method stub
		return ordersDao.selectOneReq(requestDetailNum);
	}

	@Override
	public int selectMaxGroupNum(int no) {
		// TODO Auto-generated method stub
		return ordersDao.selectMaxGroupNum(no);
	}

	@Override
	public void setOrdersBasket(OrdersDto ordersDto) {
		// TODO Auto-generated method stub
		ordersDao.setOrdersBasket(ordersDto);
		
	}

	@Override
	public List<Integer> selectByOrdersGroup(int groupNum) {
		// TODO Auto-generated method stub
		return ordersDao.selectByOrdersGroup(groupNum);
	}

	@Override
	public List<OrderRequestDto> selectOrdersRequest(int getOrdersno) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrdersRequest(getOrdersno);
	}

	@Override
	public void deleteBasket(int no) {
		// TODO Auto-generated method stub
		ordersDao.deleteBasket(no);
	}

	@Override
	public int ordersTotalcount(int membersNo, String startDate, String endDate) {
		// TODO Auto-generated method stub
		
		return ordersDao.ordersTotalcount(membersNo, startDate, endDate);
	}

	@Override
	public List<Map<String, Object>> selectOrderHistory(int membersNo, 
			int start, int end, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrderHistory(membersNo, start, end, startDate, endDate);
	}

	@Override
	public List<Map<String, Object>> selectOrderListByGroup(int groupNum) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrderListByGroup(groupNum);
	}

	@Override
	public Map<String, Object> selectOneRequest(int no) {
		// TODO Auto-generated method stub
		return ordersDao.selectOneRequest(no);
	}

	@Override
	public int selectOrderHistoryCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrderHistoryCount(searchOption,keyword);
	}

	@Override
	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, String keyword
			, int start, int end) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrderAllHistory(searchOption,keyword,start,end);
	}
	
//	@Override
//	public int selectOrderHistoryCount(String searchOption, String keyword, Date startDate, Date endDate) {
//		// TODO Auto-generated method stub
//		return ordersDao.selectOrderHistoryCount(searchOption,keyword,startDate,endDate);
//	}
	
//	@Override
//	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, String keyword
//			, int start, int end,Date startDate, Date endDate) {
//		// TODO Auto-generated method stub
//		return ordersDao.selectOrderAllHistory(searchOption,keyword,start,end, startDate, endDate);
//	}
	

//	@Override
//	public int selectorderhistorycount(String searchOption, String keyword) {
//		// TODO Auto-generated method stub
//		return ordersDao.selectorderhistorycount(searchOption, keyword);
//	}

//	@Override
//	public List<AllOrdersDto> selectOrderAllHistory(int start, int end) {
//		// TODO Auto-generated method stub
//		return ordersDao.selectOrderAllHistory(start, end);
//	}


}
