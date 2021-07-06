package com.edu.point.model;

import java.util.Date;

public class PointDto {

	private int pno = 0;
	private int no = 0;
	private int point = 0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private String route = "";
	private int isAdmin = 0;
	
	
	public PointDto(int pno, int no, int point, Date createDate, Date modifiedDate, String route) {
		super();
		this.pno = pno;
		this.no = no;
		this.point = point;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.route = route;
	}
	public PointDto() {
		super();
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "PointDto [pno=" + pno + ", no=" + no + ", point=" + point + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + ", route=" + route + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
