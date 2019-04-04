package com.simpleplan.boot.controller;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpleplan.boot.domain.CommentVO;
import com.simpleplan.boot.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Resource(name="com.simpleplan.boot.service.Impl.CommentServiceImpl")
	CommentService commentService;
	
	// 댓글 리스트
	@GetMapping
	public List<CommentVO> list(@RequestParam (value="bno") int board_bno) throws Exception{
		return commentService.commentList(board_bno);
	}
	
	// 댓글 작성
	@PostMapping
	public void add(@RequestBody CommentVO commentVO) throws Exception{
		commentService.commentInsert(commentVO);
	}
	
	// 댓글 삭제
	@DeleteMapping
	public void delete(@RequestParam (value="cno") int comment_cno) throws Exception{
		commentService.commentDelete(comment_cno);
	}
}
