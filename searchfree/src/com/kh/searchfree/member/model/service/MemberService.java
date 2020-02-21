package com.kh.searchfree.member.model.service;

import static com.kh.searchfree.common.JDBCTemplate.close;
import static com.kh.searchfree.common.JDBCTemplate.commit;
import static com.kh.searchfree.common.JDBCTemplate.getConnection;
import static com.kh.searchfree.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.dao.MemberDao;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.member.model.vo.MyProject;
import com.kh.searchfree.member.model.vo.Portfolio;
import com.kh.searchfree.member.model.vo.ProfileResource;

/**
 * @author wxyzi
 *
 */
public class MemberService {
	
	/** 로그인용 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception{
		Connection conn = getConnection();
		
		Member loginMember = new MemberDao().loginMember(conn, member);
		
		return loginMember;
	}
	
	public int signMember(Member member) throws Exception {
		Connection conn = getConnection();
		int result = new MemberDao().signMember(conn,member);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}// 트랜젝션 처리
		
		return result;
	}
	

	/**완료된 프로젝트 수
	 * @return result
	 * @throws Exception
	 */
	public int completeProject(int memberNo) throws Exception{
		Connection conn = getConnection();

		int result = new MemberDao().completeProject(conn, memberNo);
		
		return result;
		
	}

	/** 진행중인 프로젝트 수
	 * @return
	 * @throws Exception
	 */
	public int goingProject(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().goingProject(conn,memberNo);
		
		return result;
	}

	/** 받은 쪽지 수
	 * @return
	 * @throws Exception
	 */
	public int messageCount(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = new MemberDao().messageCount(conn,memberNo);

		return result;
	}


	public int reviewCount(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().reviewCount(conn,memberNo);

		return result;
	}


	public int avgSrating(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().avgSrating(conn,memberNo);

		return result;
	}

	
	/**등록한 프로젝트 수 
	 * @return result
	 * @throws Exception
	 */
	public int countProject(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().countProject(conn,memberNo);

		return result;
	}


	/**	회원탈퇴 service
	 * @param inputPwd
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(String inputPwd, String memberId) throws Exception {
		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		
		int result = memberDao.checkPwd(conn, inputPwd, memberId); // 비밀번호 일치확인 - 정상적으로 조회되면 1반환 아니면 0
		
		if(result>0) {
			result = memberDao.deleteMember(conn, memberId); // Member_status를 y로 바꾸고 result에 결과 다시 담기
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			return result;
			
		}else {
			return -1; // 비밀번호 일치확인이 실패한 경우
		}
		
	}

	public Member selectMember() throws Exception{
		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		
		Member selectMember = memberDao.selectMember(conn);
		
		return selectMember;
		
	}

	public int updateMember(Member updateMember, String memberId, String memberPwd) throws Exception{
		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		
			updateMember.setMemberPwd(memberPwd);
			
			int result = memberDao.updateMember(conn, updateMember, memberId);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			return result;

	}
	
	public int idDupCheck(String id) throws Exception{

		Connection conn = getConnection();
		return new MemberDao().idDupCheck(conn, id);
	}
	public int nickDupCheck(String nick) throws Exception{

		Connection conn = getConnection();
		return new MemberDao().nickDupCheck(conn, nick);
	}

	

		/**  select * from Category1
		* @return category1List
		* @throws Exception
		*/
		public List<Category1> getCategory1List() throws Exception{
		
		Connection conn = getConnection();
		
		List<Category1> category1List = new MemberDao().getCategory1List(conn);
		
		return category1List;
		}
		
		
		/**  select * from Category2
		* @return category2List
		* @throws Exception
		*/
		public List<Category2> getCategory2List() throws Exception{

		Connection conn = getConnection();

		List<Category2> category2List = new MemberDao().getCategory2List(conn);

		return category2List;
		}

		/**내가 등록한 프로젝트 dao
		 * @param memberNo
		 * @return selectProject1
		 * @throws Exception
		 */
		public List<MyProject> selectProject1(int memberNo) throws Exception {
			Connection conn = getConnection();
			
			List<MyProject> selectProject1 = new MemberDao().selectProject1(conn, memberNo);
			
			return selectProject1;
		}

		/**내가 의뢰한 프로젝트
		 * @param memberNo
		 * @return selectProject2
		 * @throws Exception
		 */
		public List<MyProject> selectProject2(int memberNo) throws Exception {
		Connection conn = getConnection();

		List<MyProject> selectProject2 = new MemberDao().selectProject2(conn, memberNo);

		return selectProject2;
		}

		/** 마감 안지난 일정들
		 * @param memberNo
		 * @return projectSchedule
		 * @throws Exception
		 */
		public List<MyProject> projectSchedule(int memberNo) throws Exception {
			Connection conn = getConnection();
			
			List<MyProject> projectSchedule = new MemberDao().projectSchedule(conn, memberNo);
			
			return projectSchedule;
		}

		/**프로필 이미지 등록용 service
		 * @param memberNo
		 * @param fList
		 * @return result
		 * @throws Exception
		 */
		public int insertProfile(int memberNo, ProfileResource file) throws Exception {
			Connection conn = getConnection();
			
			int result = new MemberDao().insertProfile(conn, memberNo, file);
				
			 //트랜잭션 처리
			if(result>0) commit(conn);
			else {
				 //DB 삽입 실패 시 
				// 서버에 저장된 파일을 삭제 
					String path = file.getProfileResourcePath();
					String saveFile = file.getFileChangeName();
					
					File failedFile = new File(path + saveFile);
					// -> 매개변수로 지정된 경로의 파일을 취급할 수 있음.
					
					failedFile.delete();
					rollback(conn);
				}
		
			return result;
			
		}

		/** 등록한 프로필 사진 조회용 Service
		 * @param memberNo
		 * @return files
		 * @throws Exception
		 */
		public  List<ProfileResource> selectFiles(int memberNo) throws Exception{
			Connection conn = getConnection();
			List<ProfileResource> files = new MemberDao().selectFiles(conn,memberNo);
			close(conn);
			return files;
		}

		/** 등록한 프로필 사진 수정용 service
		 * @param memberNo
		 * @param file
		 * @return
		 */
		public int updateProfile(int memberNo, ProfileResource file) throws Exception{
			Connection conn = getConnection();
		int result = new MemberDao().updateProfile(conn, memberNo, file);
				
			if(result>0) commit(conn);
			else {
					String path = file.getProfileResourcePath();
					String saveFile = file.getFileChangeName();
					
					File failedFile = new File(path + saveFile);
					
					failedFile.delete();
					rollback(conn);
				}
			return result;
		}

		//포트폴리오 인서트
		public int insertPortfolio(Portfolio portfolio) throws Exception{
			Connection conn = getConnection();
			int result = new MemberDao().insertPortfolio(conn,portfolio);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			return result;
		}

		//포트폴리오 불러오기
		public Portfolio getPortfolio(int memberNo) throws Exception{
			Connection conn = getConnection();
			Portfolio portfolio = new MemberDao().getPortfolio(conn, memberNo);
			return portfolio;
		}

		//포트폴리오 삭제
		public int deletePortfolio(int memberNo) throws Exception{
			Connection conn = getConnection();
			int result = new MemberDao().deletePortfolio(conn, memberNo);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			return result;
		}

		public int updatePortfolio(Portfolio portfolio) throws Exception{
			Connection conn = getConnection();
			int result = new MemberDao().updatePortfolio(conn, portfolio);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			return result;
		}

		public int checkDelete(int memberNo) throws Exception{
			Connection conn = getConnection();
			int result = new MemberDao().checkDelete(conn, memberNo);
			
			return result;
		}



}
