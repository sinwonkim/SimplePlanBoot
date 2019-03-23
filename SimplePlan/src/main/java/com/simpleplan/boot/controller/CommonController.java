package com.simpleplan.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleplan.boot.domain.MemberVO;
import com.simpleplan.boot.service.BoardService;

@Controller
public class CommonController {
	@Resource(name="com.simpleplan.boot.service.BoardServiceImpl")
	BoardService boardService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getStudent(HttpServletRequest httpServletRequest, Model model) {
        
        System.out.println("RequestMethod.GET");
        
        String id = httpServletRequest.getParameter("id");
        System.out.println("id : " + id);
        model.addAttribute("studentId", id);
        
        return "test";
    }
	@RequestMapping(value = "/voTest", method = RequestMethod.GET)
	public String loginVo(MemberVO memberVO,Model model) {
		
		System.out.println(memberVO.getMember_id());
		System.out.println(memberVO.getMember_password());
		model.addAttribute("memberVO", memberVO);
		return "test";
	}
	
	
	
   	@RequestMapping("/test1")
	private ModelAndView jspTest() throws Exception {
		ModelAndView modelAndView = new ModelAndView("test"); // 리턴 view페이지 설정 
		Map<String, String> charactor =  new HashMap<String,String>();
		charactor.put("vein","베인");
		charactor.put("yasuo","야스오");
		modelAndView.addObject("home","ModelAndView 클래스를  활용한 : HelloWorld");
		modelAndView.addObject("charactor",charactor);
	/*	System.out.println(">>>>>>>boardCount Test :"+boardService.boardCount()); // TEST
*/		System.out.println();
		return modelAndView;
	}	
	
	@RequestMapping("/write")
	private String boardWrite() {
		
		return "boardWrite";
	}
/*	@RequestMapping("/main")
	private String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	private String login() {
		return "login";
	}
	
	@RequestMapping("/signUp")
	private String signUp() {
		return "signUp";
	}*/
}
