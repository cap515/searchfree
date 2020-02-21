package com.kh.searchfree.project.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String reviewContent;
	private Date reviewCreateDate;
	private int reviewStarRating;
	private int projectNo;
	private int memberNo;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewNo, String reviewContent, Date reviewCreateDate, int reviewStarRating, int projectNo,
			int memberNo) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewStarRating = reviewStarRating;
		this.projectNo = projectNo;
		this.memberNo = memberNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Date getReviewCreateDate() {
		return reviewCreateDate;
	}

	public void setReviewCreateDate(Date reviewCreateDate) {
		this.reviewCreateDate = reviewCreateDate;
	}

	public int getReviewStarRating() {
		return reviewStarRating;
	}

	public void setReviewStarRating(int reviewStarRating) {
		this.reviewStarRating = reviewStarRating;
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

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", reviewCreateDate="
				+ reviewCreateDate + ", reviewStarRating=" + reviewStarRating + ", projectNo=" + projectNo
				+ ", memberNo=" + memberNo + "]";
	}
	
	
	
}
