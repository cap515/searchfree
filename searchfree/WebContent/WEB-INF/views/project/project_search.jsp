<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.kh.searchfree.admin.model.vo.Category1"%>
<%@page import="com.kh.searchfree.admin.model.vo.Category2"%>
<%@page import="com.kh.searchfree.search.model.vo.SearchValue"%>
<%@page import="com.kh.searchfree.search.model.vo.SearchResult"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>

<%
	List<Category1> category1List = (List<Category1>)request.getAttribute("category1List");
	List<Category2> category2List = (List<Category2>)request.getAttribute("category2List");
	String category1Code = (String)request.getAttribute("category1Code");
	SearchValue sv = (SearchValue)request.getAttribute("searchValue");
	List<SearchResult> rList = (List<SearchResult>)request.getAttribute("rList");
	String realPath = application.getRealPath("/");
	int[] status = {0,0,0};
%>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Directory</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<!--     
	<link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    Place favicon.ico in the root directory

    CSS here
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
 -->
 
	<style>
		.alt_radio input{
			width: 15% !important;
			height: 30% !important;
			vertical-align: middle;
			line-height:50px;
		}
		.prj_thumb img{
			width:350px !important;
			height:180px !important;
		}
	</style>
</head>

<body>

    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <%@ include file="../common/header.jsp"%>
    <!-- header-end -->
	
    <!-- slider_area_start -->
    <div class="slider_area">
        <div class="single_slider  d-flex align-items-center slider_bg_1">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-xl-10">
                        <div class="slider_text text-center justify-content-center">
                            <div style="padding-top: 90px;">
                                <h3>Search !</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider_area_end -->



    <!-- explorer_europe start  -->
    <div class="explorer_europe list_wrap">
        <div class="container">
            <div class="row">
                <div class="col-xl-12 col-lg-12">
                    <div class="filter_wrap">
                        <h3 class="exp_title">고급 검색</h3>
	                        <form action="SearchForm" method="GET">
	                        	<% if(sv != null) { %>
	                        	<div class="filter_main_wrap">
	                        		<div class="input_field col-xl-4 col-lg-4" style="width:20%">
                                        <select class="wide" id="search_area" name="search_area">
                                        	
                                            <option value="1" <% if(sv.getKeywordRange() == 1) { %>selected<% } %>>제목</option>
                                            <option value="2" <% if(sv.getKeywordRange() == 2) { %>selected<% } %>>닉네임</option>
                                            <option value="3" <% if(sv.getKeywordRange() == 3) { %>selected<% } %>>제목+닉네임</option>
                                        </select>
                                    </div>
		                            <div class="filter_inner">
	                                    <div class="input_field" style="width:80%">
	                                        <input type="text" name="search_text" placeholder="What are you finding?"
	                                        <% if(sv.getKeyword() != null) { %>value="<%=sv.getKeyword()%>"<% } %>>
	                                        <!-- <button class="submit_btn" type="submit"> <i class="fa fa-search"></i> </button> -->
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" id="inputCategory1" name="c1">
	                                            <option value='0'>1차 카테고리 선택</option>
												<% for(Category1 cg1: category1List) { %>
													<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
												<% } %>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" id="inputCategory2" name="c2">
	                                            <option value='0'>2차 카테고리 선택</option>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" name="member_grade">
	                                            <option value="1"<%if(sv.getMemberGrade()==1){ %>selected<%} %>>GENERAL</option>
	                                            <option value="2"<%if(sv.getMemberGrade()==2){ %>selected<%} %>>PRIME</option>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-6 col-lg-6" style="width:50%">
	                                        <input type="date" name="s_date" style="width: 47%; font-size: 0.8rem;"
	                                        <% if(sv.getStartDate() != null) { %>value="<%=sv.getStartDate()%>"<% } %>> - 
	                                        <input type="date" name="e_date" style="width: 47%; font-size: 0.8rem;"
	                                        <% if(sv.getExpiredDate() != null) { %>value="<%=sv.getExpiredDate()%>"<% } %>>
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4" style="width:30%">
	                                        <div class="inner">
	                                        	<%for(int i : sv.getProjectStatus()){
													status[i-1]=1;
	                                        	}%>
	                                        	<script>
	                                   				<%for(int j = 0; j < 3; j++) { %>
	                                        		console.log("j[<%=j%>] = <%=status[j]%>");
	                                        		<% } %>
	                                        	</script>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit1" name="status1" value="1"
	                                                <% if(status[0]  == 1 ) { %> checked <% } %>>
	                                                <label for="fruit1">진행전</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit2" name="status2" value="2"
	                                                <% if(status[1]  == 1 ) { %> checked <% } %>>
	                                                <label for="fruit2">진행중</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit3" name="status3" value="3"
	                                                <% if(status[2]  == 1 ) { %> checked <% } %>>
	                                                <label for="fruit3">완료</label>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <script>
	                                    	console.log("user_alt : <%= sv.getUser_alt() %>");
	                                    </script>
	                                    <div class="input_field col-xl-2 col-lg-2 alt_radio" style="width:20%">
	                                        <input type="radio" name="user_alt" id="user_alt1" value="1" 
	                                        <% if(sv.getUser_alt() == 1) { %> selected <%}%>>
	                                        <label for="user_alt1">프리</label>
	                                        <input type="radio" name="user_alt" id="user_alt2" value="2"
	                                        <% if(sv.getUser_alt() == 2) { %> checked <%}%>>
											<label for="user_alt2">클라</label>
	                                    </div>
	                            	</div>
	                            
	                            <div class="last_range">
	                                <label for="amount">Price range:</label>
	
	
	                                <div id="slider-range"></div>
	                                <p>
	                                    <input type="text" id="amount" name="price_range" readonly
	                                        style="width: 100%; border:0; color:#f6931f; font-weight:bold;"
	                                        <% if(sv.getPriceRange() != null) { %>value="<%=sv.getPriceRange()%>"<% } %>>
	                                </p>
	                                <button class="boxed-btn2">SEARCH</button>
	                            </div>
	                            <% } else { %>
	                            <div class="filter_main_wrap">
	                        		<div class="input_field col-xl-4 col-lg-4" style="width:20%">
                                        <select class="wide" id="search_area" name="search_area">
                                            <option value="1">제목</option>
                                            <option value="2">닉네임</option>
                                            <option value="3">제목+닉네임</option>
                                        </select>
                                    </div>
		                            <div class="filter_inner">
	                                    <div class="input_field" style="width:80%">
	                                        <input type="text" name="search_text" placeholder="What are you finding?">
	                                        <!-- <button class="submit_btn" type="submit"> <i class="fa fa-search"></i> </button> -->
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" id="inputCategory1" name="c1">
	                                            <option value='0'>1차 카테고리 선택</option>
												<% for(Category1 cg1: category1List) { %>
													<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
												<% } %>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" id="inputCategory2" name="c2">
	                                            <option value='0'>2차 카테고리 선택</option>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-4 col-lg-4">
	                                        <select class="wide" name="member_grade">
	                                            <option value="1">GENERAL</option>
	                                            <option value="2">PRIME</option>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-6 col-lg-6" style="width:30%">
	                                        <input type="date" name="s_date" style="width: 47%; font-size: 0.8rem;"> - 
	                                        <input type="date" name="e_date" style="width: 47%; font-size: 0.8rem;">
	                                    </div>
	                                    <div class="input_field col-xl4 col-lg-4" style="width:50%">
	                                        <div class="inner">
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit1" name="status1" value="1">
	                                                <label for="fruit1">진행전</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit2" name="status2" value="2">
	                                                <label for="fruit2">진행중</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit3" name="status3" value="3">
	                                                <label for="fruit3">완료</label>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="input_field col-xl-2 col-lg-2 alt_radio" style="width:20%">
	                                        <input type="radio" name="user_alt" id="user_alt1" value="1">
	                                        <label for="user_alt1">프리</label>
	                                        <input type="radio" name="user_alt" id="user_alt2" value="2">
											<label for="user_alt2">클라</label>
	                                    </div>
	                            	</div>
	                            
	                            <div class="last_range">
	                                <label for="amount">Price range:</label>
	
	
	                                <div id="slider-range"></div>
	                                <p>
	                                    <input type="text" id="amount" name="price_range" readonly
	                                        style="width: 100%; border:0; color:#f6931f; font-weight:bold;">
	                                </p>
	                                <button class="boxed-btn2">SEARCH</button>
	                            </div>
	                            <% } %>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="col-xl-12 col-lg-12">
                    <h3 class="exp_title"><%= rList.size() %> 개의 검색결과가 있습니다.</h3>
                    <div class="row">
						<% for(SearchResult sr : rList) {
						    String src = "";
						    if (sr.getThumnailPath() != null) {
						    	
								src = "../resources/uploadImages/" +  sr.getThumnailPath();
						    } else {
						    	src = "../resources/uploadImages/noimage.png";
						    }
						%>
						<script>
							console.log("");
						</script>
                        <div class="col-xl-4 col-lg-4 col-md-4">
                           <div class="single_explorer prj_thumb">
	                           <div class="thumb">
	                               <img src="<%= src %>" alt="">
	                           </div>
                               <div class="explorer_bottom d-flex">
                                   <div class="explorer_info">
                                       <h3><a href="<%= request.getContextPath() %>/project/detail?no=<%=sr.getProjectNo()%>"><%= sr.getProjecttitle() %></a></h3>
                                       <ul>
                                           <li><i class="fa fa-dollar"></i>
                                             	<%= sr.getProjectPrice() %>
                                           </li>
                                           <li><i class="fa fa-user"></i>
                                           		<%= sr.getMemberNick() %>
                                           </li>
                                           <li><i class="fa fa-star"></i>
												<% if(sr.getStarRating() != 0) { %>
													<%= sr.getStarRating() %>
												<% } else { %>
													없음
												<% } %>
                                           </li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ explorer_europe start  -->

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
    <script src="js/jquery-ui.js"></script>
    <script src="js/plugins.js"></script>


    <!-- contact js -->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>


    <script src="js/main.js"></script>
 

    <script>
        $(function () {
            $("#slider-range").slider({
                range: true,
                min: 10000,
                max: 1000000,
                values: [10000, 500000],
                slide: function (event, ui) {
                    $("#amount").val(ui.values[0]+" - "+ ui.values[1]);
                }
            });
            $("#amount").val($("#slider-range").slider("values", 0) +
                " - " + $("#slider-range").slider("values", 1));
        });
    </script>
    
	<script type="text/javascript">
		$(function(){
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
		})
	</script>
</body>

