package com.kh.searchfree.project.model.vo;

import java.sql.Date;

import oracle.sql.CLOB;

public class ProjectOrderList {

	
	private int projectNo;
	private int memberNoSeller;
	private int memberNoBuyer;
	private String projectTitle;
	private int projectPrice;
	private String memberNick;
	private int reviewStarRating;
	

	ProjectOrderList() {}
	

	public ProjectOrderList(int projectNo, int reviewStarRating) {
		super();
		this.projectNo = projectNo;
		this.reviewStarRating = reviewStarRating;
	}


	public ProjectOrderList(int projectNo, int memberNoSeller, int memberNoBuyer, String projectTitle, int projectPrice,
			String memberNick) {
		super();
		this.projectNo = projectNo;
		this.memberNoSeller = memberNoSeller;
		this.memberNoBuyer = memberNoBuyer;
		this.projectTitle = projectTitle;
		this.projectPrice = projectPrice;
		this.memberNick = memberNick;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}


	public int getMemberNoSeller() {
		return memberNoSeller;
	}


	public void setMemberNoSeller(int memberNoSeller) {
		this.memberNoSeller = memberNoSeller;
	}


	public int getMemberNoBuyer() {
		return memberNoBuyer;
	}


	public void setMemberNoBuyer(int memberNoBuyer) {
		this.memberNoBuyer = memberNoBuyer;
	}


	public String getProjectTitle() {
		return projectTitle;
	}


	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}


	public int getProjectPrice() {
		return projectPrice;
	}


	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}


	public String getMemberNick() {
		return memberNick;
	}


	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}


	public int getReviewStarRating() {
		return reviewStarRating;
	}


	public void setReviewStarRating(int reviewStarRating) {
		this.reviewStarRating = reviewStarRating;
	}


	@Override
	public String toString() {
		return "ProjectOrderList [projectNo=" + projectNo + ", memberNoSeller=" + memberNoSeller + ", memberNoBuyer="
				+ memberNoBuyer + ", projectTitle=" + projectTitle + ", projectPrice=" + projectPrice + ", memberNick="
				+ memberNick + ", reviewStarRating=" + reviewStarRating + "]";
	}


	












	
	



	
	


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

	
	
	
	
	
	
	
	
}
