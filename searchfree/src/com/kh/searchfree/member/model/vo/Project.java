package com.kh.searchfree.member.model.vo;

import java.sql.Date;

public class Project {
	
	private String projectTitle;
	private Date createDate;
	private String projectSummary;
	private Date expiredDate;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(String projectTitle, String projectSummary, Date createDate ) {
		super();
		this.projectTitle = projectTitle;
		this.projectSummary = projectSummary;
		this.createDate = createDate;
	}

	public Project(Date expiredDate, String projectTitle) {
		super();
		this.expiredDate = expiredDate;
		this.projectTitle = projectTitle;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getProjectSummary() {
		return projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	@Override
	public String toString() {
		return "Title : " + projectTitle + "/ 작성일 : " + createDate + "\n" + " 요약 : "
				+ projectSummary ;
	}
	


}
