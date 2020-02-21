package com.kh.searchfree.admin.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop = null;
	
	public NoticeDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/notice/adminNotice-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	/**공지사항 목록 조회용 Dao
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(Connection conn) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<Notice> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Notice>();
			// 조회 결과가 없는 경우 값이 비어있는 리스트가 반환됨
			
			Notice notice = null;
			
			while(rset.next()) {
				
				notice = new Notice();
						notice.setNoticeNo(rset.getInt("NOTICE_NO"));
						notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
						notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
						notice.setNoticeCreateDT(rset.getDate("NOTICE_CREATE_DT"));
						notice.setNoticeCode(rset.getInt("NOTICE_CODE"));
						notice.setNoticeDeleteYN((rset.getString("NOTICE_DELETE_YN")).charAt(0));
						
				list.add(notice);
				System.out.println(notice);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	/**공지사항 목록 조회용 Dao
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectqList(Connection conn) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<Notice> list = null;
		
		String query = prop.getProperty("selectaList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Notice>();
			// 조회 결과가 없는 경우 값이 비어있는 리스트가 반환됨
			
			Notice notice = null;
			
			while(rset.next()) {
				
				notice = new Notice();
						notice.setNoticeNo(rset.getInt("NOTICE_NO"));
						notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
						notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
						notice.setNoticeCreateDT(rset.getDate("NOTICE_CREATE_DT"));
						notice.setNoticeCode(rset.getInt("NOTICE_CODE"));
						notice.setNoticeDeleteYN((rset.getString("NOTICE_DELETE_YN")).charAt(0));
						
				list.add(notice);
				System.out.println(notice);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public Notice selectNotice(Connection conn, int no) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		
		String query = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(no);
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setNoticeCreateDT(rset.getDate("NOTICE_CREATE_DT"));
				notice.setNoticeCode(rset.getInt("NOTICE_CODE"));
				notice.setNoticeDeleteYN(rset.getString("NOTICE_DELETE_YN").charAt(0));
				
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

 
	public int deleteNotice(Connection conn, String noList) throws Exception{
		Statement stmt =null;
		int result = 0;
		String query = prop.getProperty("deleteNotice");
		query += "("+noList+")";
		try {
			stmt = conn.createStatement();
			
			result=stmt.executeUpdate(query);
			
			
		}finally {
			close(stmt);
		}
				
		return result;
	}
	public int deleteChNotice(Connection conn, String noList) throws Exception{
		Statement stmt =null;
		int result = 0;
		String query = prop.getProperty("deleteChNotice");
		query += "("+noList+")";
		try {
			stmt = conn.createStatement();
			
			result=stmt.executeUpdate(query);
			
			
		}finally {
			close(stmt);
		}
		
		System.out.println(result);
		return result;
	}

//	/**공지사항 검색용 Dao
//	 * @param conn
//	 * @param condition
//	 * @return list
//	 * @throws Exception
//	 */
//	public List<Notice> searchNotice(Connection conn, String condition) throws Exception{
//		Statement stmt = null;
//		ResultSet rset = null;
//		List<Notice> list = null;
//		
//		String query1 = prop.getProperty("searchNotice1");
//		String query2 = prop.getProperty("searchNotice2");
//		
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query1+condition+query2);
//			list = new ArrayList<Notice>();
//			
//			Notice notice = null;
//			
//			while(rset.next()) {
//				notice = new Notice(rset.getInt("NOTICE_NO"),
//									rset.getString("NOTICE_TITLE"), 
//									rset.getString("NOTICE_WRITER"),
//									rset.getInt("NOTICE_COUNT"),
//									rset.getDate("NOTICE_MODIFY_DT"));
//				
//				list.add(notice);
//			}
//		}finally {
//			close(rset);
//			close(stmt);
//		}
//		return list;
//	}
}