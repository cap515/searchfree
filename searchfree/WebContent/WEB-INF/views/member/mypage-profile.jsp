<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.kh.searchfree.member.model.vo.Member"%>
<%@page import="com.kh.searchfree.member.model.vo.MyProject"%>
<%@page import="com.kh.searchfree.member.model.vo.Portfolio"%>
<%
   String memberNick = (String) request.getAttribute("memberNick");
   List<MyProject> projectList1 = (List<MyProject>) request.getAttribute("projectList1");
   List<MyProject> projectList2 = (List<MyProject>) request.getAttribute("projectList2");
   String showNname = (String) request.getAttribute("showNname");
   String selectContent = (String) request.getAttribute("selectContent");
   String selectTitle = (String) request.getAttribute("selectTitle");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>MyProfileEdit</title>
<style>
.img-fluid {
   margin-bottom: 10px;
   text-align: center;
}

.testimonial_area {
   padding-top: 10px !important;
   padding-bottom: 10px !important;
   text-align: center;
}
</style>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-3.4.1.min.js"></script>


<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
   href="http://localhost:8080/searchfree/resources/img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/bootstrap.min.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/magnific-popup.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/font-awesome.min.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/themify-icons.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/nice-select.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/flaticon.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/gijgo.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/animate.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/slicknav.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/style.css">
<link rel="stylesheet"
   href="http://localhost:8080/searchfree/resources/css/kim.css">
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
                        <li><a href="<%=request.getContextPath()%>/member/mypage"
                           class="d-flex">
                              <p text-align="center">회원정보</p> <!--회원정보==마이페이지 메인 -->

                        </a></li>
                        <li><a
                           href="<%=request.getContextPath()%>/member/mypage-update"
                           class="d-flex">
                              <p>회원정보 수정</p>

                        </a></li>
                        <li><a
                           href="<%=request.getContextPath()%>/member/mypage-delete"
                           class="d-flex">
                              <p>회원탈퇴</p>

                        </a></li>
                        <li><a
                           href="<%=request.getContextPath()%>/member/mypage-profile"
                           class="d-flex">
                              <p>프로필관리</p>

                        </a></li>
                        <li><a
                           href="<%=request.getContextPath()%>/member/mypage-order"
                           class="d-flex">
                              <p>결제내역</p>

                        </a></li>

                     </ul>
                  </aside>
               </div>
               <!-- 사이드바 blog_right_sidebar -->
            </div>
            <!-- <div class="col-lg-3"> -->

            <div class="col-lg-9 posts-list">
               <p>Profile Panel</p>
               <br>
               <!-- 회원정보 띄우기 -->
               <%-- <%=memberNick%>님의 프로필 페이지 --%>

               <div>
                  <br>
                  <div class="blog-author">
                     <div class="media align-items-center">
                        <img src="img/blog/author.png" alt="">
                        <div class="media-body">
                           <div>
                              <div class="form-group text-right">
                                 <div class="form-group text-right">
                                    <!-- <img id="contentImg1" width="150" height="150">
 -->
                                    <!-- 이미지 업로드  -->
                                    <form action="<%=request.getContextPath()%>/member/insert"
                                       method="post" enctype="multipart/form-data" role="form"
                                       onsubmit="return validate();">
                                       <!-- enctype="multipart/form-data" : 파일업로드시 꼭 필요! -->

                                       <div class="form-inline mb-2">
                                          <div class="boardImg" id="titleImgArea">
                                             <!-- 업로드한 이미지 띄우기  -->
                                             <%
                                                String src = "";
                                                if (files != null) {
                                                   for (ProfileResource file : files) {
                                                      src = file.getFileChangeName();
                                                      //  }
                                                   }
                                                } else {
                                                   src = "noimage.png";
                                                }
                                             %>
                                             <img class="card-img rounded-0"
                                                style="width: 300px; height: 300px"
                                                src="<%=request.getContextPath()%>/resources/uploadImages/<%=src%>">

                                          </div>
                                          <!-- <div style="margin-left:20px" id="insertIntroText" name="insertIntroText">
                                          소개글 들어올 영역~asdfasdfasdfasdfasdfasdfasdf
                                          </div> -->
                                       </div>
                                       <button type="submit" class="float-right btn">등록</button>
                                       <input type="button" value="수정" id="imgUpload"
                                          class="float-right btn">
                                       <div id="fileArea">
                                          <!-- multiple 속성 
                  - input 요소 하나에 둘 이상의 값을 입력할 수 있음을 명시
                  multiple="multiple" ->파일 여러개 선택 가능
               -->
                                          <input type="file" id="img1" name="img1"
                                             onchange="LoadImg(this,1)">

                                       </div>

                                    </form>
                                    <form>
                                    
                                    </form>


                                    <!-- ///이미지///  -->
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>

                     <hr>

                     <div>
                        <div class="container back-white">
                           <div>
                              <p>내가 등록한 프로젝트</p>
                           </div>
                        </div>
                        <%
                           for (MyProject project : projectList1) {
                        %>
                        <br>
                        <div class="row" id="header-tab-btn">
                           <!-- 여기 아래 부분이 반복해서 값 꺼내오기 1  -->
                           <div style="margin: 50px;">
                              <!-- 이미지 불러와서 반복으로 꺼내기 -->
                              <table>
                                 <thead>

                                 </thead>
                                 <tbody>
                                    <tr>
                                       <td class="float-left">
                                          <p>
                                             DATE :
                                             <%=project.getCreateDate()%></p>
                                          <p>
                                             TITLE:
                                             <%=project.getProjectTitle()%></p>
                                          <p>
                                             SUMMARY :
                                             <%=project.getProjectSummary()%></p>
                                       </td>
                                       <td><img
                                          src="<%=request.getContextPath()%>/resources/img/explorer/2.png"
                                          alt=""></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </div>
                        </div>
                     </div>
                     <%
                        }
                     %>

                     <div>
                        <div class="container back-white">
                           <div>
                              <p>내가 의뢰한 프로젝트</p>
                           </div>
                        </div>
                        <%
                           for (MyProject project2 : projectList2) {
                        %>
                        <br>
                        <div class="row" id="header-tab-btn">
                           <!-- 여기 아래 부분이 반복해서 값 꺼내오기 1  -->
                           <div style="margin: 50px;">
                              <!-- 이미지 불러와서 반복으로 꺼내기 -->
                              <table>
                                 <thead>

                                 </thead>
                                 <tbody>
                                    <tr>
                                       <td class="float-left">
                                          <p>
                                             DATE :
                                             <%=project2.getCreateDate()%></p>
                                          <p>
                                             TITLE:
                                             <%=project2.getProjectTitle()%></p>
                                          <p>
                                             SUMMARY :
                                             <%=project2.getProjectSummary()%></p>
                                       </td>
                                       <td><img
                                          src="<%=request.getContextPath()%>/resources/img/explorer/2.png"
                                          alt=""></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </div>
                        </div>
                     </div>
                     <%
                        }
                     %>
                     <hr>
                     <div class="row"margin-bottom: 30px">
                        <p>Portfolio</p>
                        <div class="container">
                           <a href="<%=request.getContextPath()%>/member/deletePortfolio">
                              <div class=" float-right">
                                 <input type="button" value="delete" class="btn">
                              </div>
                           </a>
                                                      <a
                              href="<%=request.getContextPath()%>/member/mypage-summernote">
                              <div class=" float-right">
                                 <input type="button" value="edit" class="btn">
                              </div>
                           </a> 
                           <div class="row" style="padding-bottom: 100px;">
                              <div class="thumb" style="width: 800px; height: 200px;">

                                 <div class="row">
                                    <%=selectTitle%>
                                 </div>
                                 <div class="row">
                                    <%=selectContent%>
                                 </div>

                              </div>
                           </div>
                        </div>
                     </div>

                  </div>
                  <!-- container end -->

               </div>
            </div>


         </div>
         <!-- row -->
      </div>
      <!-- container -->
   </section>


   <footer>
      <%@ include file="../common/footer.jsp"%>
   </footer>



   <script>
      /*       // 오늘 날짜 출력 
       var today = new Date();

       var str = today.getFullYear() + "-" + today.getMonth() + 1 + "-"
       + today.getDate();
       $("#today").html(str);

       // 유효성 검사
       function validate() {
       if ($("#title").val().trim().length == 0) {
       alert("제목을 입력해 주세요.");
       $("#title").focus();
       return false;
       }

       if ($("#content").val().trim().length == 0) {
       alert("내용을 입력해 주세요.");
       $("#content").focus();
       return false;
       }
       }
       */

      // 이미지 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
      $(function() {
         // 파일 선택 버튼이 있는 영역을 보이지 않게 함 
         $("#fileArea").hide();

         //  영역 클릭 시 파일 첨부창 띄우기
         $("#imgUpload").click(function() {
            $("#img1").click();
         });

      });

      // 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
      function LoadImg(value, num) {

         // 파일 업로드시 업로드된 파일의 경로는
         // 해당 요소에 files라는 배열이 생성되면 저장됨
         if (value.files && value.files[0]) // files라는 배열이 있고, 0번째 인덱스에 값이 있냐?
            // -> 파일이 선택된 경우 
            var reader = new FileReader();

         reader.onload = function(e) {
            // 파일을 다 읽으면 실행해라
            switch (num) {

            case 1:
               $("#titleImg").prop("src", e.target.result);
               break;
            }
         }

         // file에서 내용(Content)을 읽어옴
         // + base64 인코딩된 경로를 반환 (2진법 데이터를 64진법으로 바꾼다.)
         reader.readAsDataURL(value.files[0]);
      }
   </script>

   <script>
      $(function() {
         $("#titleImg").on('change', function() {
            readURL(this);
         });
         console.log("2");
      });
      function readURL(input) {
         if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
               $('#titleImg').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
         }
         console.log("1");
      }
   </script>



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