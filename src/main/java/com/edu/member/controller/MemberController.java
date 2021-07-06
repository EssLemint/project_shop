
package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.apache.jasper.tagplugins.jstl.core.If;
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
import com.edu.util.Paging;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	// 로그인화면으로
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		logger.info("Member login! ");

		return "member/LoginForm";
	}

//	logout.do
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		logger.info("Member logout!");

//		session 파기
		session.invalidate();

		return "redirect:/login.do";
	}

	// 회원 검사
	@RequestMapping(value = "/loginCtr.do", method = RequestMethod.POST)
	public String loginCtr(String id, String pass, HttpSession session, Model model) {
		logger.info("Welcome MemberController loginCtr! {}, {}", id, pass);

		MemberDto memberDto = memberService.memberExist(id, pass);
		String viewUrl = "";

		if (memberDto == null) {
			viewUrl = "/member/LoginFormFail";
		} else if (memberDto.getIsAdmin() == 1) {
			session.setAttribute("memberDto", memberDto);
			viewUrl = "/admin/AdminMainPage";
		} else {
			session.setAttribute("memberDto", memberDto);
			viewUrl = "/main/MainPage";
		}

		return viewUrl;
	}
	
	// 사용자 메인페이지 이동
		@RequestMapping(value = "/mainPage.do", method = { RequestMethod.GET, RequestMethod.POST })
		public String mainPage(HttpSession session, MemberDto memberDto,Model model) {
			logger.info("Member MyPage! {} , {}", model);

			memberService.mainPage(memberDto);

			model.addAttribute(memberDto);

			return "main/MainPage";
		}
		
		// 관리자 메인페이지 이동
				@RequestMapping(value = "/adminmainPage.do", method = { RequestMethod.GET, RequestMethod.POST })
				public String adminMainPage(HttpSession session, MemberDto memberDto,Model model) {
					logger.info("Member MyPage! {} , {}", model);

					memberService.adminMainPage(memberDto);

					model.addAttribute(memberDto);

					return "admin/AdminMainPage";
				}

	// 마이페이지 이동전 패스워드 확인
	@RequestMapping(value = "/myPageChk.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String MyPageChk(HttpSession session, Model model, int no) {
	logger.info("Member MyPage! {} , {}", no, model);

	MemberDto memberDto = memberService.memberMyPageChk(no);

	model.addAttribute(memberDto);

	return "member/MyPagePassChk";
	
	}

		
				
	// 마이페이지 이동
	@RequestMapping(value = "/myPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String MyPage(HttpSession session, Model model, int no) {
		logger.info("Member MyPage! {} , {}", no, model);

		MemberDto memberDto = memberService.memberMyPage(no);

		model.addAttribute(memberDto);

		return "member/MyPage";
	}

	// 아이디 찾기 화면으로
	@RequestMapping(value = "/searchId.do", method = RequestMethod.GET)
	public String searchId(HttpSession session, Model model) {
		logger.info("Member ID search! ");

		return "member/SearchId";
	}

	// 아이디 찾기
	@RequestMapping(value = "/searchIdCtr.do", method = RequestMethod.POST)
	public String searchIdCtr(String email, String phone, HttpSession session, Model model) {
		logger.info("Welcome MemberController loginCtr! {}, {}", email, phone);

		MemberDto memberDto = memberService.memberIdExist(email, phone);
		model.addAttribute("memberDto", memberDto);

		String viewUrl = "";

		if (memberDto != null) {
			session.setAttribute("member", memberDto);

			viewUrl = "member/SearchIdSuccess";
		} else {
			viewUrl = "member/SearchIdFail";
		}

		return viewUrl;
	}

	// 패스워드 찾기화면으로
	@RequestMapping(value = "/searchPwd.do", method = RequestMethod.GET)
	public String searchPwd(HttpSession session, Model model) {
		logger.info("Member Password search! ");

		return "member/SearchPassword";
	}

	// 패스워드 찾기
	@RequestMapping(value = "/searchPwdCtr.do", method = RequestMethod.POST)
	public String searchPwdCtr(String id, String email, String phone, HttpSession session, Model model) {
		logger.info("Welcome MemberController searchPwdCtr! {}, {}", id, email);
		logger.info("Welcome MemberController searchPwdCtr! {}, ", phone);

		MemberDto memberDto = memberService.memberPwdExist(id, email, phone);
		model.addAttribute("memberDto", memberDto);

		String viewUrl = "";

		if (memberDto != null) {
			session.setAttribute("member", memberDto);

			viewUrl = "member/SearchPasswordSuccess";
		} else {
			viewUrl = "member/SearchPasswordFail";
		}

		return viewUrl;
	}

	// 회원가입화면으로
	@RequestMapping(value = "/newMember.do", method = RequestMethod.GET)
	public String newMember(HttpSession session, Model model) {
		logger.info("Member New Member! ");

		return "member/NewMember";
	}

	// addCtr.do
	@RequestMapping(value = "/addCtr.do", method = RequestMethod.POST)
	public String memberAddCtr(MemberDto memberDto, Model model) {

		logger.info("Welcome NewMember!!! {}, {}", memberDto);

		int pointNum = 0;
		int adminNum = 2;
		int stateNum = 1;
		memberDto.setPoint(pointNum);
		memberDto.setIsAdmin(adminNum);
		memberDto.setState(stateNum);
		memberService.memberInsertOne(memberDto);

		model.addAttribute("memberDto", memberDto);

		return "member/NewMemberChk";

	}

	// 회원 리스트 화면으로
	@RequestMapping(value = "/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberList(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "id") String searchOption, @RequestParam(defaultValue = "") String keyword,
			Model model) {
		logger.info("Welcome MemberController memberList! : {}", curPage);

		if (("id").equals(searchOption)) {
			searchOption = "members_id";
		}

		// 전체 게시물 갯수
		int totalCount = memberService.memberSelectTotalCount(searchOption, keyword);

		// 페이지 나누기 관련 처리
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();

		List<MemberDto> memberList = memberService.memberSelectList(start, end);

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);

		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingMap", pagingMap);

		return "admin/MemberList";
	}

	// 회원상세보기 화면으로 이동
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String memberView(int no, Model model) {
		logger.info("Welcome MemberController memberUpdate! " + no);
		MemberDto memberDto = memberService.memberSelectOne(no);

		model.addAttribute("memberDto", memberDto);

		return "admin/AdminMemberView";
	}

	// 회원수정 화면으로 이동
	@RequestMapping(value = "/detailView.do", method = RequestMethod.GET)
	public String memberUpdate(int no, Model model) {
		logger.info("Welcome MemberController memberUpdate! " + no);
		MemberDto memberDto = memberService.memberSelectOne(no);

		model.addAttribute("memberDto", memberDto);

		return "admin/AdminMemberUpdate";
	}

	// 회원수정
	@RequestMapping(value = "/updateCtr.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberUpdateCtr(MemberDto memberDto, Model model) {
		logger.info("Welcome MemberController memberUpdateCtr! " + memberDto);
		memberService.memberUpdateCtr(memberDto);

		return "redirect:/list.do";
	}

	// 회원 자기자신 정보 자세히 보기
	@RequestMapping(value = "/uMemberView.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String uMemberView(int no, Model model) {
		logger.info("uMemberView! " + no);
		MemberDto memberDto = memberService.uMemberView(no);

		model.addAttribute("memberDto", memberDto);

		return "member/InformationView";
	}

	// 회원 자기자신 정보 자세히 보기
	@RequestMapping(value = "/uUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String uUpdate(int no, Model model) {
		logger.info("uUpdate! " + no);
		MemberDto memberDto = memberService.uUpdate(no);

		model.addAttribute("memberDto", memberDto);

		return "member/InformationUpdate";
	}

	// 회원수정
	@RequestMapping(value = "/uMemberUpdateCtr.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String uMemberUpdateCtr(MemberDto memberDto, Model model) {
		logger.info("uMemberUpdateCtr! " + memberDto);
		memberService.uMemberUpdateCtr(memberDto);

		return "member/MyPage";
	}

	// 팝업창 호출
	@RequestMapping(value = "/memberPoint.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberPoint(int no, Model model) {
		logger.info("memberPoint" + no);
		MemberDto memberDto = memberService.memberPoint(no);

		model.addAttribute(memberDto);

		return "popup/PopUp";
	}

	@RequestMapping(value = "/memberPointUpdate.do", method = { RequestMethod.POST })
	public String memberPointUpdate(MemberDto memberDto, Model model) {
		logger.info("memberPointUpdate! " + memberDto);
		memberService.memberPointUpdate(memberDto);

		return "point/MemberPoint";
	}

	// 아이디 중복검사
	@RequestMapping(value = "/idChk.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String newMemberid(MemberDto memberDto, Model model) {
		logger.info("newMemberID CHk" + memberDto);
		memberService.newMemberid(memberDto);

		model.addAttribute(memberDto);

		return "popup/idPopUp";
	}

	@RequestMapping(value = "/testIdChk.do", method = RequestMethod.POST)
	public String newMemberIdChk(@RequestParam("id") String id, Model model) {
		logger.info("testIdChk! " + id);

		MemberDto memberDto = memberService.newMemberIdChk(id);
		model.addAttribute("id", id);
		model.addAttribute("memberDto", memberDto);

		String viewUrl = "";

		if (memberDto != null) {

			viewUrl = "popup/idno";
		} else {
			viewUrl = "popup/idok";
		}
		return viewUrl;
	}
	
	
	
	
	
}
