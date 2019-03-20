package com.simpleplan.boot.service;

import java.util.List;

import javax.annotation.Resource;

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

	@Override
	public void signUp(MemberVO memberVO) throws Exception {

		 memberDao.signUp(memberVO);
		
	}



}
