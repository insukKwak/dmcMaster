<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">

	<script type="text/javascript">
			function goView(code){
				//$('#code').val(code);
				var form = document.costForm;
				form.code.value = code;
				form.submit();
			}

	</script>

    <div id="toaster"></div>


    <!-- ====================================
    ——— WRAPPER
    ===================================== -->
    <div class="wrapper">
    
<!-- ==================================== LEFT SIDEBAR  ===================================== -->
 <%@include file="/WEB-INF/views/inc/leftmenu.jsp"%>

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
                    <h2>거래선 관리 리스트</h2>
                  </div>
                  <div class="card-body">
                 <form name="costForm" action="/prdt/cust/view" method="post" accept-charset="utf-8">
                 <input type="hidden" name="code" value=""/>
                 </form>
                    <table id="productsTable" class="table table-hover table-product" style="width:100%">
                      <thead>
                        <tr>
	                      <th></th>
	                      <th>SEQ</th>
	                      <th>거래선명 </th>
	                      <th>거래선구분 </th>
	                      <th>대표자명 </th>
	                      <th>담당자명 </th>
	                      <th>전화번호 </th>
	                      <th>핸드폰번호 </th>
	                      <th></th>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="cust" items="${prdtCustList}" varStatus="idx">
	                        <tr>
								<td></td>
								<td>${cust.SEQ}</td>
								<td><a  href="javascript:goView('${cust.SEQ}');">${cust.NAME}</a></td>
								<td>${cust.CUST_TYPE}</td>
								<td>${cust.REG_NAME}</td>
								<td>${cust.MNG_NAME}</td>
								<td>${cust.TEL_NO}</td>
								<td>${cust.PHONE_NO}</td>
								<td>
		                            <div class="dropdown">
		                              <a class="dropdown-toggle icon-burger-mini" href="#" role="button" id="dropdownMenuLink"
		                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                              </a>
		
		                              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
		                                <a class="dropdown-item" href="/prdt/cost/view?code=${cost.CODE}">View</a>
		                              </div>
		                            </div>
		                          </td>
	                        </tr>
					  </c:forEach>  
                      </tbody>
                    </table>
                     <button type="button" class="btn btn-primary" onclick="location.href='/prdt/cost/form'">등록 </button>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xl-12">
                <!-- Income and Express -->
                <div class="card card-default">
                  <div class="card-body">
                    <div class="chart-wrapper">
                      <div id="mixed-chart-1"></div>
                    </div>
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

<script>
	
</script>
						
</body>

</html>

