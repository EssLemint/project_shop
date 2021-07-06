package com.edu.bimage.model;

import java.util.Date;

public class BimageDto {

	private int no = 0; 
	private String orginalFileName = "";
	private String storedFileName = "";
	private int imageFileSize =0;
	private Date createDate = null;
	private Date modifiedDate = null;
	private int boardNo = 0;
	
	public BimageDto() {
		super();
	}

	public BimageDto(int no, String orginalFileName, String storedFileName, int imageFileSize, Date createDate,
			Date modifiedDate) {
		super();
		this.no = no;
		this.orginalFileName = orginalFileName;
		this.storedFileName = storedFileName;
		this.imageFileSize = imageFileSize;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.boardNo = boardNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOrginalFileName() {
		return orginalFileName;
	}

	public void setOrginalFileName(String orginalFileName) {
		this.orginalFileName = orginalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public int getImageFileSize() {
		return imageFileSize;
	}

	public void setImageFileSize(int imageFileSize) {
		this.imageFileSize = imageFileSize;
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

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "BimageDto [no=" + no + ", orginalFileName=" + orginalFileName + ", storedFileName=" + storedFileName
				+ ", imageFileSize=" + imageFileSize + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate
				+ ", boardNo=" + boardNo + "]";
	}


	
	
	
	
}
