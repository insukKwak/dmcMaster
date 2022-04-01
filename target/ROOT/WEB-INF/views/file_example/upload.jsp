<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">
  <script>
  
	  $(function(){
	      $("#uploadbutton").click(function(){
	      	var form = $('#uploadForm')[0];
	      	var data = new FormData(form);
	      	
	  		var options = {
	  				url : "/file/example/upload",
	  				dataType : "json",
	  				type : "post",
	  				async : false,
				        enctype: 'multipart/form-data',
				        processData: false,
				        contentType: false,
	  				data : data,
	  				beforeSend : function() {
	  					SaveAjax = false;
	  				},
						success : function(result) {
							if (result != null) {
								if (result.codeValue == 200) {
								
									alert("저장 하였습니다.");
									location.reload();
								} else {
									alert(result.message__NOTXSS);
								}
							} else {
								alert("[402]저장에 실패하였습니다.");
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
	          });
		  })
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
                    <h2>File Upload Example</h2>
                  </div>
                  <div class="card-body">
					<form  method="post" id="uploadForm">
					<input type="hidden" name="board_name" id="board_name" value="exampleBoard"/>
					  <div class="form-group">
					    <label for="exampleFormControlFile1">Example file input</label>
					    <input class="form-control-file" id="file" name="file" type="file" />
					  </div>
					  <div class="form-footer mt-6">
					    <button type="submit" class="btn btn-primary btn-pill" id="uploadbutton">Upload</button>
					    <button type="submit" class="btn btn-light btn-pill">Cancel</button>
					  </div>
					</form>
                  </div>
                </div>
              </div>             
            </div>
            
            <div class="row">
              <div class="col-12">
                <div class="card card-default">
                  <div class="card-header">
                    <h2>Upload File List</h2>
                  </div>
                  <div class="card-body">
                    <table id="productsTable" class="table table-hover table-product" style="width:100%">
					  <thead>
					    <tr>
					      <th scope="col">SEQ</th>
					      <th scope="col">BOARD SEQ</th>
					      <th scope="col">BOARD NAME</th>
					      <th scope="col">FILE NAME</th>
					      <th scope="col">REAL NAME</th>
					      <th scope="col">SIZE</th>
					      <th scope="col">PATH</th>
					      <th class="text-center">Action</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:forEach var="ex" items="${exampleList}" varStatus="idx">
						    <tr>
						      <td scope="row">${ex.SEQ}</td>
						      <td>${ex.BOARD_SEQ}</td>
						      <td>${ex.BOARD_NAME}</td>
						      <td>${ex.FILE_NAME}</td>
						      <td>${ex.REAL_FILE_NAME}</td>
						      <td>${ex.FILE_SIZE}</td>
						      <td>${ex.FILE_PATH}</td>
						      <th class="text-center">
						        <a href="#">
						          <i class="mdi mdi-close text-danger"></i>
						        </a>
						      </th>
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

