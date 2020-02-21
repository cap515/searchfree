<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.kh.searchfree.admin.model.vo.Category1"%>
<%@page import="com.kh.searchfree.admin.model.vo.Category2"%>
<%@page import="java.util.List"%>

<%
	List<Category1> category1List = (List<Category1>)request.getAttribute("category1List");
	List<Category2> category2List = (List<Category2>)request.getAttribute("category2List");
	String category1Code = (String)request.getAttribute("category1Code");
%>

<!doctype html>
<html class="no-js" lang="ko">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Directory</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>


<!-- CSS here -->
<!--     
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css"> 
    -->
<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>

	<script>
	<%-- <%for(Category1 cg1: category1List) {%>
	console.log("<%= cg1 %>");
		<% for(Category2 cg2: category2List){
			if(cg2.getCategory1Code()==cg1.getCategory1Code()) {
		%>
				console.log("<%= cg2 %>");
		<% }
		} %>
	<% } %>
	console.log("<%=category1Code%>"); --%>
</script>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
	<!-- header-start -->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<!-- header-end -->
	<!-- bradcam_area  -->
	<div class="bradcam_area bradcam_bg_2">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="bradcam_text text-center">
						<h3>Join us</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ bradcam_area  -->

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area section-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 posts-list">
					<div class="comment-form">
						<form class="form-contact comment_form"
							action="<%= request.getContextPath()%>/member/signUp.do"
							id="commentForm" onsubmit="return validate();">
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* ID :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputId"
											id="inputId" type="text" placeholder="4~16글자 사이 영문, 숫자로 입력해주세요.">
									</div>
								</div>
								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkId"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 닉네임 :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputNick"
											id="inputNick" type="text" placeholder="4~16글자 사이 영문, 숫자로 입력해주세요.">
									</div>
								</div>

								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkNick"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 이메일 :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputEmail"
											id="inputEmail" type="text" placeholder="이메일 주소를 입력해주세요.">
									</div>
								</div>
								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkEmail"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 비밀번호 :</p>
									</div>
								</div>
								<div class="col-5">
									<div class="form-group">
										<input class="form-control position-rela" name="inputPwd"
											id="inputPwd" type="password" placeholder="영문소문자,숫자 6~12글자">
									</div>
								</div>

								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkPwd1"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 비밀번호 확인 :</p>
									</div>
								</div>
								<div class="col-5">
									<div class="form-group">
										<input class="form-control position-rela" name="inputPwd2"
											id="inputPwd2" type="password" placeholder="비밀번호 재입력.">
									</div>
								</div>

								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkPwd2"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 이름 :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputNm"
											id="inputNm" type="text" placeholder="이름을 입력해주세요.">
									</div>
								</div>

								<div class="col-2 text-left"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>전화번호 :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputPhone"
											id="inputPhone" type="text" placeholder="숫자만 입력해주세요.">
									</div>
								</div>

								<div class="col-3">
									<div class="form-group text-left">
										<p id="checkPhone"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>지역 :</p>
									</div>
								</div>
								<div class="col-2">
									<div class="form-group">
										<div class="default-select">
											<select id="inputAddr1" name="inputAddr1">
												<option value="서울시">서울시</option>
												<option value="경기도">경기도</option>
												<option value="제주시">제주시</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<div class="default-select">
											<select id="inputAddr2" name="inputAddr2">
												<option value="강남구">강남구</option>
												<option value="어쩌구">어쩌구</option>
												<option value="저쩌구">저쩌구</option>
												<option value="구구구">구구구</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-2 text-left"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 계좌번호 :</p>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<input class="form-control position-rela" name="inputAccount"
											id="inputAccount" type="text" placeholder="계좌번호를 입력해주세요.">
									</div>
								</div>

								<div class="col-2 text-left"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<div class="form-group text-right">
										<p>* 관심분야 선택 :</p>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<div class="default-select">
											<select id="inputCategory1" name="inputCategory1">
												<option value='0'>1차 카테고리 선택</option>
												<% for(Category1 cg1: category1List) { %>
												<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
												<% } %>
											</select>
										</div>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<div class="default-select">
											<select id="inputCategory2" name="inputCategory2">
												<option value='0'>2차 카테고리 선택</option>
											</select>
										</div>
									</div>
								</div>
							</div>
					</div>
					<div class="form-group text-center">
						<button type="submit"
							class="button button-contactForm btn_1 boxed-btn">Send
							Message</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		</div>
	</section>
	<!--================ Blog Area end =================-->

	<!-- footer start -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	<!--/ footer end  -->

<script type="text/javascript">
	
	$(function(){
		$("#inputCategory1").change(function(){
			var $selectBody = $("#inputCategory2");
			var $selectDiv = $selectBody.next(); // 카테2 옵션 1개
			var $selectList = $selectDiv.find(".list"); // 자손중 .list 클래스인 요소 모두
			var $selectSpan = $selectDiv.find("span"); // 자손중 span 태그 모두 
			
			var $target = $("select[name='inputCategory2']"); // select 태그 중 이름이 inputcategory2 인 요소 target에 저장
			console.log("select1"+$selectBody.html()); // inputCategory2 요소 태그까지
			console.log("select2"+$target.html()); // inputCategory2 요소 태그까지
			var input = $("#inputCategory1").val(); // inputCategory1 선택한 값 
			$.ajax({
				url : "./AjaxCategory1code.do",
				type : "post",
				dataType : "json",
				data : {input : input}, // input 키 , value 로 input  // inputCategory1 선택한 값
				success:function(list){
					//console.log(list);
					
					var $result;
					var $resultLi;
					$selectList.find('li').remove();
					$selectBody.find('option').remove();
					$.each(list, function(i){
						
						$result = "";
						$result += "<option value=\"" + list[i].category2Code + "\">" + list[i].category2NM + "</option>";
						$resultLi = "";
						$resultLi += "<li data-value=\"" + list[i].category2Code + "\" class=\"option\">" 
									+ list[i].category2NM + "</option>";
						
						$selectBody.append($result);
						$selectList.append($resultLi);
					});
				},
				error:function(){
					console.log("ajax 통신 실패");
				}
			});
		});
	})
</script>
<script>
// 각 유효성 검사 결과를 저장할 객체
	var signUpCheck = { 
		"id":false,
		"idDup":false,
		"nick":false,
		"nickDup":false,
		"pwd1":false,
		"pwd2":false,
		"phone":false,
		"name":false,
		"email":false
	};
	
	
	var $id = $("#inputId");
	var $pwd1 = $("#inputPwd");
	var $pwd2 = $("#inputPwd2");
	var $nick = $("#inputNick");
	var $phone = $("#inputPhone");
	var $email = $("#inputEmail");
	var $name = $("#inputNm");
	var $idDup = $("#idDupCheck");
	var $nickDup = $("#nickDupCheck");
    
 	// 실시간 입력 형식 검사
	// 정규표현식
	$(function(){
		
		// jQuery 변수 : 변수에 직접적으로 jQuery메소드를 사용할 수 있음.
	
		
		// 아이디  유효성 검사
		// 영어 대,소문자 + 숫자, 총 6~12글자
		
		$id.on("input",function(){
			var regExp = /^[a-zA-z\d]{4,16}$/;
			if(!regExp.test($id.val())){
				
				$("#checkId").text("아이디 형식이 유효하지 않습니다.")
				.css("color","red");
				
				signUpCheck.id = false;
			} else {
				$("#checkId").text("아이디 형식이 유효합니다.")
				.css("color","green");
				
				signUpCheck.id = true;

				$.ajax({
					url : "idDupCheck.do",
					type : "get",
					data : {id : $id.val()},
					success : function(result){
						console.log("iddupclick");
						if(result == "yes"){
							$("#checkId").text("사용 가능한 아이디 입니다.")
							.css("color","green");
							
							signUpCheck.idDup = true;
						}else{
							$("#checkId").text("사용할 수 없는 아이디 입니다.")
							.css("color","red");
							signUpCheck.idDup = false;
						}
					},
					error : function(e){
						console.log("아이디 중복검사 Ajax 실패");
						console.log(e);
					}
				});
				return false;
			}
		});
		
		// 닉네임  유효성 검사
		// 영어 대,소문자 + 숫자, 총 6~12글자
		$nick.on("input",function(){
			var regExp = /^[a-zA-z\d]{4,16}$/;
			if(!regExp.test($nick.val())){
				
				$("#checkNick").text("닉네임 형식이 유효하지 않습니다.")
				.css("color","red");
				
				signUpCheck.nick = false;
			} else {
				$("#checkNick").text("닉네임 형식이 유효합니다.")
				.css("color","green");
				
				signUpCheck.nick = true;

				$.ajax({
					url : "nickDupCheck.do",
					type : "get",
					data : {id : $nick.val()},
					success : function(result){
						console.log("iddupclick");
						if(result == "yes"){
							$("#checkNick").text("사용 가능한 닉네임 입니다.")
							.css("color","green");
							
							signUpCheck.nickDup = true;
						}else{
							$("#checkNick").text("사용할 수 없는 닉네임 입니다.")
							.css("color","red");
							signUpCheck.nickDup = false;
						}
					},
					error : function(e){
						console.log("아이디 중복검사 Ajax 실패");
						console.log(e);
					}
				});
				return false;
			}
		});
		<%--
		// 아이디 중복 체크창 오픈
		$("#idDupCheck").click(function(){
			window.open("idDupForm.do","idDupForm","width=300, height=200");
			//			   팝업 창 주소		팝업창 이름		설정
		})
		--%>
		
		// 비밀번호  유효성 검사
		//소문자 + 숫자 + 특수문자, 총 6~12글자
		
		$pwd1.on("input",function(){
			var regExp = /^[a-z0-9]{6,12}$/;
			if(!regExp.test($pwd1.val())){
				$("#checkPwd1").text("비밀번호 형식이 유효하지 않습니다.").css("color","red");
				signUpCheck.pwd1 = false;
			} else {
				$("#checkPwd1").text("유효한 형식의 비밀번호 입니다.").css("color","green");
				signUpCheck.pwd1 = true;
			}
		});
		
		// 비밀번호 일치 여부
		$pwd2.on("input",function(){
			if($pwd1.val().trim() != $pwd2.val().trim()){
				$("#checkPwd2").text("비밀번호가 일치하지 않습니다.").css("color","red");
				signUpCheck.pwd2 = false;
			}else{
				$("#checkPwd2").text("비밀번호가 일치합니다.").css("color","green");
				signUpCheck.pwd2 = true;
			}
		});
		
		// 전화번호 관련
	 	$phone.on("input",function(){
	 		var regExp = /^01[0169][0-9]{7,8}$/;
			if(!regExp.test($phone.val())){
				$("#checkPhone").text("전화번호 형식이 유효하지 않습니다.").css("color","red");
				signUpCheck.phone = false;
			} else {
				$("#checkPhone").text("유효한 형식의 전화번호 입니다.").css("color","green");
				signUpCheck.phone = true;
			}
		});
		
		
		// 이메일 유효성 검사
		$email.on("input",function(){
			var regExp =  /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
			if(!regExp.test($email.val())){
				$("#checkEmail").text("이메일 형식이 유효하지 않습니다.").css("color","red");
				signUpCheck.email = false;
			} else {
				$("#checkEmail").text("유효한 형식의 이메일 입니다.").css("color","green");
				signUpCheck.email = true;
			}
		});
		
	
		
		
	});
 	 	
	// submit 동작
	function validate(){
		
		// 아이디 중복 검사 결과
		console.log(signUpCheck)
		if( $name.val() != null)	signUpCheck.name = true;
		else				  		signUpCheck.name = false;
		
		for(var key in signUpCheck){
			if(!signUpCheck[key]){
				console.log(key);
				alert("일부 입력값이 잘못되었습니다.");
				var id = "#"+key;
				$(id).focus();
				return false;
			}
		}
	}
	
</script>


	<!-- JS here -->
	<!-- 
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
 -->
	<!--contact js-->
	<!-- 
<script src="js/contact.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>

<script src="js/main.js"></script>
 -->
</body>

</html>