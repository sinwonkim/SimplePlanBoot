package com.simpleplan.boot.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleplan.boot.domain.BoardVO;
import com.simpleplan.boot.domain.CommentVO;
import com.simpleplan.boot.domain.Criteria;
import com.simpleplan.boot.domain.PageMaker;
import com.simpleplan.boot.service.BoardService;
import com.simpleplan.boot.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="com.simpleplan.boot.service.Impl.BoardServiceImpl")
	BoardService boardService;

	@Resource(name="com.simpleplan.boot.service.Impl.CommentServiceImpl")
	CommentService commentService;
	
	// 게시판 리스트
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(@ModelAttribute Criteria cri,Model model) throws Exception{
		System.out.println("getKeyword >>>>>>>>>>>>>>>>"+cri.getKeyword());
	
		model.addAttribute("list", boardService.listSearch(cri));
		model.addAttribute("cri", cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(boardService.countPaging(cri)); // 하단부 페이징 
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "boardList";
	}
	
	//listCriteria 
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public String listAll(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		
		model.addAttribute("list", boardService.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(boardService.countPaging(cri));
		
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "listCri";
	}
	
	// listPage 테스트 
	@RequestMapping("/listpage")
	public void testListCriteria() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO>  list = boardService.listCriteria(cri);
		for(BoardVO boardVO : list) { 
			System.out.println(boardVO.getBoard_bno() + " : " + boardVO.getBoard_title());
		}
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
	
	// 게시판 글 삭제하기
	@RequestMapping(value = "/delete/{board_bno}", method = RequestMethod.GET)
	public String delete(@PathVariable int board_bno) throws Exception {
		boardService.boardDelete(board_bno);
		return "redirect:/board/list";
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
	
	// 댓글 등록
	@RequestMapping(value="/comment" , method = RequestMethod.POST)
	public String commentWrite(Model model, CommentVO commentVO, HttpSession session) throws Exception{
		model.addAttribute("commentVO", commentVO);
		commentService.commentInsert(commentVO); // 댓글 등록
		session.setAttribute("comment_writer", commentVO.getComment_writer());
		return "redirect:/board/detail/"+commentVO.getComment_bno();
	}
}
