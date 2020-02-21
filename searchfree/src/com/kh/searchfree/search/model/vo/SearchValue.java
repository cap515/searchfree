package com.kh.searchfree.search.model.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class SearchValue {
	
	int keywordRange;
	String keyword;
	int category1Code;
	int category2Code;
	int memberGrade;
	Date startDate;
	Date expiredDate;
	List<Integer> projectStatus;
	int priceRangeInt[];
	String priceRange;
	int user_alt;
	
	public SearchValue() {
		super();
	}

	public SearchValue(int keywordRange, String keyword, int category1Code, int category2Code, int memberGrade,
			Date startDate, Date expiredDate, List<Integer> projectStatus, int[] priceRangeInt, String priceRange,
			int user_alt) {
		super();
		this.keywordRange = keywordRange;
		this.keyword = keyword;
		this.category1Code = category1Code;
		this.category2Code = category2Code;
		this.memberGrade = memberGrade;
		this.startDate = startDate;
		this.expiredDate = expiredDate;
		this.projectStatus = projectStatus;
		this.priceRangeInt = priceRangeInt;
		this.priceRange = priceRange;
		this.user_alt = user_alt;
	}

	public int getKeywordRange() {
		return keywordRange;
	}

	public void setKeywordRange(int keywordRange) {
		this.keywordRange = keywordRange;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public List<Integer> getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(List<Integer> projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int[] getPriceRangeInt() {
		return priceRangeInt;
	}

	public void setPriceRangeInt(int[] priceRangeInt) {
		this.priceRangeInt = priceRangeInt;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public int getUser_alt() {
		return user_alt;
	}

	public void setUser_alt(int user_alt) {
		this.user_alt = user_alt;
	}

	@Override
	public String toString() {
		return "SearchValue [keywordRange=" + keywordRange + ", keyword=" + keyword + ", category1Code=" + category1Code
				+ ", category2Code=" + category2Code + ", memberGrade=" + memberGrade + ", startDate=" + startDate
				+ ", expiredDate=" + expiredDate + ", projectStatus=" + projectStatus + ", priceRangeInt="
				+ Arrays.toString(priceRangeInt) + ", priceRange=" + priceRange + ", user_alt=" + user_alt + "]";
	}

	
	
}
