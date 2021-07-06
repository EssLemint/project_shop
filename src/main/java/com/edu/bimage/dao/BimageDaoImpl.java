package com.edu.bimage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BimageDaoImpl implements BimageDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.bimage.";
	
}
