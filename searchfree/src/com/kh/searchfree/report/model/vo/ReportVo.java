package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class ReportVo {
	
	private int memberNo;
	private int toReportNo;
	private int projectNo;
	private String reportTitle;
	private String reportContent;
	private Date reportCreateDT;
	private int reportCode;
	
	public ReportVo() {
		super();
	}

	public ReportVo(int memberNo, int toReportNo, int projectNo, String reportTitle, String reportContent,
			Date reportCreateDT, int reportCode) {
		super();
		this.memberNo = memberNo;
		this.toReportNo = toReportNo;
		this.projectNo = projectNo;
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

	public int getToReportNo() {
		return toReportNo;
	}

	public void setToReportNo(int toReportNo) {
		this.toReportNo = toReportNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
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
		return "ReportVo [memberNo=" + memberNo + ", toReportNo=" + toReportNo + ", projectNo=" + projectNo
				+ ", reportTitle=" + reportTitle + ", reportContent=" + reportContent + ", reportCreateDT="
				+ reportCreateDT + ", reportCode=" + reportCode + "]";
	}
}
