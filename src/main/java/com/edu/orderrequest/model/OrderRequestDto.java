package com.edu.orderrequest.model;

public class OrderRequestDto {
	
	
	private int membersNo = 0;
	private int ordersNo = 0;
	private int reqNo = 0;
	private String ordersAddressMain = "";
	private String ordersAddressDetail = "";
	private String ordersPhone = "";
	private int no = 0;	//pk


	public OrderRequestDto() {
		super();
	}


	public OrderRequestDto(int membersNo, int ordersNo, int reqNo, String ordersAddressMain,
			String ordersAddressDetail, String ordersPhone, int no) {
		super();
		this.membersNo = membersNo;
		this.ordersNo = ordersNo;
		this.reqNo = reqNo;
		this.ordersAddressMain = ordersAddressMain;
		this.ordersAddressDetail = ordersAddressDetail;
		this.ordersPhone = ordersPhone;
		this.no = no;
	}

	public int getMembersNo() {
		return membersNo;
	}


	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}


	public int getOrdersNo() {
		return ordersNo;
	}


	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}


	public int getReqNo() {
		return reqNo;
	}


	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}


	public String getOrdersAddressMain() {
		return ordersAddressMain;
	}


	public void setOrdersAddressMain(String ordersAddressMain) {
		this.ordersAddressMain = ordersAddressMain;
	}


	public String getOrdersAddressDetail() {
		return ordersAddressDetail;
	}


	public void setOrdersAddressDetail(String ordersAddressDetail) {
		this.ordersAddressDetail = ordersAddressDetail;
	}


	public String getOrdersPhone() {
		return ordersPhone;
	}


	public void setOrdersPhone(String ordersPhone) {
		this.ordersPhone = ordersPhone;
	}


	public int getno() {
		return no;
	}


	public void setno(int no) {
		this.no = no;
	}


	@Override
	public String toString() {
		return "OrderRequestDto [membersNo=" + membersNo + ", ordersNo=" + ordersNo
				+ ", reqNo=" + reqNo + ", ordersAddressMain=" + ordersAddressMain + ", ordersAddressDetail="
				+ ordersAddressDetail + ", ordersPhone=" + ordersPhone + ", no=" + no + "]";
	}


	
}
