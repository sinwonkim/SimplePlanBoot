package com.simpleplan.boot.service;

import com.simpleplan.boot.domain.MemberVO;

public interface MemberService {

	MemberVO listAll() throws Exception;
	
	void signUp(MemberVO memberVO) throws Exception;
}
