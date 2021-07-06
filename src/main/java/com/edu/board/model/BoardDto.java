package com.edu.board.model;

import java.util.Date;

import com.edu.member.model.MemberDto;
import com.edu.orders.model.OrdersDto;
import com.edu.product.model.ProductDto;

public class BoardDto {
	
	private int no = 0;
	private String title = "";
	private String body = "";
	private Date createDate = null;
	private Date modifiedDate = null;
	private int state = 0;
	private int memberNO = 0;
	private int ordersNO =0;
	private int productNO = 0;
	
	private MemberDto memberDto;
	private OrdersDto ordersDro;
	private ProductDto productDto;
	
	
	public BoardDto() {
		super();
	}

	public BoardDto(int no, String title, String body, Date createDate, Date modifiedDate, int state, int memberNO,
			int ordersNO, int productNO) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.state = state;
		this.memberNO = memberNO;
		this.ordersNO = ordersNO;
		this.productNO = productNO;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public int getMemberNO() {
		return memberNO;
	}

	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}

	public int getOrdersNO() {
		return ordersNO;
	}

	public void setOrdersNO(int ordersNO) {
		this.ordersNO = ordersNO;
	}

	public int getProductNO() {
		return productNO;
	}

	public void setProductNO(int productNO) {
		this.productNO = productNO;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", body=" + body + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + ", state=" + state + ", memberNO=" + memberNO + ", ordersNO="
				+ ordersNO + ", productNO=" + productNO + "]";
	}
	
	

}
