package com.simpleplan.boot.dao;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.domain.Criteria;

public interface BoardDao {
	
	//게시판 리스트 
	public List<BoardVO> boardList() throws Exception;
	
	//게시판 상세보기
	public BoardVO boardDetail(int board_bno) throws Exception;
	
	//게시판 글 삽입
	public void boardInsert(BoardVO boardVO) throws Exception;
	
	//게시판 글 수정
	public void boardUpdate(BoardVO boardVO) throws Exception;
	
	//게시판 글 삭제
	public void boardDelete(int board_bno) throws Exception;
	
	// listPage
	public List<BoardVO> listPage(int page) throws Exception;
	
	// listCriteria 검색기준
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// totalCount return
	public int countPaging(Criteria cri) throws Exception;
	
	// listSearch
	public List<BoardVO> listSearch(Criteria cri) throws Exception;
}
