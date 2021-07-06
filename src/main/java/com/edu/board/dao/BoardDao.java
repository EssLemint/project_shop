package com.edu.board.dao;

import java.util.List;

import com.edu.board.model.BoardDto;

public interface BoardDao {

	public int boardSelectTotalCount(String searchOption, String keyword);

	public List<BoardDto> boardSelectList(String searchOption, String keyword, int start, int end);

	public List<BoardDto> boardSelectList(String searchOption, String keyword);

}
