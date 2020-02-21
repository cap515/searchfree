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

import com.kh.searchfree.admin.model.vo.AdminMember;
import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;

public class MemberDao {

	private Properties prop = null;
	
	public MemberDao() throws Exception{
		String fileName = MemberDao.class.getResource("/com/kh/searchfree/sql/member/adminMember-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	/**공지사항 목록 조회용 Dao
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<AdminMember> selectList(Connection conn) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<AdminMember> list = null;
		
		String query = prop.getProperty("selectMemberList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<AdminMember>();
			// 조회 결과가 없는 경우 값이 비어있는 리스트가 반환됨
			
			AdminMember member = null;
			
			while(rset.next()) {
				
				member = new AdminMember();
				 member.setMemberNo(rset.getInt("MEMBER_NO"));
				 member.setMemberId(rset.getString("MEMBER_ID"));
				 member.setMemberNick(rset.getString("MEMBER_NICK"));
				 member.setMemberNm(rset.getString("MEMBER_NM"));
				 member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				 member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				 member.setMemberAddr(rset.getString("MEMBER_ADDRESS"));		
				 member.setMemberGrade((rset.getString("MEMBER_GRADE")).charAt(0));		
				 member.setMemberStatus((rset.getString("MEMBER_STATUS")).charAt(0));		
				 member.setMemberAccount(rset.getString("MEMBER_ACCOUNT"));		
				 member.setMemberInterest(rset.getString("MEMBER_INTEREST"));		
				 member.setMemberEnrollDate(rset.getDate("MEMBER_ENROLL_DT"));		
				 member.setCategory1Code(rset.getInt("CATEGORY1_CODE"));
				 member.setCategory2Code(rset.getInt("CATEGORY2_CODE"));
						
				list.add(member);
				System.out.println(member);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	
	
	public AdminMember selectMember(Connection conn, int memNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AdminMember member = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new AdminMember();
				member.setMemberNo(memNo);
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberNick(rset.getString("MEMBER_NICK"));
				member.setMemberNm(rset.getString("MEMBER_NM"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberAddr(rset.getString("MEMBER_ADDRESS"));
				member.setMemberGrade((rset.getString("MEMBER_GRADE")).charAt(0));
				member.setMemberStatus((rset.getString("MEMBER_STATUS")).charAt(0));
				member.setMemberAccount(rset.getString("MEMBER_ACCOUNT"));
				member.setMemberInterest(rset.getString("MEMBER_INTEREST"));
				member.setMemberEnrollDate(rset.getDate("MEMBER_ENROLL_DT"));
				member.setCategory1Code(rset.getInt("CATEGORY1_CODE"));
				member.setCategory2Code(rset.getInt("CATEGORY2_CODE"));
				System.out.println(member);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}


	//활중 update
	public int statusUpdate(Connection conn, int no) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("statusMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	//등급 update
	public int gradeUpdate(Connection conn, char grade, int memNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("gradeMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, grade+"");
			pstmt.setInt(2, memNo);
			
			result = pstmt.executeUpdate();
			System.out.println(grade);
		}finally {
			close(pstmt);
		}
		return result;
	}
	//활동 update
	public int statusUpdateN(Connection conn, int no) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("statusMemberN");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		}finally {
			close(pstmt);
		}
		return result;
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


	public List<Category2> getCategory2List(Connection conn) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		List<Category2> category2List = new ArrayList<Category2>();
		
		String query = prop.getProperty("selectCategory2");
				
		try {
				
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Category2 category2 = new Category2(rset.getInt(1), rset.getString(2), rset.getInt(3));
				
				category2List.add(category2);
			}
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return category2List;
	}
	public List<Category1> getCategory1List(Connection conn) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		List<Category1> category1List = new ArrayList<Category1>();
		
		String query = prop.getProperty("selectCategory1");
				
		try {
				
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Category1 category1 = new Category1(rset.getInt(1), rset.getString(2));
				
				category1List.add(category1);
			}
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return category1List;
	}

	
}