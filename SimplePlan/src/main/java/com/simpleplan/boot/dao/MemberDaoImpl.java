package com.simpleplan.boot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleplan.boot.domain.MemberVO;

@Repository("com.simpleplan.boot.dao.MemberDaoImpl")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlssion;
	
	private static final String namespace="mapper.MemberMapper";
	
	@Override
	public MemberVO listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectOne(namespace+".listAll");
	}

	@Override
	public void signUp(MemberVO memberVO) throws Exception {
		sqlssion.selectOne(namespace+".signUp",memberVO);
		
	}

	
}
