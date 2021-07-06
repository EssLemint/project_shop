package com.edu.basket.service;

import java.util.List;
import java.util.Map;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;

public interface BasketService {

	public Map<String, Object> selectProduct(int no);

	public void insertProductBasketNew(int productCount, int totalPrice
									, int productNo, int membersNo);

	public List<BasketDto> selectBasketList(int memNo);

	public MemberDto selectMemberOne(int memNo);

	public void deleteBasketOneCtr(int id);

	public int searchSameProduct(int productNo, int memNo);

	public void updateProductBasket(int productCount, int totalPrice, int productNo, int memNo);

	public List<BasketDto> selectBasketListPrice(int memNo);

	public int searchBasketExist(int memNo);

	public void insertProductBasketExist(int productCount, 
			int totalPrice, int productNo, int memNo);

}
