package com.edu.comments.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDaoImpl implements CommentsDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.comments.";
	
}
