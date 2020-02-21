package com.kh.searchfree.project.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.kh.searchfree.project.model.vo.ProjectOrderList;

import static com.kh.searchfree.common.JDBCTemplate.*;

public class ProjectDAO2 {


	private Properties prop = null;
		
		public ProjectDAO2() throws Exception{
		
		String fileName= 
				ProjectDAO2.class
				.getResource("/com/kh/searchfree/sql/project/project-query2.properties")
				.getPath();
		
		prop = new Properties();
		prop.load(new FileReader(fileName));
		
		
	}

		
		/** 나의 판매한 프로젝트 목록
		 * @param conn
		 * @param no
		 * @return
		 * @throws Exception
		 */
		public List<ProjectOrderList> selledProject(Connection conn, int no) throws Exception {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<ProjectOrderList> selledList = null;
			
			String query = prop.getProperty("selledProject");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				rset= pstmt.executeQuery();
				
				selledList = new ArrayList<ProjectOrderList>();
				
				ProjectOrderList projectOrder = null;
				
				while(rset.next()) {
					projectOrder = new ProjectOrderList(rset.getInt(1),
												rset.getInt(2),
												rset.getInt(3),
												rset.getString(4), 
												rset.getInt(5),
												rset.getString(6)
												
										);
					
					selledList.add(projectOrder);
				}
				
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return selledList;
		}
		
		
		
		/** 나의 구매한 프로젝트 목록
		 * @param conn
		 * @param no
		 * @return
		 * @throws Exception
		 */
		public List<ProjectOrderList> selectProject(Connection conn,int no) throws Exception {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<ProjectOrderList> orderlist = null;
			
			String query = prop.getProperty("selectProject2");
			
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				rset= pstmt.executeQuery();
				
				orderlist = new ArrayList<ProjectOrderList>();
				
				ProjectOrderList projectOrder = null;
				
				while(rset.next()) {
					projectOrder = new ProjectOrderList(rset.getInt(1),
												rset.getInt(2),
												rset.getInt(3),
												rset.getString(4), 
												rset.getInt(5),
												rset.getString(6)
												
										);
					
					orderlist.add(projectOrder);
				}
				
				
			}finally {
				close(rset);
				close(pstmt);
			}
			
			
			return orderlist;
		}

		
		
		
		
		
		
		/** 프로젝트 조회시 별점 평균 계산 DAO
		 * @param conn
		 * @return averlist
		 * @throws Exception
		 */
		public List<ProjectOrderList> selAverProject(Connection conn) throws Exception {
			
			Statement stmt = null;
			ResultSet rset = null;
			List<ProjectOrderList> averlist = null;
			
			String query = prop.getProperty("selAverProject");
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				averlist =  new ArrayList<ProjectOrderList>();
				
				ProjectOrderList projectAver = null;
				
				while(rset.next()) {
					projectAver = new ProjectOrderList(rset.getInt(1),
													rset.getInt(2)
					);

					averlist.add(projectAver);	
					
				}
				
				
			}finally {
				close(rset);
				close(stmt);
			}
			
			return averlist;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		public List<ProjectOrderList> selAverProject(Connection conn, int projectNo,int no) throws Exception {
//			
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			List<ProjectOrderList> averlist = null;
//			
//			String query = prop.getProperty("selAverProject");
//			
//			try {
//				
//				pstmt = conn.prepareStatement(query);
//				pstmt.setInt(1, 1000);
//				pstmt.setInt(2, 4);
//				rset= pstmt.executeQuery();
//				
//				averlist = new ArrayList<ProjectOrderList>();
//				
//				ProjectOrderList projectAver = null;
//				
//				while(rset.next()){
//					
//					projectAver = new ProjectOrderList(rset.getInt(1));
//					averlist.add(projectAver);
//					
//				}
//				
//
//			
//			}finally {
//				close(rset);
//				close(pstmt);
//			}
//			return averlist;
//			
//		}

		
		
		
		
		
		
		// 일반용 값 담아오는 용
//		public ProjectOrderList selectProject1(Connection conn, int no)throws Exception {
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			ProjectOrderList orderlist = null;
//			
//			String query = prop.getProperty("selectProject");
//			
//			try {
//				
//				pstmt = conn.prepareStatement(query);
//				pstmt.setInt(1, 3);
//				rset= pstmt.executeQuery();
//			
//				while(rset.next()) {
//					orderlist = new ProjectOrderList(rset.getInt(1),
//												rset.getInt(2),
//												rset.getInt(3),
//												rset.getString(4), 
//												rset.getInt(5),
//												rset.getString(6)
//										);
//				}
//					
//			}finally {
//				close(rset);
//				close(pstmt);
//			}
//			
//			return orderlist;
//		}
//
//		
//		public ProjectOrderList selectProject2(Connection conn, int no, int projectNo)throws Exception {
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//			ProjectOrderList averlist = null;
//			
//			String query = prop.getProperty("selAverProject");
//			
//			try {
//				
//				pstmt = conn.prepareStatement(query);
//				pstmt.setInt(1, 1000);
//				pstmt.setInt(2, 4);
//				rset= pstmt.executeQuery();
//				
//				while(rset.next()) {
//					averlist = new ProjectOrderList(rset.getInt(1));
//				}
//				
//
//			}finally {
//				close(rset);
//				close(pstmt);
//			}
//	
//			System.out.println(averlist);
//			return averlist;
//		}

		
		
		
		
		
		

		
	
}
