package com.kh.searchfree.project.model.vo;

import java.sql.Date;

public class ReplyRead {
	
	private int replyNo;
	private String replyContent;
	private Date replyCreateDate;
	private int replyLevel;
	private String memberNick;
	private int projectNo;
	private int replyNo2;
	
	public ReplyRead() {
		// TODO Auto-generated constructor stub
	}

	public ReplyRead(int replyNo, String replyContent, Date replyCreateDate, int replyLevel, String memberNick,
			int projectNo, int replyNo2) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyCreateDate = replyCreateDate;
		this.replyLevel = replyLevel;
		this.memberNick = memberNick;
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

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
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
		return "ReplyRead [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyCreateDate="
				+ replyCreateDate + ", replyLevel=" + replyLevel + ", memberNick=" + memberNick + ", projectNo="
				+ projectNo + ", replyNo2=" + replyNo2 + "]";
	}
	
	
}
