package com.edu.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.edu.product.dao.ProductDao;
import com.edu.product.model.ProductDto;
import com.edu.util.FileUtils;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	public ProductDao productDao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public List<ProductDto> productSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return productDao.productSelectList(searchOption, keyword, start, end);
	}

	@Override
	public void productInsertOne(ProductDto productDto,
			MultipartHttpServletRequest multipartHttpServletRequest) 
					throws Exception {
		// TODO Auto-generated method stub
		productDao.productInsertOne(productDto);
		
		int productNo = productDto.getNo();
		List<Map<String, Object>> list = 
				fileUtils.parseInsertFileInfo(productNo, 
						multipartHttpServletRequest);
		
		for (Map<String, Object> map : list) {
			productDao.insertFile(map);
		}
		
	}

	@Override
	public Map<String, Object> productSelectOne(int no) {
		// TODO Auto-generated method stub
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ProductDto productDto = productDao.productSelectOne(no);
		resultMap.put("productDto", productDto);
		
		List<Map<String, Object>> fileList = productDao.fileSelectList(no);
		resultMap.put("fileList", fileList);
		
		
		return resultMap;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int productUpdateOne(ProductDto productDto, 
			MultipartHttpServletRequest multipartHttpServletRequest, int fileIdx) {
		// TODO Auto-generated method stub
		
		int resultNum = 0;
		
		try {
			resultNum = productDao.productUpdateOne(productDto);
			
			int productNo = productDto.getNo();
			
			Map<String, Object> tempFileMap = 
					productDao.fileSelectStoredFileName(productNo);
//			
			List<Map<String, Object>> list = 
					fileUtils.parseInsertFileInfo(productNo, multipartHttpServletRequest);
			
			if(list.isEmpty() == false) {
				if(tempFileMap != null) {
					productDao.fileDelete(productNo);
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
				for (Map<String, Object> map : list) {
					productDao.insertFile(map);
				}
				
				
			}else if(fileIdx == -1) { 
				if(tempFileMap != null) {
					productDao.fileDelete(productNo);
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		return resultNum;
	}

	@Override
	public void productDeleteOne(int no) {
		// TODO Auto-generated method stub
		productDao.productDeleteOne(no);
		productDao.fileDelete(no);
	}

	@Override
	public int productSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return productDao.productSelectTotalCount(searchOption,keyword) ;
	}
	





}
