<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" >
        <title>SearchFree</title>
    <meta name="description">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        .back-white{
            background-color: white;
            border-radius: 10px;
        }

        .btn-hei, .btn-hei:hover {
            height: 80px;
            margin-bottom: 50px;
            background-color: #001d38;
            border: 0px  ;
            color: white;
        }

        .btn-hei-line{
            height: 45px;
            line-height: 15px;
        }
        
        .em-btn:hover{
        	background:lightgray !important;
        	color:black !important;
        }
    </style>
<%--	   	  
	  <script src="<%= request.getContextPath()%>/resources/js/vendor/modernizr-3.5.0.min.js"></script>
    	
      <script src="<%= request.getContextPath()%>/resources/js/vendor/jquery-1.12.4.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/popper.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/ajax-form.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/waypoints.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.counterup.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/imagesloaded.pkgd.min.js"></script> 
      <script src="<%= request.getContextPath()%>/resources/js/scrollIt.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/wow.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/nice-select.min.js"></script>
	  <script src="<%= request.getContextPath()%>/resources/js/jquery.slicknav.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/plugins.js"></script>
      <!-- <script <%= request.getContextPath()%>/resources/src="js/gijgo.min.js"></script> -->
      <script src="<%= request.getContextPath()%>/resources/js/slick.min.js"></script>
      
  
  
  
      <!--contact js-->
      <script src="<%= request.getContextPath()%>/resources/js/contact.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.ajaxchimp.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.form.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
      <script src="<%= request.getContextPath()%>/resources/js/mail-script.js"></script>
  
  
      <script src="<%= request.getContextPath()%>/resources/js/main.js"></script>


   

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/magnific-popup.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/nice-select.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/flaticon.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/gijgo.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/animate.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/slick.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/slicknav.css">
    <link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/css/style.css"> --%>
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->

    
</head>

<body>
    <!--[if lte IE 9]>
   	<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
    <![endif]-->
    <%@ include file="WEB-INF/views/common/header.jsp"%>
    <!-- slider_area_start -->
    <div class="slider_area ">
        <div class="single_slider  d-flex align-items-center slider_bg_1" style="height:400px;">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-xl-10">
                        <div class="slider_text text-center justify-content-center">
                            <p></p>
                            <h3>Search Free</h3>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<div class="explorer_europe" style="padding-bottom: 10px; padding-top: 10px;">
	    <div class="container back-white" style="border: 1px solid lightgray;">
	        <div class="explorer_wrap ">
	            <div class="row align-items-center">
	                <div class="col-xl-12 col-md-8">
	                    <div class="explorer_tab">
	                        <nav>
	                            <div class="nav" id="nav-tab" role="tablist" style="text-align:center;">
	                                <a class="nav-item nav-link  active" id="nav-home-tab" data-toggle="tab"
	                                    href="#nav-home" role="tab" aria-controls="nav-home"
	                                    aria-selected="true"  style="width:50%; margin: 0px 0px 0px 0px;">Freelancer</a>
	                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
	                                    href="#nav-profile" role="tab" aria-controls="nav-profile"
	                                    aria-selected="false" style="width:50%; margin: 0px 0px 0px 0px">Client</a>
	                            </div>
	                        </nav>
	
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="tab-content" id="nav-tabContent">
	            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
	                <div class="row">
	                    <div class="col-md-6">
	                        <button type="button" class="btn btn-block btn-hei em-btn"  id="header-tab-btn">
	                            Freelancer 찾기
	                        </button>
	                    </div>
	                    <div class="col-md-6">
	                        <button type="button" class="btn btn-block btn-hei em-btn" id="header-tab-btn">
	                            Freelancer 쓰기
	                        </button>
	                    </div>
	                </div>
	            </div>
	            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
	                <div class="row">
	                    <div class="col-md-6">
	                         
	                        <button type="button" class="btn btn-block btn-hei em-btn"  id="header-tab-btn">
	                            Client 찾기
	                        </button>
	                    </div>
	                    <div class="col-md-6">
	                         
	                        <button type="button" class="btn btn-block btn-hei em-btn"  id="header-tab-btn">
	                            Client 쓰기
	                        </button>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
    <div class="popular_catagory_area" style="padding-bottom: 10px; padding-top: 10px;">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title mb-60 text-center">
                        <p></p>
                        <h3>
                            Categories
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=1">
	                        <div class="thumb">
	                            <img src="resources/img/category1/IT.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
	                            <div class="hover_inner">
	                                <h4>IT</h4>
	                            </div>
	                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
	                    <a href="/searchfree/Search/SearchForm?c1=2">
	                        <div class="thumb">
	                            <img src="resources/img/category1/Design.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
	                            <div class="hover_inner">
	                                <h4>Design</h4>
	                            </div>
	                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=3">
                        <div class="thumb">
                            <img src="resources/img/category1/Marketing.jpg" alt="">
                        </div>
                        <div class="hover_overlay">
                            <div class="hover_inner">
                            	<h4>Marketing</h4>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=4">
	                        <div class="thumb">
	                            <img src="resources/img/category1/Translate.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
	                            <div class="hover_inner">
	                            	<h4>Translate</h4>
	                            </div>
                        	</div>
                       	</a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=5">
	                        <div class="thumb">
	                            <img src="resources/img/category1/Consulting.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
	                            <div class="hover_inner">
	                            	<h4>Consulting</h4>
	                            </div>
	                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=6">
	                        <div class="thumb">
	                            <img src="resources/img/category1/Fortune.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
	                            <div class="hover_inner">
	                            	<h4>Fortune</h4>
	                            </div>
	                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=7">
	                        <div class="thumb">
	                            <img src="resources/img/category1/Lesson.jpg" alt="">
	                        </div>
	                        <div class="hover_overlay">
		                    	<div class="hover_inner">
	                           		<h4>Lesson</h4>
	                            </div>
	                        </div>
                        </a>
                    </div>
                </div>
                <div class="col-xl-3 col-md-4 col-lg-3">
                    <div class="single_catagory">
                    	<a href="/searchfree/Search/SearchForm?c1=8">
                        <div class="thumb">
                            <img src="resources/img/category1/Guitar.jpg" alt="">
                        </div>
                        <div class="hover_overlay">
                            <div class="hover_inner">
                               	<h4>Guitar</h4>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@ include file="WEB-INF/views/common/footer.jsp"%>
</body>
	
</html>