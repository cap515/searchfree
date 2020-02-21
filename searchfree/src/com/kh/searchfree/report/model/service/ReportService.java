package com.kh.searchfree.report.model.service;

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
import com.kh.searchfree.report.model.dao.ReportDao;
import com.kh.searchfree.report.model.vo.ReportVo;
import com.kh.searchfree.search.model.dao.SearchDao;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;

public class ReportService {

	public List<SearchResult> getSearchList(SearchValue sv) throws Exception {

		Connection conn = getConnection();

		List<SearchResult> rList = new SearchDao().getSearchList(conn,sv);

		close(conn);

		return rList;
	}

	public int updateReport(ReportVo rVo) throws Exception{

		Connection conn = getConnection();
		
		int result = new ReportDao().updateReport(rVo, conn);
		
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);
		
		return result;
	
	}
}