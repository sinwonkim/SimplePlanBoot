package com.simpleplan.boot.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("com.simpleplan.boot.dao.BoardDaoImpl")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlssion;
	
	private static final String namespace="com.example.demo.board.mapper.BoardMapper";
	
	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectOne(namespace+".boardCount");	
	}
	
	
}
