package com.edu.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.controller.MemberController;
import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberDto;
import com.edu.util.FileUtils;

@Service
public class MemberServiceImpl implements MemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
		
	@Autowired
	public MemberDao memberDao;
	
	@Override
	public int memberInsertOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.memberInsertOne(memberDto);
	}

	@Override
	public MemberDto memberExist(String id, String pass) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(id, pass);
	}

	@Override
	public MemberDto memberIdExist(String email, String phone) {
		// TODO Auto-generated method stub
		logger.info("Welcome MemberController loginCtr! Service {}, {}", email, phone);
		
		return memberDao.memberIdExist(email, phone);
	}

	@Override
	public MemberDto memberPwdExist(String id, String email, String phone) {
		// TODO Auto-generated method stub
		return memberDao.memberPwdExist(id,email,phone);
	}

	public MemberDto memberMyPage(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberMyPage(no);
	}

	@Override
	public List<MemberDto> memberSelectList(int start, int end) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectList(start, end);
	}
	
	@Override
	public int memberSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount(searchOption, keyword);
	}

	@Override
	public MemberDto memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}

	@Override
	public int memberUpdateCtr(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateCtr(memberDto);
	}

	@Override
	public MemberDto uMemberView(int no) {
		// TODO Auto-generated method stub
		return memberDao.uMemberView(no);
	}

	@Override
	public MemberDto uUpdate(int no) {
		// TODO Auto-generated method stub
		return memberDao.uUpdate(no);
	}

	@Override
	public int uMemberUpdateCtr(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.uMemberUpdateCtr(memberDto);
	}

	@Override
	public MemberDto memberPoint(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberPoint(no);
	}

	@Override
	public int memberPointUpdate(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.memberPointUpdate(memberDto);
	}
	
	@Override
	public MemberDto newMemberIdChk(String id) {
		// TODO Auto-generated method stub
		return memberDao.newMemberIdChk(id);
	}

	@Override
	public MemberDto newMemberid(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto mainPage(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.mainPage(memberDto);
	}

	@Override
	public MemberDto adminMainPage(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return memberDao.adminMainPage(memberDto);
	}

	@Override
	public MemberDto memberMyPageChk(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberMyPageChk(no);
	}



	
}
