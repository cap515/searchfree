package com.kh.searchfree.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.project.model.service.ProjectService;
import com.kh.searchfree.project.model.service.ProjectService2;
import com.kh.searchfree.project.model.vo.ProjectOrderList;



@WebServlet("/project2/*")
public class ProjectOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProjectOrderController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Front Controller
				// - 클라이언트의 요청을 한 곳으로 집중시켜서
				//	 개발 및 유지보수의 효율성을 증가시키는 패턴
				
				// - 요청에 따른 servlet을 따로 생성하지 않고
				// 오직 하나의 servlet에서만 제어함
				
				
		
				String uri = request.getRequestURI();	
				String contextPath = request.getContextPath();
				String command = uri.substring((contextPath+"/Semi").length());
				// 제일 뒤에 들어온 주소만 잘라내는 것
					
				String msg = null;
				String path = null;
				RequestDispatcher view = null;
				
				ProjectService2 projectService2 = new ProjectService2();
				Member loginMember= (Member)request.getSession().getAttribute("loginMember");
					
				int no = loginMember.getMemberNo();
				//int projectNo=-1;
				
				command.equals("/orderCheck");
//				if(request.getParameter("no")!= null)
//					no =Integer.parseInt(request.getParameter("no"));
//				if(request.getParameter("projectNo")!= null)
//					projectNo = Integer.parseInt(request.getParameter("projectNo"));
				
					try {
						
						//ProjectOrderList orderlist = projectService.selectProject();
						
						
						//  (구매자) 프로젝트 주문 리스트
						
						List<ProjectOrderList>orderlist = projectService2.selectProject(no);
						 // String orderlist = projectService.selectProject();
						
						System.out.println("구매 리스트 확인"+ orderlist);
						
						
						//  (판매)한 프로젝트 주문 리스트
						
						
						List<ProjectOrderList>selledList = projectService2.selledProject(no);
						 System.out.println("판매 리스트 확인"+ selledList);
						 
						
						// 프로젝트 별점 평균값 
					//	ProjectOrderList averlist = projectService.selectProject();
						
						List<ProjectOrderList>averlist = projectService2.selAverProject();
						System.out.println("평균 확인 +" + averlist);

						
						request.setAttribute("orderlist", orderlist);
						request.setAttribute("selledList", selledList);
						request.setAttribute("averlist", averlist);
						
						path="/WEB-INF/views/project/orderCheck.jsp";
						
						
					}catch (Exception e) {
						path="/WEB-INF/views/common/errorPage.jsp";
						request.setAttribute("errorMsg","프로젝트 목록  조회과정에서 오류가 발생했습니다.");
						e.printStackTrace();
						
					}finally {
						System.out.println(path);
						view = request.getRequestDispatcher(path);
						view.forward(request,response);
						
					}
					
					
					
					
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
