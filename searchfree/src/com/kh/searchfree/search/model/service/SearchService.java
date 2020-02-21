package com.kh.searchfree.search.model.service;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.dao.MemberDao;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.project.model.dao.ProjectDao;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.project.model.vo.ProjectRead;
import com.kh.searchfree.search.model.dao.SearchDao;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;

public class SearchService {

	public List<SearchResult> getSearchList(SearchValue sv) throws Exception {

		Connection conn = getConnection();

		List<SearchResult> rList = new SearchDao().getSearchList(conn,sv);

		close(conn);

		return rList;
	}

	public List<SearchResult> getRecentList() throws Exception{
		Connection conn = getConnection();

		List<SearchResult> list = new SearchDao().getRecentList(conn);

		close(conn);

		return list;
	}
}