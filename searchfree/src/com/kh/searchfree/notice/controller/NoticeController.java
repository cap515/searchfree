package com.kh.searchfree.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.searchfree.board.model.vo.Attachment;
import com.kh.searchfree.board.model.vo.PageInfo;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.notice.model.service.NoticeService;
import com.kh.searchfree.notice.model.vo.Notice;

// 클라이언트의 요청 중 /notice디렉토리 하위로 요청 시 
// 해당 서블릿(controller)으로 집중을 시킴
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Front Controller
		// - 클라이언트의 요청을 한 곳으로 집중시켜서
		// 개발 및 유지보수의 효율성을 증가시키는 패턴

		// - 요청에 따른 servlet을 따로 생성하지 않고
		// 오직하나의 Servlet에서 제어함.

		String uri = request.getRequestURI();

		// System.out.println("uri : "+ uri);

		String contextPath = request.getContextPath();
		// System.out.println("contextPath" + contextPath);

		String command = uri.substring((contextPath + "/notice").length());
//		substring : 잘라내고 나머지를 저장

		String path = null;
		RequestDispatcher view = null;
		String msg = null;

		NoticeService noticeService = new NoticeService();

		// 요청 주소가 /list(공지사항 목록조회 )인 경우
		if (command.equals("/list1")) {
			// command : 요청 주소 맨 마지막
			
			int code = 1;
			
			try {

				// 현재 게시글 전체수
				int listCount = noticeService.getListCount();

				// 한 페이지에 보여질 게시글의 수
				int limit = 20;
				// 보여질 페이징바의 개수
				int pageingBarSize = 1;

				// 현재 패이지 변호를 표시할 변수
				int currentPage = 0;
				// 현재 페이지 변수를 표기하기 위해선 request정보를 얻어와야 하지만
				// service 영역은 순수 자바만 이용하는 것이 가장 이상적

				// 전체 페이지의 수 == 마지막 페이지
				int maxPage = 0;

				// 페이징바 시작 페이지번호
				int startPage = 0;

				// 페이징바 끝 번호
				int endPage = 0;

				// currentPage >> 현재 페이지 번호를 표시할 변수
				// 처음 게시판 목록으로 화면이 전환이 되면 1page가 보여야 함
				if (request.getParameter("currentPage") == null) {
					// currentPage 값이 비어있다면 처음접속하게 된 경우
					currentPage = 1;

				} else {
					// 전달받은 값이 있을경우 해당 받은 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}

				// maxPage - 총페이지의 수 , 마지막 페이지
				// limit == 5일경우
				// 현재 게시글이 개수가 50개일 경우 필요페이지 수 : 5
				// max페이지 도출식
				maxPage = (int) Math.ceil(((double) listCount / limit));

				// startPage = 페이징아의 시작페이지 변환
				// 페이징바에 수가 10개씩 보여줄경우
				// 시작번호는 1,11,21,31,...
				startPage = (currentPage - 1) / pageingBarSize * pageingBarSize + 1;

				// endPage =페이징바 끝 페이지 번호
				endPage = startPage + pageingBarSize - 1;
				if (maxPage <= endPage) {
					endPage = maxPage;
				}

				PageInfo pInf = new PageInfo(listCount, limit, pageingBarSize, currentPage, maxPage, startPage,
						endPage);

				List<Notice> nList = new NoticeService().selectListPage(currentPage, limit, code);

				
					path = "/WEB-INF/views/notice/noticeList1.jsp";
					request.setAttribute("nList", nList);
					request.setAttribute("pInf", pInf);
				
				

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항게시판조회", e);

			} finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}

		} else if (command.equals("/list2")) {

			
			int code= 2;
			
			try {

				// 현재 게시글 전체수
				int listCount = noticeService.getListCount();

				// 한 페이지에 보여질 게시글의 수
				int limit = 20;
				// 보여질 페이징바의 개수
				int pageingBarSize = 5;

				// 현재 패이지 변호를 표시할 변수
				int currentPage = 0;
				// 현재 페이지 변수를 표기하기 위해선 request정보를 얻어와야 하지만
				// service 영역은 순수 자바만 이용하는 것이 가장 이상적

				// 전체 페이지의 수 == 마지막 페이지
				int maxPage = 0;

				// 페이징바 시작 페이지번호
				int startPage = 0;

				// 페이징바 끝 번호
				int endPage = 0;

				// currentPage >> 현재 페이지 번호를 표시할 변수
				// 처음 게시판 목록으로 화면이 전환이 되면 1page가 보여야 함
				if (request.getParameter("currentPage") == null) {
					// currentPage 값이 비어있다면 처음접속하게 된 경우
					currentPage = 1;

				} else {
					// 전달받은 값이 있을경우 해당 받은 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}

				// maxPage - 총페이지의 수 , 마지막 페이지
				// limit == 5일경우
				// 현재 게시글이 개수가 50개일 경우 필요페이지 수 : 5
				// max페이지 도출식
				maxPage = (int) Math.ceil(((double) listCount / limit));

				// startPage = 페이징아의 시작페이지 변환
				// 페이징바에 수가 10개씩 보여줄경우
				// 시작번호는 1,11,21,31,...
				startPage = (currentPage - 1) / pageingBarSize * pageingBarSize + 1;

				// endPage =페이징바 끝 페이지 번호
				endPage = startPage + pageingBarSize - 1;
				if (maxPage <= endPage) {
					endPage = maxPage;
				}

				PageInfo pInf = new PageInfo(listCount, limit, pageingBarSize, currentPage, maxPage, startPage,
						endPage);

				List<Notice> nList = new NoticeService().selectListPage(currentPage, limit, code);

				
					
					path = "/WEB-INF/views/notice/noticeList2.jsp";
					request.setAttribute("nList", nList);
					request.setAttribute("pInf", pInf);
				

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항게시판조회", e);

			} finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}

		} else if (command.equals("/list3")) {

			try {
					path = "/WEB-INF/views/notice/noticeList3.jsp";
					
					
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항게시판조회", e);

			} finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
		}
		// 공지사항 상세 조회
		else if (command.equals("/detail")) {
			try {
				int no = Integer.parseInt(request.getParameter("no"));
				Notice notice = noticeService.selectNotice(no);

				if (notice != null) {// 상세조회 성공
					path = "/WEB-INF/views/notice/noticeDetail2.jsp";
					request.setAttribute("notice", notice);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("msg", "공지사항 상세조회 실패했습니다.");
					response.sendRedirect("list");
				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 상세 조회", e);
			}
		}

		// 공지사항 등록 화면 Controller
		else if (command.equals("/insertForm")) {
			path = "/WEB-INF/views/notice/noticeInsert.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}

		// 공지사항 등록 (글쓰기) Controller
		else if (command.equals("/insert")) {
			// 글제목, 글내용, 작성자,
			// 작성자 얻어오기
			HttpSession session = request.getSession();
			Member loginmember = (Member) session.getAttribute("loginMember");
			String noticeWriter = loginmember.getMemberId();

			String noticeTitle = request.getParameter("title");
			String noticeContent = request.getParameter("content");

			Notice notice = new Notice();

			try {
				// 1) 입력된 notice를 DB에 저장
				int result = noticeService.insertNotice(notice);

				// 2) DB 저장 결과에 따라 트랜잭션 처리

				// 3) DB 저장 성공 시 : "공지사항이 등록되었습니다."
				// -> 작성한 공지글 상세조회 페이지로 redirect

				if (result > 0) {
					msg = "공지사항 등록에 성공했습니다.";
					path = "detail?no=" + result;
				} else {
					// 4) DB 저장 실패 시 : "공지사항 등록 실패 "
					// -> 공지사항 목록 조회로 redirect
					msg = "공지사항 등록에 실패했습니다.";
					path = "list";
				}
				session.setAttribute("msg", msg);
				response.sendRedirect(path);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 등록", e);
			}
		}

		// 공지사항 수정화면 Controller
		else if (command.equals("/updateForm")) {
			// DB에서 해당 글을 조회하여 화면으로 전달
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				Notice notice = noticeService.updateForm(no);
				if (notice != null) {
					path = "/WEB-INF/views/notice/noticeUpdate.jsp";
					request.setAttribute("notice", notice);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("msg", "공지사항 수정 화면 출력 실패");
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 수정 화면으로 전환하는 과정에서 오류 발생", e);
			}
		}

		// 공지사항 수정 Controller
		else if (command.equals("/update")) {
			int noticeNo = Integer.parseInt(request.getParameter("no"));
			String noticeTitle = request.getParameter("title");
			String noticeContent = request.getParameter("content");

			Notice notice = new Notice();

			try {
				int result = noticeService.updateNotice(notice);

				if (result > 0)
					msg = "공지사항이 수정되었습니다.";
				else
					msg = "공지사항 수정 실패";

				request.getSession().setAttribute("mag", msg);
				response.sendRedirect("detail?no=" + noticeNo);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 수정하는 과정에서 오류 발생", e);
			}
		}
		// 공지사항 삭제 Controller
		else if (command.equals("/delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				int result = noticeService.deleteNotice(no);
				if (result > 0) {
					msg = "공지사항이 삭제되었습니다.";
					path = "list";
				} else {
					msg = "공지사항 삭제 실패";
					path = "detail?no=" + no;
				}

				request.getSession().setAttribute("msg", msg);
				response.sendRedirect(path);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 삭제 과정에서 오류 발생", e);
			}
		}

		// 공지사항 검색용 Controller
		else if (command.equals("/search")) {
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");

			try {
				List<Notice> list = noticeService.searchNotice(searchKey, searchValue);

				path = "/WEB-INF/views/notice/noticeList.jsp";
				request.setAttribute("list", list);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "공지사항 검색", e);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
