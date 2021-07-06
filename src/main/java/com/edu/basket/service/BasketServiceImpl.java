package com.edu.basket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.basket.dao.BasketDao;
import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.product.model.ProductDto;

@Service
public class BasketServiceImpl implements BasketService{

	@Autowired
	public BasketDao basketDao;
	
	@Override
	public Map<String, Object> selectProduct(int no) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ProductDto productDto = basketDao.selectOneProduct(no);
		resultMap.put("productDto", productDto);

		return resultMap;
		
	}

	@Override
	public void insertProductBasketNew(int productCount, int totalPrice,
						int productNo, int membersNo) {
		basketDao.insertProductBasketNew(productCount, totalPrice, productNo, membersNo);
	}

	@Override
	public void insertProductBasketExist(int productCount, int totalPrice, int productNo, int memNo) {
		// TODO Auto-generated method stub
		
		basketDao.insertProductBasketExist(productCount,totalPrice, 
				productNo, memNo);
	}
	

	@Override
	public List<BasketDto> selectBasketList(int memNo) {
		// TODO Auto-generated method stub
		return basketDao.selectBasketList(memNo);
	}

	@Override
	public MemberDto selectMemberOne(int memNo) {
		// TODO Auto-generated method stub
		
		MemberDto memberDto = basketDao.selectMemberOne(memNo);
		return memberDto;
	}

	@Override
	public void deleteBasketOneCtr(int id) {
		// TODO Auto-generated method stub
		
		basketDao.deleteBasketOneCtr(id);
		
	}

	@Override
	public int searchSameProduct(int productNo, int memNo) {
		// TODO Auto-generated method stub
		return basketDao.searchSameProduct(productNo,memNo);
	}

	@Override
	public void updateProductBasket(int productCount, int totalPrice, int productNo, int memNo) {
		// TODO Auto-generated method stub
		
		basketDao.updateProductBasket(productCount, totalPrice, productNo, memNo);
	}

	@Override
	public List<BasketDto> selectBasketListPrice(int memNo) {
		// TODO Auto-generated method stub
		return basketDao.selectBasketListPrice(memNo);
	}

	@Override
	public int searchBasketExist(int memNo) {
		// TODO Auto-generated method stub
		return basketDao.searchBasketExist(memNo);
	}

}
