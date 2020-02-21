package com.kh.searchfree.message.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.searchfree.board.model.vo.PageInfo;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.message.model.service.MessageService;
import com.kh.searchfree.message.model.vo.Message;

@WebServlet("/message/*")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		// System.out.println("uri : "+ uri);

		String contextPath = request.getContextPath();
		// System.out.println("contextPath" + contextPath);

		String command = uri.substring((contextPath + "/message").length());
		// substring : 잘라내고 나머지를 저장

		String path = null;
		RequestDispatcher view = null;
		String msg = null;

		Member member = (Member) request.getSession().getAttribute("loginMember");
		MessageService messageService = new MessageService();

		if (command.equals("/list")) {

			try {
				int mNumber = member.getMemberNo();

				int listCount = messageService.getListCount(mNumber);

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

				List<Message> mList = new MessageService().selectListPage(currentPage, limit, mNumber);

				path = "/WEB-INF/views/message/messageList.jsp";
				request.setAttribute("mList", mList);
				request.setAttribute("pInf", pInf);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "쪽지게시판조회", e);
			} finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

		} else if (command.equals("/detail")) {

			try {

				int msgNo = Integer.parseInt(request.getParameter("no"));

				System.out.println("msgNo :" + msgNo);

				Message msgDetail = messageService.selectMessage(msgNo);

				if (msgDetail != null) {// 상세조회 성공
					path = "/WEB-INF/views/message/messageDetail.jsp";
					request.setAttribute("message", msgDetail);

				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "쪽지게시판조회", e);
			} finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

		} else if (command.equals("/send")) {

			try {

				String react = "";

				List<String> seNick = new ArrayList<String>();

				String msgTitle = request.getParameter("title");

				String content = request.getParameter("msgcont");

				String receiverNicks = request.getParameter("whos");
				
				int senderNo = member.getMemberNo();

				if(receiverNicks.contains(",")) {
					
					String[] arr = receiverNicks.split(",");

					for (int i = 0; i < arr.length; i++) {
						if (arr[i].trim().length() != 0) {
							seNick.add(arr[i].trim());
						}
					}
				}else {
					seNick.add(receiverNicks);
				}
				

				int[] receiverNo = messageService.selectNick(seNick);
				
				System.out.println("controller :" + receiverNo);

				int result[] = messageService.sendMsg(msgTitle, content, receiverNo, senderNo);

				request.setAttribute("seNick", seNick);

				for (int i = 0; i < result.length; i++) {

					if (result[i] > 0) {
						msg = "메세지 전송 성공";
						path = "list";
					} else {
						msg = "메세지 전송 실패";
						path = "WriteForm";
					}
				}
				
				

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "쪽지전송", e);
			}finally {
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			

		} else if (command.equals("/delete")) {

			try {

				String msgNo = request.getParameter("no");

				String[] arr = msgNo.split(",");

				List<String> seNo = new ArrayList<String>();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].trim().length() != 0) {
						seNo.add(arr[i].trim());
					}
				}

				int result = messageService.deleteMsg(seNo);

				String react = "";

				System.out.println("result" + result);

				if (result > 0) {
					react = "메세지 삭제 성공";
					path = "list";
				} else {
					react = "메세지 삭제 실패";
					path = "detail?no=" + msgNo;
				}

				request.getSession().setAttribute("msg", react);
				response.sendRedirect(path);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "쪽지삭제", e);
			}

		} else if (command.equals("/WriteForm")) {

			try {
				
				List<String> seNick = new ArrayList<String>();

				String receiverNicks = request.getParameter("name");
				
				int senderNo = member.getMemberNo();

				if(receiverNicks.contains(",")) {
					
					String[] arr = receiverNicks.split(",");

					for (int i = 0; i < arr.length; i++) {
						if (arr[i].trim().length() != 0) {
							seNick.add(arr[i].trim());
						}
					}
				}else {
					seNick.add(receiverNicks);
				}

				System.out.println(seNick);

				request.setAttribute("seNick", seNick);

				path = "/WEB-INF/views/message/messageWriteForm.jsp";

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "쪽지페이지", e);
			} finally {

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
