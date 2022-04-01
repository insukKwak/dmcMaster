<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">
	<script type= text/javascript>
	function AppendParams()
	{
	    var tmp = '<label>URL</label>'
	    //alert('호출');
	    
	    var source = '<div class=\"col-md-12\">'+
		'<div class=\"form-group mb-3\">'+'<label for=\"simpleinput\">파라메터</label>'+
	    '<input type=\"text\" name=\"params\" class=\"form-control\">'+'</div></div>';
	    
	   var src = '<div class=\"col-md-6\">'+'<div class=\"form-group mb-3\">'+'<label for=\"simpleinput\">파라메터 ID</label>'
	    +'<input type=\"text\" name=\"paramId\" class=\"form-control\"></div></div>'
		+'<div class=\"col-md-6\"><div class=\"form-group mb-3\">'
		+'<label for=\"simpleinput\">파라메터 value(table명_컬럼id)</label>' 
		+'<input type=\"text\" name=\"paramValue\" class=\"form-control\"></div></div>'    
		        
		 
	    $("#append_params").append(src);
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
                    <h2>API VIEW</h2>
                  </div>
                  <div class="card-body">
					<form name="apiForm" action="${api.apiId != null ? '/config/api/update' : '/config/api/save'}">
					    <div class="row">
					
					    <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">API ID</label>
					            <input type="text" name="apiId" class="form-control" required="" value="${api.apiId}">
					        </div>
					     </div>
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">API Name</label>
					            <input type="text" name="name" class="form-control" required="" value="${api.name}">
					        </div>
					     </div>   
					    <div class="col-lg-6">   
					        <div class="form-group mb-3">
					             <label for="example-select">API type</label>
					             <select class="form-control" name="type">
					                 <option value="get" <c:if test="${api.type == 'get'}"> selected='selected'</c:if>>get</option>
					                 <option value="post" <c:if test="${api.type == 'post'}"> selected='selected'</c:if>>post</option>
					             </select>
					         </div>
					    </div> 
					    <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">return API Type</label>
					            <input type="text" name="apiType" class="form-control" required=""  value="${api.apiType}">
					        </div>
					     </div>
					     <div class="col-lg-12">
					        <div class="form-group mb-3">
					            <label for="simpleinput">저장Table명</label>
					            <input type="text" name="tableNm" class="form-control" required=""  value="${api.tableNm}">
					        </div>
					     </div>  
					    <div class="col-md-12">
					        <div class="form-group mb-3">
					            <label for="simpleinput">URL</label>
					            <input type="text" name="url" class="form-control" required=""  value="${api.url}">
					        </div>
					    </div>
					
					
					    <div class="col-md-12">
					        <div class="form-group mb-3">
					            <label for="simpleinput">serviceKey</label>
					            <input type="text" name="serviceKey" class="form-control" required=""  value="${api.serviceKey}">
					        </div>
					    </div>
					    <c:if test="${attrCnt != '0' }">
					    <c:forEach var="attr" items="${attr}" varStatus="idx">
					        <div class="col-md-6">
					        <div class="form-group mb-3"><label for="simpleinput">파라메터 ID</label>
					        <input type="text" name="paramId" class="form-control" value="${attr.paramId }"></div></div>
					        <div class="col-md-6"><div class="form-group mb-3">
					        <label for="simpleinput">파라메터 value(table명_컬럼id)</label> 
					        <input type="text" name="paramValue" class="form-control" value="${attr.paramValue }"></div>
					        </div>   
					    </c:forEach>
					    </c:if>
					    <a href="javascript:void(0);" onclick="AppendParams();">+</a>  
					    <div class="col-md-12">
					        <div id="append_params">
					
					         </div>
					     </div>
					
					     <button type="submit" class="btn btn-primary">Save</button>
					     </div>
					</form>

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

