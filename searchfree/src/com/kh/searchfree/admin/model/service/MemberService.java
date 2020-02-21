package com.kh.searchfree.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.dao.MemberDao;
import com.kh.searchfree.admin.model.dao.NoticeDao;
import com.kh.searchfree.admin.model.vo.AdminMember;
import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.notice.model.vo.Notice;
import static com.kh.searchfree.common.JDBCTemplate.*;


public class MemberService {

	/** 전체 회원 목록 조회용 서비스 
	 * @return list
	 * @throws Exception
	 */
	public List<AdminMember> selectList() throws Exception{
		Connection conn = getConnection();
		
		return new MemberDao().selectList(conn);
	}
	
	/** 1명 회원 정보 조회용 서비스 
	 * @return list
	 * @throws Exception
	 */
	public AdminMember selectMember(int memNo) throws Exception{
		Connection conn = getConnection();
		
		return new MemberDao().selectMember(conn, memNo);
	}

	/**공지사항 수정 화면용 Service
	 * @param no
	 * @return notice
	 * @throws Exception
	 */
	public Notice updateForm(int no) throws Exception {
		Connection conn = getConnection();
		// 공지사항 상세조회
		Notice notice = new NoticeDao().selectNotice(conn, no);
		
		// DB에 저장된 내용을 textarea에 출력할 경우
		// <br>로 저장되어 있는 부분을 다시 /r/n으로 변경해야 함.
		notice.setNoticeContent(notice.getNoticeContent().replace("<br>", "\r\n"));
		
		close(conn);
		
		return notice;
	}

	public int statusUpdate(int no) throws Exception{
		Connection conn = getConnection();
				
		
		int result = new MemberDao().statusUpdate(conn,no); 
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	public int statusUpdateN(int no) throws Exception{
		Connection conn = getConnection();
		
		
		int result = new MemberDao().statusUpdateN(conn,no); 
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	public int gradeUpdate(char grade, int memNo) throws Exception{
		Connection conn = getConnection();
		
		
		int result = new MemberDao().gradeUpdate(conn,grade, memNo); 
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteNotice(String noList) throws Exception {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn, noList);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	public int deleteChNotice(String noList) throws Exception {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteChNotice(conn, noList);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	public List<Category2> getCategory2List() throws Exception{
		
		Connection conn = getConnection();
		
		List<Category2> category2List = new MemberDao().getCategory2List(conn);
		
		return category2List;
	}
	
	public List<Category1> getCategory1List() throws Exception{
		
		Connection conn = getConnection();
		
		List<Category1> category1List = new MemberDao().getCategory1List(conn);
		
		return category1List;
	}
	
	

}
