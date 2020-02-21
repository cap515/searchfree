package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class ReplyReport {

	private int memberNo;
	private int replyNo;
	private String reportTitle;
	private String reportContent;
	private Date reportCreateDT;
	private int reportCode;
	
	public ReplyReport() {
		super();
	}
	
	public ReplyReport(int memberNo, int replyNo, String reportTitle, String reportContent, Date reportCreateDT,
			int reportCode) {
		super();
		this.memberNo = memberNo;
		this.replyNo = replyNo;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportCreateDT = reportCreateDT;
		this.reportCode = reportCode;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Date getReportCreateDT() {
		return reportCreateDT;
	}

	public void setReportCreateDT(Date reportCreateDT) {
		this.reportCreateDT = reportCreateDT;
	}

	public int getReportCode() {
		return reportCode;
	}

	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}

	@Override
	public String toString() {
		return "ReplyReport [memberNo=" + memberNo + ", replyNo=" + replyNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportCreateDT=" + reportCreateDT + ", reportCode="
				+ reportCode + "]";
	}
	
}
