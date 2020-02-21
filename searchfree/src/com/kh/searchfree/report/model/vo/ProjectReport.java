package com.kh.searchfree.report.model.vo;

import java.sql.Date;

public class ProjectReport {

	private int memberNo;
	private int projectNo;
	private String reportTitle;
	private String reportContent;
	private Date reportCreateDT;
	private int reportCode;
	
	public ProjectReport() {
		super();
	}
	
	public ProjectReport(int memberNo, int projectNo, String reportTitle, String reportContent, Date reportCreateDT,
			int reportCode) {
		super();
		this.memberNo = memberNo;
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
		return "ProjectReport [memberNo=" + memberNo + ", projectNo=" + projectNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportCreateDT=" + reportCreateDT + ", reportCode="
				+ reportCode + "]";
	}

}
