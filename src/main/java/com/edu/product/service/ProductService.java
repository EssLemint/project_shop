package com.edu.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.product.model.ProductDto;

public interface ProductService {

	public List<ProductDto> productSelectList(String searchOption, String keyword, int start, int end);

	public void productInsertOne(ProductDto productDto, 
				MultipartHttpServletRequest mulRequest) throws Exception;

	public Map<String, Object> productSelectOne(int no);

	public int productUpdateOne(ProductDto productDto, 
			MultipartHttpServletRequest multipartHttpServletRequest, int fileIdx);

	public void productDeleteOne(int no);

	public int productSelectTotalCount(String searchOption, String keyword);

}
