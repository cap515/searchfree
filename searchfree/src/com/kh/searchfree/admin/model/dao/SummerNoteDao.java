package com.kh.searchfree.admin.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.searchfree.notice.model.vo.Notice;

import static com.kh.searchfree.common.JDBCTemplate.*;

public class SummerNoteDao {

	
	/** 게시글 삽입 DAO
	 * @param conn
	 * @param board
	 * @return result
	 */
	public int insertNotice(Connection conn, Notice notice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO NOTICE VALUES(SEQ_NNO.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeDeleteYN()+"");
			pstmt.setInt(3, notice.getNoticeCode());
			pstmt.setString(4, notice.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result+" << DB결과");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public Notice selectNotice(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = null;
		
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new Notice();
				  
				notice.setNoticeNo(rs.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeCreateDT(rs.getDate("NOTICE_CREATE_DT"));
				notice.setNoticeCode(rs.getInt("NOTICE_CODE"));
				System.out.println(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return notice;
	}


	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET NOTICE_TITLE = ? , NOTICE_CONTENT = ?, NOTICE_DELETE_YN = ?, NOTICE_CODE = ? WHERE NOTICE_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeDeleteYN()+"");
			pstmt.setInt(4, notice.getNoticeCode());
			pstmt.setInt(5, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result+" << update결과");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}








