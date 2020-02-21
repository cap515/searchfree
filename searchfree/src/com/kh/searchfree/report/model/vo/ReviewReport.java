package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class ReviewReport {
	
	private int memberNo;
	private int reviewNo;
	private String reportTitle;
	private String reportContent;
	private Date reportCreateDT;
	private int reportCode;
	
	public ReviewReport() {
		super();
	}

	public ReviewReport(int memberNo, int reviewNo, String reportTitle, String reportContent, Date reportCreateDT,
			int reportCode) {
		super();
		this.memberNo = memberNo;
		this.reviewNo = reviewNo;
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

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
		return "ReviewReport [memberNo=" + memberNo + ", reviewNo=" + reviewNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportCreateDT=" + reportCreateDT + ", reportCode="
				+ reportCode + "]";
	}
	
}
