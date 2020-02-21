package com.kh.searchfree.project.model.vo;

public class ProjectApply {
	private int projectNo;
	private int memberNo;
	
	public ProjectApply() {
		// TODO Auto-generated constructor stub
	}

	public ProjectApply(int projectNo, int memberNo) {
		super();
		this.projectNo = projectNo;
		this.memberNo = memberNo;
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
		return "projectApply [projectNo=" + projectNo + ", memberNo=" + memberNo + "]";
	}
	
	
}
