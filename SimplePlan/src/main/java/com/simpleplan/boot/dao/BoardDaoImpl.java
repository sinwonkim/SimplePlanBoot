package com.simpleplan.boot.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleplan.boot.domain.BoardVO;

@Repository("com.simpleplan.boot.dao.BoardDaoImpl")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlssion;
	
	private static final String namespace="com.example.demo.board.mapper.BoardMapper";
	
	//게시판 리스트 보기
	@Override
	public List<BoardVO> boardList() throws Exception {
		
		return sqlssion.selectList(namespace+".boardList");
	}
	
	//게시판 글 삽입
	@Override
	public void boardInsert(BoardVO boardVO) throws Exception {
		
		 sqlssion.selectOne(namespace+".boardInsert",boardVO);
		
	}
	
	
}
