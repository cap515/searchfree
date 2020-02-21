package com.kh.searchfree.admin.model.service;

import static com.kh.searchfree.common.JDBCTemplate.getConnection;
import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.notice.model.service.*;
import com.kh.searchfree.admin.model.dao.SummerNoteDao;
import com.kh.searchfree.notice.model.vo.Notice;

public class SummerNoteService {

	/** Board, Attachment 테이블 데이터 삽입 Service
	 * @param board
	 * @param savePath
	 * @param imgArr
	 * @return result1
	 */
	public int insert(Notice notice) {
		Connection conn = getConnection();
		
		SummerNoteDao sDao = new SummerNoteDao();

		// 게시글 삽입 DAO
		int result1 = sDao.insertNotice(conn, notice);
		
		if(result1 > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result1;
	}

	
	/** 게시글 상세조회 Service
	 * @param no
	 * @return board
	 */
	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		return new SummerNoteDao().selectNotice(conn, no);
	}


	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		SummerNoteDao sDao = new SummerNoteDao();
		int result = sDao.updateNotice(conn,notice);
			
		
		return result;
	}

	
}
