package com.kh.searchfree.member.controller;

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

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.common.MyFileRenamePolicy;
import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.member.model.vo.MyProject;
import com.kh.searchfree.member.model.vo.Portfolio;
import com.kh.searchfree.member.model.vo.ProfileResource;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/member/*")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/member").length());

		String msg = null;
		String path = null;
		RequestDispatcher view = null;

		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");

		// System.out.println("login first " + loginMember);

		if (loginMember != null) {

			if (command.equals("/mypage")) {
				// 마이페이지 첫 화면 == 회원정보

				try {
					// 완료된 프로젝트 수
					int memberNo = loginMember.getMemberNo();

					int completeProject = new MemberService().completeProject(memberNo);
					request.setAttribute("completeProject", completeProject);

					// 진행중인 프로젝트 수
					int goingProject = new MemberService().goingProject(memberNo);
					request.setAttribute("goingProject", goingProject);

					// 새로운 쪽지
					int messageCount = new MemberService().messageCount(memberNo);
					request.setAttribute("messageCount", messageCount);

					// 받은 리뷰
					int reviewCount = new MemberService().reviewCount(memberNo);
					request.setAttribute("reviewCount", reviewCount);

					// 평균 별점
					int avgSrating = new MemberService().avgSrating(memberNo);
					request.setAttribute("avgSrating", avgSrating);

					// 프로젝트 완료울
					int countProject = new MemberService().countProject(memberNo);
					double percentProject = ((double) completeProject / countProject) * 100;
					/*
					 * if (percentProject!=0) { request.setAttribute("percentProject",
					 * percentProject); }else if ((Double.isNaN(percentProject))){ String
					 * spercentProject = "0"; request.setAttribute("percentProject",
					 * spercentProject); }
					 */
					if (percentProject != 0) {
						request.setAttribute("percentProject", percentProject);
					} else {
						request.setAttribute("percentProject", 0.0);
					}

					// 마감일이 안지난 프로젝트 리스트 담고있는 리스트
					List<MyProject> projectSchedule = new MemberService().projectSchedule(memberNo);
					request.setAttribute("projectSchedule", projectSchedule);
					System.out.println("일정 : " + projectSchedule);

					path = "/WEB-INF/views/member/mypage.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);

					System.out.println("완료된 프로젝트 수 : " + completeProject);
					System.out.println("진행 중 프로젝트 수 : " + goingProject);
					System.out.println("쪽지 갯수 : " + messageCount);
					System.out.println("등록된 리뷰 : " + reviewCount);
					System.out.println("평균 별점 : " + avgSrating);
					System.out.println("등록한 프로젝트 수 : " + countProject);
					System.out.println("완료율 : " + percentProject);
					// System.out.println(((double)completeProject/countProject)*100);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (command.equals("/mypage-update")) {
				// 업데이트 뷰
				// 마이페이지 회원정보 수정

				try {

					request.setAttribute("memberId", loginMember.getMemberId());
					request.setAttribute("memberPwd", loginMember.getMemberPwd());
					request.setAttribute("memberNm", loginMember.getMemberNm());
					request.setAttribute("memberPwd", loginMember.getMemberPwd());
					request.setAttribute("memberNick", loginMember.getMemberNick());
					request.setAttribute("memberPhone", loginMember.getMemberPhone());
					request.setAttribute("memberEmail", loginMember.getMemberEmail());
					request.setAttribute("memberAddr", loginMember.getMemberAddr());
					request.setAttribute("category1CodeInt", loginMember.getCategory1Code());
					request.setAttribute("category2CodeInt", loginMember.getCategory2Code());
					request.setAttribute("memberAccount", loginMember.getMemberAccount());

					List<Category1> category1List = new MemberService().getCategory1List();
					System.out.println(category1List);
					List<Category2> category2List = new MemberService().getCategory2List();
					System.out.println(category2List);
					request.setAttribute("category1List", category1List);
					request.setAttribute("category2List", category2List);
					request.setAttribute("category1Code", "1");

				} catch (Exception e) {
					e.printStackTrace();
				}
				path = "/WEB-INF/views/member/mypage-update.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			else if (command.equals("/updateMember")) {
				// 업데이트를 수행하는 서블릿
				String memberNick = request.getParameter("inputNick");
				String memberEmail = request.getParameter("inputEmail");

				// 사용자가 입력한 새 비밀번호
				String memberPwd = request.getParameter("inputPwd");

				String memberPhone = request.getParameter("inputPhone");
				String memberAddr = request.getParameter("inputAddr1") + "," + request.getParameter("inputAddr2");
				int category1Code = Integer.parseInt(request.getParameter("inputCategory1"));
				int category2Code = Integer.parseInt(request.getParameter("inputCategory2"));

				String memberId = loginMember.getMemberId();
				System.out.println("update login = " + loginMember);

				Member updateMember = new Member(memberPwd, memberNick, memberPhone, memberEmail, memberAddr,
						category1Code, category2Code);
				updateMember.setMemberNo(loginMember.getMemberNo());
				try {

					int result = new MemberService().updateMember(updateMember, memberId, memberPwd);

					if (result > 0) {
						System.out.println("수정 성공");
						request.setAttribute("msg", "회원 정보 수정이 정상적으로 처리되었습니다.");
						path = request.getHeader("REFERER");

					} else {
						System.out.println("수정 실패");
						request.setAttribute("msg", "수정 실패, 비밀번호를 재확인 하세요.");
						path = request.getHeader("REFERER");
					}

					response.sendRedirect(path);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (command.equals("/mypage-delete")) {
				// 마이페이지 회원 탈퇴 뷰
				path = "/WEB-INF/views/member/mypage-delete.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			} else if (command.equals("/deleteMember")) {
				// 마이페이지 회원 탈퇴 처리

				String inputPwd = request.getParameter("inputPwd");
				String memberId = loginMember.getMemberId();
				System.out.println("파라미터 inputPwd : " + inputPwd);

				try {
					int result = new MemberService().deleteMember(inputPwd, memberId);

					if (result > 0) {
						request.getSession().invalidate();
						System.out.println("회원탈퇴 성공");
						request.setAttribute("msg", "회원 탈퇴가 정상적으로 처리되었습니다.");
						path = request.getContextPath();

					} else {
						System.out.println("회원탈퇴 실패");
						request.setAttribute("msg", "회원 탈퇴 실패, 비밀번호를 재확인 하세요.");
						path = "mypage-delete.do";
					}

					response.sendRedirect(path);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (command.equals("/mypage-profile")) {
				// 마이페이지 회원정보 프로필 뷰
				try {
					// Member selectMember = new MemberService().selectMember();

					// 닉네임
					request.setAttribute("memberNick", loginMember.getMemberNick());

					// 프로젝트 리스트 가져오기
					List<MyProject> projectList1 = new MemberService().selectProject1(loginMember.getMemberNo());
					List<MyProject> projectList2 = new MemberService().selectProject2(loginMember.getMemberNo());
					System.out.println("프로젝트 리스트" + projectList1);
					request.setAttribute("projectList1", projectList1);
					request.setAttribute("projectList2", projectList2);
					System.out.println("리스트출력 : " + projectList1);

					// 등록한 프로필 사진 select해서 가져오기
					List<ProfileResource> files = new MemberService().selectFiles(loginMember.getMemberNo());

					if (!files.isEmpty()) {
						request.getSession().setAttribute("files", files);
						System.out.println("셀렉트한 파일의 0번 인덱스 :" + files.get(0));
					}

					// 포트폴리오 보여주기
					int memberNo = loginMember.getMemberNo();
					Portfolio portfolio = null;
					portfolio = new MemberService().getPortfolio(memberNo);

					// 등록된 포트폴리오가 있으면 보여줌
					if (portfolio != null) {
						String selectTitle = portfolio.getPortfolioTitle();
						String selectContent = portfolio.getPortfolioContent();
						
						System.out.println("조회 1:" + selectTitle);
						System.out.println("조회 2:" + selectContent);
						
						request.setAttribute("selectTitle", selectTitle);
						request.setAttribute("selectContent", selectContent);
					}
					else {
						request.setAttribute("selectTitle", "등록된 포트폴리오가 없습니다.");
						request.setAttribute("selectContent", " ");
					}

					path = "/WEB-INF/views/member/mypage-profile.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// 프로필 이미지 등록용 Controller
			else if (command.equals("/insert")) {
				try {
					if (ServletFileUpload.isMultipartContent(request)) {
						int maxSize = 10 * 1024 * 1024;
						String root = request.getSession().getServletContext().getRealPath("/");
						String savePath = root + "resources/uploadImages/";
						MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
								new MyFileRenamePolicy());
						ArrayList<String> saveFiles = new ArrayList<String>();
						ArrayList<String> originFiles = new ArrayList<String>();
						Enumeration<String> files = multiRequest.getFileNames();

						while (files.hasMoreElements()) {
							String name = files.nextElement();
							if (multiRequest.getFilesystemName(name) != null) {
								saveFiles.add(multiRequest.getFilesystemName(name));
								originFiles.add(multiRequest.getOriginalFileName(name));
							}
						}
						int memberNo = loginMember.getMemberNo();

						ProfileResource file = new ProfileResource();
						for (int i = originFiles.size() - 1; i >= 0; i--) {
							file = new ProfileResource(); // 파일정보 저장
							file.setProfileResourcePath(savePath); // 경로
							file.setFileOriginName(originFiles.get(i));
							file.setFileChangeName(saveFiles.get(i));
							/*
							 * if( (i == originFiles.size()-1) && multiRequest.getFilesystemName("img1")
							 * !=null ) { //마지막 인덱스를 0으로 하겠다?? file.setFileLevel(0); }else {
							 * file.setFileLevel(1); }
							 */
						}

						int result = new MemberService().insertProfile(memberNo, file);

						// 트랜잭션 처리결과에 따라
						if (result > 0)
							msg = "이미지 등록 성공";
						else
							msg = "이미지 등록 실패";

						request.getSession().setAttribute("msg", msg);
						path = request.getHeader("REFERER");
						response.sendRedirect(path);
						// 이미지 등록후 프로필페이지 그대로 유지
						// - >등록한 이미지를 영역에 보여주기 ?

					}
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "게시글 등록", e);
				}

			}

			// 프로필사진 수정동작
			else if (command.equals("/mypage-update")) {
				try {
					if (ServletFileUpload.isMultipartContent(request)) {

						int maxSize = 10 * 1024 * 1024;
						String root = request.getSession().getServletContext().getRealPath("/");
						String savePath = root + "resources/uploadImages/";

						MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
								new MyFileRenamePolicy());

						ArrayList<String> saveFiles = new ArrayList<String>();
						ArrayList<String> originFiles = new ArrayList<String>();

						Enumeration<String> files = multiRequest.getFileNames();

						while (files.hasMoreElements()) {
							String name = files.nextElement();

							if (multiRequest.getFilesystemName(name) != null) {
								saveFiles.add(multiRequest.getFilesystemName(name));
								originFiles.add(multiRequest.getOriginalFileName(name));
							}
						}
						int memberNo = loginMember.getMemberNo();

						ProfileResource file = new ProfileResource();

						for (int i = saveFiles.size() - 1; i >= 0; i--) {
							file = new ProfileResource(); // 파일정보 저장
							file.setProfileResourcePath(savePath); // 경로
							file.setFileOriginName(originFiles.get(i));
							file.setFileChangeName(saveFiles.get(i));
						}

						int result = new MemberService().updateProfile(memberNo, file);

						if (result > 0) {
							path = "/WEB-INF/views/member/mypage-profile.jsp";
							view = request.getRequestDispatcher(path);
							view.forward(request, response);
						}
						else {
						path = request.getHeader("REFERER");
						response.sendRedirect(path);
						// 이미지 등록후 프로필페이지 그대로 유지
						// - >등록한 이미지를 영역에 보여주기 ?
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (command.equals("/mypage-summernote")) {
				// 포트폴리오 - 썸머노트있는 페이지로 연결
				
				 // try { int memberNo = loginMember.getMemberNo();
				
				//  Portfolio portfolio = new MemberService().getPortfolio(memberNo);
				 
				  path = "/WEB-INF/views/member/mypage-summernote.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				//  }
			//	 catch(Exception e) {
			//		 e.printStackTrace(); 
			//	 }
			}


			 // 썸머노트 - 포트폴리오 입력 
//			else if (command.equals("/insertPortpolio")) {
//			  System.out.println("insertPortfolio");
//			
//			  int memberNo = loginMember.getMemberNo(); String content =
//			  request.getParameter("content"); String subject =
//			  request.getParameter("subject");
//			  
//			  System.out.println("멤버 : " + memberNo); System.out.println("포트폴리오에 입력한 컨텐트" +
//			  content); System.out.println("제목:" + subject);
//			  
//			  Portfolio portfolio = new Portfolio(memberNo, subject, content);
//			  System.out.println(portfolio); try { int result = new
//			  MemberService().insertPortfolio(portfolio); if (result > 0) {
//			  System.out.println("삽입성공"); //response.sendRedirect("mypage-profile"); path =
//			  "/WEB-INF/views/member/mypage-profile.jsp"; response.sendRedirect(path);
//			  
//			  } 
//			  else { System.out.println("삽입실패"); path = request.getHeader("REFERER");
//			  response.sendRedirect(path); }
//			  
//			  } catch (Exception e) { e.printStackTrace();
//			  response.sendRedirect("mypage-profile"); } }
//			 

			else if (command.equals("/deletePortfolio")) {
				System.out.println("deletePortfolio");
				// 포트폴리오 삭제 동작
				int memberNo = loginMember.getMemberNo();
				try {
					int result = new MemberService().deletePortfolio(memberNo);
					
					if (result == 0) {
						System.out.println("포트폴리오 삭제 완료");
//						path = request.getContextPath();
//						response.sendRedirect(path);
						path = "/WEB-INF/views/member/mypage-profile.jsp";
						view = request.getRequestDispatcher(path);
						view.forward(request, response);

					} else {
						System.out.println("삭제실패");
						path = request.getHeader("REFERER");
						response.sendRedirect(path);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			else if (command.equals("/updatePortfolio")) {
				System.out.println("updatePortfolio");
				// 포트폴리오 수정 동작(인서트 )
				int memberNo = loginMember.getMemberNo();
				String content = request.getParameter("content");
				String subject = request.getParameter("subject");
				Portfolio portfolio = new Portfolio(memberNo, subject, content);
				try {
					int result = new MemberService().updatePortfolio(portfolio);

					if (result > 0) {
						System.out.println("포트폴리오 수정 완료");
//						path = "/WEB-INF/views/member/mypage-profile.jsp";
						path = "mypage-profile";
						view = request.getRequestDispatcher(path);
						view.forward(request, response);
					} else {
						System.out.println("수정 실패");
						path = "mypage-profile";
						response.sendRedirect(path);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
		}else {
			// 로그아웃 하고 화면 전환
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
