package com.simpleplan.boot.dao.Impl;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleplan.boot.dao.CommentDao;
import com.simpleplan.boot.domain.CommentVO;

@Repository("com.simpleplan.boot.dao.Impl.CommentDaoImpl")
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SqlSessionTemplate sqlssion;
	
	private static final String namespace="com.example.demo.board.mapper.CommentMapper";
	
	//댓글 리스트
	@Override
	public List<CommentVO> commentList(int board_bno) throws Exception {
		
		return sqlssion.selectList(namespace+".commentList", board_bno);
	}
	
	//댓글 삽입
	@Override
	public void commentInsert(CommentVO commentVO) throws Exception {
		
		 sqlssion.selectOne(namespace+".commentInsert",commentVO);
		
	}
	
	//댓글 삭제
	@Override
	public void commentDelete(int comment_cno) throws Exception {
		
		sqlssion.selectOne(namespace+".commentDelete",comment_cno);
	}
}
