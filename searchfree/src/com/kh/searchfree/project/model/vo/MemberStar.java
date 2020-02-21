package com.kh.searchfree.project.model.vo;

public class MemberStar {
	private int memberNo;
	private int star;
	
	public MemberStar() {
		// TODO Auto-generated constructor stub
	}

	public MemberStar(int memberNo, int star) {
		super();
		this.memberNo = memberNo;
		this.star = star;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "MemberStar [memberNo=" + memberNo + ", star=" + star + "]";
	}
	
	
}
