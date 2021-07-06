package com.edu.plmage.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.plmage.model.PlmageDto;

@Repository
public class PlmageDaoImpl implements PlmageDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.plmage.";

}
