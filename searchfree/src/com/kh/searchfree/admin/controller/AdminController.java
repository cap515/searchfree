package com.kh.searchfree.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.kh.searchfree.admin.model.service.*;
import com.kh.searchfree.admin.model.vo.AdminMember;
import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.board.model.vo.Attachment;
import com.kh.searchfree.board.model.vo.Board;
import com.kh.searchfree.admin.model.vo.Reply;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.common.MyFileRenamePolicy;
import com.kh.searchfree.admin.model.service.MemberService;
import com.kh.searchfree.notice.model.vo.Notice;
import com.kh.searchfree.admin.model.vo.ReportAll;
import com.kh.searchfree.admin.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/admin").length());

		String msg = null;
		String path = null;
		RequestDispatcher view = null;
		NoticeService noticeService = new NoticeService();
		MemberService memberService = new MemberService();
		ReportService reportService = new ReportService();
		ProjectService projectService = new ProjectService();
		ReplyService replyService = new ReplyService();
		ReviewService reviewService = new ReviewService();
		HttpSession session = request.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (command.equals("/main")) {

			if(loginMember != null) {
					
				path = "/WEB-INF/views/admin/index.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else {
				response.sendRedirect(contextPath);
			}
		}else if (command.equals("/logout")) {
			request.getSession().invalidate(); // 세션 무효화 ==> 서버에있는 클라이언트측 세션을 없애는 것
			response.sendRedirect(request.getHeader("referer"));
		}
		
		else if (command.equals("/AdminNotice/NoticeList")) {
			if(loginMember != null) {
				try {
					List<Notice> list = noticeService.selectList();
					// list에 공지사항, 자주묻는 질문 같이있음
					request.setAttribute("noticeList", list);
					path = "/WEB-INF/views/admin/AdminNotice/NoticeList.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "공지사항 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}

		} else if (command.equals("/AdminNotice/QnaList")) {
			if(loginMember != null) {
				try {
					List<Notice> qlist = noticeService.selectqList();
					// list에 공지사항, 자주묻는 질문 같이있음
					request.setAttribute("QnaList", qlist);
					path = "/WEB-INF/views/admin/AdminQna/QnaList.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "공지사항 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}

		} else if (command.equals("/AdminNotice/NoticeDetail")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");

			int no = Integer.parseInt(request.getParameter("no"));

			try {
				Notice notice = new SummerNoteService().selectNotice(no);

				if (notice != null) {
					System.out.println("상세조회 서블릿" + notice);
					request.setAttribute("notice", notice);
					view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminNotice/NoticeDetail.jsp");
					view.forward(request, response);

					} else {
						request.getSession().setAttribute("msg", "공지사항 상세조회 오류");
						response.sendRedirect("NoticeList");
					}
	
					} catch (Exception e) {
						ExceptionForward.errorPage(request, response, "공지사항 상세 조회", e);
					}
			}else {
				response.sendRedirect(contextPath);
			}
		}
		// notice 수정 폼 가져오기
		else if (command.equals("/AdminNotice/NoticeEdit")) {
			if(loginMember != null) {
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				Notice notice = noticeService.updateForm(no);

				if (notice != null) {
					path = "/WEB-INF/views/admin/AdminNotice/NoticeEdit.jsp";
					request.setAttribute("notice", notice);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("msg", "공지사항 수정화면 불러오기 실패");
				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 수정화면", e);
			}
			}else {
				response.sendRedirect(contextPath);
			}

		}
		// notice 수정 처리
		else if (command.equals("/AdminNotice/update")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");

			int noticeNo = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noticeType = Integer.parseInt(request.getParameter("stNotice"));
			char noticeDeleteYN = request.getParameter("noticeStatus").charAt(0);

			Notice notice = new Notice();
			notice.setNoticeNo(noticeNo);
			notice.setNoticeTitle(title);
			notice.setNoticeContent(content);
			notice.setNoticeCode(noticeType);
			notice.setNoticeDeleteYN(noticeDeleteYN);
			try {

				System.out.println(notice);
				int result = new SummerNoteService().updateNotice(notice);

				String msg1 = null;
				if (result > 0)
					msg1 = "공지사항/자주찾는 질문 수정 성공";
				else
					msg1 = "공지사항/자주찾는 질문 수정 실패";

				request.getSession().setAttribute("msg", msg1);
				response.sendRedirect("NoticeList");
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 수정", e);
			}}else {
				response.sendRedirect(contextPath);
			}

		}
		else if (command.equals("/AdminNotice/qupdate")) {
			if(loginMember != null) {
				request.setCharacterEncoding("UTF-8");
	
				int noticeNo = Integer.parseInt(request.getParameter("no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				int noticeType = Integer.parseInt(request.getParameter("stNotice"));
				char noticeDeleteYN = request.getParameter("noticeStatus").charAt(0);
	
				Notice notice = new Notice();
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(title);
				notice.setNoticeContent(content);
				notice.setNoticeCode(noticeType);
				notice.setNoticeDeleteYN(noticeDeleteYN);
				try {
	
					System.out.println(notice);
					int result = new SummerNoteService().updateNotice(notice);
	
					String msg1 = null;
					if (result > 0)
						msg1 = "질문 게시  성공";
					else
						msg1 = "질문 게시  실패";
	
					request.getSession().setAttribute("msg", msg1);
					response.sendRedirect("NoticeList");
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "질문 게시 ", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}


		}
		// notice 등록 폼 가져오기
		else if (command.equals("/AdminNotice/NoticeInsert")) {
			if(loginMember != null) {
			path = "/WEB-INF/views/admin/AdminNotice/NoticeInsert.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
			}else {
				response.sendRedirect(contextPath);
			}

		}
		// notice 등록 service호출
		else if (command.equals("/AdminNotice/NotiInsert")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noticeType = Integer.parseInt(request.getParameter("selectNotice"));
			char noticeDeleteYN = request.getParameter("noticeStatus").charAt(0);

			Notice notice = new Notice();
			
			notice.setNoticeTitle(title);
			notice.setNoticeContent(content);
			notice.setNoticeCode(noticeType);
			notice.setNoticeDeleteYN(noticeDeleteYN);

			int result = new SummerNoteService().insert(notice);

			System.out.println("공지등록결과 " + result);
			
			String msg1 = null;
			if (result > 0)
				msg1 = "공지사항/자주찾는 질문 등록 성공";
			else
				msg1 = "공지사항/자주찾는 질문 등록 실패";

			request.getSession().setAttribute("msg", msg1);
			response.sendRedirect("NoticeList");
			
			}else {
				response.sendRedirect(contextPath);
			}
		} else if (command.equals("/AdminNotice/NoticeDeletenotican")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");
			String noList = request.getParameter("noList"); // 선택된 행번호
			try {
				int result = new NoticeService().deleteNotice(noList);

				String msg1 = null;
				if (result > 0)
					msg1 = "공지사항 삭제 성공";
				else
					msg1 = "공지사항 삭제 실패";
				request.getSession().setAttribute("msg", msg1);
				
				response.sendRedirect("NoticeList");

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 삭제", e);
			}
				
			}else {
				response.sendRedirect(contextPath);
			}
		} else if (command.equals("/AdminNotice/NoticeDeletenotireg")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");
			String noList = request.getParameter("noList"); // 선택된 행번호
			try {
				int result = new NoticeService().deleteChNotice(noList);

				String msg1 = null;
				if (result > 0)
					msg1 = "공지사항 게시 성공";
				else
					msg1 = "공지사항 게시 실패";
				request.getSession().setAttribute("msg", msg1);
				response.sendRedirect("NoticeList");

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "회원 목록 조회", e);
			}
			}else {
				response.sendRedirect(contextPath);
			}
		} else if (command.equals("/AdminNotice/qnaDeletenotican")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");
			String noList = request.getParameter("noList"); // 선택된 행번호
			try {
				int result = new NoticeService().deleteNotice(noList);

				String msg1 = null;
				if (result > 0)
					msg1 = "공지사항 삭제 성공";
				else
					msg1 = "공지사항 삭제 실패";
				request.getSession().setAttribute("msg", msg1);
				
				response.sendRedirect("QnaList");

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 삭제", e);
			}
			}else {
				response.sendRedirect(contextPath);
			}

		} else if (command.equals("/AdminNotice/qnaDeletenotireg")) {
			if(loginMember != null) {
			request.setCharacterEncoding("UTF-8");
			String noList = request.getParameter("noList"); // 선택된 행번호
			try {
				int result = new NoticeService().deleteChNotice(noList);

				String msg1 = null;
				if (result > 0)
					msg1 = "공지사항 게시 성공";
				else
					msg1 = "공지사항 게시 실패";
				request.getSession().setAttribute("msg", msg1);
				response.sendRedirect("QnaList");

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "회원 목록 조회", e);
			}
			}else {
				response.sendRedirect(contextPath);
			}

		} else if (command.equals("/memberList")) {
			if(loginMember != null) {
				try {
					List<AdminMember> list = memberService.selectList();
	
					request.setAttribute("memberList", list);
					
					path = "/WEB-INF/views/admin/AdminMember/adminMember.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "회원 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}
		} else if (command.equals("/memberDetail")) {
			if(loginMember != null) {
				request.setCharacterEncoding("UTF-8");
				
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				
				
				try {
					AdminMember selectMember = new MemberService().selectMember(memNo);
					
					if (selectMember != null) {
						System.out.println("회원상세 서블릿" + selectMember);
						
						//선택한 멤버가지고 왔으면
						selectMember.setFlag(1);
						
						request.setAttribute("selectMember", selectMember);
						view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminMember/adminMemberDetail.jsp");
						view.forward(request, response);
						
					} else {
						request.getSession().setAttribute("msg", "회원 상세조회 오류");
						response.sendRedirect("adminMember");
					}
					
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "회원 상세조회", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
		} 
		else if (command.equals("/Ystatus")) {
			if(loginMember != null) {
				int no = Integer.parseInt(request.getParameter("no"));
				
				try {
					int result = memberService.statusUpdate(no);
					System.out.println(result);
					
					String msg1 = null;
					
					if (result > 0)
						msg1 = "회원 활동 수정 성공";
					else
						msg1 = "회원 활동 수정 실패";
		
					request.getSession().setAttribute("msg", msg1);
					response.sendRedirect("memberList");
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "회원 활동 수정", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
			
		}
		else if (command.equals("/Nstatus")) {
			if(loginMember != null) {
				int no = Integer.parseInt(request.getParameter("no"));
				System.out.println(no);
				try {
					int result = memberService.statusUpdateN(no);
					
					String msg1 = null;
					
					if (result > 0)
						msg1 = "회원 활동 수정 성공";
					else
						msg1 = "회원 활동 수정 실패";
					
					request.getSession().setAttribute("msg", msg1);
					response.sendRedirect("memberList");
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "회원 활동 수정", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
			
		}
		else if (command.equals("/grade")) {
			if(loginMember != null) {
				char grade = ((String)request.getParameter("grade")).charAt(0);
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				
				System.out.println(grade);
				
				
				try {
					int result = memberService.gradeUpdate(grade, memNo);
					
					String msg1 = null;
					
					if (result > 0)
						msg1 = "회원 등급 수정 성공";
					else
						msg1 = "회원 등급 수정 실패";
					
					request.getSession().setAttribute("msg", msg1);
					response.sendRedirect("memberList");
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "회원 등급 수정", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
		}
		else if (command.equals("/grade")) {
			if(loginMember != null) {
				char grade = ((String)request.getParameter("grade")).charAt(0);
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				
				System.out.println(grade);
				
				
				try {
					int result = memberService.gradeUpdate(grade, memNo);
					
					String msg1 = null;
					
					if (result > 0)
						msg1 = "회원 등급 수정 성공";
					else
						msg1 = "회원 등급 수정 실패";
					
					request.getSession().setAttribute("msg", msg1);
					response.sendRedirect("memberList");
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "회원 등급 수정", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
			
		}
		else if(command.equals("AjaxSelectList.do")) {
			if(loginMember != null) {
				String catrgory1Code = (String)request.getParameter("input");
				
				List<Project> list = new ArrayList<Project>();
				
				try { // project list 가져오는 거 
					list = new ProjectService().selectProject();
					
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "프로젝트 조회", e);
				}
				
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(list, response.getWriter());
				
			}else {
				response.sendRedirect(contextPath);
			}
		}
		else if (command.equals("/AdminReport/ReportList")) {
			if(loginMember != null) {
				try {
					List<ReportAll> list = reportService.selectReportList();
					// list에 공지사항, 자주묻는 질문 같이있음
					request.setAttribute("RreviewList", list);
					path = "/WEB-INF/views/admin/AdminReport/ReportList.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "신고게시판 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}

		}
		else if (command.equals("/AdminReport/reportDetail")) {
			if(loginMember != null) {
				try {
					ReportAll list = reportService.selectRreviewDetail();
					// list에 공지사항, 자주묻는 질문 같이있음
					request.setAttribute("ReviewDetail", list);
					path = "/WEB-INF/views/admin/AdminReport/ReportDetail.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "신고게시판 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}

		}
		else if (command.equals("/plist")) {
			if(loginMember != null) {
				System.out.println("실행 테스트");
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				String rePath = "";
				try {
					
					List<Project> plist = projectService.selectpList(memNo);
					// list에 공지사항, 자주묻는 질문 같이있음
					
					request.setAttribute("plist", plist);
					
					
					new Gson().toJson(plist, response.getWriter());
					
					//path = "/WEB-INF/views/admin/AdminMember/adminMemberDetail.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "해당 멤버의 프로젝트 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} 
			}else {
				response.sendRedirect(contextPath);
			}


		} else if (command.equals("/clist")) {
			if(loginMember != null) {
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				String rePath = "";
				try {
					
					List<Reply> clist = replyService.selectRList(memNo);
					// list에 공지사항, 자주묻는 질문 같이있음
					
					request.setAttribute("clist", clist);
					
					new Gson().toJson(clist, response.getWriter());
					
					//path = "/WEB-INF/views/admin/AdminMember/adminMemberDetail.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "해당 멤버의 프로젝트 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} 
			}else {
				response.sendRedirect(contextPath);
			}
		}
		
		else if (command.equals("/rlist")) {
			if(loginMember != null) {
				System.out.println("리뷰 실행 테스트");
				
				int memNo = Integer.parseInt(request.getParameter("memNo"));
				try {
					
					List<Review> rlist = reviewService.selecRvList(memNo);
					// list에 공지사항, 자주묻는 질문 같이있음
					
					request.setAttribute("rlist", rlist);
					
					
					new Gson().toJson(rlist, response.getWriter());
					
					//path = "/WEB-INF/views/admin/AdminMember/adminMemberDetail.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "해당 멤버의 프로젝트 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} 
			}else {
				response.sendRedirect(contextPath);
			}

		} 
		
		else if (command.equals("/AdminCategory/categoryManage")) {
			if(loginMember != null) {
				path = "/WEB-INF/views/admin/AdminCategory/adminCategory.jsp";
				try {
					List<Category1> category1List = new MemberService().getCategory1List();
					System.out.println(category1List);
					List<Category2> category2List = new MemberService().getCategory2List();
					System.out.println(category2List);
					
					request.setAttribute("category1List",category1List);
					request.setAttribute("category2List",category2List);
					request.setAttribute("category1Code","1");
				}catch (Exception e) {
					request.setAttribute("errormsg", "해당 멤버의 카테고리 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} 
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}else {
				response.sendRedirect(contextPath);
			}
		}
		else if (command.equals("/AdminNotice/NoticeList")) {
			if(loginMember != null) {
				try {
					List<Notice> list = noticeService.selectList();
					// list에 공지사항, 자주묻는 질문 같이있음
					request.setAttribute("noticeList", list);
					path = "/WEB-INF/views/admin/AdminNotice/NoticeList.jsp";
				} catch (Exception e) {
					request.setAttribute("errormsg", "공지사항 목록 조회 과정에서 오류가 발생하였습니다.");
					path = "/WEB-INF/views/common/errorPage.jsp";
					e.printStackTrace();
				} finally {
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			}else {
				response.sendRedirect(contextPath);
			}

		} else if (command.equals("/AdminReport/detail")) {
			if(loginMember != null) {
				request.setCharacterEncoding("UTF-8");
	
				int no = Integer.parseInt(request.getParameter("no"));
	
				try {
					Notice notice = new SummerNoteService().selectNotice(no);
	
					if (notice != null) {
						System.out.println("상세조회 서블릿" + notice);
						request.setAttribute("notice", notice);
						view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminNotice/NoticeDetail.jsp");
						view.forward(request, response);
	
					} else {
						request.getSession().setAttribute("msg", "공지사항 상세조회 오류");
						response.sendRedirect("NoticeList");
					}
	
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "공지사항 상세 조회", e);
				}
			}else {
				response.sendRedirect(contextPath);
			}
		}
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
