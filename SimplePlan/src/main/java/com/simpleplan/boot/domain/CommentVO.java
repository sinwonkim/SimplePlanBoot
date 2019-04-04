package com.simpleplan.boot.domain;

public class CommentVO {
	private int comment_cno;
	private int comment_bno;
	private String comment_content;
	private String comment_writer; 
	private String comment_regdate;
	
	public int getComment_bno() {
		return comment_bno;
	}

	public void setComment_bno(int comment_bno) {
		this.comment_bno = comment_bno;
	}

	public int getComment_cno() {
		return comment_cno;
	}

	public void setComment_cno(int comment_cno) {
		this.comment_cno = comment_cno;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_writer() {
		return comment_writer;
	}

	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}

	public String getComment_regdate() {
		return comment_regdate;
	}

	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}

	@Override
	public String toString() {
		return "CommentVO [comment_cno=" + comment_cno + ", comment_bno=" + comment_bno + ", comment_content="
				+ comment_content + ", comment_writer=" + comment_writer + ", comment_regdate=" + comment_regdate + "]";
	}
}
