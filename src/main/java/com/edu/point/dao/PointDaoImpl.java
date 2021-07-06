package com.edu.point.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;
import com.edu.point.controller.PointController;
import com.edu.point.model.PointDto;

@Repository
public class PointDaoImpl implements PointDao{
	
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.point.";

	@Override
	public void pointinsert(PointDto pointDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + "pointinsert" , pointDto);
	}

	@Override
	public int pointSelectList(String searchOption, String keyword, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("no", no);
		
		
		return sqlSession.selectOne(namespace + "pointSelectList" , map);
		
	}

	@Override
	public List<MemberDto> pointHistory(int start, int end, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("no", no);
		
		return sqlSession.selectList(namespace + "pointHistory", map);
	}

	
	@Override
	public int adminMemberPointList(String searchOption, String keyword, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("no", no);
		
		
		return sqlSession.selectOne(namespace + "adminMemberPointList" , map);
		
	}

	@Override
	public List<MemberDto> adminMemberPoint(int start, int end, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("no", no);
		
		return sqlSession.selectList(namespace + "adminMemberPoint", map);
	}

	@Override
	public void orderpointinsert(PointDto pointDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + "orderpointinsert" , pointDto);
	}



}
