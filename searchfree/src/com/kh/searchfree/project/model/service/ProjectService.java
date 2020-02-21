package com.kh.searchfree.project.model.service;

import com.kh.searchfree.project.model.dao.ProjectDao;
import com.kh.searchfree.project.model.vo.MemberStar;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.project.model.vo.ProjectApply;
import com.kh.searchfree.project.model.vo.ProjectRead;
import com.kh.searchfree.project.model.vo.ProjectResource;
import com.kh.searchfree.project.model.vo.Reply;
import com.kh.searchfree.project.model.vo.ReplyRead;
import com.kh.searchfree.project.model.vo.Review;
import com.kh.searchfree.project.model.vo.ReviewRead;
import com.kh.searchfree.project.model.vo.VProjectApply;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.kh.searchfree.common.JDBCTemplate.*;

/**
 * @author Sohee
 *
 */
/**
 * @author Sohee
 *
 */
public class ProjectService {

	/**
	 * project 상세조회
	 * 
	 * @return project
	 * @throws Exception
	 */
	public ProjectRead selectProject(int projectNo) throws Exception {
		Connection conn = getConnection();

		ProjectRead projectRead = new ProjectDao().selectProject(conn, projectNo);

		close(conn);

		return projectRead;
	}

	/**
	 * project 등록
	 * 
	 * @param project
	 * @param fList
	 * @return
	 */
	public int insertProject(Project project, ArrayList<ProjectResource> fList, int projectWriter) throws Exception {
		Connection conn = getConnection();

		ProjectDao projectDao = new ProjectDao();
		int result = 0;

		// 1) 등록될 게시글의 번호를 얻어옴
		// SEQ_BNO.NEXTVAL 값을 얻어와라
		int projectNo = projectDao.selectNextNo(conn);

		if (projectNo > 0) { // 게시글 번호를 얻어온 경우
			project.setProjectNo(projectNo);
			
			project.setProjectSummary(project.getProjectSummary().replace("<br>", "\r\n"));
			
			result = projectDao.insertProject(conn, project, projectWriter);

			if (result > 0) { // 게시글 삽입 성공 시
				result = 0; // 트랜잭션 처리를 위해 재활용
				System.out.println(fList.size());
				// 3) fList의 데이터를 하나씩 DB에 삽입
				for (ProjectResource file : fList) {
					// 현재 게시글 번호 추가
					file.setProjectNo(projectNo);

					result = projectDao.insertAttachment(conn, file);
					
					result = projectNo;
					// 다음 번호 조회 + 공지사항 등록 성공 시
					// 등록 완료 후 해당 작성 페이지로 이동하기 위해서 
					// 조회된 번호를 반환시킴

					// 삽입 실패 시 다른 작업 필요 없이 바로 break;
					if (result == 0)
						break;
				}
			}
		}

		// 4) 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {
			// 5) DB 삽입 실패 시
			// 서버에 저장된 파일을 삭제
			// 앞쪽에서 DB 저장 정에 이미 서버에 저장이 되어있음
			for (ProjectResource file : fList) {
				String path = file.getProjectResourcePath(); // 경로 얻기
				String saveFile = file.getProjectResourcePath(); // 이름 얻기

				File failedFile = new File(path + saveFile);
				// : 매개변수로 지정된 경로의 파일을 접근(취급)할 수 있음.

				failedFile.delete();
			}
			rollback(conn);
		}

		close(conn);

		return result;

	}

	/**
	 * 게시글 이미지 파일 조회용 Service
	 * 
	 * @param projectNo
	 * @return files
	 * @throws Exception
	 */
	public List<ProjectResource> selectFiles(int projectNo) throws Exception {
		Connection conn = getConnection();

		List<ProjectResource> files = new ProjectDao().selectFiles(conn, projectNo);

		close(conn);
		return files;
	}

	/**
	 * 클라이언트 프로젝트 의뢰 등록 Service
	 * 
	 * @param project
	 * @param fList
	 * @return
	 * @throws Exception
	 */
	public int insertProject_client(Project project, ArrayList<ProjectResource> fList, int projectWriter) throws Exception {
		Connection conn = getConnection();

		ProjectDao projectDao = new ProjectDao();
		int result = 0;

		// 1) 등록될 게시글의 번호를 얻어옴
		// SEQ_BNO.NEXTVAL 값을 얻어와라
		int projectNo = projectDao.selectNextNo(conn);

		if (projectNo > 0) { // 게시글 번호를 얻어온 경우
			project.setProjectNo(projectNo);
			
			project.setProjectSummary(project.getProjectSummary().replace("<br>", "\r\n"));
			
			result = projectDao.insertProject_client(conn, project, projectWriter);

			if (result > 0) { // 게시글 삽입 성공 시
				result = 0; // 트랜잭션 처리를 위해 재활용
				System.out.println(fList.size());
				// 3) fList의 데이터를 하나씩 DB에 삽입
				for (ProjectResource file : fList) {
					// 현재 게시글 번호 추가
					file.setProjectNo(projectNo);

					result = projectDao.insertAttachment(conn, file);
					
					result = projectNo;
					// 삽입 실패 시 다른 작업 필요 없이 바로 break;
					if (result == 0)
						break;
				}
			}
		}

		// 4) 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {
			// 5) DB 삽입 실패 시
			// 서버에 저장된 파일을 삭제
			// 앞쪽에서 DB 저장 정에 이미 서버에 저장이 되어있음
			for (ProjectResource file : fList) {
				String path = file.getProjectResourcePath(); // 경로 얻기
				String saveFile = file.getProjectResourcePath(); // 이름 얻기

				File failedFile = new File(path + saveFile);
				// : 매개변수로 지정된 경로의 파일을 접근(취급)할 수 있음.

				failedFile.delete();
			}
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ProjectRead updateProject(int no) throws Exception {
		Connection conn = getConnection();

		// 공지사항 상세조회
		ProjectRead projectRead = new ProjectDao().selectProject(conn, no);

		// DB에 저장된 내용을 textarea에 출력할 경우
		// <br>로 저장되어있는 부분을 \r\n으로 변경해야 함.
		projectRead.setProjectSummary(projectRead.getProjectSummary().replace("\r\n", "<br>"));

		close(conn);

		return projectRead;
	}

	/**
	 * 프로젝트 내용 수정용 Service
	 * 
	 * @param project
	 * @param fList
	 * @return result
	 * @throws Exception
	 */
	public int updateProject(Project project, ArrayList<ProjectResource> fList) throws Exception {

		Connection conn = getConnection();

		// 수정된 내용이 DB에 저장될 경우 개행문자 변경 필요
		project.setProjectContent(project.getProjectContent().replace("\r\n", "<br>"));

		ProjectDao projectDao = new ProjectDao();
		int result = 0;

		result = projectDao.updateProject(conn, project);

		if (result > 0) { // 게시글 삽입 성공 시
			result = 0; // 트랜잭션 처리를 위해 재활용

			// 3) fList의 데이터를 하나씩 DB에 삽입
			for (ProjectResource file : fList) {
				// 현재 게시글 번호 추가
				file.setProjectNo(project.getProjectNo());

				result = projectDao.updateAttachment(conn, file);

				// 삽입 실패 시 다른 작업 필요 없이 바로 break;
				if (result == 0)
					break;
			}
		}

		// 4) 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {
			// 5) DB 삽입 실패 시
			// 서버에 저장된 파일을 삭제
			// 앞쪽에서 DB 저장 정에 이미 서버에 저장이 되어있음
			for (ProjectResource file : fList) {
				String path = file.getProjectResourcePath(); // 경로 얻기
				String saveFile = file.getProjectResourcePath(); // 이름 얻기

				File failedFile = new File(path + saveFile);
				// : 매개변수로 지정된 경로의 파일을 접근(취급)할 수 있음.

				failedFile.delete();
			}
			rollback(conn);
		}

		close(conn);

		return result;

	}

	/**댓글 등록용 Service
	 * @param reply
	 * @param replyWriter
	 * @return
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		Connection conn = getConnection();
		
		int result = new ProjectDao().insertReply(conn,reply);
		
		if(result>0) commit(conn);
		else	     rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 리스트 조회용 Dao
	 * @param projectNo
	 * @return rList
	 * @throws Exception
	 */
	public List<ReplyRead> selectReplyList(int projectNo) throws Exception{
		Connection conn = getConnection();
		List<ReplyRead> rList = new ProjectDao().selectReplyList(conn,projectNo);
		close(conn);
		return rList;
	}

	/**프로젝트 삭제(PROJECT_DELETE_YN 'Y'로 바꿔주기 Service
	 * @param projectNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteProject(int projectNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new ProjectDao().deleteProject(conn,projectNo);
		
		if(result>0) commit(conn);
		else	     rollback(conn);
		
		close(conn);
		return result;
	}

	/**지원하기 (project_apply에 insert) Service
	 * @param memberNo
	 * @param projectNo
	 * @return
	 * @throws Exception
	 */
	public int insertApply(int memberNo, int projectNo) throws Exception{
		Connection conn = getConnection();
		int result = new ProjectDao().insertApply(conn,projectNo,memberNo);
		
		if(result>0) {
			commit(conn);
			result = projectNo;	
		}
		else		 rollback(conn);
		close(conn);
		return result;
	}

	/** 지원자 불러오는 List
	 * @param projectNo
	 * @return
	 * @throws Exception
	 */
	public List<VProjectApply> selectApplyList(String projectNo) throws Exception {
		Connection conn = getConnection();
		List<VProjectApply> aList = new ProjectDao().selectApplyList(conn,projectNo);
		close(conn);
		return aList;
	}

	
	/**멤버별 평균 별점 가져오는 Service
	 * @param memberNo
	 * @return memberStar
	 * @throws Exception
	 */
	public MemberStar selectMemberStar(int memberNo) throws Exception{
		Connection conn = getConnection();
		MemberStar memberStar = new ProjectDao().selectMemberStar(conn,memberNo);
		close(conn);
		return memberStar;
	}

	/**지원자가 있는지 확인하는 Service
	 * @param memberNo
	 * @param projectNo
	 * @return result
	 * @throws Exception
	 */
	public int checkApply(int memberNo, int projectNo) throws Exception{
		Connection conn = getConnection();
		int result = new ProjectDao().checkApply(conn,memberNo,projectNo);
		close(conn);
		return result;
	}

	/** 리뷰 등록 Service
	 * @param review
	 * @return result
	 * @throws Exception
	 */
	public int insertReview(Review review) throws Exception{
		Connection conn = getConnection();
		int result = new ProjectDao().insertReview(conn,review);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 해당 프로젝트 리뷰 불러오기
	 * @param projectNo
	 * @return reviewList
	 * @throws Exception
	 */
	public List<ReviewRead> selectReviewList(int projectNo) throws Exception{
		Connection conn = getConnection();
		List<ReviewRead> reviewList = new ProjectDao().selectReviewList(conn,projectNo);
		close(conn);
		return reviewList;
	}

	/**이미 작성한 리뷰가 있는 지 확인하는 Service
	 * @param projectNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int checkReview(int projectNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		int result = new ProjectDao().checkReview(conn,projectNo,memberNo);
		close(conn);
		return result;
	}

	/** 프로젝트를 올린 멤버의 평점을 가져오는 부분
	 * @param projectNo
	 * @return pMemberStar
	 * @throws Exception
	 */
	public int pMemberStar(int projectNo) throws Exception{
		Connection conn = getConnection();
		int pMemberStar = new ProjectDao().pMemberStar(conn,projectNo);
		close(conn);
		return pMemberStar;
	}

	

}
