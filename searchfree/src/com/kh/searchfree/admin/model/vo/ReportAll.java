package com.kh.searchfree.admin.model.vo;

import java.sql.Date;

public class ReportAll {

	private int reportListNo;
	private int reportCode;
	private String reportTitle;
	private String reportContent; 
	private Date reportCreateDT;
	private String oriMemberId; //원글쓴이
	private String memberId; // 신고자
	private char reportStatus; // 처리상태-> DB에 없는 값
	
	//리뷰신고게시판용
	private int reviewNo;
	private int projectNo;
	private int memberNo;
	
	

	public ReportAll() {
		super();
	}
	
	
	public ReportAll(int reportCode, String memberId, Date reportCreateDT, char reportStatus) {
		super();
		this.reportCode = reportCode;
		this.memberId = memberId;
		this.reportCreateDT = reportCreateDT;
		this.reportStatus = reportStatus;
	}

	
	
	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getReportContent() {
		return reportContent;
	}


	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}


	public String getOriMemberId() {
		return oriMemberId;
	}


	public void setOriMemberId(String oriMemberId) {
		this.oriMemberId = oriMemberId;
	}


	public int getReportListNo() {
		return reportListNo;
	}


	public void setReportListNo(int reportListNo) {
		this.reportListNo = reportListNo;
	}


	public String getReportTitle() {
		return reportTitle;
	}


	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}


	public char getReportStatus() {
		return reportStatus;
	}
	
	public void setReportStatus(char reportStatus) {
		this.reportStatus = reportStatus;
	}
	public int getReportCode() {
		return reportCode;
	}

	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getReportCreateDT() {
		return reportCreateDT;
	}

	public void setReportCreateDT(Date reportCreateDT) {
		this.reportCreateDT = reportCreateDT;
	}


	@Override
	public String toString() {
		return "ReportAll [reportListNo=" + reportListNo + ", reportCode=" + reportCode + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportCreateDT=" + reportCreateDT + ", oriMemberId="
				+ oriMemberId + ", memberId=" + memberId + ", reportStatus=" + reportStatus + ", reviewNo=" + reviewNo
				+ ", projectNo=" + projectNo + ", memberNo=" + memberNo + "]";
	}


	

}
