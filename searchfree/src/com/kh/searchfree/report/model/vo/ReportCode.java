package com.kh.searchfree.report.model.vo;

public class ReportCode {

	private int reportCode;
	private String reportTitle;
	
	public ReportCode() {
		super();
	}
	public ReportCode(int reportCode, String reportTitle) {
		super();
		this.reportCode = reportCode;
		this.reportTitle = reportTitle;
	}
	
	public int getReportCode() {
		return reportCode;
	}
	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	
	@Override
	public String toString() {
		return "ReportCode [reportCode=" + reportCode + ", reportTitle=" + reportTitle + "]";
	}
	
}
