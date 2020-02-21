package com.kh.searchfree.notice.model.service;

import static com.kh.searchfree.common.JDBCTemplate.close;
import static com.kh.searchfree.common.JDBCTemplate.commit;
import static com.kh.searchfree.common.JDBCTemplate.getConnection;
import static com.kh.searchfree.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.board.model.vo.Attachment;
import com.kh.searchfree.notice.model.dao.NoticeDao;
import com.kh.searchfree.notice.model.vo.Notice;
import com.kh.searchfree.notice.model.dao.NoticeDao;
import com.kh.searchfree.notice.model.vo.Notice;

public class NoticeService {

	/**
	 * 공지사항 목록 조회용 서비스
	 * 
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(int code) throws Exception {
		Connection conn = getConnection();

		return new NoticeDao().selectList(conn, code);
	}

	public Notice selectNotice(int no) throws Exception {

		Connection conn = getConnection();

		NoticeDao noticeDao = new NoticeDao();

		// 공지사항 상세 조회
		Notice notice = noticeDao.selectNotice(conn, no);
		
		close(conn);
		return notice;
	}

	public int insertNotice(Notice notice) throws Exception {
		Connection conn = getConnection();
		NoticeDao noticeDao = new NoticeDao();

		// 등록될 공지사항의 글 번호 생성
		// -> 공지사항 등록 성공 시 해당 글번호 상세조회를 위해서
		// + 파일 업로드 시 현재 등록된 글 번호를 외래키로 사용하기 위해서
		int no = noticeDao.selectNextNo(conn);

		int result = 0;

		if (no > 0) { // 다음 번호가 생성이 됐을 경우
			// DB 저장 시 개행문자 \r\n을 <br>로 변경해야
			// 상세조회시 줄바꿈이 유지됨.
			notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));

			result = noticeDao.insertNotice(conn, notice, no);

			if (result > 0) { // 공지사항 DB 삽입 성공
				commit(conn);

				result = no;
				// 다음 번호 조회 + 공지사항 등록 성공 시
				// 등록 완료 후 해당 작성 페이지로 이동하기 위해서
				// 조회된 번호를 반환시킴
			} else {
				rollback(conn);
			}
		}
		close(conn);
		return result;
	}

	/**
	 * 공지사항 수정 화면용 Service
	 * 
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

	public int updateNotice(Notice notice) throws Exception {
		Connection conn = getConnection();

		// 수정된 내용이 DB에 저장될 경우 개행문자 변경 필요
		notice.setNoticeContent(notice.getNoticeContent().replace("\r\n", "<br>"));

		int result = new NoticeDao().updateNotice(conn, notice);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int deleteNotice(int no) throws Exception {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn, no);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/**
	 * 공지사항 검색용 Service
	 * 
	 * @param searchKey
	 * @param searchValue
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> searchNotice(String searchKey, String searchValue) throws Exception {
		Connection conn = getConnection();

		String condition = null;

		searchValue = "'%' || '" + searchValue + "' || '%'";
		// like '%공지%'

		switch (searchKey) {
		case "title":
			condition = " NOTICE_TITLE LIKE " + searchValue;
			break;
		case "content":
			condition = " NOTICE_CONTENT LIKE " + searchValue;
			break;
		case "titcont":
			condition = " (NOTICE_TITLE LIKE " + searchValue + "OR NOTICE_CONTENT LIKE " + searchValue + ")";
			break;
		}

		List<Notice> list = new NoticeDao().searchNotice(conn, condition);
		close(conn);

		return list;
	}

	

	/**pageing lis 호출용 service
	 * @param currentPage
	 * @param limit
	 * @param code 
	 * @return nList
	 * @throws Exception
	 */
	public List<Notice> selectListPage(int currentPage, int limit, int code) throws Exception {

		Connection conn = getConnection();

		List<Notice> nList = new NoticeDao().selectListPage(conn, currentPage, limit , code);

		close(conn);

		return nList;
	}

	/** pageing list출렬용 service
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount() throws Exception {
		Connection conn = getConnection();

		int listCount = new NoticeDao().getListCount(conn);

		close(conn);
		return listCount;
	}

}
