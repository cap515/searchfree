package com.kh.searchfree.project.model.vo;

public class ReviewRead {
	private int reviewNo;
	private int projectNo;
	private String profileResourcePath;
	private String fileChangeName;
	private String memberNick;
	private int star;
	private String reviewContent;
	
	public ReviewRead() {
		// TODO Auto-generated constructor stub
	}

	public ReviewRead(int reviewNo,int projectNo, String profileResourcePath, String fileChangeName, String memberNick, int star,
			String reviewContent) {
		super();
		this.reviewNo = reviewNo;
		this.projectNo = projectNo;
		this.profileResourcePath = profileResourcePath;
		this.fileChangeName = fileChangeName;
		this.memberNick = memberNick;
		this.star = star;
		this.reviewContent = reviewContent;
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

	public String getProfileResourcePath() {
		return profileResourcePath;
	}

	public void setProfileResourcePath(String profileResourcePath) {
		this.profileResourcePath = profileResourcePath;
	}

	public String getFileChangeName() {
		return fileChangeName;
	}

	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	@Override
	public String toString() {
		return "ReviewRead [projectNo=" + projectNo + ", profileResourcePath=" + profileResourcePath
				+ ", fileChangeName=" + fileChangeName + ", memberNick=" + memberNick + ", star=" + star
				+ ", reviewContent=" + reviewContent + "]";
	}
	
	
}
