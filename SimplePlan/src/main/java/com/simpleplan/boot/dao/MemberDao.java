package com.simpleplan.boot.dao;

import com.simpleplan.boot.domain.MemberVO;

public interface MemberDao {
	
	public MemberVO listAll() throws Exception;
	
	// 회원가입
	void signUp(MemberVO memberVO) throws Exception;
	
	// 회원 로그인 체크
	boolean loginCheck(MemberVO vo) throws Exception;
	
	
}
