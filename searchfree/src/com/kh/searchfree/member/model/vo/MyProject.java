package com.kh.searchfree.member.model.vo;

import java.sql.Date;

public class MyProject {
private Date createDate;
private Date expriredDate;
private String projectTitle;
private String projectSummary;

public MyProject() {
	// TODO Auto-generated constructor stub
}


public MyProject(Date expriredDate, String projectTitle, String projectSummary) {
	super();
	this.expriredDate = expriredDate;
	this.projectTitle = projectTitle;
	this.projectSummary = projectSummary;
}

public Date getCreateDate() {
	return createDate;
}

public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

public Date getExpriredDate() {
	return expriredDate;
}

public void setExpriredDate(Date expriredDate) {
	this.expriredDate = expriredDate;
}

public String getProjectTitle() {
	return projectTitle;
}

public void setProjectTitle(String projectTitle) {
	this.projectTitle = projectTitle;
}

public String getProjectSummary() {
	return projectSummary;
}

public void setProjectSummary(String projectSummary) {
	this.projectSummary = projectSummary;
}

@Override
public String toString() {
	return "MyProject [createDate=" + createDate + ", expriredDate=" + expriredDate + ", projectTitle=" + projectTitle
			+ ", projectSummary=" + projectSummary + "]";
}



}
