package com.kh.searchfree.search.model.vo;

public class SearchResult {

	String thumnailPath;
	String projecttitle;
	String projectSummary;
	String memberNick;
	int memberNo;
	int projectPrice;
	int projectNo;
	int starRating;
	
	public SearchResult() {
		super();
	}
	public SearchResult(String thumnailPath, String projecttitle, String projectSummary, String memberNick,
			int memberNo, int projectPrice, int projectNo, int starRating) {
		super();
		this.thumnailPath = thumnailPath;
		this.projecttitle = projecttitle;
		this.projectSummary = projectSummary;
		this.memberNick = memberNick;
		this.memberNo = memberNo;
		this.projectPrice = projectPrice;
		this.projectNo = projectNo;
		this.starRating = starRating;
	}
	
	public String getThumnailPath() {
		return thumnailPath;
	}
	public void setThumnailPath(String thumnailPath) {
		this.thumnailPath = thumnailPath;
	}
	public String getProjecttitle() {
		return projecttitle;
	}
	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}
	public String getProjectSummary() {
		return projectSummary;
	}
	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getProjectPrice() {
		return projectPrice;
	}
	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	
	@Override
	public String toString() {
		return "SearchResult [thumnailPath=" + thumnailPath + ", projecttitle=" + projecttitle + ", projectSummary="
				+ projectSummary + ", memberNick=" + memberNick + ", memberNo=" + memberNo + ", projectPrice="
				+ projectPrice + ", projectNo=" + projectNo + ", starRating=" + starRating + "]";
	}
}
