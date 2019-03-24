package com.simpleplan.boot.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="com.simpleplan.boot.service.BoardServiceImpl")
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		model.addAttribute("list", boardService.boardList());
		
		return "boardList";
	}
	
	@RequestMapping("/write")
	public String write(Model model,BoardVO boardVO, HttpSession session) throws Exception{
		boardService.boardList(boardVO);
		String id = (String)session.getAttribute("member_id");
		model.addAttribute("id", id);
		System.out.println("session id 값은 입니다."+id);
		return "boardWrite";
	}
}
