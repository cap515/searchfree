package com.kh.searchfree.project.model.vo;

import java.sql.Clob;
import java.sql.Date;

public class ProjectRead {
	private int projectNo;
	private int projectAlt;
	private int memberNo;
	private String projectTitle;
	private String category1Name;
	private String category2Name;
	private String memberInterest;
	private String memberName;
	private String projectSummary;
	private Date projectStartDate;
	private Date projectExpiredDate;
	private int projectPrice;
	private String projectContent;
	private int reviewStarRating;
	
	
	public ProjectRead() {
	}


	public ProjectRead(int projectNo, int projectAlt, int memberNo, String projectTitle, String category1Name,
			String category2Name, String memberInterest, String memberName, String projectSummary,
			Date projectStartDate, Date projectExpiredDate, int projectPrice, String projectContent,
			int reviewStarRating) {
		super();
		this.projectNo = projectNo;
		this.projectAlt = projectAlt;
		this.memberNo = memberNo;
		this.projectTitle = projectTitle;
		this.category1Name = category1Name;
		this.category2Name = category2Name;
		this.memberInterest = memberInterest;
		this.memberName = memberName;
		this.projectSummary = projectSummary;
		this.projectStartDate = projectStartDate;
		this.projectExpiredDate = projectExpiredDate;
		this.projectPrice = projectPrice;
		this.projectContent = projectContent;
		this.reviewStarRating = reviewStarRating;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}


	public int getProjectAlt() {
		return projectAlt;
	}


	public void setProjectAlt(int projectAlt) {
		this.projectAlt = projectAlt;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getProjectTitle() {
		return projectTitle;
	}


	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}


	public String getCategory1Name() {
		return category1Name;
	}


	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}


	public String getCategory2Name() {
		return category2Name;
	}


	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}


	public String getMemberInterest() {
		return memberInterest;
	}


	public void setMemberInterest(String memberInterest) {
		this.memberInterest = memberInterest;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getProjectSummary() {
		return projectSummary;
	}


	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}


	public Date getProjectStartDate() {
		return projectStartDate;
	}


	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}


	public Date getProjectExpiredDate() {
		return projectExpiredDate;
	}


	public void setProjectExpiredDate(Date projectExpiredDate) {
		this.projectExpiredDate = projectExpiredDate;
	}


	public int getProjectPrice() {
		return projectPrice;
	}


	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}


	public String getProjectContent() {
		return projectContent;
	}


	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}


	public int getReviewStarRating() {
		return reviewStarRating;
	}


	public void setReviewStarRating(int reviewStarRating) {
		this.reviewStarRating = reviewStarRating;
	}


	@Override
	public String toString() {
		return "ProjectRead [projectNo=" + projectNo + ", projectAlt=" + projectAlt + ", memberNo=" + memberNo
				+ ", projectTitle=" + projectTitle + ", category1Name=" + category1Name + ", category2Name="
				+ category2Name + ", memberInterest=" + memberInterest + ", memberName=" + memberName
				+ ", projectSummary=" + projectSummary + ", projectStartDate=" + projectStartDate
				+ ", projectExpiredDate=" + projectExpiredDate + ", projectPrice=" + projectPrice + ", projectContent="
				+ projectContent + ", reviewStarRating=" + reviewStarRating + "]";
	}

}
