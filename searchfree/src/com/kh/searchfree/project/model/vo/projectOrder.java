package com.kh.searchfree.project.model.vo;

import java.sql.Date;

public class projectOrder {
	private int orderNo;
	private char orderStatus;
	private Date orderDate;
	private int memberNo;
	private int projectNo;
	
	public projectOrder() {
		// TODO Auto-generated constructor stub
	}

	public projectOrder(int orderNo, char orderStatus, Date orderDate, int memberNo, int projectNo) {
		super();
		this.orderNo = orderNo;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.memberNo = memberNo;
		this.projectNo = projectNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public char getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(char orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	@Override
	public String toString() {
		return "projectOrder [orderNo=" + orderNo + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", memberNo=" + memberNo + ", projectNo=" + projectNo + "]";
	}
	
	
}
