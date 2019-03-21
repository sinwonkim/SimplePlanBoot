package com.simpleplan.boot.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simpleplan.boot.domain.MemberVO;
import com.simpleplan.boot.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="com.simpleplan.boot.service.MemberServiceImpl")
	MemberService memberService;
	
	@RequestMapping("/main")
	private String main() {
		return "main";
	}
	
	// 로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,MemberVO memberVO) throws Exception {
		
		return "login";
	}
	// 로그인 처리 
	@RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
	public ModelAndView loginCheck(@ModelAttribute MemberVO memberVO, HttpSession session) throws Exception {
		boolean result = memberService.loginCheck(memberVO, session);						
		if (result) { // true일 경우 세션에 등록 
			// 세션 변수 등록 
			session.setAttribute("member_id", memberVO.getMember_id());
			session.setAttribute("member_name", memberVO.getMember_name());
		}
		ModelAndView mav = new ModelAndView();
		if (result == true) {// 로그인 성공
			mav.setViewName("main");
			mav.addObject("msg", "success");
		} else { // 로그인 실패
			// login.jsp로 이동 
			mav.setViewName("member/login");
			mav.addObject("msg","fail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String loignOut(HttpSession session) {
		
		session.invalidate();
		return "login";
	}
	
	
	// 회원가입 페이지  view단 
	@RequestMapping(value ="/signUp", method = RequestMethod.GET)
	public String signUpGET() {
		return "signUp";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpPOST(MemberVO memberVO,RedirectAttributes redirectAttributes) throws Exception {
		memberService.signUp(memberVO);
		redirectAttributes.addAttribute("msg","SIGNUP");
		
		return "redirect:/member/login";
	}
}
