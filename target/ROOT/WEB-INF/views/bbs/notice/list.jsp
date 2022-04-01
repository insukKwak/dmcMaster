<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">

	<script type="text/javascript">
			

	</script>

    <div id="toaster"></div>


    <!-- ====================================
    ——— WRAPPER
    ===================================== -->
    <div class="wrapper">
    
<!-- ==================================== LEFT SIDEBAR  ===================================== -->
 <%@include file="/WEB-INF/views/inc/sidebar.jsp"%>

        <!-- ==================================== PAGE WRAPPER ===================================== -->
        <div class="page-wrapper">

<!-- Header -->
 <%@include file="/WEB-INF/views/inc/header.jsp"%>          
 
        <!-- ====================================
        ——— CONTENT WRAPPER
        ===================================== -->
        <div class="content-wrapper">
          <div class="content">
            <!-- Table Product -->
            <div class="row">
              <div class="col-12">
                <div class="card card-default">
                  <div class="card-header">
                    <h2>Notice List</h2>
                  </div>
                  <div class="card-body">
                    <table id="productsTable" class="table table-hover table-product" style="width:100%">
                      <thead>
                        <tr>
	                      <th></th>
	                      <th>SEQ</th>
	                      <th>제 목</th>
	                      <th>작성자</th>
	                      <th>작성일</th>
	                      <th>Act</th>
	                      <th></th>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="notice" items="${noticeList}" varStatus="idx">
	                        <tr>
								<td></td>
								<td>${notice.SEQ}</td>
								<td>${notice.TITLE}</td>
								<td>${notice.CRE_NO}</td>
								<td>${notice.CRE_DT}</td>
								<td>
		                            <div class="dropdown">
		                              <a class="dropdown-toggle icon-burger-mini" href="#" role="button" id="dropdownMenuLink"
		                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                              </a>
		                              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
		                                <a class="dropdown-item" href="/bbs/notice/view?seq=${notice.SEQ}">View</a>
		                                <a class="dropdown-item" href="/bbs/notice/delete?seq=${notice.SEQ}">Delete</a>
		                              </div>
		                            </div>
		                          </td>
								<td></td>
	                        </tr>
					  </c:forEach>  
                      </tbody>
                    </table>
                    <button type="button" class="btn btn-primary" onclick="location.href='/bbs/notice/form'">Insert</button>
                  </div>
                </div>
              </div>
            </div>          
          </div>
        </div>

<!-- Footer -->
 <%@include file="/WEB-INF/views/inc/footer.jsp"%>

</div>
</div> <!-- End Wrapper -->


<script src="/resources/assets/plugins/jquery/jquery.min.js"></script>
<script src="/resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/assets/plugins/slimscrollbar/jquery.slimscroll.min.js"></script>
<script src="https://unpkg.com/hotkeys-js/dist/hotkeys.min.js"></script>
<script src="/resources/assets/plugins/toaster/toastr.min.js"></script>
<script src="/resources/assets/plugins/ladda/spin.min.js"></script>
<script src="/resources/assets/plugins/ladda/ladda.min.js"></script>
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
<script src="/resources/assets/plugins/codemirror/codemirror.js"></script>
<script src="/resources/assets/plugins/codemirror/mode/xml/xml.js"></script>
<script src="/resources/assets/plugins/codemirror/mode/css/css.js"></script>
<script src="/resources/assets/plugins/dropzone/dropzone.js"></script>
<script src="/resources/assets/plugins/jquery-mask-input/jquery.mask.min.js"></script>
<script src="/resources/assets/plugins/select2/js/select2.min.js"></script>
<script src="/resources/assets/plugins/jvectormap/jquery-jvectormap-2.0.3.min.js"></script>
<script src="/resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill.js"></script>
<script src="/resources/assets/plugins/jvectormap/jquery-jvectormap-us-aea.js"></script>
<script src="/resources/assets/plugins/daterangepicker/moment.min.js"></script>
<script src="/resources/assets/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/resources/assets/plugins/apexcharts/apexcharts.js"></script>
<script src="/resources/assets/plugins/DataTables/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
<script src="/resources/assets/plugins/prism/prism.js"></script>
<script src="/resources/assets/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCn8TFXGg17HAUcNpkwtxxyT9Io9B_NcM" defer></script>

<script src="/resources/assets/js/mono.js"></script>
<script src="/resources/assets/js/map.js"></script>
<script src="/resources/assets/js/custom.js"></script>
						
</body>

</html>

