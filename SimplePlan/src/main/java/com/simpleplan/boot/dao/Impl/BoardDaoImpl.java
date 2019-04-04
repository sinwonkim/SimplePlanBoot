package com.simpleplan.boot.dao.Impl;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleplan.boot.dao.BoardDao;
import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.domain.Criteria;

@Repository("com.simpleplan.boot.dao.Impl.BoardDaoImpl")
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
	
	//게시판 글 삭제
	@Override
	public void boardDelete(int board_bno) throws Exception {
		
		sqlssion.selectOne(namespace+".boardDelete",board_bno);
	}
	
	//listPage
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if (page <= 0 ) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		return sqlssion.selectList(namespace+".listPage", page);
	}
	
	// listCriteria 검색 기준
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectList(namespace+".listCriteria", cri);
	}
	
	// Board
	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectOne(namespace+".countPaging", cri);
	}
	
	// listSearch
	@Override
	public List<BoardVO> listSearch(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectList(namespace+".listSearch", cri);
	}
}
