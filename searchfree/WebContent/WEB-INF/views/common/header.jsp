<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.kh.searchfree.member.model.vo.Member"%>
<%@page import="com.kh.searchfree.member.model.vo.ProfileResource"%>
<%@page import="java.util.List"%>
<% List<ProfileResource> files = (List<ProfileResource>) request.getSession().getAttribute("files"); %>
<%
   String msg = (String)session.getAttribute("msg");
   Member loginMember = (Member)session.getAttribute("loginMember");
   // Object 타입이라서 형 변환 해줘야 함
   
   // C6) 쿠키사용을 위한 변수 생성
   boolean save = false; // 아이디 저장 체크박스
   String saveId = ""; // 쿠키에 저장된 saveId 라는 키가 가지고 있는 값을 저장할 변수
   Cookie[] cookies = request.getCookies(); // 전달받은 쿠키 저장
   
   // 서버 첫 시작시 request.getCookies()의 값이 null
   // -> if문으로 처리하지 않는 경우 페이지 로딩 시 NullPointException 발생됨
   if(cookies != null ){
      
      for(Cookie c : cookies){
         
         // 쿠키 객체에서 name을 얻어와 그 값이 "saveId"와 같은지 비교
         //             == key, 속성
         if(c.getName().equals("saveId")){
            
            saveId = c.getValue();
            save = true;
            
         }
      }
   }
   
            
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/style.css" />

<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
   integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
   crossorigin="anonymous">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
   href="<%=request.getContextPath() %>/resources/img/favicon.png" />
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->

<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/magnific-popup.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/themify-icons.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/nice-select.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/flaticon.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/gijgo.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/animate.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/slick.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath() %>/resources/css/slicknav.css" />

<!-- Custom fonts for this template-->
<link
   href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css"
   rel="stylesheet" type="text/html">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet" />

<!-- Custom styles for this template-->

<link rel="stylesheet"
   href="<%= request.getContextPath()%>/resources/css/projectRead.css">

<!-- link that opens popup -->
<link rel="stylesheet"
   href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />


<!-- JS here -->

<script
   src="<%=request.getContextPath() %>/resources/js/vendor/modernizr-3.5.0.min.js"></script>


<script
   src="<%=request.getContextPath() %>/resources/js/vendor/jquery-1.12.4.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/isotope.pkgd.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/ajax-form.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/waypoints.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.counterup.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/imagesloaded.pkgd.min.js"></script>
<script src="http://localhost:8080/searchfree/resources/js/scrollIt.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.scrollUp.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/wow.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/nice-select.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.slicknav.min.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.magnific-popup.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/gijgo.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/slick.min.js"></script>



<!--contact js-->
<script src="<%=request.getContextPath() %>/resources/js/contact.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.ajaxchimp.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
<script
   src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/mail-script.js"></script>


<script src="<%=request.getContextPath() %>/resources/js/main.js"></script>


<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
   integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
   crossorigin="anonymous"></script>
<style>
.on_login img {
   width: 60px;
   height: 60px;
   margin-left: 10px;
   object-fit: cover;
   object-position: top;
   border-radius: 50%;
   vertical-align: middle;
   border: 1px solid #b3b3b3;
}
</style>

</head>
<body>
	<script>
      <%if(msg != null){%>
            alert("<%=msg %>");
      <%
         session.removeAttribute("msg");//세션을 삭제
         }
      %>
      
   </script>
   <div class="modal fade" id="modal-container-1207" role="dialog"
      aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="myModalLabel">Login</h5>
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span>
               </button>
            </div>
            <div class="modal-body">
               <form class="form-signin" method="POST"
                  action="<%= request.getContextPath()%>/member/login.do"
                  onsubmit="return loginValidate();">
                  <!-- form태그 내부에서 submit 이벤트가 발생했을 때 loginValidate() 실행, 
                                                                  결과가 false가 나오면 return false가 되므로 갱신이벤트가 사라짐(페이지가 안 넘어감)-->
                  <input type="text" class="form-control" id="memberId"
                     name="memberId" placeholder="ID" value=""> <br> <input
                     type="password" class="form-control" id="memberPwd"
                     name="memberPwd" placeholder="password"> <br>
                  <div class="col-lg-3 col-md-4 mt-sm-30">
                     <div class="switch-wrap d-flex justify-content-between">
                        <div class="primary-checkbox">
                           <input type="checkbox" id="default-checkbox"> <label
                              for="default-checkbox"></label>
                        </div>
                        <h4>save id</h4>
                     </div>
                  </div>
                  <br>
                  <div class="text-center">
                     <button class="genric-btn success-border medium mt-3"
                        type="submit">Login</button>
                     <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button> -->
                     <a class="genric-btn success-border medium mt-3"
                        href="<%=request.getContextPath() %>/member/signUpForm.do">Join
                        us</a> <a class="genric-btn success-border medium mt-3" href="#">find
                        ID / password</a>
                  </div>
                  <br>
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-dismiss="modal">Close</button>
            </div>
         </div>
      </div>
   </div>
   <!-- header-start -->
   <header>
      <%=application.getContextPath() %>
      <div class="header-area">
         <div id="sticky-header" class="main-header-area "
            style="padding: 10px;">
            <div class="container-fluid ">
               <div class="header_bottom_border">
                  <div class="row align-items-center">
  							<div class="col-xl-3 col-lg-2">
								<div class="logo">
									<a href="<%=request.getContextPath()%>"> <img
										src="<%=request.getContextPath()%>/resources/img/logo.png">
									</a>
								</div>
							</div>
							<div class="col-xl-6 col-lg-7">
								<div class="main-menu  d-none d-lg-block">
									<nav>
										<ul id="navigation">
											<li><a href="index.html">home</a></li>
											<li><a href="Listings.html"></a></li>
											<li><a href="<%=request.getContextPath()%>/Search/SearchForm">PROJECT 검색 <i class="ti-angle-down"></i></a>
												</li>
											<li><a href="#">프로젝트 등록 <i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="<%=request.getContextPath()%>/project/projectUpload_freelancer">구매 등록</a></li>
													<li><a href="<%=request.getContextPath()%>/project/projectUpload_client">판매등록</a></li>
												</ul></li>
											
											<li><a href="#">공지사항 <i class="ti-angle-down"></i></a>
												<ul class="submenu">
													<li><a href="<%=request.getContextPath()%>/message/list">쪽지함</a></li>
													<li><a href="<%=request.getContextPath()%>/notice/list1">공지사항</a></li>
												</ul></li>
										</ul>
									</nav>
								</div>
							</div>
                     <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                        <% if(loginMember == null) {%>
                        <div class="Appointment">
                           <div class="book_btn d-none d-lg-block">
                              <a id="modal-1207" href="#modal-container-1207" role="button"
                                 class="danger radius btn-hei-line" data-toggle="modal">로그인</a>
                           </div>
                        </div>
                        <% } else { %>
                        <div class="Appointment">
                           <div class="d-none d-lg-block">
                              <div class="on_login">
                                 <a href="<%= request.getContextPath() %>/member/mypage"
                                    class="bigSand_genric-btn btn3">마이페이지</a> <a
                                    href="<%=request.getContextPath()%>/member/logout.do"
                                    class="bigSand_genric-btn btn3">로그아웃</a> 
									<%
									      String src = "";
									      if (files != null) {
									         for (ProfileResource file : files) {
									            // if ((file.getMemberNo() == projectRead.getProjectNo())) {
									            src = file.getFileChangeName();
									            //  }
									         }
									      }else {
									         src = "noimage.png";
									      }
									 %>
									<img
									src="<%=request.getContextPath()%>/resources/uploadImages/<%=src%>">
                              </div>
                           </div>
                        </div>
                        <% } %>
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
   <link
      href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css"
      rel="stylesheet">
   <script
      src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>
</body>
</html>