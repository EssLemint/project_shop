package com.edu.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.board.model.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.board.";

	@Override
	public int boardSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace + "boardSelectTotalCount"
				, map);
	}

	@Override
	public List<BoardDto> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectOne(namespace + "boardSelectList"
				, map);
	}

	@Override
	public List<BoardDto> boardSelectList(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectList(namespace + "boardSelectList"
				, map);

	}

	
}
