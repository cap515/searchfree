package com.kh.searchfree.admin.model.vo;

public class Category1 {
	private int category1Code;
	private String category1NM;
	
	public Category1() {
		// TODO Auto-generated constructor stub
	}

	public Category1(int category1Code, String category1nm) {
		super();
		this.category1Code = category1Code;
		category1NM = category1nm;
	}

	public int getCategory1Code() {
		return category1Code;
	}

	public void setCategory1Code(int category1Code) {
		this.category1Code = category1Code;
	}

	public String getCategory1NM() {
		return category1NM;
	}

	public void setCategory1NM(String category1nm) {
		category1NM = category1nm;
	}

	@Override
	public String toString() {
		return "Category1 [category1Code=" + category1Code + ", category1NM=" + category1NM + "]";
	}
	
	
}
