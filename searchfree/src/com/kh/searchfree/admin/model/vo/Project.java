package com.kh.searchfree.admin.model.vo;

import java.sql.Date;


public class Project {
	private int projectNo;
	private int projectStatus;
	private int projectPrice;
	private Date projectCreateDate;
	private Date projectModifyDate;
	private Date projectExpiredDate;
	private Date projectStartDate;
	private String projectTitle;
	private String projectSummary;
	private String projectContent;
	private String projectThumbNail;
	private char projectDeleteYN;
	private String projectTag;
	private int projectAlt;
	private int projectCount;
	private int memberNo;
	private int projectCategoryCode1;
	private int projectCategoryCode2;
	
	public Project() {
	}

	public Project(int projectNo, int projectStatus, int projectPrice, Date projectCreateDate, Date projectModifyDate,
			Date projectExpiredDate, Date projectStartDate, String projectTitle, String projectSummary,
			String projectContent, String projectThumbNail, char projectDeleteYN, String projectTag, int projectAlt,
			int projectCount, int memberNo, int projectCategoryCode1, int projectCategoryCode2) {
		super();
		this.projectNo = projectNo;
		this.projectStatus = projectStatus;
		this.projectPrice = projectPrice;
		this.projectCreateDate = projectCreateDate;
		this.projectModifyDate = projectModifyDate;
		this.projectExpiredDate = projectExpiredDate;
		this.projectStartDate = projectStartDate;
		this.projectTitle = projectTitle;
		this.projectSummary = projectSummary;
		this.projectContent = projectContent;
		this.projectThumbNail = projectThumbNail;
		this.projectDeleteYN = projectDeleteYN;
		this.projectTag = projectTag;
		this.projectAlt = projectAlt;
		this.projectCount = projectCount;
		this.memberNo = memberNo;
		this.projectCategoryCode1 = projectCategoryCode1;
		this.projectCategoryCode2 = projectCategoryCode2;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}

	public Date getProjectCreateDate() {
		return projectCreateDate;
	}

	public void setProjectCreateDate(Date projectCreateDate) {
		this.projectCreateDate = projectCreateDate;
	}

	public Date getProjectModifyDate() {
		return projectModifyDate;
	}

	public void setProjectModifyDate(Date projectModifyDate) {
		this.projectModifyDate = projectModifyDate;
	}

	public Date getProjectExpiredDate() {
		return projectExpiredDate;
	}

	public void setProjectExpiredDate(Date projectExpiredDate) {
		this.projectExpiredDate = projectExpiredDate;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
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

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getProjectThumbNail() {
		return projectThumbNail;
	}

	public void setProjectThumbNail(String projectThumbNail) {
		this.projectThumbNail = projectThumbNail;
	}

	public char getProjectDeleteYN() {
		return projectDeleteYN;
	}

	public void setProjectDeleteYN(char projectDeleteYN) {
		this.projectDeleteYN = projectDeleteYN;
	}

	public String getProjectTag() {
		return projectTag;
	}

	public void setProjectTag(String projectTag) {
		this.projectTag = projectTag;
	}

	public int getProjectAlt() {
		return projectAlt;
	}

	public void setProjectAlt(int projectAlt) {
		this.projectAlt = projectAlt;
	}

	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getProjectCategoryCode1() {
		return projectCategoryCode1;
	}

	public void setProjectCategoryCode1(int projectCategoryCode1) {
		this.projectCategoryCode1 = projectCategoryCode1;
	}

	public int getProjectCategoryCode2() {
		return projectCategoryCode2;
	}

	public void setProjectCategoryCode2(int projectCategoryCode2) {
		this.projectCategoryCode2 = projectCategoryCode2;
	}

	@Override
	public String toString() {
		return "Project [projectNo=" + projectNo + ", projectStatus=" + projectStatus + ", projectPrice=" + projectPrice
				+ ", projectCreateDate=" + projectCreateDate + ", projectModifyDate=" + projectModifyDate
				+ ", projectExpiredDate=" + projectExpiredDate + ", projectStartDate=" + projectStartDate
				+ ", projectTitle=" + projectTitle + ", projectSummary=" + projectSummary + ", projectContent="
				+ projectContent + ", projectThumbNail=" + projectThumbNail + ", projectDeleteYN=" + projectDeleteYN
				+ ", projectTag=" + projectTag + ", projectAlt=" + projectAlt + ", projectCount=" + projectCount
				+ ", memberNo=" + memberNo + ", projectCategoryCode1=" + projectCategoryCode1
				+ ", projectCategoryCode2=" + projectCategoryCode2 + "]";
	}
	
	
}
