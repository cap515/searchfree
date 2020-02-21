<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.searchfree.member.model.vo.Member"%>
<%@ page import="com.kh.searchfree.member.model.vo.Portfolio"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>MyProfileEdit</title>
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
<script>
	</script>
	<!-- header-start -->
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!-- header-end -->
<body>
	<!-- bradcam_area  -->
	<div class="bradcam_area bradcam_bg_2">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text text-center">
						<h3>portpolio</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->
	
<section class="body-content">
		<div class="container">
			<div class="row">
<form id="articleForm" role="form" method="post"
<%-- <% 
String action = "";
 if((checkDelete==0) && (selectTitle==null)){
action = "/member/insertPortpolio";
}else if( (checkDelete==0) && (selectTitle !=null) ){
action = "/member/updatePortfolio";
}else if(checkDelte==1){
	action = "/member/updatePortfolio";ㄹ
}
%> --%>
 action="<%=request.getContextPath()%>/member/updatePortfolio">
	

  <br style="clear: both">
  <h3 style="margin-bottom: 25px;">Article Form</h3>
  <div class="form-group">
    <input type="text" class="form-control" id="subject" name="subject" placeholder="subject" required>
  </div>
  <div class="form-group">
    <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="140" rows="7"></textarea>
  </div>
  <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Submit Form</button>
</form>

</div>
</div>
</section>


	
	<script type="text/javascript">
    $(document).ready(function() {
      $('#summernote').summernote({
    	  tabsize : 2,
   	    width : 1200,
        height: 300,
        minHeight: null,
        maxHeight: null,
        focus: true,
        callbacks: {
          onImageUpload: function(files, editor, welEditable) {
            for (var i = files.length - 1; i >= 0; i--) {
              sendFile(files[i], this);
            }
          }
        }
      });
    });
    
    function sendFile(file, el) {
      var form_data = new FormData();
      form_data.append('file', file);
      $.ajax({
        data: form_data,
        type: "POST",
        url: '/image',
        cache: false,
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
        success: function(url) {
          $(el).summernote('editor.insertImage', url);
          $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
        }
      });
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

	<footer>
		<%@ include file="../common/footer.jsp"%>
	</footer>



</body>

</html>