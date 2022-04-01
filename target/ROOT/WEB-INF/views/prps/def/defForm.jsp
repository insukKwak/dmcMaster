<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">
    <script>
	function goDel(){
		var form = document.costForm;
		form.del.value = 'Y';
		form.submit();
	}
	
	function goList(){
		window.location.href = '/prps/def/list';
	}
	
	function goReg(seq){
		var options ='width=250;height=200;menubar=no';
		window.open('/prps/def/pop?seq=${def.SEQ}&subjectcode=${def.SBJT_CODE}','costpop',options);
	}
	
	function goEdit(seq){
		alert(seq);
	}
	
	function goCostDel(seq){
		alert(seq);
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
                    <h2>등록 </h2>
                  </div>
                  <div class="card-body">
                  
					<form name="costForm" action="/prps/def/save" method="post" accept-charset="utf-8">
					    <div class="row">
						<input type="hidden" name="del" value=""/>
					    <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">제작년도 </label>
					            <input type="text" name="year" class="form-control" required="" value="${program.LASTYEAR}" readonly >
					        </div>
					     </div>
					     
					      <div class="col-lg-3">
					        <div class="form-group mb-3">
					            <label for="simpleinput">학년</label>
					            <input type="text" name="grade" class="form-control" required="" value="${contCnt.GRADE}" readonly>
					        </div>
					     </div>  
					     <div class="col-lg-3">
					        <div class="form-group mb-3">
					            <label for="simpleinput">학기 </label>
					            <input type="text" name="semester" class="form-control" required="" value="${program.LASTTERM}" readonly>
					        </div>
					     </div>   
					      <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">프로그램명 </label>
					            <input type="text" name="sbjt_name" class="form-control" required="" value="${program.TITLE}" readonly>
					        </div>
					     </div>
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">프로그램코드 </label>
					            <input type="text" name="sbjt_code" class="form-control" required="" value="${program.SUBJECTCODE}" readonly>
					        </div>
					     </div>
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					        <label for="simpleinput">제작목표  </label>
					        <input type="text" name="start_dt" class="form-control"  value="${program.start_dt}" >
					        </div>
					     </div>
					     <div class="col-lg-3">
					        <div class="form-group mb-3">
					        <label for="simpleinput">제작 시작  </label>
					        <input type="text" name="start_dt" class="form-control"  value="${program.start_dt}" placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     <div class="col-lg-3">
					        <div class="form-group mb-3">
					        <label for="simpleinput">제작 종료 </label>
					         <input type="text" name="end_dt" class="form-control"   value="${program.end_dt}" placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">담당 PD </label>
					            <input type="text" name="general_pd" class="form-control" required="" value="${contCnt.PD}" readonly>
					        </div>
					     </div>
					      <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">편수 </label>
					            <input type="text" name="contcnt" class="form-control"   value="${contCnt.CONTCNT}" readonly>
					        </div>
					     </div>
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">PD1 </label>
					            <input type="text" name="pd1" class="form-control"   value="${program.pd1}" >
					        </div>
					     </div>
					      <div class="col-lg-6">
					        <div class="form-group mb-3">
					            <label for="simpleinput">PD2 </label>
					            <input type="text" name="pd2" class="form-control"   value="${program.pd2}" >
					        </div>
					     </div>
					     <div class="col-md-12">
					        <div class="form-group mb-3">
					        <label for="simpleinput">특이사항 </label>
					        <input type="text" name="etc" class="form-control"   value="${program.etc}" >
					        </div>
					     </div>
					       <div class="col-md-12">
					        <div class="form-group mb-3">
					            <label for="simpleinput">회차정보 및 내용 </label>
					            
					            <table>
					            <c:forEach var="cont" items="${content}" varStatus="idx">
					            	<tr>
					            		<td>${cont.TITLE}</td> 
					            		<td> 부제 : ${cont.SUBTITLE}</td>
					            		<td> 출연진 : ${cont.ACTOR}</td>
					            	</tr>
					            </c:forEach>
					            </table>
					        </div>
					    </div>
					     <a href="javascript:goList()" class="btn btn-primary">목록 </a> &nbsp;&nbsp;
					     <button type="submit" class="btn btn-primary">저장 </button>  &nbsp;&nbsp;
					     <a href="javascript:goDel()" class="btn btn-primary">삭제 </a> &nbsp;&nbsp;
					     <a href="javascript:goReg('${def.SEQ }')" class="btn btn-primary">제작비 등록  </a>
					    </div>
					    <br/><br/>
	                    <label for="simpleinput">방송제작비 리스트 </label>
					    <table id="costTable" class="table table-hover table-product" style="width:100%">
		                  <thead>
	                        <tr>
		                     
		                      <th>SEQ</th>
		                      <th>CODE</th>
		                      <th>항목명</th>
		                      <th>항목분류</th>
		                      <th>표준제작비 </th>
		                      <th>단위수량 </th>
		                      <th>적용요율 </th>
		                      <th>청구금액 </th>
		                       <th></th>
	                        </tr>
	                      </thead>
	                      <tbody>
							<c:forEach var="cost" items="${costList}" varStatus="idx">
		                        <tr>
									<td>${idx.count}</td>
									<td>${cost.PRDT_CODE}</td>
									<td><a  href="javascript:goView('${cost.PRDT_CODE}');">${cost.TITLE}</a></td>
									<td>${cost.CLASSIFICATION}</td>
									<td>${cost.PRDT_COST}</td>
									<td>${cost.CNT}</td>
									<td>${cost.RATE}</td>
									<td>${cost.AMOUNT}</td>
									<td>
									<a href="javascript:goEdit('${cost.SEQ }')" class="btn btn-primary">수정 </a> &nbsp;&nbsp;
									<a href="javascript:goCostDel('${cost.SEQ }')" class="btn btn-primary">삭제 </a> &nbsp;&nbsp;
									</td>
									
		                        </tr>
						  </c:forEach>  
	                      </tbody>
		                </table>
					        
						
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

