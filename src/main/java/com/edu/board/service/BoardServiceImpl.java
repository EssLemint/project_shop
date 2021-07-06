package com.edu.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDao;
import com.edu.board.model.BoardDto;
import com.edu.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	public BoardDao boardDao; 
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;

	@Override
	public int boardSelectTotalCount(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectTotalCount(searchOption, keyword);
	}

	@Override
	public List<BoardDto> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectList(searchOption,keyword,start,end);
	}

	@Override
	public List<BoardDto> boardSelectList(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectList(searchOption,keyword);
	}

}
