package com.edu.member.model;

import java.util.Date;

public class MemberDto {

	private int no = 0;
	private String id = "";
	private String pass = "";
	private String name = "";
	private String email = "";
	private String phone = "";
	private String addressMain = "";
	private String addressDetail = "";
	private int point = 0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private int isAdmin = 0;
	private int state = 0;
	
	
	public MemberDto() {
		super();
	}


	public MemberDto(int no, String id, String pass, String name, String email, String phone, String addressMain,
			String addressDetail, int point, Date createDate, Date modifiedDate, int isAdmin, int state) {
		super();
		this.no = no;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addressMain = addressMain;
		this.addressDetail = addressDetail;
		this.point = point;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.isAdmin = isAdmin;
		this.state = state;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddressMain() {
		return addressMain;
	}


	public void setAddressMain(String addressMain) {
		this.addressMain = addressMain;
	}


	public String getAddressDetail() {
		return addressDetail;
	}


	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
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


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", addressMain=" + addressMain + ", addressDetail=" + addressDetail + ", point="
				+ point + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", isAdmin=" + isAdmin
				+ ", state=" + state + "]";
	}

	
}
