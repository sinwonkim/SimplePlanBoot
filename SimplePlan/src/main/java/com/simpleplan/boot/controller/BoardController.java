package com.simpleplan.boot.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
