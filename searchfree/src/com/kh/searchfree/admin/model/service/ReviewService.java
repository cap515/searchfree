package com.kh.searchfree.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.dao.ReplyDao;
import com.kh.searchfree.admin.model.dao.ReviewDao;
import com.kh.searchfree.admin.model.vo.Reply;
import com.kh.searchfree.admin.model.vo.Review;

import static com.kh.searchfree.common.JDBCTemplate.*;


public class ReviewService {

	/** 리뷰게시판 목록 조회용 서비스 
	 * @return list
	 * @throws Exception
	 */ 
	public List<Review> selecRvList(int memNo) throws Exception{
		Connection conn = getConnection();
		
		return new ReviewDao().selecRvList(conn, memNo);
	}
	
	

	
}
