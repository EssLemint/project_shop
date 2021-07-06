package com.edu.point.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;
import com.edu.point.model.PointDto;

public interface PointService {
	
	public void pointinsert(PointDto pointDto);
	public void orderpointinsert(PointDto pointDto);
	
	public List<MemberDto> pointHistory(int start, int end, int no);
	public int pointSelectList(String searchOption, String keyword, int no);
	
	public int adminMemberPointList(String searchOption, String keyword, int no);
	public List<MemberDto> adminMemberPoint(int start, int end, int no);
}
