package com.kh.searchfree.admin.model.vo;

public class Category2 {
	private int category2Code;
	private String category2NM;
	private int category1Code;
	
	public Category2() {
		// TODO Auto-generated constructor stub
	}

	public Category2(int category2Code, String category2nm, int category1Code) {
		super();
		this.category2Code = category2Code;
		category2NM = category2nm;
		this.category1Code = category1Code;
	}

	public int getCategory2Code() {
		return category2Code;
	}

	public void setCategory2Code(int category2Code) {
		this.category2Code = category2Code;
	}

	public String getCategory2NM() {
		return category2NM;
	}

	public void setCategory2NM(String category2nm) {
		category2NM = category2nm;
	}

	public int getCategory1Code() {
		return category1Code;
	}

	public void setCategory1Code(int category1Code) {
		this.category1Code = category1Code;
	}

	@Override
	public String toString() {
		return "Category2 [category2Code=" + category2Code + ", category2NM=" + category2NM + ", category1Code="
				+ category1Code + "]";
	}
	
	
}
