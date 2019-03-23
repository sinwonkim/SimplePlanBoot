package com.simpleplan.boot.domain;

public class BoardVO {
	private int board_bno;
	private String board_title;
	private String board_content;
	private String board_writer; 
	private String board_regdate;
	
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [board_bno=" + board_bno + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", board_regdate=" + board_regdate + "]";
	}
	
	
}
