<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">

	<script type="text/javascript">
			
		$(function() {
		    $("#addApi").click(function(){        	
		    	window.location.href = '/api/config/insForm';
		    });
		})
	
	    function deleteDt(data) {
	    	
			var options = {
					url : "/api/config/delete",
					dataType : "json",
					type : "post",
					async : false,
					data : window.location.search.replace(/^[?]/, "") + "&" + $("form[name='searchFrm']").serialize()+ "&" + $("form[name='authFrm']").serialize() + "&apiId="+data,
					beforeSend : function() {
						SaveAjax = false;
					},
					success : function(result) {
						if (result != null) {
							if (result.codeValue == 200) {
								alert("삭제 하였습니다.");
								window.location.reload();
							} else {
								alert(result.message__NOTXSS);
							}
						} else {
							alert("[402]삭제에 실패하였습니다.");
						}
					},
					error : function() {
						alert("[401]서버와 통신에 실패하였습니다.");
					},
					complete : function(data) {
						SaveAjax = true;
					}
				};
			
				$.ajax(options);
				return false;      
		}
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
                    <h2>Blank Page Sample</h2>
                  </div>
                  <div class="card-body">
					<a href="/api/config/insForm">+Ins Api</a>
                    <table id="productsTable" class="table table-hover table-product" style="width:100%">
                      <thead>
                        <tr>
	                      <th></th>
	                      <th>Seq</th>
	                      <th>API Id</th>
	                      <th>API Name</th>
	                      <th>API Type</th>
	                      <th>Action</th>
	                      <th></th>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="api" items="${apiList}" varStatus="idx">
	                        <tr>
								<td></td>
								<td>${api.SEQ}</td>
								<td>${api.APIID}</td>
								<td>${api.NAME}</td>
								<td>${api.TYPE}</td>
								<td>
		                            <div class="dropdown">
		                              <a class="dropdown-toggle icon-burger-mini" href="#" role="button" id="dropdownMenuLink"
		                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                              </a>
		
		                              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
		                                <a class="dropdown-item" href="/api/config/apiView?apiId=${api.APIID}">View</a>
		                                <a class="dropdown-item" href="javascript: deleteDt('${api.APIID}');">Delete</a>
		                              </div>
		                            </div>
		                          </td>
			                      <td></td>
	                        </tr>
					  </c:forEach>  
                      </tbody>
                    </table>
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
<script src="/resources/assets/js/chart.js"></script>
<script src="/resources/assets/js/map.js"></script>
<script src="/resources/assets/js/custom.js"></script>

</body>

</html>

