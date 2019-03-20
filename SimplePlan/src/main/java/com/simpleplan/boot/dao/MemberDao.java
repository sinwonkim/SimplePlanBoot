package com.simpleplan.boot.dao;

import com.simpleplan.boot.domain.MemberVO;

public interface MemberDao {
	
	public MemberVO listAll() throws Exception;
	
	void signUp(MemberVO memberVO) throws Exception;
	
}
