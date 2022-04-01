<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">
  
	<script type="text/javascript">
	
		$(function() {
			$("#addParams").click(function() {
				$("#append_paramId").append(addParamID);
				$("#append_paramVal").append(addParamVal);
			});	
		})
		
		$(function() {
		    $("#cancelBt").click(function(){        	
		    	window.history.back();
		    });
		})
	
		function checkForm() {
			var chkId = document.apiForm.apiId.value;
			var chkSeq = document.apiForm.seq.value;
	    	var options = {
					url : "/api/config/apiCheck",
					dataType : "json",
					type : "post",
					async : false,
					data : window.location.search.replace(/^[?]/, "") + "&" + $("form[name='apiForm']").serialize(),
					beforeSend : function() {
						SaveAjax = false;
					},
					success : function(result) {
						if(result.data != null){
							if(chkSeq == ''  && chkId == result.data.APIID && result.data.SEQ != null){
								alert("이미 등록된 아이디 입니다.");
								return false;
							}else if(chkSeq != '' && result.data.SEQ != null){
								save();
							}
						}else{
	  						save();
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
		
		function save() {
	    	var options = {
					url : "/api/config/edit",
					dataType : "json",
					type : "post",
					async : false,
					data : window.location.search.replace(/^[?]/, "") + "&" + $("form[name='apiForm']").serialize()+ "&" + $("form[name='authFrm']").serialize(),
					beforeSend : function() {
						SaveAjax = false;
					},
					success : function(result) {
						if (result != null) {
							if (result.codeValue == 200) {
							
								alert("저장 하였습니다.");
								//window.location.reload();
								window.location.href = "/api/config/list";
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
		}
			
		var addParamID ="";
			addParamID += '<div class=\"form-group mb-3\">'
			addParamID += '<label for=\"simpleinput\">파라메터 ID</label>'
			addParamID += '<input type=\"text\" name=\"paramId\" class=\"form-control\" required=\"\" />'
			addParamID += '</div>'
			
		var addParamVal ="";
			addParamVal += '<div class=\"form-group mb-3\">'
			addParamVal += '<label for=\"simpleinput\">파라메터 value(table명_컬럼id)</label>'
			addParamVal += '<input type=\"text\" name=\"paramValue\" class=\"form-control\" required=\"\" />'
			addParamVal += '</div>'		
		
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
					<form name="apiForm" method="post" action="/api/config/edit"  onsubmit="return checkForm();">
						<input type="hidden" id="seq" name="seq"value="${apiView.SEQ}"/>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="simpleinput">API ID</label> 
										<input type="text" name="apiId" class="form-control" required=""  value="${apiView.APIID}">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="simpleinput">API Name</label> 
										<input type="text" name="name" class="form-control" required=""  value="${apiView.NAME}">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="example-select">API type</label> 
									<select class="form-control" name="type">
										<option value="get" <c:if test="${apiView.TYPE == 'get'}"> selected='selected'</c:if>>get</option>
										<option value="post" <c:if test="${apiView.TYPE == 'post'}"> selected='selected'</c:if>>post</option>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="example-select">API 실행</label> 
									<select class="form-control" name="executeTime">
										<option>즉시</option>
										<option>배치</option>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="example-select">API ReturnType</label> 
									<select class="form-control" name="returnType">
										<option value="list" <c:if test="${apiView.RETURNTYPE == 'list'}"> selected='selected'</c:if>>리스트</option>
										<option value="view" <c:if test="${apiView.RETURNTYPE == 'view'}"> selected='selected'</c:if>>오브젝트(뷰)</option>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="simpleinput">저장Table명</label> 
									<input type="text" name="tableNm" class="form-control" required="" value="${apiView.TABLENM}">
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group mb-3">
									<label for="simpleinput">URL</label> 
									<input type="text" 	name="url" class="form-control" required=""   value="${apiView.URL}">
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group mb-3">
									<label for="simpleinput">serviceKey</label> 
									<input type="text" name="serviceKey" class="form-control" required=""   value="${apiView.SERVICEKEY}">
								</div>
							</div>

							<c:forEach var="attr" items="${attrList}" varStatus="idx">
							<input type="hidden" name="attrSeq" value="${attr.attrSeq}"/>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="simpleinput">파라메터 ID</label>
									<input type="text" name="paramId" class="form-control" value="${attr.PARAMID}"/>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group mb-3">
									<label for="simpleinput">파라메터 value(table명_컬럼id)</label>
									<input type="text" name="paramValue" class="form-control" value="${attr.PARAMVALUE}"/>
								</div>
							</div>		
							</c:forEach>	
							
							
							<div class="col-lg-6" id="append_paramId"></div>	
							<div class="col-lg-6" id="append_paramVal"></div>
							
							<div class="col-lg-12">
								<button type="button" class="btn btn-secondary" id="cancelBt">Cancel</button>
								<button type="button" class="btn btn-info"  id="addParams">Add Params</button>
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
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

