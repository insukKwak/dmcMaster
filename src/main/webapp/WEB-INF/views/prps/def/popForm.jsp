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
		alert(seq);
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
        ——— CONTENT WRAPPER
        ===================================== -->
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
					       	 <label for="input">제작비 항목 </label>
					        	<input type="text" name="prdt_code" class="form-control"  value=""  style="width:50"><a href="javascript:popupSearch()" > 검색 </a>
					        </div>
					     </div>
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					        	<label for="simpleinput">표준제작비 </label>
					        	<input type="text" name="prdt_cost" class="form-control"  value="" placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     <div class="col-lg-3">
					        <div class="form-group mb-3">
					        <label for="simpleinput">단위 수량  </label>
					         <input type="text" name="cnt" class="form-control"   value=" " placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     <div class="col-lg-3">
					        <div class="form-group mb-3">
					        <label for="simpleinput">적용요율  </label>
					         <input type="text" name="rate" class="form-control"   value=" " placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     <div class="col-lg-6">
					        <div class="form-group mb-3">
					        <label for="simpleinput">요구금액  </label>
					         <input type="text" name="amount" class="form-control"   value=" " placeholder="YYYYMMDD" style="width:120px">
					        </div>
					     </div> 
					     <a href="javascript:window.close()" class="btn btn-primary"> 닫기 </a> &nbsp;&nbsp;
					    </div>
					        
						
					</form>

                  </div>
                </div>
              </div>
            </div>


</body>

</html>

