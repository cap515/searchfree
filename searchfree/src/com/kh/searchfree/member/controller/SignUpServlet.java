package com.kh.searchfree.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.member.model.vo.Member;

@WebServlet("/member/signUp.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		System.out.println(1);
		String memberId = request.getParameter("inputId");
		String memberPwd = request.getParameter("inputPwd");
		String memberNm = request.getParameter("inputNm");
		String memberPhone = request.getParameter("inputPhone");
		String memberEmail = request.getParameter("inputEmail");
		String memberAddr = request.getParameter("inputAddr1")+","+request.getParameter("inputAddr2");
		System.out.println(memberAddr);
		String memberNick = request.getParameter("inputNick");
		System.out.println(memberNick);
		int category1Code = Integer.parseInt(request.getParameter("inputCategory1"));
		System.out.println(category1Code);
		int category2Code = Integer.parseInt(request.getParameter("inputCategory2"));
		String memberAccount = request.getParameter("inputAccount");
		
		Member member = new Member();
		
		member.setCategory1Code(category1Code);
		member.setCategory2Code(category2Code);
		member.setMemberAccount(memberAccount);
		member.setMemberAddr(memberAddr);
		member.setMemberEmail(memberEmail);
		member.setMemberId(memberId);
		member.setMemberNm(memberNm);
		member.setMemberPhone(memberPhone);
		member.setMemberPwd(memberPwd);
		member.setMemberNick(memberNick);
		
		System.out.println("signup : "+ member);
		
		try {
			int result = new MemberService().signMember(member);
			
			HttpSession session = request.getSession();
			
			if(result >0) {
				response.sendRedirect(request.getContextPath());
				session.setAttribute("msg", "가입성공");
			}else {
				response.sendRedirect(request.getContextPath());
				session.setAttribute("msg", "가입실패");
			}
			
			
		}catch(Exception e) {
			request.setAttribute("errorMsg", "회원가입 과정에서 오류가 발생하였습니다.");
			
			e.printStackTrace();
			String path = "/WEB-INF/views/common/errorPage.jsp";
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
