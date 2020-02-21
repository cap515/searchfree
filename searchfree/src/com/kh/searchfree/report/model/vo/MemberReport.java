package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class MemberReport {

	private int memberNo;
	private int memberNo2;
	private String reportTitle;
	private String reportContent;
	private Date reportCreateDT;
	private int reportCode;
	
	public MemberReport() {
		super();
	}

	public MemberReport(int memberNo, int memberNo2, String reportTitle, String reportContent, Date reportCreateDT,
			int reportCode) {
		super();
		this.memberNo = memberNo;
		this.memberNo2 = memberNo2;
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

	public int getMemberNo2() {
		return memberNo2;
	}

	public void setMemberNo2(int memberNo2) {
		this.memberNo2 = memberNo2;
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
		return "MemberReport [memberNo=" + memberNo + ", memberNo2=" + memberNo2 + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportCreateDT=" + reportCreateDT + ", reportCode="
				+ reportCode + "]";
	}
	
}
