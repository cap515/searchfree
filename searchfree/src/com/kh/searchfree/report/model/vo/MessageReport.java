package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class MessageReport {

	private int memberNo;
	private int messageNo;
	private String reportTitle;
	private String reportContent;
	private Date reportMsgDT;
	private int reportCode;
	
	public MessageReport() {
		super();
	}
	
	public MessageReport(int memberNo, int messageNo, String reportTitle, String reportContent, Date reportMsgDT,
			int reportCode) {
		super();
		this.memberNo = memberNo;
		this.messageNo = messageNo;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportMsgDT = reportMsgDT;
		this.reportCode = reportCode;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
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
	public Date getReportMsgDT() {
		return reportMsgDT;
	}
	public void setReportMsgDT(Date reportMsgDT) {
		this.reportMsgDT = reportMsgDT;
	}
	public int getReportCode() {
		return reportCode;
	}
	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}
	
	@Override
	public String toString() {
		return "MessageReport [memberNo=" + memberNo + ", messageNo=" + messageNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportMsgDT=" + reportMsgDT + ", reportCode=" + reportCode
				+ "]";
	}
	
}
