<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.searchfree.board.model.vo.Attachment"%>
<%@page import="java.util.List, com.kh.searchfree.project.model.vo.ProjectOrderList"%> 
    
    <%  
   
    List<ProjectOrderList> orderlist = (List<ProjectOrderList>)request.getAttribute("orderlist");
    List<ProjectOrderList> selledList = (List<ProjectOrderList>)request.getAttribute("selledList");
	List<ProjectOrderList> averlist = (List<ProjectOrderList>)request.getAttribute("averlist");
    	
    %>
    
    
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Directory</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/css/magnific-popup.css">
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/themify-icons.css">
    <link rel="stylesheet" href="resources/css/nice-select.css">
    <link rel="stylesheet" href="resources/css/flaticon.css">
    <link rel="stylesheet" href="resources/css/gijgo.css">
    <link rel="stylesheet" href="resources/css/animate.css">
    <link rel="stylesheet" href="resources/css/slick.css">
    <link rel="stylesheet" href="resources/css/slicknav.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->

    <style>
        #left_side {
            position: relative;
        }

        #left_side>img {
            position: absolute;
            height: 280px;
            left: 0;
            right: 0;
            margin: auto;
        }
    </style>
</head>

<body>
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
                        <h3>OrderList</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->
    <div class="listing_details">
        <div class="explorer_europe">
            <div class="container">
                <div class="explorer_wrap">
                    <div class="row align-items-center">
                        <div class="col-xl-6 col-md-4 single_details">
                            <h3>OrderList</h3>
                        </div>
                        <div class="col-xl-6 col-md-8">
                            <div class="explorer_tab">
                                <nav>
                                    <div class="nav" id="nav-tab" role="tablist">
                                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab"
                                            href="#nav-home" role="tab" aria-controls="nav-home"
                                            aria-selected="true">판매한 프로젝트</a>
                                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
                                            href="#nav-profile" role="tab" aria-controls="nav-profile"
                                            aria-selected="false">구매한 프로젝트</a>
                                    </div>
                                </nav>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="row">
                        
                        <!-- ArrayList<ProjectOrderList> orderlist = (ArrayList<ProjectOrderList>).request.getAttribute("orderlist")  -->
                        <!-- for( ProjectOrderList orderProject: orderlist) -->
                        
                        <!-- ArrayList<ProjectOrderList> averlist= (ArrayList<ProjectOrderList>).request.getAttribute("averlist") -->
                        
                        <!-- orderProject.getProjectTitle() -->
                        <!-- orderProject.getProjectPrice() -->
                        <!-- orderProject.getMemberNick() -->
                        
                        <!-- orderProject.getReviewStarRating()  -->
                        
                        <!-- selledProject.getProjectResourcePath()  -->
                        <!-- selledProject.getFileChangeName()  -->
                        <!-- orderProject.getProjectResourcePath()  -->
                        <!-- orderProject.getFileChangeName()  -->
                        
                        
                        <% if(selledList.isEmpty()){ %>
	               			<div style="text-align:center">
	               				Project Not Sold
	               			</div>
	               	
               			<% }else{ %>
                        
                        <%  
						for( ProjectOrderList selledProject: selledList) { 
						%>
							<div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    
                                    <div class="explorer_bottom d-flex">
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html"> <%=selledProject.getProjectTitle()%>  </a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                   <%=selledProject.getProjectPrice() %> 원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                   	구매 회원: <%=selledProject.getMemberNick() %>님</li>
                                                   
                                                   
                                                <li> <i class="fa fa-star"></i>
                                                    <% boolean flag= true; %>
                                                    
                                                    <% for (ProjectOrderList averProject : averlist) { %>
													
														<% if ( selledProject.getProjectNo() == averProject.getProjectNo() ) {  %>
															<% flag=false; %>
															<%= averProject.getReviewStarRating() %> 점
														<% } %>	
														 
													<% } %>
                                                    	 <% if(flag) { %> 
                                                    	없음
                                                    <% } %>
                                                    
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
							<%
								}
							%>
            				<% } %>
            
            
                       </div>     
                    </div>  
                    
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="row">
                        
                        <% if(orderlist.isEmpty()){ %>
	               			<tr>
	               				<td colspan="5">No Project Purchased</td>
	               			</tr>
	               	
               			<% }else{ %>
                        
                        <%
						for( ProjectOrderList orderProject: orderlist) { 
						%>
						
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    
                                    <div class="explorer_bottom d-flex">
                                       <!--  <div class="icon">
                                            <i class="flaticon-food"></i>
                                        </div> -->
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html"><%=orderProject.getProjectTitle()%></a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    <%=orderProject.getProjectPrice() %>원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                   	프리랜서: <%=orderProject.getMemberNick() %>님</li>
                                                   
                                                   
                                                    <li> <i class="fa fa-star"></i>
                                                    <% boolean flag= true; %>
                                                    
                                                    <%  for (ProjectOrderList averProject : averlist) { %>
													
														<% if ( orderProject.getProjectNo() == averProject.getProjectNo() ) {  %>
															<% flag=false; %>
															<%= averProject.getReviewStarRating() %> 점
														<% }  %>	
															
													<% } %>
                                               			 <% if(flag) { %> 
                                                    	없음
                                                    <% } %>
                                                    
                                                    </li>
                                                   <!--  < orderProject.getReviewStarRating() %>   --> 
                                                    
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <%
								}
							%>
             				<% } %>
                            
                        </div>
                    </div>
            </div>
        </div>
    </div>
    
    <!-- footer start -->
    	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
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


    <script src="js/main.js"></script>
</body>

</html>