package com.simpleplan.boot.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	// 게시판 리스트
	@RequestMapping(value="/write" , method = RequestMethod.GET)
	public String write(Model model,HttpSession session) throws Exception {
		String id = (String)session.getAttribute("member_id");
		model.addAttribute("id", id);
		return "boardWrite";
	}
	
	// 게시판 글 등록
	@RequestMapping(value="/write" , method = RequestMethod.POST)
	public String write(Model model,BoardVO boardVO, HttpSession session) throws Exception{
		
		boardService.boardInsert(boardVO); // 게시판 글 등록
	
		session.setAttribute("boardMsg", "글이 등록되었습니다.");
				
		return "redirect:/board/list";

	}
}
