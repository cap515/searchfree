package com.kh.searchfree.notice.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.kh.searchfree.board.model.vo.Attachment;
import com.kh.searchfree.notice.model.vo.Notice;
import com.kh.searchfree.notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop = null;
	
	public NoticeDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/notice/notice-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	/**공지사항 목록 조회용 Dao
	 * @param conn
	 * @param code 
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(Connection conn, int code) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Notice> list = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, code);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			// 조회 결과가 없는 경우 값이 비어있는 리스트가 반환됨
			
			Notice notice = null;
			
			while(rset.next()) {
				notice = new Notice(rset.getInt("NOTICE_NO"),
						rset.getString("NOTICE_TITLE"),
						rset.getDate("NOTICE_CREATE_DT"));
				
				list.add(notice);
			}
		}finally {
			close(rset);
			close(pstmt);
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
				notice = new Notice(no, 
							rset.getString("NOTICE_TITLE"),
							rset.getString("NOTICE_CONTENT"),
							rset.getDate("NOTICE_CREATE_DT"));
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return notice;
	}

	/**공지사항 조회수 증가용 Dao
	 * @param conn
	 * @param no
	 * @return result
	 * @throws Exception
	 */
	public int increaseCount(Connection conn, int no) throws Exception {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 공지사항 등록용 Dao
	 * @param conn
	 * @param notice
	 * @param no
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Connection conn, Notice notice, int no)throws Exception {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeContent());
			
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**공지사항 글번호 생성용 Dao
	 * @param conn
	 * @return no
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn)  throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		int no = 0;
		
		String query = prop.getProperty("selectNextNo");
		
		try{
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				no = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return no;
	}

	public int updateNotice(Connection conn, Notice notice) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int no) throws Exception{
		PreparedStatement pstmt =null;
		int result = 0;
		String query = prop.getProperty("deleteNotice");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			result=pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	/**공지사항 검색용 Dao
	 * @param conn
	 * @param condition
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> searchNotice(Connection conn, String condition) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		List<Notice> list = null;
		
		String query1 = prop.getProperty("searchNotice1");
		String query2 = prop.getProperty("searchNotice2");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query1+condition+query2);
			list = new ArrayList<Notice>();
			
			Notice notice = null;
			
			while(rset.next()) {
				notice = new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_TITLE"), 
									rset.getString("NOTICE_CONTENT"),
									rset.getDate("NOTICE_CREATE_DT"));
				
				list.add(notice);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	/**pageing count용 DAO
	 * @param conn
	 * @return listcount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
					
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
		
	}

	/**Pageing용 list 호출용 DAO
	 * @param conn
	 * @param currentPage
	 * @param limit
	 * @param code 
	 * @return nList
	 * @throws Exception
	 */
	public List<Notice> selectListPage(Connection conn, int currentPage, int limit, int code)throws Exception {
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Notice> nList = null;
		System.out.println("code" + code);
		
		String sql = prop.getProperty("selectListPage");
		
		try {
			//쿼리문 실행시 between 조건에 사용될 값
			int startRow = (currentPage - 1) * limit +1;
			int endRow = startRow + limit -1;
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			System.out.println("code : "  + code);
			System.out.println("start row : "  + startRow);
			System.out.println("endRow : "  + endRow);
			
			rset = pstmt.executeQuery();
			
			nList = new ArrayList<Notice>();
			Notice noticepage = null;
			
			while(rset.next()) {
				noticepage = new Notice(
						rset.getInt("NOTICE_NO"), 
						rset.getString("NOTICE_TITLE"), 
						rset.getString("NOTICE_CONTENT"), 
						rset.getDate("NOTICE_CREATE_DT") 
						);
				nList.add(noticepage);
	
			}
			System.out.println(nList);
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return nList;
	}

	
}