package com.edu.requestdetail.model;

public class RequestDetailDto {
	private int reqNo = 0;
	private String reqDetail = "";
	
	
	public RequestDetailDto() {
		super();
	}


	public RequestDetailDto(int reqNo, String reqDetail) {
		super();
		this.reqNo = reqNo;
		this.reqDetail = reqDetail;
	}


	public int getReqNo() {
		return reqNo;
	}


	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}


	public String getReqDetail() {
		return reqDetail;
	}


	public void setReqDetail(String reqDetail) {
		this.reqDetail = reqDetail;
	}


	@Override
	public String toString() {
		return "RequestDetailDto [reqNo=" + reqNo + ", reqDetail=" + reqDetail + "]";
	}
}
