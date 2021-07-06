package com.edu.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.plmage.model.PlmageDto;
import com.edu.product.model.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.product.";
	String fileNameSpace = "com.edu.util.";
	

	@Override
	public List<ProductDto> productSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "productSelectList",map);
	}

	@Override
	public int productInsertOne(ProductDto productDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "productInsertOne",productDto);
	}

	@Override
	public void insertFile(Map<String, Object> map) {
		sqlSession.insert(fileNameSpace + "insertFile",map);
		
	}

	@Override
	public ProductDto productSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "productSelectOne", no);
	}

	@Override
	public List<Map<String, Object>> fileSelectList(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(fileNameSpace + "fileSelectList", no);
	}

	@Override
	public int productUpdateOne(ProductDto productDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "productUpdateOne", productDto);
	}

	@Override
	public Map<String, Object> fileSelectStoredFileName(int productNo) {
		// TODO Auto-generated method stub
		return 	sqlSession.selectOne(fileNameSpace + "fileSelectStoredFileName", productNo);
	}

	@Override
	public int fileDelete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(fileNameSpace + "fileDelete", no);
	}

	@Override
	public void productDeleteOne(int no) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + "productDeleteOne" , no);
	}

	@Override
	public int productSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace + "productSelectTotalCount", map);
	}

	

}
