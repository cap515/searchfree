package com.kh.searchfree.admin.model.vo;

import java.sql.Date;

public class AdminMember {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberNick;
	private String memberNm;
	private String memberPhone;
	private String memberEmail;
	private String memberAddr;
	private char memberGrade;
	private char memberStatus;
	private String memberAccount;
	private String memberInterest;
	private String memberIntro;
	private Date memberEnrollDate;
	private int category1Code;
	private int category2Code;
	private char report_YN;
	
	private int flag;
	
	



	public AdminMember() {
	}


	public AdminMember(int memberNo, String memberId, String memberPwd, String memberNick, String memberNm,
			String memberPhone, String memberEmail, String memberAddr, char memberGrade, char memberStatus,
			String memberAccount, String memberInterest, String memberIntro, Date memberEnrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
		this.memberGrade = memberGrade;
		this.memberStatus = memberStatus;
		this.memberAccount = memberAccount;
		this.memberInterest = memberInterest;
		this.memberIntro = memberIntro;
		this.memberEnrollDate = memberEnrollDate;
	}

	

	public char getReport_YN() {
		return report_YN;
	}


	public void setReport_YN(char report_YN) {
		this.report_YN = report_YN;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	public int getCategory1Code() {
		return category1Code;
	}


	public void setCategory1Code(int category1Code) {
		this.category1Code = category1Code;
	}


	public int getCategory2Code() {
		return category2Code;
	}
	
	
	public void setCategory2Code(int category2Code) {
		this.category2Code = category2Code;
	}
	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPwd() {
		return memberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}


	public String getMemberNick() {
		return memberNick;
	}


	public void setMemberNick(String memerNick) {
		this.memberNick = memerNick;
	}


	public String getMemberNm() {
		return memberNm;
	}


	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberAddr() {
		return memberAddr;
	}


	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}


	public char getMemberGrade() {
		return memberGrade;
	}


	public void setMemberGrade(char memberGrade) {
		this.memberGrade = memberGrade;
	}


	public char getMemberStatus() {
		return memberStatus;
	}


	public void setMemberStatus(char memberStatus) {
		this.memberStatus = memberStatus;
	}


	public String getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}


	public String getMemberInterest() {
		return memberInterest;
	}


	public void setMemberInterest(String memberInterest) {
		this.memberInterest = memberInterest;
	}


	public String getMemberIntro() {
		return memberIntro;
	}


	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}


	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}


	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNick="
				+ memberNick + ", memberNm=" + memberNm + ", memberPhone=" + memberPhone + ", memberEmail="
				+ memberEmail + ", memberAddr=" + memberAddr + ", memberGrade=" + memberGrade + ", memberStatus="
				+ memberStatus + ", memberAccount=" + memberAccount + ", memberInterest=" + memberInterest
				+ ", memberIntro=" + memberIntro + ", memberEnrollDate=" + memberEnrollDate + ", category1Code="
				+ category1Code + ", category2Code=" + category2Code + ", report_YN=" + report_YN + ", flag=" + flag
				+ "]";
	}





	
}
