package com.kh.searchfree.report.controller;

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
import javax.servlet.http.HttpSession;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.project.model.service.ProjectService;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.report.model.service.ReportService;
import com.kh.searchfree.report.model.vo.ReportVo;
import com.kh.searchfree.search.model.service.SearchService;
import com.kh.searchfree.search.model.vo.SearchResult;
import com.kh.searchfree.search.model.vo.SearchValue;

@WebServlet("/report/*")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReportController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/report").length());
		
		String path = null;
		RequestDispatcher view = null;

		SearchService searchService = new SearchService();

		if (command.equals("/reportForm")) {
			try {
				
				request.setAttribute("report_code1",request.getParameter("report_code1"));
				request.setAttribute("toReportNo",request.getParameter("toReportNo"));

			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "신고", e);
			}
			path = "/WEB-INF/views/report/reportForm.jsp";
			
			//request.setAttribute("searchList", searchList);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		else if (command.equals("/report")) {
			try {
				System.out.println(1);
				ReportVo rVo = new ReportVo();
				
				int report_code1 = -1;
				int report_code = -1;
				int toReportNo = -1;
				if(request.getParameter("report_code1") != null) {
					report_code1 = Integer.parseInt((String)request.getParameter("report_code1"));
					if(request.getParameter("report_code2") != null) {
						report_code = report_code1 + Integer.parseInt((String)request.getParameter("report_code2"));
						rVo.setReportCode(report_code);
					}
				}
				rVo.setReportTitle(request.getParameter("report_title"));
				rVo.setReportContent(request.getParameter("report_content"));
				if(request.getParameter("toReport") != null) 
					rVo.setToReportNo(Integer.parseInt(request.getParameter("toReportNo")));
				HttpSession session = request.getSession();
				Member loginMember = (Member)session.getAttribute("loginMember");
				
				rVo.setMemberNo(loginMember.getMemberNo());
				if(request.getParameter("toReportNo") != null)
					rVo.setToReportNo(Integer.parseInt(request.getParameter("toReportNo")));
				
				System.out.println("rVo"+rVo);
				
				int result = new ReportService().updateReport(rVo);
				
			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "신고", e);
			}
			path = "/index.jsp";
			
			//request.setAttribute("searchList", searchList);
			view = request.getRequestDispatcher(path);
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
