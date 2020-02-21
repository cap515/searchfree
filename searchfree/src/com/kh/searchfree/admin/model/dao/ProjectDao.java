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
import com.kh.searchfree.admin.model.vo.Project;

public class ProjectDao {
	private Properties prop = null;
	
	public ProjectDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/adminProject/adminProject-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	public List<Project> selectProject(Connection conn)throws Exception{
				
				Statement stmt = null;
				ResultSet rset = null;
				
				List<Project> list = null;
				
				String query = prop.getProperty("selectProject");
				
				try {
					stmt = conn.createStatement();
					rset = stmt.executeQuery(query);
					
					list = new ArrayList<Project>();
					
					Project project = null;
					
					while(rset.next()) {
						
						project = new Project();
						project.setProjectNo(rset.getInt("PROJECT_NO"));
						project.setProjectStatus((rset.getString("PROJECT_STATUS")).charAt(0));
						project.setProjectDeleteYN((rset.getString("PROJECT_DELETE_YN")).charAt(0));
								
						list.add(project);
						System.out.println("프로젝트 "+project);
					}
				}finally {
					close(rset);
					close(stmt);
				}
				
				return list;
			}
	
	public List<Project> selectpList(Connection conn, int memNo)throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Project> plist = new ArrayList<Project>();;
		
		String query = prop.getProperty("selectpList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project project = new Project();
				project.setMemberNo(memNo);
				project.setProjectStatus(rset.getInt("PROJECT_STATUS"));
				project.setProjectTitle(rset.getString("PROJECT_TITLE"));
				project.setProjectContent(rset.getString("PROJECT_CONTENT"));
				project.setProjectCreateDate(rset.getDate("PROJECT_CREATE_DT"));
				System.out.println(project);
				
				plist.add(project);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return plist;
	}

}
