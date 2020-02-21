<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.kh.searchfree.admin.model.vo.Category1"%>
<%@page import="com.kh.searchfree.admin.model.vo.Category2"%>
<%@page import="java.util.List"%>

<%
	List<Category1> category1List = (List<Category1>)request.getAttribute("category1List");
	List<Category2> category2List = (List<Category2>)request.getAttribute("category2List");
	String category1Code = (String)request.getAttribute("category1Code");
	String msg = (String)session.getAttribute("msg");
	%>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Admin Category</title>

  <!-- Custom fonts for this template -->
  <link href="<%=request.getContextPath()%>/adminResources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
    href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
    rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/adminResources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="<%=request.getContextPath()%>/adminResources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

  <style>
    ul>li {
      list-style-type: none;
      display: block;
      position: relative;
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
      <li class="nav-item">
        <a class="nav-link" href="admin_Members.html">
          <i class="fas fa-fw fa-user"></i>
          <span>Members</span></a>
      </li>

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

            <div class="card shadow mb-4 border-left-primary " id="catgory-wrapper">
              <!-- 카테고리관리 카드, 왼쪽에 파란색 스타일 -->
              <div class="card-header py-3">
                <!-- 헤더 타이틀 -->
                <h4 class="m-0 font-weight-bold text-primary">카테고리 관리</h4>
              </div>
              <table>
                <th colspan="2">
                  <div class="card-header m-4 card shadow rounded-top border-bottom-secondary border-left-gray">
                    <select id="inputCategory1" name="inputCategory1">
                      <option value='0'>1차 카테고리 선택</option>
						<% for(Category1 cg1: category1List) { %>
						<option value="<%= cg1.getCategory1Code() %>"><%= cg1.getCategory1NM() %></option>
						<% } %>
                    </select>
                  </div>
                </th>
                <tr>
                  <td>
                    <div class="card-header shadow mb-4">
                      <h6 class=" font-weight-bold text-primary"></h6>
                      <div class="card-body shadow mb-4">
                        <ul class>
                          <li><input type="radio" class="category2" name="category2" value="개발">개발</li>
                          <li><input type="radio" class="category2" name="category2" value="디자인">디자인</li>
                        </ul>
                      </div>
                    </div>
                  </td>
                </tr>
              </table>
              <div id="admin btn" class="float-right py-sm-4 m-2 ">
                <!-- 관리 버튼 -->
                <!-- 카테고리 수정 버튼 -->
                <button class="float-right btn btn-primary m-1" data-target="#myModal" data-toggle="modal" onclick="updateCategory();">수정</button>
                <!-- 카테고리 삭제 버튼 -->
              <button class="float-right btn btn-primary m-1" onclick="deleteCategory();">삭제</button>
              <button class="float-right btn btn-primary m-1" data-target="#myModal2" data-toggle="modal">추가</button>


                <!-- 수정 Modal-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                  aria-hidden="true">
                  <div class="modal-dialog">
                    <!-- class="modal-dialog"에 modal-lg추가하면 큰모달,  modal-sm추가하면 작은모달, 아무것도 안쓰면 중간크기의 모달이 만들어진다. -->
                    <div class="modal-content">
                      <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">카테고리 수정</h4>
                        <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                      </div>
                      <!-- 모달창 영역에 버튼태그의 data-dismiss 속성을 적용하면 모달을 닫게하는 기능을 적용하겠다라는 의미 
                      class="modal fade"에서 fade없으면 부드럽게 창이 뜨지 않는다.-->

                      <div class="modal-body">
                        <p>
                          <input type="text" style="width: 100%;" id=updateCategory>
                        </p>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-primary">확인</button>
                      </div>
                      <!-- data-dismiss="modal" : 모달을 닫는 기능을 갖고있다. -->
                    </div> <!-- 모달 콘텐츠 -->
                  </div> <!-- 모달 다이얼로그 -->
                </div> <!-- 모달 전체 윈도우 -->
              </div>

              <!-- 추가 Modal-->
              <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
              aria-hidden="true">
              <div class="modal-dialog">
                <!-- class="modal-dialog"에 modal-lg추가하면 큰모달,  modal-sm추가하면 작은모달, 아무것도 안쓰면 중간크기의 모달이 만들어진다. -->
                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">카테고리 추가</h4>
                    <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                  </div>
                  <!-- 모달창 영역에 버튼태그의 data-dismiss 속성을 적용하면 모달을 닫게하는 기능을 적용하겠다라는 의미 
                  class="modal fade"에서 fade없으면 부드럽게 창이 뜨지 않는다.-->

                  <div class="modal-body">
                    <p>
                      <input type="text" style="width: 100%;" id=upmdateCategory>
                    </p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary">확인</button>
                  </div>
                  <!-- data-dismiss="modal" : 모달을 닫는 기능을 갖고있다. -->
                </div> <!-- 모달 콘텐츠 -->
              </div> <!-- 모달 다이얼로그 -->
            </div> <!-- 모달 전체 윈도우 -->
          </div>

          
            </div>


            <script>
              function deleteCategory() {
                window.confirm("삭제하시겠습니까?");
              }

             
              function updateCategory() {
                var radioVal = $('input[name="category2"]:checked').val();
                $("#updateCategory").val(radioVal);
              }

            </script>
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

        <!-- Footer -->
    
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
    <script src="<%=request.getContextPath()%>/adminResources/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/adminResources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/adminResources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/adminResources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="<%=request.getContextPath()%>/adminResources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/adminResources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=request.getContextPath()%>/adminResources/js/demo/datatables-demo.js"></script>

</body>
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
				url : "./AjaxCategory1code.do",
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
</html>