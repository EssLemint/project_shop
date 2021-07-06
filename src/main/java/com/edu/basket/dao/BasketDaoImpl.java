package com.edu.basket.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.product.model.ProductDto;

@Repository
public class BasketDaoImpl implements BasketDao{
	

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.basket.";
	String namespaceProuct = "com.edu.product.";

	@Override
	public ProductDto selectOneProduct(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespaceProuct +"productSelectOne", no);
	}

	@Override
	public void insertProductBasketNew(int productCount, int totalPrice
				, int productNo, int membersNo) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productCount", productCount);
		map.put("totalPrice", totalPrice);
		map.put("productNo", productNo);
		map.put("membersNo", membersNo);
		
		sqlSession.insert(namespace +"insertProductBasketNew", map);
	}
	
	@Override
	public void insertProductBasketExist(int productCount, int totalPrice, int productNo, int membersNo) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productCount", productCount);
		map.put("totalPrice", totalPrice);
		map.put("productNo", productNo);
		map.put("membersNo", membersNo);
		sqlSession.insert(namespace +"insertProductBasketExist", map);
		
	}

	@Override
	public List<BasketDto> selectBasketList(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectBasketList", membersNo);
	}

	@Override
	public MemberDto selectMemberOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectMemberOne", no );
	}

	@Override
	public void deleteBasketOneCtr(int id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + "deleteBasketOneCtr",id);
	}

	@Override
	public int searchSameProduct(int productNo, int memNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("membersNo", memNo);
		
		return sqlSession.selectOne(namespace + "searchSameProduct", map);
	}

	@Override
	public void updateProductBasket(int productCount, int totalPrice, int productNo, int memNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("membersNo", memNo);
		map.put("productCount", productCount);
		map.put("totalPrice", totalPrice);
		sqlSession.update(namespace + "updateProductBasket", map);
	}

	@Override
	public List<BasketDto> selectBasketListPrice(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectBasketListPrice", membersNo);
	}

	@Override
	public int searchBasketExist(int membersNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "searchBasketExist", membersNo) ;
	}

//	@Override
//	public int checkBasketGroup(int membersNo) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectOne(namespace + "checkBasketGroup", membersNo);
//	}

	

}
