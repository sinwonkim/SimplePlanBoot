package com.simpleplan.boot.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.BoardDao;
import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.domain.Criteria;
import com.simpleplan.boot.service.BoardService;


@Service("com.simpleplan.boot.service.Impl.BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="com.simpleplan.boot.dao.Impl.BoardDaoImpl")
	BoardDao boardDao;
	
	//게시판 리스트 보기
	@Override
	public List<BoardVO> boardList() throws Exception {
		
		return boardDao.boardList();
	}
	
	//게시판 리스트 상세보기
	@Override
	public BoardVO boardDetail(int board_bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.boardDetail(board_bno);
	}
	
	//게시판 글 등록
	@Override
	public void boardInsert(BoardVO boardVO) throws Exception {
		
		boardDao.boardInsert(boardVO); // 삽입이라 return 값 없다.
	}

	//게시판 글 수정
	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		
		boardDao.boardUpdate(boardVO);
		
	}
	//게시판 글 삭제
	@Override
	public void boardDelete(int board_bno) throws Exception {
		
		boardDao.boardDelete(board_bno);
		
	}
	
	//listPage
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		return boardDao.listPage(page);
	}
	
	//listCriteria 검색기준
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return boardDao.listCriteria(cri);
	}
	
	//totalCount return 
	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.countPaging(cri);
	}
	
	// listSearch
	@Override
	public List<BoardVO> listSearch(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.listSearch(cri);
	}
	

	

}
