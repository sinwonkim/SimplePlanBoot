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

	@Override
	public List<BoardVO> boardList() throws Exception {
		
		return boardDao.boardList();
	}
	

}
