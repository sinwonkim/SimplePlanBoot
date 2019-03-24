package com.simpleplan.boot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.BoardDao;
import com.simpleplan.boot.domain.BoardVO;


@Service("com.simpleplan.boot.service.BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="com.simpleplan.boot.dao.BoardDaoImpl")
	BoardDao boardDao;
	
	//게시판 리스트 보기
	@Override
	public List<BoardVO> boardList() throws Exception {
		
		return boardDao.boardList();
	}
	
	//게시판 글 등록
	@Override
	public void boardInsert(BoardVO boardVO) throws Exception {
		
		boardDao.boardInsert(boardVO); // 삽입이라 return 값 없다.
	}

}
