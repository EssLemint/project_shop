package com.edu.basket.model;

public class BasketDto {
	
	private int id = 0;
	private int productCount = 0;
	private int totalPrice = 0;
	private int productNo =0;
	private int membersNo =0;
	private String name = "";
	
	public BasketDto() {
		super();
	}

	public BasketDto(int id, int productCount, int totalPrice, int productNo, int membersNo, String name) {
		super();
		this.id = id;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.productNo = productNo;
		this.membersNo = membersNo;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getMembersNo() {
		return membersNo;
	}

	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BasketDto [id=" + id + ", productCount=" + productCount + ", totalPrice=" + totalPrice + ", productNo="
				+ productNo + ", membersNo=" + membersNo + ", name=" + name + "]";
	}
	
	

}

