package com.kh.searchfree.admin.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.kh.searchfree.admin.model.dao.MemberDao;
import com.kh.searchfree.admin.model.dao.NoticeDao;
import com.kh.searchfree.admin.model.dao.ProjectDao;
import com.kh.searchfree.admin.model.vo.AdminMember;
import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.notice.model.vo.Notice;
import static com.kh.searchfree.common.JDBCTemplate.*;


public class ProjectService {

	/** 프로젝트 목록 조회용 서비스 
	 * @return list
	 * @throws Exception
	 */
	public List<Project> selectProject() throws Exception{
		Connection conn = getConnection();
		
		return new ProjectDao().selectProject(conn);
	}
	/** 특정 회원 프로젝트 목록 조회용 서비스 
	 * @return plist
	 * @throws Exception
	 */
	public List<Project> selectpList(int memNo) throws Exception{
		Connection conn = getConnection();
		
		return new ProjectDao().selectpList(conn,memNo);
	}
	



	
}
