package com.simpleplan.boot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.BoardDao;


@Service("com.simpleplan.boot.service.BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="com.simpleplan.boot.dao.BoardDaoImpl")
	BoardDao boardDao;
	
	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.boardCount();
	}

}
