package com.simpleplan.boot.service;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> boardList() throws Exception;

	public void boardList(BoardVO boardVO);
	
}
