package com.simpleplan.boot.dao;

import java.util.List;

import com.simpleplan.boot.domain.BoardVO;

public interface BoardDao {

	public int boardCount() throws Exception;
	
	public List<BoardVO> boardList() throws Exception;
}
