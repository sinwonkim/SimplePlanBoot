package com.simpleplan.boot.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleplan.boot.domain.MemberVO;
import com.simpleplan.boot.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="com.simpleplan.boot.service.Impl.MemberServiceImpl")
	MemberService memberService;
	
	// 로그인 화면
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login(Model model,MemberVO memberVO) throws Exception {
			
			return "login";
		}
	
	// 로그인 처리 
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute MemberVO memberVO,HttpServletResponse response,HttpServletRequest request, HttpSession session) throws Exception {
		 String cookie = request.getParameter("useCookie");
		 System.out.println(">>>>>>>>>"+cookie);
		boolean result = memberService.loginCheck(memberVO);	
		String location = "";
		if (result) { // true일 경우 세션에 등록 
			// 세션 변수 등록 
			session.setAttribute("member_id", memberVO.getMember_id());
			session.setAttribute("member_name", memberVO.getMember_name());
			System.out.println("sessison >>>>>>>>>>>>"+session.getAttribute("member_id"));
		}
		// cookie
		if(request.getParameter("useCookie") != null) {
			/*Cookie loginCookie = new Cookie("useCookie", (String) session.getAttribute("member_id"));*/
			Cookie loginCookie = new Cookie("useCookie", "Vein");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60*60*24*7);
			
			response.addCookie(loginCookie);
			
		}
		if (result == true) {// 로그인 성공
			location = "/";
		
		} else { // 로그인 실패
			// login.jsp로 이동 
			location = "login";
		}
		return "redirect:"+location;
	}
	
	// 로그아웃
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
	public String signUpPOST(@ModelAttribute MemberVO memberVO,HttpSession session, Model model) throws Exception {
		boolean result = memberService.signUpCheck(memberVO);
		String location ="";
		if(result) { // 회원여부 존재하지 않으면  true 를 반환해서  회원가입 실행 
			location ="main"; 
			memberService.signUp(memberVO);	 // 실질적 회원가입 
			session.setAttribute("member_id", memberVO.getMember_id());
			session.setAttribute("member_name", memberVO.getMember_name());
			model.addAttribute("signSucess", "회원가입되었습니다.");
		} else { 
			location ="signUp"; // false 이미 존재하는 아이디면 회원가입 페이지로
			model.addAttribute("errMsg", "id가 중복되어 회원가입에 실패하였습니다.");
		}
		return location;
	}
}
