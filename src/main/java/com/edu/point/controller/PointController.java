package com.edu.point.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.websocket.Session;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;
import com.edu.member.service.MemberService;
import com.edu.point.model.PointDto;
import com.edu.point.service.PointService;
import com.edu.product.model.ProductDto;
import com.edu.util.Paging;

@Controller
public class PointController {

	private static final Logger logger = LoggerFactory.getLogger(PointController.class);

	@Autowired
	private PointService pointService;

	//사용자 직접 충전
	@RequestMapping(value = "/pointinsert.do", method = {RequestMethod.POST})
	public String pointinsert(PointDto pointDto, Model model) {
		logger.info("pointinsert! " + pointDto);
		String route = "사용자직접충전";
		pointDto.setRoute(route);
		
	
		pointService.pointinsert(pointDto);
		model.addAttribute(pointDto);
		
		
		return "point/BridgeMyPage";
	}
	
	//사용자 상품 구매
	@RequestMapping(value = "/orderpointinsert.do", method = {RequestMethod.POST})
	public String orderpointinsert(PointDto pointDto, Model model) {
		logger.info("orderpointinsert! " + pointDto);
		String route = "상품 구매";
		pointDto.setRoute(route);
		pointService.orderpointinsert(pointDto);
		
		pointService.orderpointinsert(pointDto);
		pointService.orderpointinsert(pointDto);

		model.addAttribute(pointDto);
		return "forward:/orderHistoryList.do"; 
	
	}
	
	
//	@RequestMapping(value = "/pointHistory.do", method = {RequestMethod.POST,RequestMethod.GET})
//	public String pointHistory(@RequestParam(defaultValue = "1")int curPage,
//			int no, Model model) {
//		logger.info("pointHistory! " + no);
//	
//		int totalCount = pointService.pointHistory(curPage, no);
//		
//		Paging memberPaging = new Paging(curPage , no);
//		int start = memberPaging.getPageBegin();
//		int end = memberPaging.getPageEnd();
//		
//		List<PointDto>pointList = pointService.pointSelectList(start , end);
//		
//		Map<String, Object> pagingMap = new HashMap<>();
//		pagingMap.put("totalCount", totalCount);
//		pagingMap.put("memberPaging", memberPaging);
//
//		model.addAttribute("memberList", pointList);
//		model.addAttribute("pagingMap", pagingMap);
//		model.addAttribute(no);
//		model.addAttribute("pointList", pointList);
//		
//		
//		return "point/PointHistory";
//	}
	@RequestMapping(value = "/pointHistory.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String memberList(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "id") String searchOption, @RequestParam(defaultValue = "") String keyword,
			HttpSession session, int no, Model model) {
		logger.info("Welcome MemberPoint List! : {} {}", no);

		if (("id").equals(searchOption)) {
			searchOption = "members_id";
		}
		
		// 전체 게시물 갯수
		int totalCount = pointService.pointSelectList(searchOption, keyword, no);
		
		// 페이지 나누기 관련 처리
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();
		

		List<MemberDto> pointList = pointService.pointHistory(start, end, no);

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);

		model.addAttribute("userno", no);
		model.addAttribute("pointList", pointList);
		model.addAttribute("pagingMap", pagingMap);
		
			
		
		
		
		return "point/PointHistory";
	}
	
	@RequestMapping(value = "/adminMemberPoint.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String adminMemberPoint(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "id") String searchOption, @RequestParam(defaultValue = "") String keyword,
			HttpSession session, int no, Model model) {
		logger.info("Welcome MemberPoint List! : {} {}", model);

		if (("id").equals(searchOption)) {
			searchOption = "members_id";
		}
		
		// 전체 게시물 갯수
		int totalCount = pointService.adminMemberPointList(searchOption, keyword, no);
		
		// 페이지 나누기 관련 처리
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();
		

		List<MemberDto> pointList = pointService.adminMemberPoint(start, end, no);

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);

		model.addAttribute("userno", no);
		model.addAttribute("pointList", pointList);
		model.addAttribute("pagingMap", pagingMap);
		
		return "admin/AdminMemberPoint";
	}
	
	//후기게시판 작성 충전
	
	

}
