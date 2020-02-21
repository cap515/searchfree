package com.kh.searchfree.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	private static Connection conn = null;
	public static Connection getConnection()  {
			try {
				if(conn == null || conn.isClosed()) {
					// 싱글턴 패턴 포기
				Properties prop = new Properties();
				// 배포용 경로 설정 방법
				String fileName 
					= JDBCTemplate.class.getResource("/com/kh/searchfree/sql/driver.properties").getPath();
				// JDBCTemplate.java 파일이 컴파일되어 class 파일이 생성된 곳의 리소스를 가져오는데
				// class 파일 기준으로 매개변수로 전달된 리소스(driver.properties)가 있는 경로를 찾아가서 full path를 가져옴 
				prop.load(new FileReader(fileName));
				// src 내부 파일들은 src 이 최상위
				// 배포되는 웹 파일들은 WebContent가 최상위
				// 배포시 classes 아래에 생성되어 배포됨
				// WebContent 하위 : 배포용
				// src : 작업용 
				// 작업후 저장하면 배포용으로 변환
				// 작업할 때 부터 배포용 버전으로 경로를 맞춰줘야함
				
				// ojdbc6라이브러리를
				// WebContent/WEB-INF/lib 폴더에 추가 
				//	웹 배포시 같이 배포되어야하기 때문
				
							try {
								Class.forName(prop.getProperty("driver"));
								conn = DriverManager.getConnection(
										prop.getProperty("url"),
										prop.getProperty("user"),
										prop.getProperty("password"));
								
								conn.setAutoCommit(false);
								
							}catch (Exception e) {
								e.printStackTrace();
							} 
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		return conn;
	}
	
	public static void close(Statement stmt) {
		
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(ResultSet rset) {
		
		try {
			if ( rset != null && !rset.isClosed()) {
				rset.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if ( conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
