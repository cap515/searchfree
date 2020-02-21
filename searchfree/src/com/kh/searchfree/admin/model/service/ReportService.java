package com.kh.searchfree.admin.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.kh.searchfree.admin.model.dao.ReportDao;
import com.kh.searchfree.admin.model.vo.ReportAll;

import static com.kh.searchfree.common.JDBCTemplate.*;


public class ReportService {

	/** 신고게시판 목록 조회용 서비스 
	 * @return list
	 * @throws Exception
	 */ 
	public List<ReportAll> selectReportList() throws Exception{
		Connection conn = getConnection();
		
		return new ReportDao().selectReportList(conn);
	}

	public ReportAll selectRreviewDetail()throws Exception {
		Connection conn = getConnection();
		
		return new ReportDao().selectRreviewDetail(conn);
	}
	
	

	
}
