package com.edu.orders.model;

import java.util.Date;

public class OrdersDto {
	
	private int no = 0;
	private Date date = null;
	private int totalPrice = 0;
	private int membersNo = 0;
	private int productNo = 0;
	private int productCount = 0;
	private int orderState = 0;
	private int orderGroup = 0;
	
	public OrdersDto() {
		super();
	}

	public OrdersDto(int membersNo, int orderState) {
		super();
		this.membersNo = membersNo;
		this.orderState = orderState;
	}

	public OrdersDto(int no, Date date, int totalPrice, int membersNo, int productNo, int productCount, int orderState,
			int orderGroup) {
		super();
		this.no = no;
		this.date = date;
		this.totalPrice = totalPrice;
		this.membersNo = membersNo;
		this.productNo = productNo;
		this.productCount = productCount;
		this.orderState = orderState;
		this.orderGroup = orderGroup;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getMembersNo() {
		return membersNo;
	}


	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getProductCount() {
		return productCount;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public int getOrderState() {
		return orderState;
	}


	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}


	public int getOrderGroup() {
		return orderGroup;
	}


	public void setOrderGroup(int orderGroup) {
		this.orderGroup = orderGroup;
	}


	@Override
	public String toString() {
		return "OrdersDto [no=" + no + ", date=" + date + ", totalPrice=" + totalPrice + ", membersNo=" + membersNo
				+ ", productNo=" + productNo + ", productCount=" + productCount + ", orderState=" + orderState
				+ ", orderGroup=" + orderGroup + "]";
	}
	
	
	
	
}
