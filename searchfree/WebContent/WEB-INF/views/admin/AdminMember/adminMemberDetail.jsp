<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.searchfree.admin.model.vo.Project"%>
<%@page import="com.kh.searchfree.admin.model.vo.AdminMember"%>
   <%
   AdminMember selectMember = (AdminMember)request.getAttribute("selectMember");
   		
    String msg = (String)session.getAttribute("msg");
	%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Notice</title>

<!-- Custom fonts for this template -->
<link
	href="<%=request.getContextPath()%>/adminResources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/adminResources/css/sb-admin-2.min.css"
	rel="stylesheet">

<!-- Custom styles for this page -->


<!-- Bootstrap core JavaScript-->
<script
	src="<%=request.getContextPath()%>/adminResources/vendor/jquery/jquery.min.js"></script>

<!-- Core plugin JavaScript-->
<script
	src="<%=request.getContextPath()%>/adminResources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script
	src="<%=request.getContextPath()%>/adminResources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script
	src="<%=request.getContextPath()%>/adminResources/vendor/datatables/jquery.dataTables.min.js"></script>

<!-- Page level custom scripts -->
<script
	src="<%=request.getContextPath()%>/adminResources/js/demo/datatables-demo.js"></script>
	
	<style type="text/css">
		#page-top * {
		text-decoration: none;
		}
	</style>
</head>



<body id="page-top" class="sidebar-toggled">
<script>
      <%if(msg != null){%>
            alert("<%=msg %>");
      <%
         session.removeAttribute("msg");//세션을 삭제
         }
      %>
      
   </script>
  <!-- Page Wrapper -->
  <div id="wrapper">

    

   <!-- 사이드바 -->
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<%=request.getContextPath()%>"> <i class="fas fa-fw fa-cogs"></i>
				<div class="sidebar-brand-text mx-3">SearchFree</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" onclick="location.href='<%=request.getContextPath()%>/admin/main'">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Admin Menu
      </div>


      <!-- Nav Item - Members -->
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/admin/memberList"> <i
					class="fas fa-fw fa-user"></i> <span>Members</span></a></li>

      <!-- Nav Item - Tables Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTables"
          aria-expanded="true" aria-controls="collapseTables">
          <i class="fas fa-fw fa-bars"></i>
          <span>Tables</span>
        </a>
        <div id="collapseTables" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Table</h6>
						<a
							class="collapse-item"
							href="<%=request.getContextPath() %>/admin/AdminNotice/NoticeList">Notice</a>
						<a class="collapse-item"
							href="<%=request.getContextPath() %>/admin/AdminNotice/QnaList">Q&A</a>
						<a class="collapse-item"
						href="<%=request.getContextPath() %>/admin/AdminReport/ReportList">Reports</a>
					</div>
				</div></li>
      


      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->
    <!-- 사이드바 끝! -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                      aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>



            <!-- <div class="topbar-divider d-none d-sm-block"></div> -->

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin 001</span>
                <img class="img-profile rounded-circle" src="https://image.flaticon.com/icons/png/512/2371/2371561.png">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <!--  <h1 class="h3 mb-2 text-gray-800"></h1> -->
          <!-- <p class="mb-4">멤버페이지에서 회원 이름 클릭시 현재 페이지가 조회됩니다.  -->
            <!-- <a target="_blank" href="https://datatables.net">official DataTables documentation</a> -->
          <!-- </p> --> 

          <!-- DataTales Example -->
          <div class="card shadow mb-4 border-left-primary">
            <div class="card-header py-3">
              <h4 class="m-0 font-weight-bold text-primary">'<%=selectMember.getMemberNick() %>'&nbsp;<sub>님의 활동내역</sub>&nbsp;&nbsp;<i class="fas fa-comments fa text-gray-300"></i></h4>
            </div>
              	<div class="card-body">
            
            <div class="card border-left-success shadow h-100 py-2">
              	<div class="card-body">
              	<br>
              <table class="table " id="member-profile" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th	style="text-align : center;" >회원번호</th>
                    <th style="text-align : center;" >Status</th>
                    <th>Level</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Account</th>
                    <th>가입일</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Email</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td style="text-align : center;" ><%=selectMember.getMemberNo() %></td>
                    <td style="text-align : center;" >
                        <a href="#" id="memberDropdown dropdown-toggle" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false" >
                          <%if(selectMember.getMemberStatus()=='N'){%>
                          	<p style="color:white; background-color:#1cc88a;border-radius:5px;line-height:26px;">
                          	<strong>정상</strong><i class="fas fa-check"></i></p>
                          <%} else if(selectMember.getMemberStatus()=='Y'){%>
                          	<p style="color:white; background-color:gray;border-radius:5px;line-height:26px;">
                          	<strong>활동정지</strong><i class="fas fa-trash"></i></p>
                          <%} %>
                        </a>
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow"
                          aria-labelledby="leveldropdown">
                          <div class="dropdown-header" id="leveldropdown">회원상태 변경</div>
                          <div class="dropdown-divider"></div>
                          <a class="dropdown-item d-flex align-items-center"
                          id="actDisabled" 
                          href="javascript:void(0)"
                          style="pointer-events: none;cursor: default;color:lightgray;	">
                            <span class="font-weight-bold">활동 중단</span>
                          </a>
                          <a class="dropdown-item d-flex align-items-center" 
                          id="actAbled"
                          href="javascript:void(0)"
                          style="pointer-events: none;cursor: default;color:lightgray;">
                            <span class="font-weight-bold">활중 복구</span>
                          </a>
                      </div>
                    </td>
                    <td>
                        <a href="#" id="memberDropdown" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false" >
                          <% if(selectMember.getMemberGrade() == '1'){%>
							<p class="btn btn-success btn-icon-split">
								&nbsp;<Strong>일반회원</Strong>&nbsp;
							</p>
							<%}else if(selectMember.getMemberGrade() == '2'){ %>
								<p class="btn btn-primary btn-icon-split icon text-white-80">
								&nbsp;<Strong>우수회원</Strong>&nbsp;
							</p>
							<%}else if(selectMember.getMemberGrade() == '3'){ %>
								<p class="btn btn-danger btn-icon-split">
								&nbsp;<Strong>관리자</Strong>&nbsp;
							</p>
							<%} %>
                        </a>
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow"
                          aria-labelledby="leveldropdown">
                          <div class="dropdown-header">회원등급 변경</div>
                          <div class="dropdown-divider"></div>
                          <a class="dropdown-item d-flex align-items-center" 
                          href="admin_Members_detail copy.html"
                          id="gradeGreen"
                          style="pointer-events: none;cursor: default;color:lightgray;	">
                            <span class="font-weight-bold">일반등급으로 변경</span>
                          </a>
                          <a class="dropdown-item d-flex align-items-center" 
                          href="admin_Members_detail copy.html"
                          id="gradeBlue"
                          style="pointer-events: none;cursor: default;color:lightgray;	">
                            <span class="font-weight-bold">우수회원으로 변경</span>
                          </a>
                      </div>

                    </td>
                    <td><%=selectMember.getMemberId()%></td>
                    <td><%=selectMember.getMemberNm()%></td>
                    <td><%=selectMember.getMemberAccount()%></td>
                    <td><%=selectMember.getMemberEnrollDate()%></td>
                    <td><%=selectMember.getMemberAddr()%></td>
                    <td><%=selectMember.getMemberPhone()%></td>
                    <td><%=selectMember.getMemberEmail()%></td>
                  </tr>
                </tbody>
              </table>
              <hr style="color: gray;"><br>
              	</div>
              
              </div><br>
              
              <div class="card border-left-info shadow h-100 py-2">
              <div class="card-body">
              <select id="selectBox" name="selectBox">
                <option selected disabled  id="searchList">조회할 목록을 선택하세요</option>
                <option value="1" class="option">작성글 목록</option>
                <option value="2" class="option">작성 댓글 목록</option>
                <option value="3" class="option">작성 리뷰 목록</option>
              </select> 
              
              <a class ="fas fa-file-alt btn" style="float:right;background-color:lightgray;color:white;"
              onClick="history.go(-1)">목록으로</a>
              <br><br>
              <div class="table-responsive" id="tableList" class="list">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead id="tHead" align="center">
                    <tr>
                      <th style="width:10%">No.</th>
                      <th style="width:25%" class="ttitle">제목</th>
                      <th style="width:50%">내용</th>
                      <th style="width:15%">등록 일자</th>
                    </tr>
                  </thead>
                  <tbody id="listArea" align="center">
                  <tr></tr>
                  </tbody>
                </table>
                <div id="test"></div>
                </div>
                </div>
				<script>
					var memNo = "<%=selectMember.getMemberNo()%>";
					$("#selectBox").on("change",function(){
						
						var value = $("#selectBox").val(); // selectbox value
						// 1: 프로젝트 글, 2: 댓글, 3: 리뷰
						var selUrl;
						switch(value){
				  	 	case '1' : selUrl="plist"; break;
						case '2' : selUrl="clist"; break; 
						case '3' : selUrl="rlist"; break; 
						}
						$.ajax({
							url : selUrl,
							data : {memNo : memNo},
							type : "POST",
							dataType : "json",
							success : function(list){
								
								
								var $listArea = $("#listArea");
								
								console.log($listArea);
								
								
								
								if(selUrl == "plist"){
								$.each(list, function(i){
									
									var $tr = $("<tr>");
									
									var $no = $("<td>").text(i+1); 
									var $title = $("<td>").text(list[i].replyContent);
									console.log($title);
									var $a = $("<a>").prop("href", "<%=request.getContextPath()%>/project/detail?no="+list[i].projectNo).text(list[i].projectTitle);
									$title.append($a);
									
									
									// 태그 지우기용
									$("#test").html(list[i].projectContent).hide();
									var str = $("#test").text();
									if(str.length > 30){
										str = str.substring(0,30) + "...";
									}
									
									var $content = $("<td>").text(str);
									
									var $writeDate = $("<td>").text(list[i].projectCreateDate);
									
									$tr.append($no).append($title).append($content).append($writeDate);
									
									$listArea.append($tr);
									});
								
								
								$("#test").remove();
								
								
							}else if(selUrl == "clist"){
								
								$.each(list, function(i){
									var $tr = $("<tr>");
									
									var $no = $("<td>").text(i+1); 
									
									if(list[i].replyDeleteYN == 'N'){
										var $title = $("<td>").text('정상 게시 중');
									}else {
										var $title = $("<td>").text('삭제된 댓글');
									}
									
									console.log($title);
									var $a = $("<a>").prop("href", "<%=request.getContextPath()%>/project/detail?no="+list[i].replyNo);
									$title.append($a);
						 			
									
									var $content = $("<td>").text(list[i].replyContent);
									
									var $writeDate = $("<td>").text(list[i].replyCreateDate);
									
									$tr.append($no).append($title).append($content).append($writeDate);
									
									$listArea.append($tr);
								});
								
								$("#test").remove();
							}else if(selUrl == "rlist"){
								
								$.each(list, function(i){
									
									var $tr = $("<tr>");
									
									var $no = $("<td>").text(i+1); 
									var $title = $("<td>").css("text-align","center").text(list[i].reviewStarRating);
									console.log($title);
									var $a = $("<a>").prop("href", "<%=request.getContextPath()%>/project/detail?no="+list[i].reviewNo);
									$title.append($a);
						 			
									
									var $content = $("<td>").text(list[i].reviewContent);
									
									var $writeDate = $("<td>").text(list[i].reviewCreateDate);
									
									$tr.append($no).append($title).append($content).append($writeDate);
									
									$listArea.append($tr);
								});

								
								$("#test").remove();
								
							}
							},error : function(){
								console.log("ajax 통신 에러");
							}
							
						});
						
				});
               	</script>
              </div>
              

            </div>
         
          </div>
          
        </div>
        <!-- /.container-fluid -->



      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">로그아웃 이후에는 세션이 만료되어 더이상 관리자 페이지를 이용할 수 없습니다.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
         <a class="btn btn-primary" href="<%=request.getContextPath()%>/admin/logout">네</a>
				</div>
      </div>
    </div>
  </div>

 		<!-- Bootstrap core JavaScript-->
		<script
			src="<%=request.getContextPath()%>/adminResources/vendor/jquery/jquery.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="<%=request.getContextPath()%>/adminResources/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script
			src="<%=request.getContextPath()%>/adminResources/vendor/datatables/jquery.dataTables.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/demo/datatables-demo.js"></script>
</body>


<script>
$(function(){
    
    var status = '<%=selectMember.getMemberStatus()%>';
	var grade = '<%=selectMember.getMemberGrade()%>';
	
	 if(status =='N'){
	    	$("#actDisabled").css({"pointer-events": "auto","cursor": "pointer","color":"black"});
	    	$("#actDisabled").attr("href", "Ystatus?no=<%=selectMember.getMemberNo()%>");

	    }else if(status =='Y'){
	    	$("#actAbled").css({"pointer-events": "auto","cursor": "pointer","color":"black"});
	    	$("#actAbled").attr("href", "Nstatus?no=<%=selectMember.getMemberNo()%>");
	    }
	    
	     if(grade == '2'){
	    	//일반으로
	    	$("#gradeGreen").css({"pointer-events": "auto","cursor": "pointer","color":"black"});
	    	$("#gradeGreen").attr("href", "grade?grade=1&memNo=<%=selectMember.getMemberNo()%>");

	    }else if(grade == '1'){
	    	//우수로
	    	$("#gradeBlue").css({"pointer-events": "auto","cursor": "pointer","color":"black"});
	    	$("#gradeBlue").attr("href", "grade?grade=2&memNo=<%=selectMember.getMemberNo()%>");
	    }
  });
	
		


		      

</script>
</html>