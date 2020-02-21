package com.kh.searchfree.report.model.dao;

import java.sql.Statement;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import static com.kh.searchfree.common.JDBCTemplate.*;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.dao.MemberDao;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.report.model.vo.ReportVo;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;


public class ReportDao {
	
	private Properties prop = null;
	
	public ReportDao() throws Exception {

		String fileName = ReportDao.class.getResource("/com/kh/searchfree/sql/report/report-query.properties").getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	
	
	public int updateReport(ReportVo rVo, Connection conn) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member loginMember = null;
		int result = 0;
		
		
		int reportCode1 = rVo.getReportCode()/10;	
		System.out.println("reportCode : " + rVo.getReportCode());
		System.out.println("reportCode1 : " + reportCode1);
		String query;
		if(reportCode1 != 2)
			query = prop.getProperty("updateReport");
		else {
			query = prop.getProperty("selectReportProjectNo");
		}
		switch(reportCode1) {
		case 1: query = prop.getProperty("updateReportReply");break;
		case 2: query = prop.getProperty("selectReportProjectNo");break;
		case 3: query = prop.getProperty("updateReportMessage");break;
		case 4: query = prop.getProperty("updateReportProject");break;
		case 5: query = prop.getProperty("updateReportMember");break;
		}
		String tableName = null;
		try {
			pstmt=conn.prepareStatement(query);
			if(reportCode1 != 2) {
				pstmt.setInt(1,rVo.getMemberNo());
				System.out.println("2 : " + rVo.getMemberNo());
				pstmt.setInt(2,rVo.getToReportNo());
				System.out.println("3 : " + rVo.getToReportNo());
				pstmt.setString(3, rVo.getReportTitle());
				System.out.println("4 : " + rVo.getReportTitle());
				pstmt.setString(4, rVo.getReportContent());
				System.out.println("5 : " + rVo.getReportContent());
				pstmt.setInt(5, rVo.getReportCode());
				System.out.println("6 : " + rVo.getReportCode());
			} else {
				pstmt.setInt(1, rVo.getToReportNo());
				rset = pstmt.executeQuery();
				if(rset.next()) {
					rVo.setProjectNo(rset.getInt(1));
				}
				query = prop.getProperty("updateReportReview");
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rVo.getToReportNo());
				pstmt.setInt(2, rVo.getProjectNo());
				pstmt.setInt(3, rVo.getMemberNo());
				pstmt.setString(4, rVo.getReportTitle());
				pstmt.setString(5, rVo.getReportContent());
				pstmt.setInt(6, rVo.getReportCode());
				
			}
			System.out.println("query : "+query);
			result = pstmt.executeUpdate();
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		System.out.println(loginMember);
		
		return result;
	}
}