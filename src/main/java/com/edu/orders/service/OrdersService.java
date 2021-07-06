package com.edu.orders.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.orderrequest.model.OrderRequestDto;
//import com.edu.orders.model.AllOrdersDto;
import com.edu.orders.model.OrdersDto;
import com.edu.product.model.ProductDto;
import com.edu.requestdetail.model.RequestDetailDto;

public interface OrdersService {

	public Map<String, Object> selectOneProduct(int no);

	public Map<String, Object> selectOneMember(int no);
	
	public Map<String, Object> selectRecentOrder(int memNo);

	public Map<String, Object> selectOrderOne(int orderNum);

//	public void insertOrderDetail(OrderDetailDto orderDetailDto);

//	public Map<String, Object> selectOrderDetailOne(int orderNum);

	public void updateProductOrder(int no, int salesRate);

	public void updateUserPoint(int no, int totalPrice);

	//멤버 장바구니 전체 select
	public List<BasketDto> selectBasketList(int no);

	public void orderInsertOne(int totalPrice, int memNo, int productNo
					, int count, int orderState);

	public void orderAddrequest(int basketnum, String request, int no);

	public int checkBasketGroup(int memNo);

	public List<BasketDto> selectBasketGroup(int membersNo);

	public void setOrdersBasketFirst(OrdersDto ordersDto);

	public List<OrdersDto> selectOrdersBasketOneList(int basketnum, int no);

	public OrderRequestDto findOrderRequest(int basketnum, int no);

	public void insertOrderOneReq(int orderNum, int memNo, String requestDetail, String addressMain, String addressDetail,
			String phone);

	public OrderRequestDto selectRecentOrderReq(int orderNum, int memNo);

	public RequestDetailDto selectOneReq(int requestDetailNum);

	public int selectMaxGroupNum(int no);

	public void setOrdersBasket(OrdersDto ordersDto);

	public List<Integer> selectByOrdersGroup(int groupNum);

	public List<OrderRequestDto> selectOrdersRequest(int getOrdersno);

	public void deleteBasket(int no);

	public List<Map<String,Object>> selectOrderHistory(int membersNo, int start, int end,
			String startDate, String endDate);

	public int ordersTotalcount(int membersNo, String startDate, String endDate);

	public List<Map<String, Object>> selectOrderListByGroup(int groupNum);

	public Map<String, Object> selectOneRequest(int no);

	

//	public int selectorderhistorycount(String searchOption, String keyword);
//	public List<AllOrdersDto> selectOrderAllHistory(int start, int end);

	public int selectOrderHistoryCount(String searchOption, String keyword);
	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, String keyword, int start, int end);
//	public int selectOrderHistoryCount(String searchOption, String keyword, Date startDate, Date endDate);
	//	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, String keyword, int start, int end,
//			Date startDate, Date endDate);

}
