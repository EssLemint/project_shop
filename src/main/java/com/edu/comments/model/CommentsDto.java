package com.edu.comments.model;

import java.util.Date;

public class CommentsDto {
	
	private int no = 0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private String body = "";
	private int state = 0;
	private int boardNo = 0;
	private int membersNo = 0;
	
	
	public CommentsDto() {
		super();
	}


	public CommentsDto(int no, Date createDate, Date modifiedDate, String body, int state, int boardNo, int membersNo) {
		super();
		this.no = no;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.body = body;
		this.state = state;
		this.boardNo = boardNo;
		this.membersNo = membersNo;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public int getMembersNo() {
		return membersNo;
	}


	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}


	@Override
	public String toString() {
		return "CommentsDto [no=" + no + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", body="
				+ body + ", state=" + state + ", boardNo=" + boardNo + ", membersNo=" + membersNo + "]";
	}


}
