package com.simpleplan.boot.service;

import java.util.List;

import com.simpleplan.boot.domain.CommentVO;

public interface CommentService {
		
		//댓글 리스트
		public List<CommentVO> commentList(int board_bno) throws Exception;
		
		//댓글 작성
		public void commentInsert(CommentVO CommentVO) throws Exception;
		
		//댓글 삭제
		public void commentDelete(int comment_cno) throws Exception;
}
