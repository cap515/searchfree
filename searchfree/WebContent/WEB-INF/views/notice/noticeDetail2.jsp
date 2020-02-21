<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kh.searchfree.notice.model.vo.Notice"%>
<%
	Notice notice = (Notice) request.getAttribute("notice");
%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="UTF-8">
<title>공지사항 상세조회</title>

<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">


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
									<a href="index.html"> <img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="">
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
								<div class="Appointment">
									<div class="book_btn d-none d-lg-block">
										<a href="#">Sign In</a>
									</div>
								</div>
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
	<div class="bradcam_area bradcam_bg_2">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text text-center">
						<h3>notice</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="explorer_europe">
		<div class="container">
			<div class="explorer_wrap">
				<div class="row align-items-center">
					<div class="col-xl-6 col-md-4">
						<h3>Customer Center</h3>
					</div>
					<div class="col-xl-6 col-md-8">
						<div class="explorer_tab">
							<nav>
								<div class="nav" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active" id="nav-home-tab"
										href="1공지사항list.html" role="tab" aria-controls="nav-home"
										aria-selected="true">공지사항</a> <a class="nav-item nav-link"
										id="nav-profile-tab" href="1공지사항list.html" role="tab"
										aria-controls="nav-profile" aria-selected="false">자주하는질문</a> <a
										class="nav-item nav-link" id="nav-contact-tab"
										href="1공지사항list.html" role="tab" aria-controls="nav-contact"
										aria-selected="false">이용약관</a>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<div class="row">
						<div class="col-md-12">
							<div class="single_explorer">
								<div class="thumb">
									<div class="container">
										<table class="table table-sm table-hover tb1">
											<thead>
												<%
													if (notice != null) {
												%>
												<tr class="table-active ntd">
													<th class="no ntd">no : <%=notice.getNoticeNo()%></th>
													<th class="title ntd"><%=notice.getNoticeTitle()%></th>
													<th class="date ntd"><%=notice.getNoticeCreateDT()%></th>

												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
										<div class="col-md-12">
											<div class="noticecontent" style="height:500px">
											<%=notice.getNoticeContent()%>
											</div>
										<%
											}
										%>
										</div>
										<div class="blog_left_sidebar to-list">
											
											<div class="float-right">
												<a href="<%=request.getContextPath()%>/notice/list" class="genric-btn info ">목록으로</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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

	<!-- link that opens popup -->
	<script
		src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
		
	</script>
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