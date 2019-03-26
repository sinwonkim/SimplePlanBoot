package com.simpleplan.boot.service;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;

public interface BoardService {
	
	//게시판 리스트 보기
	public List<BoardVO> boardList() throws Exception;
	
	//게시판 상세 보기 
	public BoardVO boardDetail(int board_bno) throws Exception;
	
	
	//게시판 글 등록
	public void boardInsert(BoardVO boardVO) throws Exception;
	
}
