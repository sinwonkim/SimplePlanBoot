package com.simpleplan.boot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleplan.boot.domain.MemberVO;
import com.simpleplan.boot.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="com.simpleplan.boot.service.MemberServiceImpl")
	MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,MemberVO memberVO) throws Exception {
		MemberVO memberList = memberService.listAll();
		if(memberList.getMember_id().equals(memberVO.getMember_id())) {
			System.out.println("동일하다");
		}
		model.addAttribute("memberList",memberList);
		return "test";
	}
	// 회원가입 페이지  view단 
	@RequestMapping(value ="/signUp", method = RequestMethod.GET)
	public String signUpGET() {
		return "signUp";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpPOST(MemberVO memberVO) throws Exception {
		memberService.signUp(memberVO);
		return "test";
	}
}
