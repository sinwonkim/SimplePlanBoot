package com.simpleplan.boot.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simpleplan.boot.dao.CommentDao;
import com.simpleplan.boot.domain.CommentVO;
import com.simpleplan.boot.service.CommentService;


@Service("com.simpleplan.boot.service.Impl.CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	
	@Resource(name="com.simpleplan.boot.dao.Impl.CommentDaoImpl")
	CommentDao commentDao;
	
	//댓글 보기
	@Override
	public List<CommentVO> commentList(int board_bno) throws Exception {
		
		return commentDao.commentList(board_bno);
	}
	
	//댓글 등록
	@Override
	public void commentInsert(CommentVO commentVO) throws Exception {
		
		commentDao.commentInsert(commentVO);
	}

	//댓글 삭제
	@Override
	public void commentDelete(int comment_cno) throws Exception {
		
		commentDao.commentDelete(comment_cno);
		
	}
}
