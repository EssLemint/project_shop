package com.edu.point.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.model.MemberDto;
import com.edu.point.controller.PointController;
import com.edu.point.dao.PointDao;
import com.edu.point.model.PointDto;
@Service
public class PointServiceImpl implements PointService{

	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	
	@Autowired
	public PointDao pointDao;
	
	@Override
	public void pointinsert(PointDto pointDto) {
		// TODO Auto-generated method stub
		pointDao.pointinsert(pointDto);
	}

	@Override
	public int pointSelectList(String searchOption, String keyword, int no) {
		// TODO Auto-generated method stub
		return pointDao.pointSelectList(searchOption, keyword, no);
	}

	@Override
	public List<MemberDto> pointHistory(int start, int end, int no) {
		// TODO Auto-generated method stub
		return pointDao.pointHistory(start, end, no);
	}

	
	@Override
	public int adminMemberPointList(String searchOption, String keyword, int no) {
		// TODO Auto-generated method stub
		return pointDao.adminMemberPointList(searchOption, keyword, no);
	}

	@Override
	public List<MemberDto> adminMemberPoint(int start, int end, int no) {
		// TODO Auto-generated method stub
		return pointDao.adminMemberPoint(start, end, no);
	}

	@Override
	public void orderpointinsert(PointDto pointDto) {
		// TODO Auto-generated method stub
		pointDao.pointinsert(pointDto);
	}



}
