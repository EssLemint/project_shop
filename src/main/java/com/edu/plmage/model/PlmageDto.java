package com.edu.plmage.model;

import java.util.Date;

import com.edu.product.model.ProductDto;

public class PlmageDto {
	private int no = 0;
	private String originalFileName = "";
	private String storedFileName = "";
	private int fileSize = 0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private int productNo = 0;
	
	private ProductDto product;

	public PlmageDto() {
		super();
	}

	public PlmageDto(int no, String originalFileName, String storedFileName, int fileSize, Date createDate,
			Date modifiedDate, int productNo) {
		super();
		this.no = no;
		this.originalFileName = originalFileName;
		this.storedFileName = storedFileName;
		this.fileSize = fileSize;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.productNo = productNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
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

	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "PlmageDto [no=" + no + ", originalFileName=" + originalFileName + ", storedFileName=" + storedFileName
				+ ", fileSize=" + fileSize + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate
				+ ", productNo=" + productNo + "]";
	}

	

}
