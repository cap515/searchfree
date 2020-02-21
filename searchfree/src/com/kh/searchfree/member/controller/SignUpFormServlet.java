
package com.kh.searchfree.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;

import static com.kh.searchfree.common.ExceptionForward.*;
import com.kh.searchfree.member.model.service.MemberService;
@WebServlet("/member/signUpForm.do")
public class SignUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/signUpForm.jsp";
		
		/*
			해야할거
			SignUpForm.jsp에 DB 참조해서 카테고리1과 그 하위 카테고리2를 가져와서 select에 넣어줘야함
		*/
		
		try {
		System.out.println(1);
		List<Category1> category1List = new MemberService().getCategory1List();
		System.out.println(category1List);
		List<Category2> category2List = new MemberService().getCategory2List();
		System.out.println(category2List);
		
		request.setAttribute("category1List",category1List);
		request.setAttribute("category2List",category2List);
		request.setAttribute("category1Code","1");
		}catch(Exception e){
			ExceptionForward.errorPage(request, response, "카테고리 목록을 가져오는", e);
		}
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
