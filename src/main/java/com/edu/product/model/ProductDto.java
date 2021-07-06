package com.edu.product.model;

import java.util.Date;

public class ProductDto {
	
	private int no = 0;
	private String id = "";
	private String name = "";
	private int price = 0;
	private int stock = 0;
	private String detail = "";
	private int salesRate = 0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private int state = 0;
	private String storedFileName = "";
	
	public ProductDto() {
		super();
	}

	public ProductDto(int no, String id, String name, int price, int stock, String detail, int sales_rate,
			Date createDate, Date modifiedDate, int state, String storedFileName) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.detail = detail;
		this.salesRate = sales_rate;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.state = state;
		this.storedFileName = storedFileName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getSales_rate() {
		return salesRate;
	}

	public void setSales_rate(int sales_rate) {
		this.salesRate = sales_rate;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public int getSalesRate() {
		return salesRate;
	}

	public void setSalesRate(int salesRate) {
		this.salesRate = salesRate;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	@Override
	public String toString() {
		return "ProductDto [no=" + no + ", id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", detail=" + detail + ", salesRate=" + salesRate + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + ", state=" + state + ", storedFileName=" + storedFileName + "]";
	}

	

}
