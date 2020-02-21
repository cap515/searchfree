<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.kh.searchfree.member.model.vo.Member"%>
<%@page import="com.kh.searchfree.message.model.vo.Message"%>
<%@page import="com.kh.searchfree.board.model.vo.PageInfo"%>

<%
	Member member = (Member) session.getAttribute("loninMember");

	List<Message> mList = (List<Message>) request.getAttribute("mList");

	List<String> seNick = (List<String>) request.getAttribute("seNick");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message Write</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>


	<header>
		<div class="header-area ">
			<div id="sticky-header" class="main-header-area">
				<div class="container-fluid ">
					<div class="header_bottom_border">
						<div class="row align-items-center">
							<div class="col-xl-3 col-lg-2">
								<div class="logo">
									<a href="index.html"> <img
										src="<%=request.getContextPath()%>/resources/img/logo.png"
										alt="">
									</a>
								</div>
							</div>
							<div class="col-xl-6 col-lg-7">
								<div class="main-menu  d-none d-lg-block">
									<nav>
										<ul id="navigation">
											<li><a href="index.html">home</a></li>
											<li><a href="Listings.html">Listings</a></li>
											<li><a href="#">pages <i class="ti-angle-down"></i></a>
												<ul class="submenu">

													<li><a href="elements.html">elements</a></li>
													<li><a href="single_listings.html">Single listing</a></li>
												</ul></li>
											<li><a href="about.html">about</a></li>
											<li><a href="#">blog <i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="blog.html">blog</a></li>
													<li><a href="single-blog.html">single-blog</a></li>
												</ul></li>
											<li><a href="contact.html">Contact</a></li>
										</ul>
									</nav>
								</div>
							</div>
							<div class="col-xl-3 col-lg-3 d-none d-lg-block">
								<%
									if (loginMember == null) {
								%>
								<div class="Appointment">
									<div class="book_btn d-none d-lg-block">
										<a id="modal-1207" href="#modal-container-1207" role="button"
											class="danger radius btn-hei-line" data-toggle="modal">로그인</a>
									</div>
								</div>
								<%
									} else {
								%>
								<div class="Appointment">
									<div class="d-none d-lg-block">
										<div class="on_login">
											<a href="" class="bigSand_genric-btn btn3">마이페이지</a> <a
												href="<%=request.getContextPath()%>/member/logout.do"
												class="bigSand_genric-btn btn3">로그아웃</a> <img
												src="<%=request.getContextPath()%>/resources/img/catagory/3.png">
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>
							<div class="col-12">
								<div class="mobile_menu d-block d-lg-none"></div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</header>
	<!-- header-end -->
	<!-- bradcam_area  -->
	<div class="bradcam_area bradcam_bg_2">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text text-center">
						<h3>messege</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->
	<!-- ================ contact section start ================= -->
	<div class="col-xl-12">
		<div class="bradcam_text text-center paddings">
			<h1>notice write</h1>
		</div>
	</div>

	<section class="contact-section section_padding">

		<form class="" action="<%=request.getContextPath()%>/message/send"
			method="post" id="contactForm123" novalidate="novalidate">
			<div class="container">
				<div class="row btnrow">
					<div class="col-lg-12 p-0">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<input class="form-control messegeform" name="title"
										id="msgTitle" type="text" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '제목입력'" placeholder='제목입력'>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<input class="form-control messegeform" name="whos" id="msgWho"
										type="text" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '받는사람 입력'" placeholder='받는사람 입력'
										value="<%if(seNick != null){%><% for(String str : seNick){%><%= str + ',' +' '%><%} %><%} %>"
										>
								</div>
							</div>

							<div class="col-12">
								<div class="form-group">

									<textarea class="form-control w-100 messegeform" name="msgcont"
										id="message" cols="30" rows="9"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter Message'"
										placeholder='Enter Message'></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 sheel">
					<div class="float-right">
						<a href="<%=request.getContextPath()%>/message/list"
							class=" button button-contactForm btn_4 boxed-btn2 ">목록으로</a>
					</div>

					<div class="float-right">
						<button id="sendbtn"
						
							class="button button-contactForm btn_4 boxed-btn2">전송하기</button>
					</div>


				</div>
			</div>
		</form>
		<script type="text/javascript">
			
				$("#sendbtn").on("click", function validate() {
					if ($("#msgTitle").val().trim().length == 0) {
						alert("제목을 입력해 주세요.");
						$("#msgTitle").focus();
						return false;
					}
					if ($("#msgWho").val().trim().length == 0) {
						alert("받는 사람을 입력해 주세요.");
						$("#msgWho").focus();
						return false;
					}

					if ($("#message").val().trim().length == 0) {
						alert("내용을 입력해 주세요.");
						$("#message").focus();
						return false;
					}
				});
			
			
		</script>


		<div class="row btnrow">
			<div class="col-md-12">
				<div class="blog_left_sidebar col-md-12"></div>
			</div>
		</div>

	</section>
	<!-- ================ contact section end ================= -->

	<!-- footer start -->
	<footer class="footer">
		<div class="footer_top">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-md-6 col-lg-3">
						<div class="footer_widget">
							<div class="footer_logo">
								<a href="#"> <img src="img/footer_logo.png" alt="">
								</a>
							</div>
							<p>
								Esteem spirit temper too say adieus who <br> direct esteem.
								It esteems luckily or <br> picture placing drawing.
							</p>
							<div class="socail_links">
								<ul>
									<li><a href="#"> <i class="ti-facebook"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-google-plus"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-twitter"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-instagram"></i>
									</a></li>
								</ul>
							</div>

						</div>
					</div>
					<div class="col-xl-2 col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">Services</h3>
							<ul>
								<li><a href="#">SEO/SEM </a></li>
								<li><a href="#">Web design </a></li>
								<li><a href="#">Ecommerce</a></li>
								<li><a href="#">Digital marketing</a></li>
							</ul>

						</div>
					</div>
					<div class="col-xl-2 col-md-6 col-lg-2">
						<div class="footer_widget">
							<h3 class="footer_title">Useful Links</h3>
							<ul>
								<li><a href="#">About</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#"> Contact</a></li>
								<li><a href="#">Support</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-4 col-md-6 col-lg-4">
						<div class="footer_widget">
							<h3 class="footer_title">Subscribe</h3>
							<form action="#" class="newsletter_form">
								<input type="text" placeholder="Enter your mail">
								<button type="submit">Subscribe</button>
							</form>
							<p class="newsletter_text">Esteem spirit temper too say
								adieus who direct esteem esteems luckily.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copy-right_text">
			<div class="container">
				<div class="footer_border"></div>
				<div class="row">
					<div class="col-xl-12">
						<p class="copy_right text-center">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--/ footer end  -->


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
	<script src="js/gijgo.min.js"></script>

	<!--contact js-->
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>

	<script src="js/main.js"></script>

</body>
</html>