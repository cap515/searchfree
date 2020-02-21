package com.kh.searchfree.search.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.project.model.service.ProjectService;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.search.model.service.SearchService;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;

@WebServlet("/Search/*")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/Search").length());

		String path = null;
		RequestDispatcher view = null;

		SearchService searchService = new SearchService();

		System.out.println(0);
		
		if (command.equals("/SearchForm")) {
			try {
				System.out.println(1);
				int keywordRange = -1;
				if(request.getParameter("search_area") != null)
					keywordRange = Integer.parseInt(request.getParameter("search_area"));
				String keyword = request.getParameter("search_text");
				int category1Code = -1;
				int category2Code = -1;
				int memberGrade = -1;
				Date startDate = null;
				Date expiredDate = null;
				ArrayList<Integer> projectStatus = new ArrayList<Integer>();
				String[] priceRangeStr = new String[2];
				int[] priceRangeInt = null;
				int user_alt = -1;
				
				if(request.getParameter("c1") != null)
					category1Code = Integer.parseInt(request.getParameter("c1"));
				if(request.getParameter("c2") != null) 
					category2Code = Integer.parseInt(request.getParameter("c2"));
				if(request.getParameter("member_grade") != null)
					memberGrade = Integer.parseInt(request.getParameter("member_grade"));
				if(request.getParameter("s_date") != null && request.getParameter("s_date") != "")
					startDate = Date.valueOf(request.getParameter("s_date"));
				if(request.getParameter("e_date") != null && request.getParameter("e_date") != "")
					expiredDate = Date.valueOf(request.getParameter("e_date"));
				if(request.getParameter("status1") != null)
					projectStatus.add(Integer.parseInt(request.getParameter("status1")));
				if(request.getParameter("status2") != null)
					projectStatus.add(Integer.parseInt(request.getParameter("status2")));
				if(request.getParameter("status3") != null)
					projectStatus.add(Integer.parseInt(request.getParameter("status3")));
				
				if(request.getParameter("price_range") != null) {
					System.out.println(request.getParameter("price_range"));
					
					priceRangeInt = new int[2]; 
					priceRangeStr =	request.getParameter("price_range").split("-"); 
					priceRangeInt[0] =
					Integer.parseInt(priceRangeStr[0].trim()); 
					priceRangeInt[1] =
					Integer.parseInt(priceRangeStr[1].trim());
				}
				if(request.getParameter("user_alt") != null) {
					user_alt = Integer.parseInt(request.getParameter("user_alt"));
				}
				System.out.println(memberGrade);
				SearchValue sv = new SearchValue(keywordRange, keyword, category1Code, 
						category2Code, memberGrade, startDate, expiredDate, projectStatus ,
						priceRangeInt, request.getParameter("price_range"), user_alt);
				
				request.setAttribute("searchValue", sv);
				
				List<SearchResult> rList = searchService.getSearchList(sv);
				
				List<Category1> category1List = new MemberService().getCategory1List();
				
				
				request.setAttribute("category1List",category1List);
				request.setAttribute("rList",rList);

			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "검색", e);
			}
			path = "/WEB-INF/views/project/project_search.jsp";
			
			//request.setAttribute("searchList", searchList);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			System.out.println(path);
		} else if (command.equals("/recentList")) {
			
			List<SearchResult> list = null;
			try {
				list = searchService.getRecentList();
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "카테고리2 목록 조회", e);
			}
			
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(list, response.getWriter());
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
