<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.searchfree.member.model.vo.Member"%>
<%@page import="com.kh.searchfree.member.model.vo.MyProject"%>
<%
	int completeProject = (int)request.getAttribute("completeProject");
	int goingProject = (int)request.getAttribute("goingProject");
	int messageCount = (int)request.getAttribute("messageCount");
	int reviewCount = (int)request.getAttribute("reviewCount");
	int avgSrating = (int)request.getAttribute("avgSrating");
	double percentProject = (double)request.getAttribute("percentProject");
	if(Double.isNaN(percentProject)){
		percentProject = 0;
	}
	List<MyProject> projectSchedule = (List<MyProject>)request.getAttribute("projectSchedule");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!-- script -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
    <style>
        .clearfix::after,
        .calendar ol::after {
            content: ".";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
        }

        /* ================
Calendar Styling */
        .calendar {
            border-radius: 10px;
        }

        .month {
            font-size: 2rem;
        }

        @media (min-width: 992px) {
            .month {
                font-size: 3.5rem;
            }
        }

        .calendar ol li {
            float: left;
            width: 14.28571%;
        }

        .calendar .day-names {
            border-bottom: 1px solid #eee;
        }

        .calendar .day-names li {
            text-transform: uppercase;
            margin-bottom: 0.5rem;
        }

        .calendar .days li {
            border-bottom: 1px solid #eee;
            min-height: 8rem;
        }

        .calendar .days li .date {
            margin: 0.5rem 0;
        }

        .calendar .days li .event {
            font-size: 0.75rem;
            padding: 0.4rem;
            color: white;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            border-radius: 4rem;
            margin-bottom: 1px;
        }

        .calendar .days li .event.span-2 {
            width: 200%;
        }

        .calendar .days li .event.begin {
            border-radius: 1rem 0 0 1rem;
        }

        .calendar .days li .event.end {
            border-radius: 0 1rem 1rem 0;
        }

        .calendar .days li .event.clear {
            background: none;
        }

        .calendar .days li:nth-child(n+29) {
            border-bottom: none;
        }

        .calendar .days li.outside .date {
            color: #ddd;
        }

        /*
*
* ==========================================
* FOR DEMO PURPOSES
* ==========================================
*
*/
    </style>
	<title>MYPAGE INFO</title>
	<!-- 마이페이지 메인 (회원정보) -->
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="http://localhost:8080/searchfree/resources/img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/themify-icons.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/nice-select.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/flaticon.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/gijgo.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/animate.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/slicknav.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/style.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/kim.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>
<body>
    <!-- header-start -->
    <header>
    <%@ include file="../common/header.jsp"%>
    
    </header>
    <!-- header-end -->
    <!-- bradcam_area  -->
    <div class="bradcam_area bradcam_bg_2">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Single Blog</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->


    <section class="body-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget post_category_widget">

                            <ul class="list cat-list">
                                <li>
                                    <a href="<%= request.getContextPath() %>/member/mypage" class="d-flex">
                                        <p text-align="center">회원정보</p>
                                        <!--회원정보==마이페이지 메인 -->

                                    </a>
                                </li>
                                <li>
                                    <a href="<%= request.getContextPath() %>/member/mypage-update" class="d-flex">
                                        <p>회원정보 수정</p>

                                    </a>
                                </li>
                                <li>
                                    <a href="<%= request.getContextPath() %>/member/mypage-delete" class="d-flex">
                                        <p>회원탈퇴</p>

                                    </a>
                                </li>
                                <li>
                                    <a href="<%= request.getContextPath() %>/member/mypage-profile" class="d-flex">
                                        <p>프로필관리</p>

                                    </a>
                                </li>
                                <li>
                                    <a href="<%= request.getContextPath() %>/project2/orderCheck" class="d-flex">
                                        <p>결제내역</p>

                                    </a>
                                </li>

                            </ul>
                        </aside>



                    </div> <!-- 사이드바 -->


                </div> <!-- <div class="col-lg-4"> -->
                <div class="col-lg-9 posts-list">

                    <!-- counter_area1  -->
                    <div class="counter_area">
                        <div class="container">
                            <div class="border_bottom">
                                <p>Progress</p>
                                <div class="row">
                                    <div class="col-xl-4 col-md-4">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
                                            <%= completeProject %>
                                            </span> </h3>
                                            <p>완료된 프로젝트</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-md-4">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
                                            <%= goingProject %>
                                            </span></h3>
                                            <p>진행중인 프로젝트수</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-md-4 ">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
                                            <%= messageCount %>
                                            </span></h3>
                                            <p>새로운 쪽지</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- counter_area1  -->

                    <!-- counter_area2  -->
                    <div class="counter_area">
                        <div class="container">
                            <div class="border_bottom">
                                <div class="row">
                                    <div class="col-xl-4 col-md-4">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
                                            <%= reviewCount %>
                                            </span> </h3>
                                            <p>등록된 리뷰</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-md-4">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
											<%= avgSrating %>
											</span></h3>
                                            <p>평균 별점</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-md-4 ">
                                        <div class="single_counter text-center">
                                            <h3> <span class="counter" style=color:rgb(131,203,245)>
                                            <%= percentProject %></span><span
                                                    style="color:rgb(131,203,245)">%</span></h3>
                                            <p>프로젝트 완료율</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- counter_area2  -->


                        </div>
                    </div>
                    <p>Schedule</p>


					<div>
						<!--  <p>주요 일정</p> -->
						<%
							for (MyProject project : projectSchedule) {
						%>
						<div>
						<table>
						<th>
							<tr>
							<td>
							<div class="float-left">
							<p>
								마감일자 :
								<%=project.getExpriredDate()%>
							</p>
							<p>
								프로젝트 제목 :
								<%=project.getProjectTitle()%>
							</p>
							<p>
								프로젝트 내용 요약 :
								<%=project.getProjectSummary()%>
							</p>
							</div>
							<div class="float-right">
							<img
								src="<%=request.getContextPath()%>/resources/img/explorer/2.png"
								alt="">
							</div>
							</td>
							</tr>
						</th>
							</table>
						</div>
						<br>
						<hr>
						<% } %>
					</div>

				</div>

            </div>

		</div>
    </section>

    <!-- footer start -->
    <footer>
  	<%@ include file="../common/footer.jsp"%>
    </footer>
    <!--/ footer end  -->




    <!-- link that opens popup -->
    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <!-- <script src="js/gijgo.min.js"></script> -->
    <script src="js/slick.min.js"></script>



    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>


    <script src="js/main.js"></script>


</body>
</html>