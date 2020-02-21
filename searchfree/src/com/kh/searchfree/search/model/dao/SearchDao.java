package com.kh.searchfree.search.model.dao;

import java.sql.Statement;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import static com.kh.searchfree.common.JDBCTemplate.*;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.dao.MemberDao;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;

public class SearchDao {

	private Properties prop = null;

	public SearchDao() throws Exception {

		String fileName = SearchDao.class.getResource("/com/kh/searchfree/sql/search/search-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}

	public List<SearchResult> getSearchList(Connection conn, SearchValue sv) throws Exception {

		Statement stmt = null;
		ResultSet rset = null;

		List<SearchResult> rList = new ArrayList<SearchResult>();

		String query = "SELECT * FROM SEARCH_SUMMARY WHERE PROJECT_DELETE_YN='N' ";

		try {
			if (sv.getKeyword() != null) {
				if (sv.getKeywordRange() > 0) {
					switch (sv.getKeywordRange()) {
					case 1:
						query += " AND PROJECT_TITLE LIKE\'%" + sv.getKeyword() + "%\'";
						break;
					case 2:
						query += " AND MEMBER_NICK LIKE \'%" + sv.getKeyword() + "%\'";
						break;
					case 3:
						query += " AND (PROJECT_TITLE = \'%" + sv.getKeyword() + "%\' OR WHERE PROJECT_NICK) = \'%"
								+ sv.getKeyword() + "%\'";
						break;
					}
				}
			}

			if (sv.getCategory1Code() > 0) {
				query += " AND PROJECT_CATEGORY1_CODE = " + sv.getCategory1Code();
			}
			if (sv.getCategory2Code() > 0) {
				query += " AND PROJECT_CATEGORY2_CODE = " + sv.getCategory2Code();
			}

			if (sv.getMemberGrade() > 0) {
				query += " AND MEMBER_GRADE = " + sv.getMemberGrade();
			}

			ArrayList<Integer> status = (ArrayList) (sv.getProjectStatus());
			Iterator it = status.iterator();

			if (it.hasNext()) {
				query += " AND(";
			}
			while (it.hasNext()) {
				query += " PROJECT_STATUS = \'" + it.next() + "\'";
				if (it.hasNext())
					query += " OR";
				else
					query += ")";
			}
			int[] price = sv.getPriceRangeInt();
			if (sv.getPriceRangeInt() != null) {
				query += "AND PROJECT_PRICE BETWEEN " + price[0] + " AND " + price[1] + " ";
			}
			if (sv.getUser_alt() != -1) {
				query += "AND PROJECT_ALT=" + sv.getUser_alt();
			}

			System.out.println(query);

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {

				SearchResult sr = new SearchResult(
						rset.getString("FILE_CHANGE_NAME"),
						rset.getString("PROJECT_TITLE"), rset.getString("PROJECT_SUMMARY"),
						rset.getString("MEMBER_NICK"), rset.getInt("MEMBER_NO"), rset.getInt("PROJECT_PRICE"),
						rset.getInt("PROJECT_NO"), rset.getInt("STAR_AVG"));
				System.out.println(sr.getProjectNo() + " star : " + sr.getStarRating());
				rList.add(sr);
			}
		} finally {
			close(rset);
			close(stmt);
		}

		return rList;

	}

	public List<SearchResult> getRecentList(Connection conn) throws Exception {

		List<SearchResult> list = new ArrayList<SearchResult>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("getRecentList");
		try {

			pstmt = conn.prepareStatement(query);

			System.out.println(query);
			
			int rnum = 1;
			while (list.size() < 6) {
				
				pstmt.setInt(1, rnum++);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					SearchResult sr = new SearchResult(
							rset.getString("FILE_CHANGE_NAME"),
							rset.getString("PROJECT_TITLE"), rset.getString("PROJECT_SUMMARY"),
							rset.getString("MEMBER_NICK"), rset.getInt("MEMBER_NO"), rset.getInt("PROJECT_PRICE"),
							rset.getInt("PROJECT_NO"), rset.getInt("STAR_AVG"));
					System.out.println(sr.getProjectNo() + " star : " + sr.getStarRating());
					list.add(sr);
					System.out.println("size : " + list.size());
				}
			}
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
}
