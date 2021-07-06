package com.edu.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.member.model.MemberDto;
import com.edu.plmage.model.PlmageDto;
import com.edu.product.model.ProductDto;

public interface ProductDao {

	public List<ProductDto> productSelectList(String searchOption, String keyword, int start, int end);
	
	public int productInsertOne(ProductDto productDto);

	public void insertFile(Map<String, Object> map);

	public ProductDto productSelectOne(int no);

	public List<Map<String, Object>> fileSelectList(int no);

	public int productUpdateOne(ProductDto productDto);

	public Map<String, Object> fileSelectStoredFileName(int productNo);
	
	public int fileDelete(int no);

	public void productDeleteOne(int no);

	public int productSelectTotalCount(String searchOption, String keyword);

	
}
