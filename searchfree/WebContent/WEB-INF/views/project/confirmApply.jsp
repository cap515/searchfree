<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.kh.searchfree.project.model.vo.VProjectApply,
com.kh.searchfree.project.model.vo.MemberStar" %>
<% 
	List<VProjectApply> aList = (List<VProjectApply>)request.getAttribute("aList");
	List<MemberStar> mStarList = (List<MemberStar>)request.getAttribute("mStarList");
	int memberAvgStar = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Read</title>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Directory</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/resources/img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/themify-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/nice-select.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/gijgo.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/animate.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slick.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/projectRead.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->


</head>

<body>
    <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->
   
    <section class="project_area section-padding">
        <div class="container">
            <div class="row bigSand_border">
                <!-- Project Title start -->
                <div class="col-lg-12 mb-5 mb-lg-0">
                    <div class="bigSand_project_title bigSand_text text-center" style="height:100px;">
                        <h4 style="line-height:100px; padding:0px 0px 0px 0px;">신청자 목록</h4>
                    </div>
                </div>
                <!-- Project Title end -->
             
                <div class="col-lg-12 mb-5">
                <% if(aList == null){ %>
                	<span>지원자가 없습니다.</span>
                <%} else{
                		for(VProjectApply projectApply : aList){%>
                    <div class="col-lg-12 mb-5 mb-lg-0 bigSand_right_profile">
                        <div class="bigSand_popup_profile_ico">
                            <img src="/img/test/profile_icon.png" alt="">
                        </div>
                        <div class="bigSand_popup_profile_name select_freelancer_nick">
                            <h5 class="memberNick"><%=projectApply.getMemberNick() %></h5>
                        </div>
                        <div class="bigSand_popup_profile_button">
                            <a href="#" class="bigSand_genric-btn btn1">프로필 조회</a>
                            <a href="#" class="bigSand_genric-btn btn1 select_freelancer">지원자 선택</a>
                        </div>
                        <div class="bigSand_star_rating">
                            &nbsp;&nbsp;
                            <% for(MemberStar memberStar : mStarList){
                            	if(projectApply.getMemberNo() == memberStar.getMemberNo()){
 									memberAvgStar = memberStar.getStar();	                           		
                            	}
                            }
                             %>
                            <input type="number" class="star_point" name="star_point" value="<%=memberAvgStar%>"
                                readonly>
                        </div>
                    </div>
                    <%} }%>
                </div>
            </div>
            <div class="bigSand_content_btns">
                <a href="#" class="bigSand_genric-btn btn3" onclick="window.close();">목록으로</a>            
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->

    <!-- link that opens popup -->
    <!-- JS here -->
    <script src="<%=request.getContextPath() %>/resources/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/vendor/jquery-1.12.4.min.js"></script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> </script>
    <script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/ajax-form.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/waypoints.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.counterup.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/imagesloaded.pkgd.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/scrollIt.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.scrollUp.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/wow.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/nice-select.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.slicknav.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.magnific-popup.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
    <!-- <script src="js/gijgo.min.js"></script> -->
    <script src="<%=request.getContextPath() %>/resources/js/slick.min.js"></script>



    <!--contact js-->
    <script src="<%=request.getContextPath() %>/resources/js/contact.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.ajaxchimp.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/mail-script.js"></script>
    <%-- <script src="<%=request.getContextPath() %>/resources/js/userJs.js"></script> --%>


    <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>


    <script>
    	/* var projectNo = opener.document.getElementById("projectNo").value;

    	document.getElementById("id").value = projectNo; */
    	
        $(function(){
            var star_ratings = $('.star_point');
            console.log(star_ratings[0]);
            console.log(star_ratings + ", " + star_ratings[0] + ", " +  star_ratings[0].value);
            for(var i = 0; i < star_ratings.length; i++){
                var text = "<span>";
                for(var j = 0; j < 5; j++){
                    if(j < star_ratings[i].value)
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
    	$(".select_freelancer").on("click",function(){
            confirm("선택하시겠습니까?");
    	})
       
        
        
        
        
    </script>


</body>

</html>