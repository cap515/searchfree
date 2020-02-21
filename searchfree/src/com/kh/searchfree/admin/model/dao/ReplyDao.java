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

import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.admin.model.vo.Reply;
import com.kh.searchfree.admin.model.vo.ReportAll;

public class ReplyDao {
	private Properties prop = null;
	
	public ReplyDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/reply/adminReply-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	public List<Reply> selectRList(Connection conn, int memNo)throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Reply>();
			
			Reply reply = null;
			
			while(rset.next()) {
				reply = new Reply();
				reply.setMemberNo(memNo);
				reply.setReplyContent(rset.getString("REPLY_CONTENT"));
				reply.setReplyDeleteYN(rset.getString("REPLY_DELETE_YN").charAt(0));
				reply.setReplyCreateDate(rset.getDate("REPLY_CREATE_DT"));		
				list.add(reply);
				
				System.out.println("댓글 리스트 :  "+reply);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


}
