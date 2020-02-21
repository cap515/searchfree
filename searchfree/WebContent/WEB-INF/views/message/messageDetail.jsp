<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.kh.searchfree.member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.searchfree.message.model.vo.Message"%>
<%@page import="com.kh.searchfree.board.model.vo.PageInfo"%>

<%
	Member member = (Member) session.getAttribute("loninMember");

	List<Message> mList = (List<Message>) request.getAttribute("mList");
	Message msgDetail = (Message) request.getAttribute("message");
	String react = (String)(request.getAttribute("msg"));
%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Directory</title>
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
			<h1>messege</h1>
		</div>

		<section class="contact-section section_padding paddings">

			<div class="container">
				<table class="table table-sm table-hover tb1">
					<thead>
						<%
							if (msgDetail != null) {
						%>

						<tr class="table-active ">
							<th class="no ">no.<%=msgDetail.getMessageNo()%></th>
							<th class="">제목 <%=msgDetail.getMessageNo()%></th>
							<th class="who">발신이 :<%=msgDetail.getSenderNick()%></th>
							<th class="date"><%=msgDetail.getMessageCreateDT()%></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="col-md-12 notice"><%=msgDetail.getMessageContent()%></div>
				<%
					} else {
				%>
				
						<tr class="table-active ">
							<th class="no ">no.:</th>
							<th class="who">발신이 :</th>
							<th class="">제목 :</th>
							<th class="date">날짜:</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
					<div class="col-md-12 notice"  style="text-align: center">쪽지를 불러오는데 실패하였습니다.</div>
				<%
					}
				%>
				<div class="col-md-12 sheel">
					<div class="float-right">
						<a href="<%=request.getContextPath()%>/message/list"
							class="genric-btn info ">목록으로</a>
					</div>

					<div class="float-right" id="answer">
						<a href="<%=request.getContextPath()%>/message/WriteForm?name=<%=msgDetail.getSenderNick() %>"
							class="genric-btn info ">답장하기</a>
					</div>
					
					<div class="float-right" id="delete">
						<button 
							class="genric-btn info ">삭제하기</button>
					</div>
				</div>
			</div>
			<script type="text/javascript">
			
				$(function(){
					$("#delete").click(function(){
						var onemoer = confirm("정말 삭제하시겠습니까?");
						
						if(onemoer){
							location.replace("<%=request.getContextPath()%>/message/delete?no=<%=msgDetail.getMessageNo()%>");
							
						}else{
							location.replace("<%=request.getContextPath()%>/message/detail?no=<%=msgDetail.getMessageNo()%>");
						}
								
								
					})
					
				})
			
			</script>
		</section>
	</div>
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