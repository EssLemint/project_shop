package com.edu.orders.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.orderrequest.model.OrderRequestDto;
//import com.edu.orders.model.AllOrdersDto;
import com.edu.orders.model.OrdersDto;
import com.edu.product.model.ProductDto;
import com.edu.requestdetail.model.RequestDetailDto;

@Repository
public class OrdersDaoImpl implements OrdersDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.orders.";
	String memNameSpace = "com.edu.members.";
	String basketNameSpace = "com.edu.basket.";
	String requestNameSpace = "com.edu.orderrequest.";
	String reqDetailNameSpace = "com.edu.requestdetail.";
	
	@Override
	public ProductDto selectOneProduct(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOneProduct", no);
	}

	@Override
	public MemberDto selectOneMember(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOneMember", no) ;
	}

	@Override
	public OrdersDto selectRecentOrder(int memNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectRecentOrder",memNo);
	}

	@Override
	public OrdersDto selectOrderOne(int orderNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOrderOne",orderNum);
	}

//	@Override
//	public int insertOrderDetail(OrderDetailDto orderDetailDto) {
//		// TODO Auto-generated method stub
//		return sqlSession.insert(namespace + "insertOrderDetail", orderDetailDto);
//	}
//
//	@Override
//	public OrderDetailDto selectOrderDetailOne(int orderNum) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectOne(namespace + "selectOrderDetailOne", orderNum);
//	}

	@Override
	public void updateProductOrder(int no, int salesRate) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("salesRate", salesRate);
		sqlSession.update(namespace + "updateProductOrder", map);
	}

	@Override
	public void updateUserPoint(int no, int totalPrice) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("totalPrice", totalPrice);
		sqlSession.update(namespace + "updateUserPoint", map);
		
	}

	@Override
	public List<BasketDto> selectBasketList(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(basketNameSpace + "selectBasketList", membersNo);
	}

	@Override
	public void orderInsertOne(int totalPrice, int memNo, int productNo,
			int count,int orderState) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPrice", totalPrice);
		map.put("membersNo", memNo);
		map.put("productNo", productNo);
		map.put("productCount", count);
		map.put("orderState", orderState);
		
		sqlSession.insert(namespace + "orderInsertOne", map);
		
	}

	@Override
	public void orderAddrequest(int basketnum, String request, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("basketnum", basketnum);
		map.put("request", request);
		map.put("membersNo", no);
		sqlSession.insert(requestNameSpace + "orderAddrequest", map);
	}

	@Override
	public int checkBasketGroup(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(basketNameSpace + "checkBasketGroup", membersNo);
	}

	@Override
	public List<BasketDto> selectBasketGroup(int membersNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("membersNo", membersNo);
		return sqlSession.selectList(namespace + "selectBasketGroup",membersNo) ;
	}

	@Override
	public void setOrdersBasketFirst(OrdersDto ordersDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + "setOrdersBasketFirst", ordersDto);  
		
	}

	@Override
	public List<OrdersDto> selectOrdersBasketOneList(int basketnum, int membersNo) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("basketnum", basketnum);
		map.put("membersNo", membersNo);
		return sqlSession.selectList(namespace + "selectOrdersBasketOneList", map);
	}

	@Override
	public OrderRequestDto findOrderRequest(int basketnum, int no) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("basketnum", basketnum);
		map.put("membersNo", no);
		return sqlSession.selectOne(requestNameSpace + "findOrderRequest", map) ;
	}

	@Override
	public void insertOrderOneReq(int orderNum, int memNo, String requestDetail, String addressMain, String addressDetail,
			String phone) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordersNo", orderNum);
		map.put("membersNo", memNo);
		map.put("reqNo", requestDetail);
		map.put("ordersAddressMain", addressMain);
		map.put("ordersAddressDetail", addressDetail);
		map.put("ordersPhone", phone);
		
		sqlSession.insert(requestNameSpace + "insertOrderOneReq", map);
		
	}

	@Override
	public OrderRequestDto selectRecentOrderReq(int orderNum, int memNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordersNo", orderNum);
		map.put("membersNo", memNo);
		
		return sqlSession.selectOne(requestNameSpace + "selectRecentOrderReq",map);
	}

	@Override
	public RequestDetailDto selectOneReq(int reqNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(reqDetailNameSpace + "selectOneReq", reqNo);
	}

	@Override
	public int selectMaxGroupNum(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectMaxGroupNum", membersNo);
	}

	@Override
	public void setOrdersBasket(OrdersDto ordersDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + "setOrdersBasket",ordersDto);
		
	}

	@Override
	public List<Integer> selectByOrdersGroup(int orderGroup) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectByOrdersGroup", orderGroup);
	}

	@Override
	public List<OrderRequestDto> selectOrdersRequest(int ordersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(requestNameSpace + "selectOrdersRequest",ordersNo);
	}

	@Override
	public void deleteBasket(int membersNo) {
		// TODO Auto-generated method stub
		sqlSession.delete(basketNameSpace + "deleteBasket", membersNo);
	}

	@Override
	public int ordersTotalcount(int membersNo,String startDate, String endDate) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("membersNo", membersNo);
		
		return sqlSession.selectOne(namespace + "ordersTotalcount", map);
	}

	@Override
	public List<Map<String, Object>> selectOrderHistory(int membersNo, int start
			, int end, String startDate,
			String endDate) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("membersNo", membersNo);
		map.put("start", start);
		map.put("end", end);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return sqlSession.selectList(namespace + "selectOrderHistory", map);
	}

	@Override
	public List<Map<String, Object>> selectOrderListByGroup(int groupNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectOrderListByGroup", groupNum);
	}

	@Override
	public Map<String, Object> selectOneRequest(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(requestNameSpace + "selectOneRequest", no);
	}

	@Override
	public int selectOrderHistoryCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace + "selectOrderHistoryCount", map);
	}

	@Override
	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, 
			String keyword, int start, int end) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "selectOrderAllHistory", map);
	}
	
//	@Override
//	public List<Map<String, Object>> selectOrderAllHistory(String searchOption, 
//			String keyword, int start, int end,
//			Date startDate, Date endDate) {
//		// TODO Auto-generated method stub
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//		
//		Date exdate = new Date();
//		String sDate = "";
//		String eDate = "";
//		
//		if(startDate == null && endDate == null) {
//			String dateEx = transFormat.format(exdate);
//			sDate = dateEx.substring(0,4);
//			eDate = dateEx.substring(5,7);
//			
//			String yearMonth = sDate + "-" + eDate + "-";
//			sDate = yearMonth + "01";
//			
//			GregorianCalendar today = new GregorianCalendar ( );
//			int maxday = today.getActualMaximum ( ( today.DAY_OF_MONTH ) );
//			
//			eDate = yearMonth +  maxday;
//		}
//		else {
//			sDate = transFormat.format(startDate);
//			eDate = transFormat.format(endDate);
//		}
//		
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		
//		map.put("searchOption", searchOption);
//		map.put("keyword", keyword);
//		map.put("start", start);
//		map.put("end", end);
//		map.put("startDate", sDate);
//		map.put("endDate", eDate);
//		
//		return sqlSession.selectList(namespace + "selectOrderAllHistory", map);
//	}
	

//	@Override
//	public int selectorderhistorycount(String searchOption, String keyword) {
//		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("searchOption", searchOption);
//		map.put("keyword", keyword);
//		
//		return sqlSession.selectOne(namespace + "selectorderhistorycount" , map);
//	}

//	@Override
//	public List<AllOrdersDto> selectOrderAllHistory(int start, int end) {
//		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("start", start);
//		map.put("end", end);
//		
//		return sqlSession.selectList(namespace + "selectOrderAllHistory", map);
//	}

	



	
}
