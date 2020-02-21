package com.kh.searchfree.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/changePwd.do")
public class ChangPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangPwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면전환
		String path = "/WEB-INF/views/member/changePwd.jsp";
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
