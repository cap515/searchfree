package com.kh.searchfree.project.model.vo;

public class VProjectApply {
	private String projectResourcePath;
	private String fileChangeName;
	private int memberNo;
	private int projectNo;
	private String memberNick;
	private char memberGrade;
	
	public VProjectApply() {
		// TODO Auto-generated constructor stub
	}

	public VProjectApply(String projectResourcePath, String fileChangeName, int memberNo, int projectNo,
			String memberNick, char memberGrade) {
		super();
		this.projectResourcePath = projectResourcePath;
		this.fileChangeName = fileChangeName;
		this.memberNo = memberNo;
		this.projectNo = projectNo;
		this.memberNick = memberNick;
		this.memberGrade = memberGrade;
	}

	public String getProjectResourcePath() {
		return projectResourcePath;
	}

	public void setProjectResourcePath(String projectResourcePath) {
		this.projectResourcePath = projectResourcePath;
	}

	public String getFileChangeName() {
		return fileChangeName;
	}

	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public char getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(char memberGrade) {
		this.memberGrade = memberGrade;
	}

	@Override
	public String toString() {
		return "VProjectApply [projectResourcePath=" + projectResourcePath + ", fileChangeName=" + fileChangeName
				+ ", memberNo=" + memberNo + ", projectNo=" + projectNo + ", memberNick=" + memberNick
				+ ", memberGrade=" + memberGrade + "]";
	}
	
	
}
