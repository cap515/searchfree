package com.kh.searchfree.member.model.vo;

public class Portfolio {
	private String PortfolioTitle;
	private String PortfolioContent;
	private int MemberNo;

	public Portfolio() {
		// TODO Auto-generated constructor stub
	}

	public Portfolio(String portfolioTitle, String portfolioContent) {
		super();
		PortfolioTitle = portfolioTitle;
		PortfolioContent = portfolioContent;
	}

	public Portfolio( int memberNo, String portfolioTitle, String portfolioContent) {
		super();
		MemberNo = memberNo;
		PortfolioTitle = portfolioTitle;
		PortfolioContent = portfolioContent;
	}

	public String getPortfolioTitle() {
		return PortfolioTitle;
	}

	public void setPortfolioTitle(String portfolioTitle) {
		PortfolioTitle = portfolioTitle;
	}

	public String getPortfolioContent() {
		return PortfolioContent;
	}

	public void setPortfolioContent(String portfolioContent) {
		PortfolioContent = portfolioContent;
	}

	public int getMemberNo() {
		return MemberNo;
	}

	public void setMemberNo(int memberNo) {
		MemberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Portfolio [PortfolioTitle=" + PortfolioTitle + ", PortfolioContent=" + PortfolioContent + ", MemberNo="
				+ MemberNo + "]";
	}

}
