package com.kh.searchfree.project.model.vo;

public class ProjectResource {
	private int projectResourceNo;
	private String projectResourcePath;
	private String fileOriginName;
	private String fileChangeName;
	private char projectResourceDeleteYN;
	private int projectNo;
	
	public ProjectResource() {
		// TODO Auto-generated constructor stub
	}

	public ProjectResource(int projectResourceNo, String projectResourcePath, String fileOriginName,
			String fileChangeName, char projectResourceDeleteYN, int projectNo) {
		super();
		this.projectResourceNo = projectResourceNo;
		this.projectResourcePath = projectResourcePath;
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.projectResourceDeleteYN = projectResourceDeleteYN;
		this.projectNo = projectNo;
	}

	public int getProjectResourceNo() {
		return projectResourceNo;
	}

	public void setProjectResourceNo(int projectResourceNo) {
		this.projectResourceNo = projectResourceNo;
	}

	public String getProjectResourcePath() {
		return projectResourcePath;
	}

	public void setProjectResourcePath(String projectResourcePath) {
		this.projectResourcePath = projectResourcePath;
	}

	public String getFileOriginName() {
		return fileOriginName;
	}

	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}

	public String getFileChangeName() {
		return fileChangeName;
	}

	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}

	public char getProjectResourceDeleteYN() {
		return projectResourceDeleteYN;
	}

	public void setProjectResourceDeleteYN(char projectResourceDeleteYN) {
		this.projectResourceDeleteYN = projectResourceDeleteYN;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	@Override
	public String toString() {
		return "ProjectResource [projectResourceNo=" + projectResourceNo + ", projectResourcePath="
				+ projectResourcePath + ", fileOriginName=" + fileOriginName + ", fileChangeName=" + fileChangeName
				+ ", projectResourceDeleteYN=" + projectResourceDeleteYN + ", projectNo=" + projectNo + "]";
	}

	
	
}
