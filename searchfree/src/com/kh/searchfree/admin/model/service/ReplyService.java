package com.kh.searchfree.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.dao.ReplyDao;
import com.kh.searchfree.admin.model.vo.Reply;

import static com.kh.searchfree.common.JDBCTemplate.*;


public class ReplyService {

	/** 댓글게시판 목록 조회용 서비스 
	 * @return clist
	 * @throws Exception
	 */ 
	public List<Reply> selectRList(int memNo) throws Exception{
		Connection conn = getConnection();
		
		return new ReplyDao().selectRList(conn, memNo);
	}
	
	

	
}
