<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.kh.searchfree.project.model.vo.ProjectRead, java.sql.Date,
	com.kh.searchfree.project.model.vo.ProjectResource,
	com.kh.searchfree.project.model.vo.ReplyRead,
	com.kh.searchfree.project.model.vo.ReviewRead"%>
<%@page import="java.util.ArrayList"%>
<%
	ProjectRead projectRead = (ProjectRead) request.getAttribute("projectRead");
	int projectPrice = projectRead.getProjectPrice();
	Date projectStartDate = projectRead.getProjectStartDate();
	Date projectExpiredDate = projectRead.getProjectExpiredDate();
	int reviewStarRating = projectRead.getReviewStarRating();
	int projectNo = projectRead.getProjectNo();
	ArrayList<ProjectResource> files2 = (ArrayList<ProjectResource>) request.getAttribute("files");
	ArrayList<ReplyRead> rList = (ArrayList<ReplyRead>) request.getAttribute("rList");
	ArrayList<ReviewRead> reviewList = (ArrayList<ReviewRead>) request.getAttribute("reviewList");
	int pMemberStar = (Integer)request.getAttribute("pMemberStar");
%>
<!-- 결제하기 project_Alt = 1-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세조회</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Directory</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/resources/img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/magnific-popup.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/nice-select.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/gijgo.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/slick.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/slicknav.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/projectRead.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/projectRead.css">
<!-- <link rel="stylesheet" href="css/responsive.css"> -->

<!-- summer note css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css"
	rel="stylesheet">

</head>

<body>

	<%@ include file="../common/header.jsp"%>

	<section class="project_area section-padding">
		<div class="container">
			<div class="row bigSand_border">
				<!-- Project Title start -->
				<div class="col-lg-12 mb-5 mb-lg-0">
					<div class="bigSand_project_title bigSand_text text-center">
						<h4><%=projectRead.getProjectTitle()%></h4>
					</div>
				</div>
				<!-- Project Title end -->
				<div class="col-lg-12 mb-5 mb-lg-0">
					<div class="bigSand_breadcrumb_wrapper">
						<ul class="bigSand_breadcrumb">
							<li><a href="#"><%=projectRead.getCategory1Name()%></a></li>
							<li><a href="#"><%=projectRead.getCategory2Name()%></a></li>
							<!-- <li><a href="#">태그1</a></li> -->
							<!-- <li><a href="#">태그2</a></li> -->
							<!-- <li><a href="#">태그3</a></li> -->
						</ul>

					</div>
				</div>
				<div class="col-lg-7 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
						<article class="blog_item">
							<!-- 썸네일 부분 -->
							<%
								String src = "";
								for (ProjectResource file : files2) {
									if ((file.getProjectNo() == projectRead.getProjectNo())) {
										src = file.getFileChangeName();
									}
								}
							%>

							<img class="card-img rounded-0"
								src="<%=request.getContextPath()%>/resources/uploadImages/<%=src%>" />
							<div class="blog_details">
								<p><%=projectRead.getProjectSummary()%></p>
							</div>
						</article>
					</div>
				</div>
				<div class="col-lg-5">
					<div class="blog_right_sidebar">
						<div class="bigSand_right_profile">
							<div class="bigSand_profile_icon">
								<img
									src="<%=request.getContextPath()%>/resources/uploadImages/noimage.png""
									alt="">
							</div>
							<div class="bigSand_profile_name">
								<h5><%=projectRead.getMemberName()%></h5>
							</div>
							<div class="bigSand_profile_button">
								<a href="#" class="bigSand_genric-btn btn1">쪽지 보내기</a> <a
									href="#" class="bigSand_genric-btn btn1">프로필 조회</a>
							</div>
							<div class="bigSand_star_rating">
								&nbsp;&nbsp; <input type="number" class="star_point"
									name="star_point" value="<%=pMemberStar%>" readonly>
							</div>
						</div>
						<div class="bigSand_project_info">
							<div class="bigSand_project_schedule">
								<div class="bigSand_schedule_wrapper">
									<input type="date" class="bigSand_schedule_dateForm"
										name="bigSand_schedule_start" id="bigSand_schedule_start"
										value="<%=projectStartDate%>" readonly> <span>~</span>
									<input type="date" class="bigSand_schedule_dateForm"
										name="bigSand_schedule_start" id="bigSand_schedule_start"
										value="<%=projectExpiredDate%>" readonly>
								</div>
							</div>
							<div class="bigSand_project_price" id="bigSand_project_price">
								<div class="bigSand_price_wrapper">
									<span>￦ </span> <input type="number"
										class="bigSand_price_input" name="bigSand_price_input"
										id="bigSand_price_input" value="<%=projectPrice%>" readonly>
								</div>
							</div>
						</div>
						<a href="#" class="bigSand_right_payment bigSand_payment_btn">결제하기</a>
					</div>
				</div>
				<div class="col-lg-12 mb-5 mb-lg-0">
					<div class="bigSand_hr"></div>
					<div class="bigSand_comment_tab_tabmenu">
						<ul class="bigSand_comment_tab_ul">
							<li id="tab1" class="bigSand_comment_tab_btnCon"><input
								type="radio" checked name="tabmenu" id="tabmenu1"> <label
								for="tabmenu1">프로젝트 내용</label></li>
							<li id="tab2" class="bigSand_comment_tab_btnCon"><input
								type="radio" name="tabmenu" id="tabmenu2"> <label
								for="tabmenu2">리뷰</label></li>
						</ul>
					</div>
					<div class="bigSand_project_content">
						<%=projectRead.getProjectContent()%>
					</div>

					<div class="bigSand_project_review">
						<%if(reviewList == null){ %>
						<span>존재하는 리뷰가 없습니다.</span>
						<%} else{
						for(ReviewRead reviewRead : reviewList){
						%>
						<div class="bigSand_review">
							<div class="bigSand_review_profile_icon">
								<img src="/img/test/profile_icon.png" alt="">
							</div>
							<div class="bigSand_review_profile_name">
								<h5><%=reviewRead.getMemberNick() %></h5>
							</div>
							<div class="bigSand_review_star_rating">
								&nbsp;&nbsp; <input type="number" class="star_point review_star"
									name="star_point" value="<%=reviewRead.getStar() %>" readonly>
							</div>
							<div class="bigSand_review_btns">
								<a href="report/reportForm?report_code=20&toReportNo=<%= reviewRead.getReviewNo() %>" class="bigSand_genric-btn btn2 review_btn">신고</a>
							</div>
							<div class="bigSand_review_text">
								<p><%=reviewRead.getReviewContent() %></p>
							</div>
						</div>
						<%} }%>
						<!-- 리뷰 반복 -->
						
					</div>
					<div class="bigSand_hr"></div>
				</div>

				<div class="col-lg-12 mb-5 mb-lg-0 bigSnad_comment_wrapper">
					<h1>댓글</h1>
					<div class="col-lg-12 bigSand_comments">
						<!-- 댓글이 존재하지 않을 때  -->
						<%
							if (rList == null) {
						%>
						<div class="bigSand_comment">
							<span>존재하는 댓글이 없습니다.</span>
						</div>
						<%
							} else {
								for (ReplyRead replyRead : rList) {
						%>
						<div class="bigSand_comment">
							<div class="bigSand_comment_id">
								<div class="bigSand_comment_id_userId">
									<a href="#"><%=replyRead.getMemberNick()%></a>
								</div>
								<div class="bigSand_comment_id_writeTime">
									<span><%=replyRead.getReplyCreateDate()%></span>
								</div>
							</div>
							<div class="bigSand_comment_text"><%=replyRead.getReplyContent()%></div>
							<div class="bigSand_comment_btns">
								<a href="#" onclick="return false"
									class="bigSand_genric-btn btn2 write_Comment_btn">답글</a> <a
									href="report/reportForm?report_code=10&toReportNo=<%= replyRead.getReplyNo() %>" class="bigSand_genric-btn btn2">신고</a>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
				</div>

				<!-- 댓글 작성 부분 -->
				<form class="bigSand_comment col-lg-12 mb-5 mb-lg-0"
					action="insertReply?no=<%=projectRead.getProjectNo()%>"
					method="POST">
					<!-- <div class="col-lg-12 mb-5 mb-lg-0"> -->
					<div class="col-lg-12 mb-5 mb-lg-0 comment_write">
						<textarea name="comment_write" id="comment_write" rows="4"
							style="width: 90%; resize: none;"></textarea>
						<button type="submit"
							class="bigSand_genric-btn btn2 comment_write_btn float-right">등록</button>
						<input type="text" name="projectNo" value="<%=projectNo%>" hidden>
						<!--</div> -->
					</div>
				</form>

				<div
					class="col-lg-12 mb-5 mb-lg-0 bigSand_tm-10 justify-content-center d-flex">
				</div>
			</div>
			<div class="bigSand_content_btns">
				<%
					if (loginMember != null && projectRead.getMemberNo() == loginMember.getMemberNo()) {
						request.setAttribute("projectNo", projectNo);
				%>
				<a href="updateProject?no=<%=projectRead.getProjectNo()%>"
					class="bigSand_genric-btn btn3">수정</a> <a
					href="deleteProject?no=<%=projectRead.getProjectNo()%>"
					class="bigSand_genric-btn btn3">삭제</a>
				<%
					}
				%>
				<a href="project/list" class="bigSand_genric-btn btn3">목록으로</a>
				<a href="#" id="insertReview" class="bigSand_genric-btn btn3">리뷰작성</a>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

	<!-- footer start -->
	<%@ include file="../common/footer.jsp"%>
	<!--/ footer end  -->



	<!-- link that opens popup -->
	<script
		src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
		
	</script>
	<!-- JS here -->
	<script
		src="<%=request.getContextPath()%>/resources/js/vendor/modernizr-3.5.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/ajax-form.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/imagesloaded.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scrollIt.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/nice-select.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.slicknav.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/plugins.js"></script>
	<!-- <script src="js/gijgo.min.js"></script> -->
	<script src="js/slick.min.js"></script>



	<!--contact js-->
	<script src="<%=request.getContextPath()%>/resources/js/contact.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.form.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/mail-script.js"></script>
	<%-- <script src="<%=request.getContextPath()%>/resources/js/userJs.js"></script> --%>


	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>

	<!-- summernote js -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>

	<script>
		$(function() {
			var star_ratings = $('.star_point');
			console.log(star_ratings);
			console.log(star_ratings + ", " + star_ratings[1] + ", "
					+ star_ratings[1].value());
			for (var i = 0; i < star_ratings.length; i++) {
				var text = "<span>";
				for (var j = 0; j < 5; j++) {
					if (j < star_ratings[i].value())
						text += "★";
					else
						text += "☆"
				}
				text += "</span>"
				console.log(text);
				text += star_ratings[i].parentNode.innerHTML;
				star_ratings[i].parentNode.innerHTML = text;
			}
		});

		$(function() {
			console.log("tab");
			$("#tabmenu1").click(function() {
				$(".bigSand_project_content").css("display", "block");
				$(".bigSand_project_review").css("display", "none");
				console.log("content");
			});

			$("#tabmenu2").click(function() {
				$(".bigSand_project_review").css("display", "block");
				$(".bigSand_project_content").css("display", "none");
				console.log("review");
			});
		});

		$(function() {
			/*
			<div class="input_Comment_Comment">
			    <div class="comment_write">
			        <textarea name="comment_write" id="comment_write" rows="4"
			            style="width: 90%; resize: none;"></textarea>
			        <a href="#" class="bigSand_genric-btn btn2 comment_write_btn">등록</a>
			    </div>
			</div>
			 */
			var inputCommentHtml = '<form><div class="input_Comment_Comment" id="input_Comment_Comment">'
					+ '<div class="comment_write">'
					+ '<textarea name="comment_write" id="comment_write" rows="4"'
					+ 'style="width: 90%; resize: none;"></textarea>'
					+ '<button type="submit" class="bigSand_genric-btn btn2 comment_write_btn float-right">등록</button>'
					+ '</div>' + '</div></form>';
			$(".bigSand_genric-btn.btn2.write_Comment_btn").click(function() {
				$("div").remove("#input_Comment_Comment");
				$(this).parents(".bigSand_comment").append(inputCommentHtml);
			});
		});
		$(function() {
			var inputLength = $("#bigSand_price_input").val().length * 13.3
					+ "px";
			console.log(inputLength);
			$("#bigSand_price_input").css("width", inputLength);
		});
		
		$("#insertReview").click(function () {
			window.open("<%=request.getContextPath()%>/project/writeReview?no=<%=projectNo%>","confirm", "width=600, height=300");}
		);
	</script>


</body>

</html>