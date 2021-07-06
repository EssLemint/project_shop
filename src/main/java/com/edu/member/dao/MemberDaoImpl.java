package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.controller.MemberController;
import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.member.";

	@Override
	public int memberInsertOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne" , memberDto);
	}

	@Override
	public MemberDto memberExist(String id, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("pass", pass);
		
		return sqlSession.selectOne(namespace + "memberExist", paramMap);
	}

	@Override
	public MemberDto memberIdExist(String email, String phone) {
		// TODO Auto-generated method stub
		logger.info("Welcome MemberController loginCtr! Dao {}, {}", email, phone);
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("phone", phone);
		
		return sqlSession.selectOne(namespace + "memberIdExist", paramMap);
	}

	@Override
	public MemberDto memberPwdExist(String id, String email, String phone) {
		// TODO Auto-generated method stub
		HashMap<String, Object>paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("email", email);
		paramMap.put("phone", phone);
		
		return sqlSession.selectOne(namespace + "memberPwdExist", paramMap);
	}


	@Override
	public MemberDto memberMyPage(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberMyPage" , no);
	}

	@Override
	public List<MemberDto> memberSelectList(int start, int end) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "memberSelectList", map);
	}
	
	@Override
	public int memberSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace + "memberSelectTotalCount",map);
	}
	
	@Override
	public MemberDto memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateCtr(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateCtr", memberDto);
	}

	@Override
	public MemberDto uMemberView(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "uMemberView", no);
	}

	@Override
	public MemberDto uUpdate(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "uUpdate" , no);
	}

	@Override
	public int uMemberUpdateCtr(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "uMemberUpdateCtr" , memberDto);
	}

	@Override
	public MemberDto memberPoint(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberPoint", no);
	}

	@Override
	public int memberPointUpdate(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberPointUpdate", memberDto);
	}

	@Override
	public MemberDto newMemberIdChk(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "newMemberIdChk", id);
	}

	@Override
	public MemberDto newMemberid(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto mainPage(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto adminMainPage(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto memberMyPageChk(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberMyPageChk" , no);
	}

}
