package com.kh.searchfree.admin.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeCreateDT;
	private char noticeDeleteYN;
	private int noticeCode;
	
	public Notice() {
		super();
	}
	public Notice(int noticeNo, String noticeContent, Date noticeCreateDT, char noticeDeleteYN, int noticeCode,
			int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeContent = noticeContent;
		this.noticeCreateDT = noticeCreateDT;
		this.noticeDeleteYN = noticeDeleteYN;
		this.noticeCode = noticeCode;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeCreateDT() {
		return noticeCreateDT;
	}
	public void setNoticeCreateDT(Date noticeCreateDT) {
		this.noticeCreateDT = noticeCreateDT;
	}
	public char getNoticeDeleteYN() {
		return noticeDeleteYN;
	}
	public void setNoticeDeleteYN(char noticeDeleteYN) {
		this.noticeDeleteYN = noticeDeleteYN;
	}
	public int getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeCreateDT=" + noticeCreateDT + ", noticeDeleteYN=" + noticeDeleteYN + ", noticeCode="
				+ noticeCode + "]";
	}
	
	
	
}
