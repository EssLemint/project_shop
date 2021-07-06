package com.edu.point.dao;

import java.util.List;
import java.util.Map;

import com.edu.member.model.MemberDto;
import com.edu.point.model.PointDto;

public interface PointDao {
		
	public void pointinsert(PointDto pointDto);
	public void orderpointinsert(PointDto pointDto);
	
	public List<MemberDto> pointHistory(int start, int end, int no);
	public int pointSelectList(String searchOption, String keyword, int no);
	
	public int adminMemberPointList(String searchOption, String keyword, int no);
	public List<MemberDto> adminMemberPoint(int start, int end, int no);
}
