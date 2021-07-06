package com.edu.basket.dao;

import java.util.List;

import com.edu.basket.model.BasketDto;
import com.edu.member.model.MemberDto;
import com.edu.product.model.ProductDto;

public interface BasketDao {

	public ProductDto selectOneProduct(int no);

	public void insertProductBasketNew(int productCount, int totalPrice, 
					int productNo, int membersNo);

	public void insertProductBasketExist(int productCount, 
			int totalPrice, int productNo, int memNo);
	
	public List<BasketDto> selectBasketList(int memNo);

	public MemberDto selectMemberOne(int memNo);

	public void deleteBasketOneCtr(int id);

	public int searchSameProduct(int productNo, int memNo);

	public void updateProductBasket(int productCount, int totalPrice, int productNo, int memNo);

	public List<BasketDto> selectBasketListPrice(int memNo);

	public int searchBasketExist(int memNo);

}
