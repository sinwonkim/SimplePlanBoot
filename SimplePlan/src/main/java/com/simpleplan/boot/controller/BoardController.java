package com.simpleplan.boot.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="com.simpleplan.boot.service.BoardServiceImpl")
	BoardService boardService;
	
	// 게시판 리스트
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		model.addAttribute("list", boardService.boardList());
		
		return "boardList";
	}
	
	// 화면 레이아웃 테스트 
	@RequestMapping("/test")
	public String layOutTest() throws Exception {
		
		return "boardTest";
	}
	
	// 게시판 리스트 상세보기
	@RequestMapping("/detail/{board_bno}")
	public String detail(@PathVariable int board_bno, Model model) throws Exception {
		model.addAttribute("detail", boardService.boardDetail(board_bno));
		
		return "boardDetail";
	}
	
	// 게시판 글 수정  폼 보기
	@RequestMapping(value = "/update/{board_bno}", method = RequestMethod.GET)
	public String updateGet(@PathVariable int board_bno, Model model) throws Exception {
		model.addAttribute("detail", boardService.boardDetail(board_bno));
		
		return "boardUpdate";
	}
	
	//게시판 글 수정 하기 
	@RequestMapping(value = "/update", method= RequestMethod.POST)
	public String updatePost(BoardVO boardVO) throws Exception {
		boardService.boardUpdate(boardVO);
		
		
		return "redirect:/board/detail/"+boardVO.getBoard_bno();
	}
	
	// 게시판 글 등록 보기
	@RequestMapping(value = "/write" , method = RequestMethod.GET)
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
