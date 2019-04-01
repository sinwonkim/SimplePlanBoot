package com.simpleplan.boot.service;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.domain.Criteria;

public interface BoardService {
	
	//게시판 리스트 보기
	public List<BoardVO> boardList() throws Exception;
	
	//게시판 상세 보기 
	public BoardVO boardDetail(int board_bno) throws Exception;
	
	//게시판 글 수정 
	public void boardUpdate(BoardVO boardVO) throws Exception;
	
	//게시판 글 등록
	public void boardInsert(BoardVO boardVO) throws Exception;
	
	//게시판 글 삭제
	public void boardDelete(int board_bno) throws Exception;
	
	// listPage
	public List<BoardVO> listPage(int page) throws Exception;
	
	// listCriteria 검색기준
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// totalCount를 return 
	public int countPaging(Criteria cri) throws Exception;
	
	// search 
	public List<BoardVO> listSearch(Criteria cri) throws Exception;
}
