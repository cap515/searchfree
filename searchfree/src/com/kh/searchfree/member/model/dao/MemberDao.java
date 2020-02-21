package com.kh.searchfree.member.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.member.model.vo.MyProject;
import com.kh.searchfree.member.model.vo.Portfolio;
import com.kh.searchfree.member.model.vo.ProfileResource;

public class MemberDao {
//마이페이지 db 처리
	private static Properties prop = null;
	
	public MemberDao() throws Exception{ 
		// member 관련 sql 파일을 관리할 properties 파일 생성
		
		String fileName 
		= MemberDao.class
		.getResource("/com/kh/searchfree/sql/member/member-query.properties")
		.getPath();
		
		prop = new Properties();
		
		prop.load(new FileReader(fileName));
		
	}
	
	   public Member loginMember(Connection conn, Member member) throws Exception{
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      
		      Member loginMember = null;
		      
		      String query = prop.getProperty("loginMember");
		      
		      try {
		         System.out.println(member);
		         pstmt = conn.prepareStatement(query);
		         pstmt.setString(1, member.getMemberId());
		         pstmt.setString(2, member.getMemberPwd());
		         
		         rset = pstmt.executeQuery();
		         
		         if(rset.next()) {
		            loginMember = new Member();
		            loginMember.setMemberNo(rset.getInt("MEMBER_NO"));
		            loginMember.setMemberId(rset.getString("MEMBER_ID"));
		            loginMember.setMemberNm(rset.getString("MEMBER_NM"));
		            loginMember.setMemberPhone(rset.getString("MEMBER_PHONE"));
		            loginMember.setMemberEmail(rset.getString("MEMBER_EMAIL"));
		            loginMember.setMemberAddr(rset.getString("MEMBER_ADDRESS"));
		            loginMember.setMemberInterest(rset.getString("MEMBER_INTEREST"));
		            loginMember.setMemberEnrollDate(rset.getDate("MEMBER_ENROLL_DT"));
		            loginMember.setMemberStatus(rset.getString("MEMBER_STATUS").charAt(0));
		            loginMember.setMemberGrade(rset.getString("MEMBER_GRADE").charAt(0));
		            loginMember.setMemberNick(rset.getString("MEMBER_NICK"));
		            loginMember.setMemberAccount(rset.getString("MEMBER_ACCOUNT"));
		            loginMember.setMemberIntro(rset.getString("MEMBER_INTRO"));
		            loginMember.setCategory1Code(rset.getInt("CATEGORY1_CODE"));
		            loginMember.setCategory2Code(rset.getInt("CATEGORY2_CODE"));
		         }
		      }finally {
		         close(rset);
		         close(pstmt);
		      }
		      System.out.println(loginMember);
		      return loginMember;
		   }
	
	/** 회원가입
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signMember(Connection conn, Member member) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("joinMember");
		System.out.println(member);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberNick());
			pstmt.setString(4, member.getMemberNm());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberAddr());
			pstmt.setString(8, member.getMemberAccount());
			pstmt.setInt(9, member.getCategory1Code());
			pstmt.setInt(10, member.getCategory2Code());

			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/**완료된 프로젝트 갯수 반환
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int completeProject(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("completeProject");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/**진행중 프로젝트
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int goingProject(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("goingProject");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	/**받은 쪽지 
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int messageCount(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("messageCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/**등록된 리뷰 수 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int reviewCount(Connection conn, int memberNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("reviewCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/**평균별점
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int avgSrating(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("avgSrating");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int countProject(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("countProject");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int checkPwd(Connection conn, String inputPwd, String memberId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, inputPwd);
			
			System.out.println("파라미터에서부터 dao까지 inputPwd가 왔나?" + inputPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt(1);
			}
					
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) throws Exception  {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberId);
			result = pstmt.executeUpdate();
			System.out.println("탈퇴 dao결과 " + result);
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 정보 조회용 DAO
	 * @param conn
	 * @param memberId
	 * @return selectMember
	 */
	public Member selectMember(Connection conn ) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member selectMember = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "asdfasdf" );
			//pstmt.setString(1, loginMember.getMemberId());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectMember = new Member(
						rset.getString("MEMBER_ID"),
						rset.getString("MEMBER_PWD"),
						rset.getString("MEMBER_NM"),
						rset.getString("MEMBER_NICK"), 
						rset.getString("MEMBER_PHONE"), 
						rset.getString("MEMBER_EMAIL"), 
						rset.getString("MEMBER_ADDRESS") );
				System.out.println("dao에서 selectMember : " + selectMember);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return selectMember;
	}
	
	public int updateMember(Connection conn, Member updateMember, String memberId) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateMember");
		System.out.println(query);
		System.out.println("update member "+updateMember);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,updateMember.getMemberNick());
			pstmt.setString(2,updateMember.getMemberPwd());
			pstmt.setString(3,updateMember.getMemberPhone());
			pstmt.setString(4,updateMember.getMemberEmail());
			pstmt.setString(5,updateMember.getMemberAddr());
			pstmt.setInt(6,updateMember.getCategory1Code());
			pstmt.setInt(7,updateMember.getCategory2Code());
			pstmt.setString(8, memberId);
			
			result = pstmt.executeUpdate();
			
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	

	
	/** 아이디 중복체크 확인용 DAO
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String id) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("idDupCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
				// 첫번째 칼럼값을 가져옴
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	/** 닉네임 중복검사
	 * @param conn
	 * @param nick
	 * @return result
	 * @throws Exception
	 */
	public int nickDupCheck(Connection conn, String nick) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("nickDupCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nick);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
				// 첫번째 칼럼값을 가져옴
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	  /**  select * from Category1
		 * @param conn
		 * @return category1List
		 * @throws Exception
		 */
		public List<Category1> getCategory1List(Connection conn) throws Exception {

			Statement stmt = null;
			ResultSet rset = null;
			List<Category1> category1List = new ArrayList<Category1>();

			String query = prop.getProperty("selectCategory1");

			try {

				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);

				while(rset.next()) {
					Category1 category1 = new Category1(rset.getInt(1), rset.getString(2));

					category1List.add(category1);
				}

			}finally {
				close(rset);
				close(stmt);
			}

			return category1List;
		}
		
		/**  select * from Category2
		 * @param conn
		 * @return category1List
		 * @throws Exception
		 */
		public List<Category2> getCategory2List(Connection conn) throws Exception {

			Statement stmt = null;
			ResultSet rset = null;
			List<Category2> category2List = new ArrayList<Category2>();

			String query = prop.getProperty("selectCategory2");

			try {

				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);

				while(rset.next()) {
					Category2 category2 = new Category2(rset.getInt(1), rset.getString(2), rset.getInt(3));

					category2List.add(category2);
				}

			}finally {
				close(rset);
				close(stmt);
			}

			return category2List;
		}

		public List<MyProject> selectProject1(Connection conn, int memberNo) throws Exception{
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<MyProject> selectProject1 = new ArrayList<MyProject>();
			String query = prop.getProperty("selectProject1");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					MyProject project1 = new MyProject();
					project1.setProjectTitle(rset.getString("PROJECT_TITLE"));
					project1.setProjectSummary(rset.getString("PROJECT_SUMMARY"));
					project1.setCreateDate(rset.getDate("PROJECT_CREATE_DT"));
					 
					selectProject1.add(project1);
					
					// 나중에 테스트 다 해보고 아래처럼 바꿀것
//					project1.setProjectTitle(rset.getString("컬럼이름"));
					
				}
			}finally {
				close(pstmt);
				close(rset);
			}
			
			return selectProject1;
		}

		public List<MyProject> selectProject2(Connection conn, int memberNo) throws Exception {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<MyProject> selectProject2 = new ArrayList<MyProject>();
			String query = prop.getProperty("selectProject2");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					MyProject project2 = new MyProject();
					project2.setProjectTitle(rset.getString("PROJECT_TITLE"));
					project2.setProjectSummary(rset.getString("PROJECT_SUMMARY"));
					project2.setCreateDate(rset.getDate("PROJECT_CREATE_DT"));
					
					selectProject2.add(project2);
					
				}
				
			}finally {
				close(pstmt);
				close(rset);
			}
			
			return selectProject2;
		}

		public List<MyProject> projectSchedule(Connection conn, int memberNo) throws Exception {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<MyProject> projectSchedule = new ArrayList<MyProject>();
			String query = prop.getProperty("projectSchedule");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					MyProject expiredDate = 
							new MyProject(rset.getDate("PROJECT_EXPIRED_DT"),
												rset.getString("PROJECT_TITLE"),
												rset.getString("PROJECT_SUMMARY"));
					projectSchedule.add(expiredDate);
				}
			}finally {
				close(pstmt);
				close(rset);
			}
			
			return projectSchedule;
		}

		/** 프로필 등록용
		 * @param conn
		 * @param memberNo
		 * @param fList
		 * @return result
		 * @throws Exception
		 */
		public int insertProfile(Connection conn, int memberNo, ProfileResource file) throws Exception {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("insertProfileResource");
			Statement stmt = conn.createStatement();
			String path = null;
			
			try {
				
				ResultSet rset = stmt.executeQuery("SELECT FILE_CHANGE_NAME FROM PROFILE_RESOURCE WHERE MEMBER_NO="+memberNo);
				
				if(rset.next()) {
					path = rset.getString(1);
				}
				if(path == null)
					query = prop.getProperty("insertProfileResource");
				else
					query = prop.getProperty("updateFiles");
				
				
				pstmt = conn.prepareStatement(query);
				if(path == null) {
				pstmt.setInt(1, memberNo);
				pstmt.setString(2, file.getProfileResourcePath());
				pstmt.setString(3,file.getContent());
				pstmt.setString(4, file.getFileChangeName());
				pstmt.setString(5, file.getFileOriginName());
				} else {
					pstmt.setString(1,file.getProfileResourcePath());
					pstmt.setString(2, file.getFileOriginName());
					pstmt.setString(3, file.getFileChangeName());
					pstmt.setString(4, file.getContent());
					pstmt.setInt(5, memberNo);
				}
				result = pstmt.executeUpdate();
				
			}finally {
				close(pstmt);
			}
			return result;
		}

		/** 게시글 이미지 파일 조회용 Dao
		 * @param conn
		 * @param memberNo
		 * @return files
		 * @throws Exception
		 */
		public List<ProfileResource> selectFiles(Connection conn, int memberNo) throws Exception{
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			ArrayList<ProfileResource> files = null;
			
			String query = prop.getProperty("selectFiles");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rset = pstmt.executeQuery();
				
				files = new ArrayList<ProfileResource>();
				ProfileResource file = null;
				
				while(rset.next()) {
					file = new ProfileResource(
							rset.getInt("MEMBER_NO"), 
							rset.getString("PROFILE_RESOURCE_PATH"), 
							rset.getString("PROFILE_RESOURCE_DELETE_YN").charAt(0), 
							rset.getString("FILE_ORIGIN_NAME"), 
							rset.getString("FILE_CHANGE_NAME"), 
							rset.getString("PROFILE_RESOURCE_CONTENT")
							);
					
					files.add(file);
				}
				
			}finally {
				close(rset);
				close(pstmt);
			}
			return files;
		}

		public int updateProfile(Connection conn, int memberNo, ProfileResource file) throws Exception {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("updateFiles");
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, file.getProfileResourcePath());
			//	pstmt.setString(2, file.getFileOriginName());
				pstmt.setString(2, file.getFileChangeName());
				pstmt.setString(3, file.getContent());
				//pstmt.setString(5, file.get());
				pstmt.setInt(4,memberNo);
				
				result = pstmt.executeUpdate();
				
			}finally {
				close(pstmt);
			}
			return result;
		}


		/** 포트폴리오 insert동작
		 * @param conn
		 * @param portfolio
		 * @return result
		 * @throws Exception
		 */
		public int insertPortfolio(Connection conn, Portfolio portfolio) throws Exception{
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("insertPortfolio");
			
			System.out.println("-포트폴리오-");
			System.out.println(portfolio);
			System.out.println("dao에서 입력하는 멤버넘버 : " + portfolio.getMemberNo());
			System.out.println("dao에서 입력하는 타이틀 : " + portfolio.getPortfolioTitle());
			System.out.println("dao에서 입력하는 콘텐츠 : " + portfolio.getPortfolioContent());
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, portfolio.getMemberNo());
				pstmt.setString(2, portfolio.getPortfolioTitle());
				pstmt.setString(3,portfolio.getPortfolioContent());
				result = pstmt.executeUpdate();
			}finally {
				close(pstmt);
			}
			return result;
		}

		/**포트폴리오 불러오기
		 * @param conn
		 * @param memberNo
		 * @return portfolio
		 * @throws Exception
		 */
		public Portfolio getPortfolio(Connection conn, int memberNo) throws Exception{
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Portfolio portfolio = null;
			String query = prop.getProperty("selectPortfolio");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					portfolio = new Portfolio(rset.getString("PORTFOLIO_TITLE"),
							rset.getString("PORTFOLIO_CONTENT"));
					
				}
				System.out.println("dao에서 셀렉트" + portfolio);
				
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return portfolio;
		}

		public int deletePortfolio(Connection conn, int memberNo) throws Exception{
			PreparedStatement pstmt = null;
			String query = prop.getProperty("deletePortfolio");
			int result = 0;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,memberNo );
				result = pstmt.executeUpdate();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int updatePortfolio(Connection conn, Portfolio portfolio)  throws Exception{
			PreparedStatement pstmt = null;
			String query = prop.getProperty("upPortfolio");
			int result = 0;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, portfolio.getPortfolioTitle());
				pstmt.setString(2, portfolio.getPortfolioContent());
				pstmt.setInt(3, portfolio.getMemberNo());
				result = pstmt.executeUpdate();
				System.out.println("업데이트   dao"+ result);
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int checkDelete(Connection conn, int memberNo) throws Exception {
			PreparedStatement pstmt = null;
			String query = prop.getProperty("checkDelete");
			int result = 0;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				result = pstmt.executeUpdate();
			}finally {
				close(pstmt);
			}
			return result;
		}
	
}
