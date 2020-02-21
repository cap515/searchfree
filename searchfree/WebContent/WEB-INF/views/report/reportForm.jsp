<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// Object 타입이라서 형 변환 해줘야 함
	int report_code1 = -1;
	if(request.getParameter("report_code1") != null){
		report_code1 = Integer.parseInt(request.getParameter("report_code1"));
	}
	int toReportNo = -1;
	if(request.getParameter("toReportNo") != null){
		toReportNo = Integer.parseInt(request.getParameter("toReportNo"));
	}
	// 서버 첫 시작시 request.getCookies()의 값이 null
	// -> if문으로 처리하지 않는 경우 페이지 로딩 시 NullPointException 발생됨
%>
<!DOCTYPE html>
<html class="node-js" lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Project Read</title>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Directory</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/projectUpload.css">
    <link rel="stylesheet" href="css/projectRead.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- summer note css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet">

</head>

<body>
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
        <form action="./report" method="post">
            <div class="row bigSand_border">
                <!-- Project Title start -->
                
	                <div class="col-lg-12 mb-5 mb-lg-0">
	                    <div class="bigSand_project_title bigSand_text text-center" style="height:100px;">
	                        <h4 style="line-height:100px; padding:0px 0px 0px 0px;">REPORT</h4>
	                    </div>
	                </div>
	                
	                <!-- Project Title end -->
	             	<input type="number" name="toReportNo" value="<%= toReportNo %>"style="display:none">
	                <div class="col-lg-12 mb-5">
	                   <select name="report_code1" id="report_code1" style="width:25%;height:30px;" required readonly >
	                       <option value="10" <%if(report_code1 == 10){%>selected<%}%> disabled="disabled">댓글 신고</option>
	                       <option value="20" <%if(report_code1 == 20){%>selected<%}%> disabled="disabled">리뷰 신고</option>
	                       <option value="30" <%if(report_code1 == 30){%>selected<%}%> disabled="disabled">쪽지 신고</option>
	                       <option value="40" <%if(report_code1 == 40){%>selected<%}%> disabled="disabled">프로젝트 신고</option>
	                       <option value="50" <%if(report_code1 == 50){%>selected<%}%> disabled="disabled">회원 신고</option>
	                    </select>
	                    <select name="report_code2" id="report_code2" style="width:25%;height:30px;" required >
	                        <option value="1">욕설</option>
	                        <option value="2">광고</option>
	                        <option value="3">부적절한 컨텐츠</option>
	                     </select>
	                    <br><br>
	                   <input type="text" name="report_title" style="width:100%" placeholder="제목을 입력해주세요">
	                   <br><br>
	                   <textarea name="report_content" id="report_content" rows="10" style="resize:none; width:100%" placeholder="신고 내용을 입력해주세요"></textarea>
	                </div>
                
            </div>
            <div class="bigSand_content_btns">
                <button class="bigSand_genric-btn btn3">보내기</button>
                <a href="#" class="bigSand_genric-btn btn3">취소</a>
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
    <script src="js/gijgo.min.js"></script>
    <script src="js/slick.min.js"></script>



    <!-- contact js -->
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
</body>
	<script>
		console.log("<%=toReportNo%>");
	</script>
</html>