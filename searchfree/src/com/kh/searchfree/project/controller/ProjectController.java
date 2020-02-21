package com.kh.searchfree.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.searchfree.project.model.service.ProjectService;
import com.kh.searchfree.project.model.vo.MemberStar;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.project.model.vo.ProjectApply;
import com.kh.searchfree.project.model.vo.ProjectRead;
import com.kh.searchfree.project.model.vo.ProjectResource;
import com.kh.searchfree.project.model.vo.Reply;
import com.kh.searchfree.project.model.vo.ReplyRead;
import com.kh.searchfree.project.model.vo.Review;
import com.kh.searchfree.project.model.vo.ReviewRead;
import com.kh.searchfree.project.model.vo.VProjectApply;
import com.oreilly.servlet.MultipartRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;

import com.kh.searchfree.common.MyFileRenamePolicy;
import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.member.model.vo.Member;

@WebServlet("/project/*")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/project").length());

		String path = null;
		RequestDispatcher view = null;
		String msg = null;

		ProjectService projectService = new ProjectService();

		// 프로젝트 상세 조회 : projectNo를 받아와서 그에 맞는 프로젝트 상세조회 가능하도록
		if (command.equals("/detail")) {
			System.out.println("디테일 시작");

			int projectNo = Integer.parseInt(request.getParameter("no"));
			// int projectNo = 30;

			try {

				ProjectRead projectRead = projectService.selectProject(projectNo);

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");

				int already = 0;

				if (loginMember != null) {

					int memberNo = loginMember.getMemberNo();

					// 값이 1이면 지원자 있는 것
					int result = projectService.checkApply(memberNo, projectNo);
					if (result == 1) {
						already = 1;
					}
				}

				// 프로젝트를 올린 멤버의 별점을 가져오는 부분
				int pMemberStar = projectService.pMemberStar(projectNo);

				// 프로젝트 썸네일 가져오는 부분
				if (projectRead != null) {
					List<ProjectResource> files = projectService.selectFiles(projectNo);

					if (!files.isEmpty()) {
						request.setAttribute("files", files);
					}

					// 댓글 읽어오는 부분
					List<ReplyRead> rList = projectService.selectReplyList(projectNo);

					if (!rList.isEmpty()) {
						request.setAttribute("rList", rList);
					}
					// 리뷰 읽어오는 부분
					List<ReviewRead> reviewList = projectService.selectReviewList(projectNo);

					if (!reviewList.isEmpty()) {
						request.setAttribute("reviewList", reviewList);
					}

					// 프로젝트상세조회로 넘어가야되는데 projectRead_Buy/ projectRead_Sell이 따로있음
					// 프로젝트 번호별로 결제하기/지원하기를 따로 보여줘야됨
					// 그러면 if로 project_alt를 따져줘야함

					if (projectRead.getProjectAlt() == 1) { // project_alt가 1이면 판매
						// 결제하기 project_alt=1,판매
						path = "/WEB-INF/views/project/projectRead_Buy.jsp";
					} else {// project_alt가 2이면 지원
						// 지원하기 project_Alt = 2
						path = "/WEB-INF/views/project/projectRead_Sell.jsp";
					}

					request.setAttribute("pMemberStar", pMemberStar);
					request.setAttribute("already", already);
					request.setAttribute("projectRead", projectRead);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);

				} else {
					System.out.println("프로젝트 상세 조회 실패");
					response.sendRedirect(contextPath);
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "프로젝트 상세 조회", e);
			}
		}

		// 프로젝트등록페이지로 이동(freelancer 쪽)
		else if (command.equals("/projectUpload_freelancer")) {
			try {

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");
				if (loginMember == null) {
					request.getSession().setAttribute("msg", "로그인 후 이용해주세요");
					response.sendRedirect(contextPath);

				} else {

					List<Category1> category1List = new MemberService().getCategory1List();
					System.out.println(category1List);
					List<Category2> category2List = new MemberService().getCategory2List();
					System.out.println(category2List);
					request.setAttribute("category1List", category1List);
					request.setAttribute("category2List", category2List);
					request.setAttribute("category1Code", "1");
					path = "/WEB-INF/views/project/projectUpload_freelancer.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "카테고리 목록을 가져오는", e);
			}
		}

		// 프로젝트 등록(freelancer 쪽)
		else if (command.equals("/insert_freelancer")) {

			try {
				if (ServletFileUpload.isMultipartContent(request)) {

					int maxSize = 10 * 1024 * 1024;

					String root = request.getSession().getServletContext().getRealPath("/");

					String savePath = root + "resources/uploadImages/";
					System.out.println(savePath);

					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
							new MyFileRenamePolicy());

					ArrayList<String> saveFiles = new ArrayList<String>();

					ArrayList<String> originFiles = new ArrayList<String>();

					Enumeration<String> files = multiRequest.getFileNames();

					while (files.hasMoreElements()) {

						String name = files.nextElement();

						if (name.equals("thumbnailImg")) {
							saveFiles.add(multiRequest.getFilesystemName(name));
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}

					ArrayList<ProjectResource> fList = new ArrayList<ProjectResource>();

					ProjectResource file = new ProjectResource();
					file.setProjectResourcePath(savePath);
					file.setFileOriginName(originFiles.get(0));
					file.setFileChangeName(saveFiles.get(0));
					/*
					 * System.out.println((i == 0));
					 * System.out.println(multiRequest.getFilesystemName("thumbnailImg") != null);
					 * 
					 * if ((i == 0) && multiRequest.getFilesystemName("thumbnailImg") != null) {
					 * file.setFileLevel(0); } else { file.setFileLevel(1); }
					 */
					fList.add(file);
					// }

					Member loginMember = (Member) request.getSession().getAttribute("loginMember");

					int projectWriter = loginMember.getMemberNo();
					Project project = new Project();

					project.setProjectTitle(multiRequest.getParameter("projectTitle"));
					project.setProjectCategoryCode1(Integer.parseInt(multiRequest.getParameter("inputCategory1")));
					project.setProjectCategoryCode2(Integer.parseInt(multiRequest.getParameter("inputCategory2")));

					String projectStartDate = multiRequest.getParameter("projectStartDate");
					project.setProjectStartDate(Date.valueOf(projectStartDate));
					System.out.println(projectStartDate);

					String projectExpiredDate = multiRequest.getParameter("projectExpiredDate");
					project.setProjectExpiredDate(Date.valueOf(projectExpiredDate));

					project.setProjectPrice(Integer.parseInt(multiRequest.getParameter("projectPrice")));

					project.setProjectSummary(multiRequest.getParameter("projectSummary"));

					project.setProjectContent(multiRequest.getParameter("projectContent"));

					int projectStatus = 0;

					Date sqlTodayDate = new java.sql.Date(System.currentTimeMillis());

					int compare = sqlTodayDate.compareTo(Date.valueOf(projectStartDate));

					// 오늘이랑 비교를 했을 때 compare 값이 0보다 크면 진행전(1)
					// 같거나 작으면 진행중
					// 크면 expiredDate비교
					// 오늘이랑 비교했을때 0보다 크면 진행 중(2)

					if (compare < 0) {
						projectStatus = 1; // 진행전=1
					} else if (compare > 0) {
						projectStatus = 2;
					}

					project.setProjectStatus(projectStatus);

					int result = projectService.insertProject(project, fList, projectWriter);

					if (result > 0) {
						System.out.println("프로젝트 판매 게시글 등록 성공");
						path = "detail?no=" + result;
						view = request.getRequestDispatcher(path);
						view.forward(request, response);
					} else {
						System.out.println("프로젝트 판매 게시글 등록 실패");
						request.getSession().setAttribute("msg", "판매 게시글 등록 실패");
						response.sendRedirect(contextPath);
					}
				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 등록", e);
			}
		}

		// 프로젝트 의뢰하는 등록페이지로 이동(client 쪽)
		else if (command.equals("/projectUpload_client")) {
			try {

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");

				if (loginMember == null) {
					request.getSession().setAttribute("msg", "로그인 후 이용해주세요");
					response.sendRedirect(contextPath);
				} else {

					List<Category1> category1List = new MemberService().getCategory1List();
					List<Category2> category2List = new MemberService().getCategory2List();
					request.setAttribute("category1List", category1List);
					request.setAttribute("category2List", category2List);
					request.setAttribute("category1Code", "1");
					path = "/WEB-INF/views/project/projectUpload_client.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "카테고리 목록을 가져오는", e);
			}
		}

		// 클라이언트 측에서 프로젝트 의뢰 등록
		else if (command.equals("/insert_client")) {
			try {
				if (ServletFileUpload.isMultipartContent(request)) {

					int maxSize = 10 * 1024 * 1024;

					String root = request.getSession().getServletContext().getRealPath("/");

					String savePath = root + "resources/uploadImages/";

					System.out.println(savePath);

					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
							new MyFileRenamePolicy());

					ArrayList<String> saveFiles = new ArrayList<String>();

					ArrayList<String> originFiles = new ArrayList<String>();

					Enumeration<String> files = multiRequest.getFileNames();

					while (files.hasMoreElements()) {

						String name = files.nextElement();

						if (name.equals("thumbnailImg")) {
							saveFiles.add(multiRequest.getFilesystemName(name));
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}

					ArrayList<ProjectResource> fList = new ArrayList<ProjectResource>();

					ProjectResource file = new ProjectResource();
					file.setProjectResourcePath(savePath);
					file.setFileOriginName(originFiles.get(0));
					file.setFileChangeName(saveFiles.get(0));
					/*
					 * System.out.println((i == 0));
					 * System.out.println(multiRequest.getFilesystemName("thumbnailImg") != null);
					 * 
					 * if ((i == 0) && multiRequest.getFilesystemName("thumbnailImg") != null) {
					 * file.setFileLevel(0); } else { file.setFileLevel(1); }
					 */
					fList.add(file);
					// }

					Member loginMember = (Member) request.getSession().getAttribute("loginMember");

					int projectWriter = loginMember.getMemberNo();

					Project project = new Project();

					project.setProjectTitle(multiRequest.getParameter("projectTitle"));
					project.setProjectCategoryCode1(Integer.parseInt(multiRequest.getParameter("inputCategory1")));
					project.setProjectCategoryCode2(Integer.parseInt(multiRequest.getParameter("inputCategory2")));

					String projectStartDate = multiRequest.getParameter("projectStartDate");
					project.setProjectStartDate(Date.valueOf(projectStartDate));
					System.out.println(projectStartDate);

					String projectExpiredDate = multiRequest.getParameter("projectExpiredDate");
					project.setProjectExpiredDate(Date.valueOf(projectExpiredDate));

					project.setProjectPrice(Integer.parseInt(multiRequest.getParameter("projectPrice")));

					project.setProjectSummary(multiRequest.getParameter("projectSummary"));

					project.setProjectContent(multiRequest.getParameter("projectContent"));

					int projectStatus = 0;

					Date sqlTodayDate = new java.sql.Date(System.currentTimeMillis());

					int compare = sqlTodayDate.compareTo(Date.valueOf(projectStartDate));

					// 오늘이랑 비교를 했을 때 compare 값이 0보다 크면 진행전(1)
					// 같거나 작으면 진행중
					// 크면 expiredDate비교
					// 오늘이랑 비교했을때 0보다 크면 진행 중(2)

					if (compare < 0) {
						projectStatus = 1; // 진행전=1
					} else if (compare > 0) {
						projectStatus = 2;
					}

					project.setProjectStatus(projectStatus);

					int result = projectService.insertProject_client(project, fList, projectWriter);

					if (result > 0) {
						System.out.println("클라이언트 의뢰 게시글 등록 성공");
						path = "detail?no=" + result;
						view = request.getRequestDispatcher(path);
						view.forward(request, response);
					} else {
						request.getSession().setAttribute("msg", "의뢰 등록 실패");
						response.sendRedirect(contextPath);
					}

				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "클라이언트 의뢰 게시글 등록", e);
			}
		}

		// 지원자 확인을 보여주는 Controller
		// 지원자 리스트도 같이 불러옴
		else if (command.equals("/confirmApply")) {
			// DB에서 알아서 숫자로 바뀜
			String projectNo = request.getParameter("no");
			System.out.println(projectNo);
			try {

				List<VProjectApply> aList = projectService.selectApplyList(projectNo);

				List<MemberStar> mStarList = new ArrayList<MemberStar>();

				MemberStar mStar = null;

				for (VProjectApply projectApply : aList) {
					int memberNo = projectApply.getMemberNo();

					mStar = projectService.selectMemberStar(memberNo);

					mStarList.add(mStar);

				}
				request.setAttribute("aList", aList);
				request.setAttribute("mStarList", mStarList);

				System.out.println("지원자 리스트 : " + aList);
				System.out.println("멤버의 평균 별점 : " + mStarList);
				// 가져온 LIST 돌면서 각각의 별점을 담아오는 리스트

				path = "/WEB-INF/views/project/confirmApply.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "프로젝트 수정화면으로 전환하는 ", e);
			}
		}

		// 프로젝트 수정 화면 Controller
		else if (command.equals("/updateProject")) {
			// DB에서 해당 글을 조회하여 화면으로 전달

			int projectNo = Integer.parseInt(request.getParameter("no"));

			try {

				List<Category1> category1List = new MemberService().getCategory1List();
				System.out.println(category1List);
				List<Category2> category2List = new MemberService().getCategory2List();
				System.out.println(category2List);

				request.setAttribute("category1List", category1List);
				request.setAttribute("category2List", category2List);
				request.setAttribute("category1Code", "1");

				ProjectRead projectRead = projectService.updateProject(projectNo);

				if (projectRead != null) {

					List<ProjectResource> files = projectService.selectFiles(projectNo);

					if (!files.isEmpty()) {
						request.setAttribute("files", files);
					}

					path = "/WEB-INF/views/project/projectUpdate.jsp";
					request.setAttribute("projectRead", projectRead);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("msg", "프로젝트 수정 화면 출력 실패");
				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "프로젝트 수정화면으로 전환하는 ", e);
			}
		}

		// 프로젝트 수정 Controller
		else if (command.equals("/update")) {
			try {

				int projectNo = Integer.parseInt(request.getParameter("no"));
				int result = 0;

				if (ServletFileUpload.isMultipartContent(request)) {

					// 1_1. 전송 파일의 용량 제한 : 10MB로 제한
					// B -> KB -> MB -> GB -> TB
					int maxSize = 10 * 1024 * 1024;

					// 1_2. 웹 서버 컨테이너 경로 추출
					// WebContent 경로 추출
					String root = request.getSession().getServletContext().getRealPath("/");

					// 1_3. 업로드 된 파일이 저장될 경로 지정
					String savePath = root + "resources/uploadImages/";

					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
							new MyFileRenamePolicy());

					// 4. 서버에 저장된 파일의 원래 파일명, 이전 파일명을
					// DB에 전달하기 위한 ArrayList 생성

					// 저장된 파일(변경된 파일명)
					ArrayList<String> saveFiles = new ArrayList<String>();

					// 원본 파일명
					ArrayList<String> originFiles = new ArrayList<String>();

					// 전달된 요청(multipartRequest)에서 파일 리스트 정보를 얻어와
					// 저장될 파일명, 원래 파일명을 각 ArrayList에 추가함
					Enumeration<String> files = multiRequest.getFileNames();

					while (files.hasMoreElements()) {

						// 업로드된 파일은 역순으로 전달됨.
						String name = files.nextElement();

						// if (multiRequest.getFilesystemName(name) != null) {
						if (name.equals("thumbnailImg")) {
							// getFilesystemName(key) : rename된 파일명 얻어오기
							saveFiles.add(multiRequest.getFilesystemName(name));
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}

					// 6. Attachment VO를 생성한 후
					// Attachment들을 저장할 List를 생성하여
					// 파일 경로, 파일 원본명, 변경된 파일명을 세팅

					ArrayList<ProjectResource> fList = new ArrayList<ProjectResource>();

					// 파일 정보는 역순으로 전달됨으로, 반복문을 역으로 수행하여 원래 순서대로 저장
					// for (int i = 0; i <= originFiles.size() - 1; i++) {
					ProjectResource file = new ProjectResource();
					file.setProjectResourcePath(savePath);
					file.setFileOriginName(originFiles.get(0));
					file.setFileChangeName(saveFiles.get(0));
					/*
					 * System.out.println((i == 0));
					 * System.out.println(multiRequest.getFilesystemName("thumbnailImg") != null);
					 * 
					 * if ((i == 0) && multiRequest.getFilesystemName("thumbnailImg") != null) {
					 * file.setFileLevel(0); } else { file.setFileLevel(1); }
					 */
					fList.add(file);
					// }
					Project project = new Project();

					project.setProjectNo(projectNo);
					project.setProjectTitle(multiRequest.getParameter("projectTitle"));
					project.setProjectCategoryCode1(Integer.parseInt(multiRequest.getParameter("inputCategory1")));
					project.setProjectCategoryCode2(Integer.parseInt(multiRequest.getParameter("inputCategory2")));

					String projectStartDate = multiRequest.getParameter("projectStartDate");
					project.setProjectStartDate(Date.valueOf(projectStartDate));
					System.out.println(projectStartDate);

					String projectExpiredDate = multiRequest.getParameter("projectExpiredDate");
					project.setProjectExpiredDate(Date.valueOf(projectExpiredDate));

					project.setProjectPrice(Integer.parseInt(multiRequest.getParameter("projectPrice")));

					project.setProjectSummary(multiRequest.getParameter("projectSummary"));

					project.setProjectContent(multiRequest.getParameter("projectContent"));

					int projectStatus = 0;

					Date sqlTodayDate = new java.sql.Date(System.currentTimeMillis());

					int compare = sqlTodayDate.compareTo(Date.valueOf(projectStartDate));

					// 오늘이랑 비교를 했을 때 compare 값이 0보다 크면 진행전(1)
					// 같거나 작으면 진행중
					// 크면 expiredDate비교
					// 오늘이랑 비교했을때 0보다 크면 진행 중(2)

					if (compare < 0) {
						projectStatus = 1; // 진행전=1
					} else if (compare > 0) {
						projectStatus = 2;
					}

					project.setProjectStatus(projectStatus);

					result = projectService.updateProject(project, fList);

					if (result > 0) {
						System.out.println("게시글 수정 성공");
						request.getSession().setAttribute("msg", "게시글 수정 성공");
						path = "detail?no=" + projectNo;
					} else {
						System.out.println("게시글 수정 실패");
						request.getSession().setAttribute("msg", "게시글 수정 실패");
						path = "detail?no=" + projectNo;
					}
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 수정", e);
			}
		}

		// 댓글 등록용 Controller
		else if (command.equals("/insertReply")) {
			try {

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");
				int projectNo = Integer.parseInt(request.getParameter("projectNo"));

				if (loginMember == null) {
					request.getSession().setAttribute("msg", "로그인 후 이용해주세요");
					request.getHeader("REFERER");
				} else {

					int replyWriter = loginMember.getMemberNo();
					String replyContent = request.getParameter("comment_write");

					Reply reply = new Reply();

					reply.setReplyContent(replyContent);
					reply.setProjectNo(projectNo);
					reply.setMemberNo(replyWriter);

					int result = projectService.insertReply(reply);

					if (result > 0) {
						System.out.println("댓글 달기 성공");
						request.getSession().setAttribute("msg", "댓글이 등록되었습니다.");
						path = "detail?no=" + projectNo;
					} else {
						System.out.println("댓글 달기 실패");
						request.getSession().setAttribute("msg", "댓글 등록 실패");
						path = "detail?no=" + projectNo;
					}
				}
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "댓글 등록", e);
			}

		}

		else if (command.equals("/deleteProject")) {
			int projectNo = Integer.parseInt(request.getParameter("no"));
			int result = 0;

			try {
				result = projectService.deleteProject(projectNo);

				if (result > 0)
					System.out.println("프로젝트 삭제 성공");
				else
					System.out.println("프로젝트 삭제 실패");
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "프로젝트 삭제", e);
			}
		} else if (command.equals("/insertApply")) {
			try {

				int projectNo = Integer.parseInt(request.getParameter("no"));

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");

				if (loginMember != null) {

					int memberNo = loginMember.getMemberNo();
					int result = projectService.insertApply(memberNo, projectNo);
					if (result > 0) {
						System.out.println("지원하기 성공");
						msg = "지원 성공";
						path = "detail?no=" + projectNo;
					} else {
						System.out.println("지원하기 실패");
						msg = "지원하기 실패";
						path = "list";
					}

				} else {
					msg = "로그인 후 이용해주세요";
					request.getSession().setAttribute("msg", msg);
				}

				path = request.getContextPath();
				response.sendRedirect(path);

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "지원하기", e);
			}
		}

		// 리뷰 작성 페이지로 이동
		else if (command.equals("/writeReview")) {

			int projectNo = Integer.parseInt(request.getParameter("no"));
			Member loginMember = (Member) request.getSession().getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			System.out.println("리뷰 프로젝트 번호 : " + projectNo);
			System.out.println("리뷰 멤버 번호 : " + memberNo);

			request.setAttribute("memberNo", memberNo);
			request.setAttribute("projectNo", projectNo);
			path = "/WEB-INF/views/project/reviewWrite.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else if (command.equals("/insertReview")) {
			try {

				int projectNo = Integer.parseInt(request.getParameter("no"));
				System.out.println("리뷰리뷰리뷰" + projectNo);

				Member loginMember = (Member) request.getSession().getAttribute("loginMember");
				int memberNo = loginMember.getMemberNo();

				System.out.println("리뷰 등록할 때 프로젝트 번호 : " + projectNo);
				System.out.println("리뷰 등록할 때 멤버 번호 : " + memberNo);

				// 이미 리뷰를 작성한 적이 있는지 확인
				int result = projectService.checkReview(projectNo, memberNo);

				if (result != 0) {
					System.out.println("리뷰 이미 작성");
					msg = "이미 리뷰를 작성하셨어요!";
				} else {
					Review review = new Review();

					review.setProjectNo(Integer.parseInt(request.getParameter("projectNo")));
					review.setMemberNo(memberNo);
					review.setReviewContent(request.getParameter("review_content"));
					if (request.getParameter("star_point") != null)
						review.setReviewStarRating(Integer.parseInt(request.getParameter("star_point")));

					System.out.println(request.getParameter("star_point"));
					result = projectService.insertReview(review);

					System.out.println("insert할 리뷰 : " + review);
					if (result > 0) {
						msg = "리뷰 등록 성공";
						path = "detail?no=" + projectNo;
					} else {
						msg = "리뷰 등록 실패";
						path = "list";
					}
				}
				request.setAttribute("msg", msg);
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				System.out.println("리뷰리뷰리뷰" + projectNo);
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "리뷰등록", e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
