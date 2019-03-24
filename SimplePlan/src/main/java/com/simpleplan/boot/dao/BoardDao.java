package com.simpleplan.boot.dao;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;

public interface BoardDao {
	
	//게시판 리스트 
	public List<BoardVO> boardList() throws Exception;
	
	//게시판 글 삽입
	public void boardInsert(BoardVO boardVO) throws Exception;
}
