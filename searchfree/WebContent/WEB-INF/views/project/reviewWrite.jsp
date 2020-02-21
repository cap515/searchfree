<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int projectNo = (Integer)request.getAttribute("projectNo");
	int memberNo = (Integer)request.getAttribute("memberNo");
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
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
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

    <!-- summer note css -->
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet"> -->

</head>

<body>
	<script>console.log("<%=projectNo%>")</script>
    <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

    <!-- bradcam_area 
        <div class="bigSand_area bigSand_bg_2">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="bigSand_text text-center">
                            <h3>Category name</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        / bradcam_area  -->
    <!--================Blog Area =================-->



    <section class="project_area section-padding">
        <div class="container">
        	<form action="insertReivew?no=<%=projectNo %>" method="POST">
            	<div class="row bigSand_border">
                <!-- Project Title start -->
                
	                <div class="col-lg-12 mb-1 mb-lg-0">
	                    <div class="bigSand_project_title bigSand_text text-center" style="height:100px;">
	                        <h4 style="line-height:100px; padding:0px 0px 0px 0px;">Write Review</h4>
	                    </div>
	                </div>
	                <!-- Project Title end -->
	             	
	                <div class="col-lg-12 mb-5">
	                    <p style="margin-bottom: 0px;">리뷰 내용</p>
	                    <div style="margin-bottom: 10px;">
	                        <a href="#" class="starr" style="color:#f91842; text-decoration: none;" onclick="return false;">★</a>
	                        <a href="#" class="starr" style="color:#f91842; text-decoration: none;" onclick="return false;">☆</a>
	                        <a href="#" class="starr" style="color:#f91842; text-decoration: none;" onclick="return false;">☆</a>
	                        <a href="#" class="starr" style="color:#f91842; text-decoration: none;" onclick="return false;">☆</a>
	                        <a href="#" class="starr" style="color:#f91842; text-decoration: none;" onclick="return false;">☆</a>
		
	                        <input type="number" class="star_point" name="star_point" style="width:40px;"
	                        id="star_point" readonly style="margin-left: 10px;" name="star_point" value="1">
	                    </div>
	                    <!-- 내용 작성 부분 -->
	                    <textarea name="review_content" id="review_content" rows="10" style="resize:none;width:100%"></textarea>
	                    
	                </div>
           		</div>
	            <div class="bigSand_content_btns">
	                <a href="#" class="bigSand_genric-btn btn3" onclick="window.close();">취소</a>
	                <button class="bigSand_genric-btn btn3">리뷰 등록</button>
	            </div>
            </form>
        </div>
    </section>
    <!--================Blog Area =================-->

    <!-- link that opens popup -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> </script>
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
    <script src="js/userJs.js"></script>


    <script src="js/main.js"></script>

    <!-- summernote js -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>

    <script type="text/javascript">
        var stars = $(".starr");
        var rating = 0;
        console.log("stars : " + stars[0]);
        $(function(){
            $(".starr").on("click",function(){
                for(var i = 0; i < 5; i++){
                    stars[i].innerHTML="☆";
                    if(this == stars[i]){
                        rating = i+1;
                        console.log(rating);
                    }
                }
                for(var i = 0; i < rating; i++){
                    stars[i].innerHTML="★";
                }
                $("#star_point").val(rating);
                console.log(rating);
   			});
        });
    </script>


</body>

</html>