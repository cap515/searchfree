package com.kh.searchfree.admin.model.vo;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private String replyContent;
	private char replyDeleteYN;
	private Date replyCreateDate;
	private int replyLevel;
	private int memberNo;
	private int projectNo;
	private int replyNo2;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyNo, String replyContent, char replyDeleteYN, Date replyCreateDate, int replyLevel,
			int memberNo, int projectNo, int replyNo2) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyDeleteYN = replyDeleteYN;
		this.replyCreateDate = replyCreateDate;
		this.replyLevel = replyLevel;
		this.memberNo = memberNo;
		this.projectNo = projectNo;
		this.replyNo2 = replyNo2;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public char getReplyDeleteYN() {
		return replyDeleteYN;
	}

	public void setReplyDeleteYN(char replyDeleteYN) {
		this.replyDeleteYN = replyDeleteYN;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getReplyNo2() {
		return replyNo2;
	}

	public void setReplyNo2(int replyNo2) {
		this.replyNo2 = replyNo2;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyDeleteYN=" + replyDeleteYN
				+ ", replyCreateDate=" + replyCreateDate + ", replyLevel=" + replyLevel + ", memberNo=" + memberNo
				+ ", projectNo=" + projectNo + ", replyNo2=" + replyNo2 + "]";
	}
	
	
}
