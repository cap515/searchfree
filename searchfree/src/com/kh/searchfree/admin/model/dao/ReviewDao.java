package com.kh.searchfree.admin.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.admin.model.vo.Reply;
import com.kh.searchfree.admin.model.vo.ReportAll;
import com.kh.searchfree.admin.model.vo.Review;

public class ReviewDao {
	private Properties prop = null;
	
	public ReviewDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/review/adminReview-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	public List<Review> selecRvList(Connection conn, int memNo)throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Review> list = null;
		
		String query = prop.getProperty("selectReivewList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Review>();
			
			Review review = null;
			
			while(rset.next()) {
				review = new Review();
				review.setMemberNo(memNo);
				review.setReviewStarRating(rset.getInt("REVIEW_STAR_RATING"));
				review.setReviewContent(rset.getString("REVIEW_CONTENT"));
				review.setReviewCreateDate(rset.getDate("REVIEW_CREATE_DT"));		
				review.setProjectNo(rset.getInt("PROJECT_NO"));
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				
				list.add(review);
				
				System.out.println("리뷰 리스트 :  "+review);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
