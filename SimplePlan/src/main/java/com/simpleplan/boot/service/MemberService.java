package com.simpleplan.boot.service;
import com.simpleplan.boot.domain.MemberVO;

public interface MemberService {

	MemberVO listAll() throws Exception;
	
	//회원 가입 처리
	void signUp(MemberVO memberVO) throws Exception;
	
	//중복 회원 확인 
	public boolean signUpCheck(MemberVO memberVO) throws Exception;
	
	//회원 로그인 체크 
	public boolean loginCheck(MemberVO memberVO) throws Exception;
	
}
