package com.kh.searchfree.message.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.message.model.vo.Message;
import com.kh.searchfree.notice.model.dao.NoticeDao;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class MessageDao {

	private Properties prop = null;

	public MessageDao() throws Exception {
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/message/message-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}

	public int getListCount(Connection conn, int mNumber) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getListCount");

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNumber);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public List<Message> selectListPage(Connection conn, int currentPage, int limit, int mNumber) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Message> mList = null;

		String sql = prop.getProperty("selectListPage");

		try {
			// 쿼리문 실행시 between 조건에 사용될 값
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNumber);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			mList = new ArrayList<Message>();
			Message messagePage = null;

			while (rset.next()) {
				messagePage = new Message(rset.getInt("MESSAGE_NO"), rset.getString("MESSAGE_TITLE"),
						rset.getDate("MESSAGE_CREATE_DT"), rset.getString("MESSAGE_CONTENT"),
						rset.getString("MEMBER_NICK"));

				mList.add(messagePage);
			}
			;

			System.out.println("mList" + mList);

		} finally {
			close(rset);
			close(pstmt);
		}

		return mList;
	}

	public Message selectMessage(Connection conn, int msgNo) throws Exception {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		Message msgDetail = null;

		String sql = prop.getProperty("selectMessage");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				msgDetail = new Message(msgNo, rset.getString("MESSAGE_TITLE"), rset.getDate("MESSAGE_CREATE_DT"),
						rset.getInt("RECEIVER_NO"), rset.getString("MESSAGE_CONTENT"), rset.getString("MEMBER_NICK"));

			}
			;
		} finally {
			close(rset);
			close(pstmt);
		}

		return msgDetail;
	}

	public int selectNick(Connection conn, String seleNick) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNick");
		int receiverNo = 0;
		
		System.out.println("Dao 닉입력" + seleNick);
		
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, seleNick);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				
				receiverNo = rset.getInt(1);
			}

		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(receiverNo);

		return receiverNo;
	}

	public int sendMsg(Connection conn, String msgTitle, String content, int reNo, int senderNo)
			throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("sendMsg");

		
		try {
			pstmt = conn.prepareStatement(sql);

		

				pstmt.setInt(1, senderNo);
				pstmt.setInt(2, reNo);
				pstmt.setString(3, msgTitle);
				pstmt.setString(4, content);

				result = pstmt.executeUpdate();
			

		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteMsg(Connection conn, int input) throws Exception {

		PreparedStatement pstmt = null;

		int result = 0;

		String sql = prop.getProperty("deleteMsg");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

}
