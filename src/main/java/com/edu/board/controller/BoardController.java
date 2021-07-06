package com.edu.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.board.model.BoardDto;
import com.edu.board.service.BoardService;
import com.edu.util.Paging;


@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list.do",
			method= RequestMethod.GET)
	public String boardList(@RequestParam(defaultValue = "1") int curPage
			, @RequestParam(defaultValue="name") String searchOption
			, @RequestParam(defaultValue="") String keyword
			,Model model) {
		logger.info("Welcome MemberController memberList! : {} {}", curPage, keyword);
		
//		//게시글 전체 갯수
//		int totalCount = boardService.boardSelectTotalCount(searchOption, keyword);
//		
//		// 페이징 관련 처리
//		Paging memberPaging = new Paging(totalCount, curPage);
//		int start = memberPaging.getPageBegin();
//		int end = memberPaging.getPageEnd();
//		
//		List<BoardDto> boardList = 
//				boardService.boardSelectList(searchOption, keyword, start, end);
//		
//		
		
		List<BoardDto> boardList = 
				boardService.boardSelectList(searchOption, keyword);
		
		
		model.addAttribute("boardList",boardList);
		
		
		return "board/BoardList";		
	}
	
	
	
}
