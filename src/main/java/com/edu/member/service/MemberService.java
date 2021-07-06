package com.edu.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;

public interface MemberService {
	
	public int memberInsertOne(MemberDto memberDto);
	public MemberDto memberExist(String id, String pass);
	public MemberDto memberIdExist(String email, String phone);
	public MemberDto memberPwdExist(String id, String email, String phone);
	
	public MemberDto memberMyPageChk(int no);
	public MemberDto memberMyPage(int no);
	public MemberDto uMemberView(int no);
	public MemberDto uUpdate(int no);
	public int uMemberUpdateCtr(MemberDto memberDto);
	public MemberDto memberPoint(int no);
	public int memberPointUpdate(MemberDto memberDto);

	
	public int memberSelectTotalCount(String searchOption,String keyword);
	public List<MemberDto> memberSelectList(int start, int end);
	public MemberDto memberSelectOne(int no);
	public int memberUpdateCtr(MemberDto memberDto);
	
	
	public MemberDto newMemberIdChk(String id);
	public MemberDto newMemberid(MemberDto memberDto);

	public MemberDto mainPage(MemberDto memberDto);
	public MemberDto adminMainPage(MemberDto memberDto);
}
