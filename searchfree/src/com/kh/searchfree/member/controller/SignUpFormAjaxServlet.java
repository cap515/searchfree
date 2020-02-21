
package com.kh.searchfree.member.controller;

import java.io.IOException;
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

import static com.kh.searchfree.common.ExceptionForward.*;
import com.kh.searchfree.member.model.service.MemberService;
@WebServlet("/member/AjaxCategory1code.do")
public class SignUpFormAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpFormAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String catrgory1Code = (String)request.getParameter("input");

		System.out.println("catrgory1Code = " + catrgory1Code);
		List<Category2> category2ListAll = new ArrayList<Category2>();
		List<Category2> list = new ArrayList<Category2>();
		try {
			category2ListAll = new MemberService().getCategory2List();
			
			for(Category2 cg2 : category2ListAll) {
				if(cg2.getCategory1Code() == Integer.parseInt(catrgory1Code))
					list.add(cg2);
			}
		}catch(Exception e) {
			ExceptionForward.errorPage(request, response, "카테고리2 목록 조회", e);
		}
		
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
