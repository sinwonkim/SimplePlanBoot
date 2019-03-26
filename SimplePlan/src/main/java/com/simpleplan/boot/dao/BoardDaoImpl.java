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
	
	//게시판 상세 보기
	@Override
	public BoardVO boardDetail(int board_bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectOne(namespace+".boardDeatail",board_bno);
	}
	
	//게시판 글 삽입
	@Override
	public void boardInsert(BoardVO boardVO) throws Exception {
		
		 sqlssion.selectOne(namespace+".boardInsert",boardVO);
		
	}
	
	//게시판 글 수정
	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		
		sqlssion.selectOne(namespace+".boardUpdate",boardVO);
		
	}

	
	
	
}
