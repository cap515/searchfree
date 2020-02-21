package com.kh.searchfree.project.model.service;

import static com.kh.searchfree.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;


import com.kh.searchfree.project.model.dao.ProjectDAO2;

import com.kh.searchfree.project.model.vo.ProjectOrderList;



public class ProjectService2 {

//	public ProjectOrderList selectProject1(int no) throws Exception {
//		Connection conn = getConnection();
//		
//		ProjectOrderList orderlist = new ProjectDAO2().selectProject1(conn, no);
//		
//		return orderlist;
//	}
//
//	public ProjectOrderList selectProject2(int no,int projectNo) throws Exception {
//		Connection conn = getConnection();
//		
//		ProjectOrderList averlist = new ProjectDAO2().selectProject2(conn, no, projectNo);
//		
//		return averlist;
//	}

	
	
	
	// 컬렉션 리스트용
	/** 구매한 order프로젝트 
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrderList> selectProject(int no) throws Exception {
		Connection conn = getConnection();
		
		List<ProjectOrderList>orderlist = new ProjectDAO2().selectProject(conn,no);
		close(conn);
		
		return orderlist;
	}

	
	
	/** 판매한 order프로젝트
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrderList> selledProject(int no) throws Exception {
		Connection conn = getConnection();
		
		List<ProjectOrderList>selledList = new ProjectDAO2().selledProject(conn,no);
		close(conn);
		return selledList;
	}

	
	
	
	
	
	
	
	/**
	 * @param 프로젝트의 평점
	 * @param projectNo
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrderList> selAverProject() throws Exception {
		Connection conn = getConnection();
		
		List<ProjectOrderList>averlist = new ProjectDAO2().selAverProject(conn);
		close(conn);
		return averlist;
	}

	
	
	

	
	
//
//	public int selectProject(int projectNo, int memberNo) throws Exception {
//		
//		Connection conn = getConnection();
//		
//		int result = new ProjectDAO2().selectProject(conn,projectNo,memberNo);
//				
//		return result;
//	}


	
	
	
	
	
	
	
}
