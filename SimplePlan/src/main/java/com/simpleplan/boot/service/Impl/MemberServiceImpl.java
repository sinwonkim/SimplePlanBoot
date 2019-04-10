package com.simpleplan.boot.service.Impl;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.MemberDao;
import com.simpleplan.boot.domain.MemberVO;
import com.simpleplan.boot.service.MemberService;

@Service("com.simpleplan.boot.service.Impl.MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="com.simpleplan.boot.dao.Impl.MemberDaoImpl")
	MemberDao memberDao;
	
	@Override
	public MemberVO listAll() throws Exception {		
		return memberDao.listAll();
	}
	
	// 회원가입 
	@Override
	public void signUp(MemberVO memberVO) throws Exception {
		//비밀번호 bcrypt암호화
		String hashedPw = BCrypt.hashpw(memberVO.getMember_password(), BCrypt.gensalt());
		memberVO.setMember_password(hashedPw);
		memberDao.signUp(memberVO);
	}

	// 회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO memberVO) throws Exception {
		String hashedPw = memberDao.loginCheck(memberVO);
		
		boolean result = BCrypt.checkpw(memberVO.getMember_password(), hashedPw);
		
		return result;
	}
	
	//중복 회원 확인 
	@Override
	public boolean signUpCheck(MemberVO memberVO) throws Exception {
		String result = memberDao.signUpCheck(memberVO);

		return (result == null) ? true : false;
	}

	

	



}
