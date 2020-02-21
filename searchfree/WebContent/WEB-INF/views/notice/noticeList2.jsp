<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List, 
	com.kh.searchfree.notice.model.vo.Notice, 
	com.kh.searchfree.board.model.vo.PageInfo, 
	com.kh.searchfree.board.model.vo.Attachment"%>

<!-- //이번 페이지 요청 (request)에 있는 파라미터를 얻어옴  -->
<%
	List<Notice> nList = (List<Notice>) request.getAttribute("nList");
	PageInfo pInf = (PageInfo) request.getAttribute("pInf");

	int listCount = pInf.getListCount();
	int currentPage = pInf.getCurrentPage();
	int maxPage = pInf.getMaxPage();
	int startPage = pInf.getStartPage();
	int endPage = pInf.getEndPage();
%>
<html>
<head>
<meta charset="UTF-8">
<title>자주하는질문</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/nav.jsp"%>


	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header-start -->
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
	<!-- header-end -->
	<!-- slider_area_end -->
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

	<!-- content_area_start -->

	<div class="explorer_europe">
		<div class="container">
			<div class="explorer_wrap">
				<div class="row align-items-center">
					<div class="col-xl-6 col-md-4">
						<h3>고객센터</h3>
					</div>
					<div class="col-xl-6 col-md-8">
						<div class="explorer_tab">
							<nav>
								<div class="nav" id="nav-tab" role="tablist">
									<a class="nav-item nav-link  nav-notice"
										id="nav-home-tab" data-toggle="tab" href="#"
										role="tab" aria-controls="nav-home" aria-selected="false">공지사항
									</a> 
									<a class="nav-item nav-link active nav-question" id="nav-profile-tab"
										data-toggle="tab" href="#" role="tab"
										aria-controls="nav-profile" aria-selected="true">자주하는질문 </a>

									<a class="nav-item nav-link nav-dill" id="nav-contact-tab"
										data-toggle="tab" href="#" role="tab"
										aria-controls="nav-contact" aria-selected="false">이용약관 </a>

								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-content" id="nav-profile">
				<div class="tab-pane fade show active" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<div class="row">
						<div class="col-md-12">
							<div class="single_explorer">
								<div class="thumb">
									<div class="container">

										<table class="table table-sm table-hover tb1" id="tb1">
											<thead>
												<tr class="table-active ntd">
													<th class="no ntd">no</th>
													<th class="title ntd">title</th>
													<th class="date ntd">date</th>
												</tr>
											</thead>
											<tbody>
												<%
													if (!nList.isEmpty()) {
												%>
												<%
													for (Notice notice : nList) {
												%>
												<tr class="tr1">
													<td class="no"><%=notice.getNoticeNo()%></td>
													<td class="title"><%=notice.getNoticeTitle()%></td>
													<td class="date"><%=notice.getNoticeCreateDT()%></td>

													<%
														}
													%>

													<%
														}else{
													%>
													<td colspan="6">존재하는 게시글이 없습니다.</td>
													<%} %>
												</tr>
											</tbody>
										</table>
										<script type="text/javascript">
										
											
												$(function (){
													$(".tr1").click(function(){
														var noticeNo = $(this).children().eq(0).text();
														location.href = "<%=request.getContextPath()%>/notice/detail?no="+ noticeNo+ "&currentPage="+<%=currentPage%>;
														}).mouseenter(function() {
														$(this).parent().css("cursor","pointer");
													});
													
													$("#nav-home-tab").click(function(){
														location.href = "<%=request.getContextPath() %>/notice/list1"
													});
													
													$("#nav-contact-tab").click(function(){
														location.href = "<%=request.getContextPath() %>/notice/list3"
													});
												});
												
										
										
										</script>

									</div>
								</div>
							</div>

						</div>
					</div>
					
					<div class="blog_left_sidebar to-list">
						<div class="blog_left_sidebar">
							<nav
								class="blog-pagination justify-content-center d-flex page-item">
								<ul class="pagination">
									<%
										if (currentPage > 1) {
									%>
									<li class="page-item"><a
										href="<%=request.getContextPath()%>/notice/list?currentPage=<%=currentPage - 1%>"
										class="page-link" aria-label="Previous"> <i
											class="ti-angle-left"></i>
									</a></li>
									<%
										}
									%>

									<%
										for (int p = startPage; p <= endPage; p++) {
									%>
									<%
										if (p == currentPage) {
									%>
									<li class="page-item"><a class="page-link"><%=p%></a></li>
									<%
										} else {
									%>
									<li class="page-item"><a
										href="<%=request.getContextPath()%>/notice/list?currentPage=<%=p%>"
										class="page-link"><%=p%></a></li>
									<%
										}
									%>
									<%
										}
									%>
									<%
										if (currentPage < maxPage) {
									%>
									<li class="page-item"><a
										href="<%=request.getContextPath()%>/notice/list?currentPage=<%=currentPage + 1%>"
										class="page-link" aria-label="Next"> <i
											class="ti-angle-right"></i>
									</a></li>
									<%
										}
									%>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- content_area_end -->




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
									Esteem spirit temper too say adieus who <br> direct
									esteem. It esteems luckily or <br> picture placing
									drawing.
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