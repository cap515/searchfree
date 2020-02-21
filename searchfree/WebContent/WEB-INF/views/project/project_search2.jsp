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
                        <h3 class="exp_title">Advanced Filter</h3>
	                        <form action="/searchForm" method="post">
	                        	<div class="filter_main_wrap">
		                            <div class="filter_inner">
	                                    <div class="input_field">
	                                        <input type="text" placeholder="What are you finding?">
	                                        <!-- <button class="submit_btn" type="submit"> <i class="fa fa-search"></i> </button> -->
	                                    </div>
	                                    <div class="input_field col-xl-3 col-lg-3" style="float:left">
	                                        <select class="wide" id="inputCategory1" name="inputCategory1">
	                                            <option value='0'>1차 카테고리 선택</option>
												<% for(Category1 cg1: category1List) { %>
													<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
												<% } %>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-3 col-lg-3" style="float:left">
	                                        <select class="wide" id="inputCategory2" name="inputCategory2">
	                                            <option value='0'>2차 카테고리 선택</option>
	                                        </select>
	                                    </div>
	                                    <div class="input_field col-xl-3 col-lg-3" style="float:left">
	                                        <div class="inner">
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit1" name="fruit-1" value="1">
	                                                <label for="fruit1">진행전</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit2" name="fruit-1" value="2">
	                                                <label for="fruit2">진행중</label>
	                                            </div>
	                                            <div class="check_1" style="width: 30%;">
	                                                <input type="checkbox" id="fruit3" name="fruit-1" value="3">
	                                                <label for="fruit3">완료</label>
	                                            </div>
	                                        </div>
	                                    </div>
	
	                                    <div class="input_field col-xl-3 col-lg-3">
	                                        <select class="wide" name="member_grade">
	                                            <option value="GENERAL">GENERAL</option>
	                                            <option value="PRIME">PRIME</option>
	                                        </select>
	                                    </div>
	
	                                    <div class="input_field">
	                                        <input type="date" style="width: 47%; font-size: 0.8rem;"> - <input type="date" style="width: 47%; font-size: 0.8rem;">
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
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-xl-12 col-lg-12">
                    <h3 class="exp_title">5432 Listings are available</h3>
                    <div class="row">
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/1.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-beach"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/2.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-food"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/3.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-food-1"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/4.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-barbershop"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/5.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-cabin"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="single_explorer">
                                <div class="thumb">
                                    <img src="img/explorer/6.png" alt="">
                                </div>
                                <div class="explorer_bottom d-flex">
                                    <div class="icon">
                                        <i class="flaticon-shop"></i>
                                    </div>
                                    <div class="explorer_info">
                                        <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                        <ul>
                                            <li> <i class="fa fa-dollar"></i>
                                                840,000원
                                            </li>
                                            <li> <i class="fa fa-user"></i>
                                                Freelancer Name</li>
                                                <li> <i class="fa fa-star"></i>
                                                    5.00</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="page_nation text-center">
                                <ul>
                                    <li>
                                        <a href="#">01</a>
                                    </li>
                                    <li>
                                        <a href="#">02</a>
                                    </li>
                                    <li>
                                        <a href="#">03</a>
                                    </li>
                                    <li>
                                        <a href="#"> <i class="ti-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
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
                    $("#amount").val(ui.values[0]+"￦ - "+ ui.values[1])+"￦";
                }
            });
            $("#amount").val($("#slider-range").slider("values", 0)+"￦" +
                " - " + $("#slider-range").slider("values", 1)+"￦");
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

</html>