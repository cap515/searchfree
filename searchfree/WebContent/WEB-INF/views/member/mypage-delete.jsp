<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>MyMemberWithdrawal</title>
    <!-- script -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>


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
                    <div class="col-lg-3" >
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
                                    <a href="#" class="d-flex">
                                        <p>결제내역</p>

                                    </a>
                                </li>

                            </ul>
                        </aside>



                        </div> <!-- 사이드바 -->
                    </div> <!-- <div class="col-lg-3"> -->
                   
                        <div class="col-lg-9 posts-list">
                          <p>Membership Withdrawal</p>
                          <textarea readonly rows="10" cols="100">
<회웥 탈퇴 확인 사항>

1. 탈퇴 후 회원님이 작성한 프로필 정보, 계정 정보, 프로젝트 정보, 댓글 등 모든 내용이 삭제되며, 추후 재가입하더라도 복구되지 않습니다.

2. 관련 법령에 따라 아래의 종류에 해당하는 기록이 있는 경우, 회원 정보 및 관력 기록을 정해진 기간 동안 보관하며, 보관 기간 내에는 동일한 아이디 및 이메일로 재가입이 불가능합니다.
이후 보관기관이 종료되었을 시 회원 정보 및 관련 기록은 지체 없이 파기됩니다.

(보관정보 종류와 보관기관 안내)
* 소비자의 불만 또는 분쟁처리에 관한 기록 - 3년
* 신용정보의 수집/처리 및 이용 등에 관한 기록 - 3년
* 대금결제 및 재화 등의 공급에 관한 기록 - 5년
* 계약 또는 청약철회 등에 관한 기록 - 5년
* 표시/광고에 관한 기록 - 6개월

                          </textarea>
                            <div class="container" >
                              <form method="POST" action="<%= request.getContextPath() %>/member/deleteMember" onsubmit="return validate()">
                                <div class="row">
                                    <div class="col-xl-4 col-md-4" style="float: left;"></div>
                                    <div class="col-xl-4 col-md-4" style="float: left;">
                                        
                                            <div >
                                                <small>비밀번호</small><br>
                                                <div class="form-group">
                                                <input class="form-control" name="inputPwd" id="inputPwd" type="password" onfocus="this.placeholder = ''" 
                                                onblur="this.placeholder = '비밀번호를 입력하세요'" placeholder = '비밀번호를 입력하세요'>
                                                </div>
                                            </div>
                                        

                                    </div>
                                
                                </div>                               

                                <div class="row" style="display:block ; text-align:center" >
                                    <div>                                        
                                        <button id="click_btnDel" class="genric-btn info-border radius">확인</button>
                                        <a href="mypage" id="click_Enroll" class="genric-btn info-border radius">취소</a>     
                                        <!-- 취소 클릭시 마이페이지 메인으로 이동 -->                                  
                                    </div>    
                                </div>
                            
                                
                                        </form>
                            </div>    <!-- <div class="container"> -->

                        </div> <!-- <div class="col-lg-9"> -->
               </div> 
            </div>
        </section>    


        
        
<%@ include file="../common/footer.jsp" %>

    <script>
       /*  $('#click_btnDel').click(function(){
            var answer = confirm ('탈퇴 하시겠습니까? 탈퇴 시 계정이 삭제됩니다.');
            if(answer){

                
                alert("탈퇴 되었습니다")
            }else{
                alert("탈퇴가 취소 되었습니다!!")
            return false;
            }
        });

        $("#click_Enroll").click(function(){

                $("#pwd")[0].reset();
                

            alert("취소되었습니다.");
            return false
        }); */
	
        function validate(){
        	return confirm("탈퇴 하시겠습니까?")
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