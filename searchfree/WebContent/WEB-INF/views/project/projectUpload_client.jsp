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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Upload</title>
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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/projectUpload.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/projectRead.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->


</head>

<body>
    <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

    <!-- header-start -->
    <%@include file="../common/header.jsp" %>
   
    <section class="project_area section-padding">
        <div class="container">
                <form id="form1" class="bigSand_project_form" method="POST" action="<%=request.getContextPath()%>/project/insert_client" enctype="multipart/form-data">
            		<div class="row bigSand_border">
                    <!-- Project Title start -->
                    <div class="col-lg-12 mb-5 mb-lg-0">
                        <div class="bigSand_project_title bigSand_text text-center">
                            <input type="text" class="bigSand_project_inputitle" name="projectTitle" placeholder="input Title" required>
                        </div>
                    </div>
                    <!-- Project Title end -->
                    <div class="col-lg-7 mb-5 mb-lg-0">
                        <div class="blog_left_sidebar">
                            <article class="blog_item">
                                <div class="blog_item_img bigSand_project_image_div" id="titleImgArea">
                                    <img id="bigSand_project_image" alt="your image" class="card-img rounded-0"
                                    width="300" height="352"><br><br>
                                    <input type="file" id="fileArea" name="thumbnailImg" onchange="LoadImg(this,1)"
                                    accept="image/png, image/jpeg" id="bigSand_input_imagefile" alt="" required>
                                </div>
                                <div class="blog_details bigSand_project_explanation">
                                    <span class="bigSand_project_explanation_text">프로젝트 한줄 소개</span><br>
                                    <textarea name="projectSummary" id="" rows="6" required></textarea>
                                </div>
                            </article>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="blog_right_sidebar">
                            <div class="bigSand_category">
                            <!-- 가운데 -->
                            <div >
                                    <div class="bigSand_category_label">
                                        <label for="inputCategory1">1차 카테고리 선택</label>
                                    </div>
                                    <div class="bigSand_category_select">

                                        <select name="inputCategory1" id="inputCategory1" class="bigSand_first_category bigSand_category_select_select">
                                            <option value='0'>1차 카테고리 선택</option>
											<% for(Category1 cg1: category1List) { %>
											<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
											<% } %>
                                        </select>
                                    </div>
                                
                                
                                <div>
                                    <div class="bigSand_category_label">
                                        <label for="inputCategory2">2차 카테고리 선택</label>
                                    </div>
                                    <div class="bigSand_category_select">
                                        <select name="inputCategory2" id="inputCategory2" class="bigSand_second_category bigSand_category_select_select">
                                            <option value='0'>2차 카테고리 선택</option>
                                        </select>
                                    </div>
                                </div>
                                </div>
                                
                                <br>
                            </div>
                            <div class="bigSand_project_info">
                                <div class="bigSand_project_schedule">
                                    <div class="bigSand_schedule_wrapper">
                                        <input type="date" class="bigSand_schedule_dateForm" name="projectStartDate"
                                            id="bigSand_schedule_start" value="" required>
                                        <span>~</span>
                                        <input type="date" class="bigSand_schedule_dateForm" name="projectExpiredDate"
                                            id="bigSand_schedule_start" value="" required>
                                    </div>
                                </div>
                                <div class="bigSand_project_price">
                                    <div class="bigSand_price_wrapper">
                                        <span>￦ </span>
                                        <input type="number" class="bigSand_price_input" name="projectPrice" id="bigSand_price_input" 
                                        value="" placeholder="Price" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 mb-5 mb-lg-0">
                        <div class="bigSand_hr"></div>
                        <div class="bigSand_summernote_margin">
                            <h2>클라이언트 프로젝트 의뢰</h2><br>
                            <!-- summer note start -->
                            <textarea name="projectContent" id="summernote" required></textarea>
                            <script>
                            $('#summernote').summernote({
                                placeholder: '내용을 입력해주세요',
                                tabsize: 2,
                                height: "auto"
                            });
                            </script>
                            <!-- summer note end -->
                        </div>
                        <div class="bigSand_hr"></div>
                    </div>
                    <div class="col-lg-12 bigSnad_upload_btns">
                        <div class="bigSand_comment_btns">
                           <!-- <a href="" class="bigSand_genric-btn btn1 bigSand_upload_btn_resizing">등록</a> -->
                            <button type="submit" class="bigSand_genric-btn btn1 bigSand_upload_btn_resizing">의뢰 등록</button>
                        </div>
                    </div>
                    
        			</div>
                </form>
            </div>
    </section>
    
    <script>
    	/* $(function (){
    		$("#fileArea").hide();
    		
    		$("#bigSand_project_image").click(function(){
				$("#fileArea").click(); 
				// 매개변수가 없는 click()은 '클릭해라'라는 의미
			});
    	}); */
    	
	    // 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
	    function LoadImg(value, num) {
	    	
	    	// multiple 속성을 사용하면 사진이 배열의 형태로 올라옴
	    	// 파일 업로드 시 업로드 된 파일의 경로는 files라는 배열이 생성되면 저장됨 
	    	// files라는 배열이 있고 value.files[0]에 값이 있는지 확인
	    	// : 파일이 선택된 경우를 말함
	    	if(value.files && value.files[0]){
	    		var reader = new FileReader();
	    		// 파일을 읽어들임
	    		
	    		reader.onload = function(e){
	    			
	    			$("#bigSand_project_image").prop("src",e.target.result);
	    			// e.target.result -> reader.onload한 이벤트 즉 파일 경로가 추가됨
	    			
	    		}
	    		// file에서 내용(content)을 읽어옴
	    		// +base64 인코딩된 경로를 반환
	    		reader.readAsDataURL(value.files[0]);
	    	}
	    }
    </script>
    <!--================Blog Area =================-->

    <!-- footer start -->
    <%@ include file="../common/footer.jsp"%>
    <!--/ footer end  -->



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
<script type="text/javascript">
	
	
		$("#inputCategory1").change(function(){
			var $selectBody = $("#inputCategory2");
			var $selectDiv = $selectBody.next();
			var $selectList = $selectDiv.find(".list"); 
			var $selectSpan = $selectDiv.find("span");
			
			var $target = $("select[name='inputCategory2']");
			console.log("select1"+$selectBody.html());
			console.log("select2"+$target.html());
			var input = $("#inputCategory1").val();
			$.ajax({
				url : "../member/AjaxCategory1code.do",
				type : "post",
				dataType : "json",
				data : {input : input},
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
	
</script>
    <script>
        $(function() {
            $("#bigSand_input_imagefile").on('change', function(){
                readURL(this);
            });
            console.log("2");
        });
        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#bigSand_project_image').attr('src', e.target.result);
                }
              reader.readAsDataURL(input.files[0]);
            }
            console.log("1");
        }
        $(function(){
            $("#bigSand_price_input").keydown(function(){
                var inputLength = ($("#bigSand_price_input").val().length + 0) * 13.3 + "px";
                console.log(inputLength);
                $("#bigSand_price_input").css("width",inputLength);
            });
        });
        var inputTagHtml = '<input type="text" name="project_tag" class="project_tag">';

        $("#bigSand_add_tag").click(function(){
                $(this).parents(".bigSand_project_tag").append(inputTagHtml);
        });
        
        
        function tag_length(){
            var inputLength = ($(this).val().length + 0) * 9.8 + "px";
            console.log(inputLength);
            if(((this).val().length + 0) * 9.8 > 60)
                $(this).css("width",inputLength);
        }
        
        
    </script>
</body>

</html>