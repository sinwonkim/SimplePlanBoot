package com.simpleplan.boot.service;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.MemberDao;
import com.simpleplan.boot.domain.MemberVO;

@Service("com.simpleplan.boot.service.MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="com.simpleplan.boot.dao.MemberDaoImpl")
	MemberDao memberDao;
	
	@Override
	public MemberVO listAll() throws Exception {		
		return memberDao.listAll();
	}
	
	// 회원가입 
	@Override
	public void signUp(MemberVO memberVO) throws Exception {
		 memberDao.signUp(memberVO);	
	}
	//중복 회원 확인 
	@Override
	public boolean signUpCheck(MemberVO memberVO) throws Exception {
		boolean result = memberDao.signUpCheck(memberVO);
		return result;
	}
	// 회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO memberVO, HttpSession session) throws Exception {
		boolean result = memberDao.loginCheck(memberVO);
		return result;
	}

	

	



}
