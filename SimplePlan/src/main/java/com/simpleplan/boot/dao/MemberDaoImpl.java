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
	
	// 
	@Override
	public MemberVO listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlssion.selectOne(namespace+".listAll");
	}
	
	// 회원가입
	@Override
	public void signUp(MemberVO memberVO) throws Exception {
		sqlssion.selectOne(namespace+".signUp",memberVO);
		
	}

	// 회원 로그인 확인
	@Override
	public boolean loginCheck(MemberVO memberVO) throws Exception {
		String name = sqlssion.selectOne(namespace+".loginCheck", memberVO);
		return (name == null) ? false : true;
	}
	
	// 회원가입 중복 체크 
	@Override
	public boolean signUpCheck(MemberVO memberVO) throws Exception {
		String name = sqlssion.selectOne(namespace+".signUpCheck",memberVO);
		return (name == null) ? true : false;
	}
	


	
}
