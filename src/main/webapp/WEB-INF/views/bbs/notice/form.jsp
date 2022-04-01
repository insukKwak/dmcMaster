<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">

<script type="text/javascript">
function checkForm() {
	  var quillHook1 = document.getElementById("editor");
	  if (quillHook1 !== null) {
	    var quill1 = new Quill(quillHook1, {
	      modules: {
	        formula: false,
	        syntax: false,
	        toolbar: "#toolbar"
	      },
	      placeholder: "Enter Text!!!!",
	      theme: "snow"
	    });

	    console.log(quill1.getContents());
	    $('#content').val(quill1.getText(0,10000));
	  }
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
                    <h2>Notice VIEW</h2>
                  </div>
                  <div class="card-body">
					<form name="noticeForm" method="post" action="/bbs/notice/edit"  onsubmit="return checkForm();">
					<!-- <form name="noticeForm" method="post" action="/bbs/notice/edit"  > -->
						<input type="hidden" id="seq" name="seq"value="${notice.SEQ}"/>
						<input type="hidden" id="content" name="content"value=""/>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group mb-3">
									<label for="simpleinput">Title</label> 
									<input type="text" name="title" class="form-control" required=""   value="${notice.TITLE}">
								</div>
							</div>
							
							<div class="col-md-12">
							   <div id="standalone">
				                <div id="toolbar">
				                  <span class="ql-formats">
				                    <select class="ql-font"></select>
				                    <select class="ql-size"></select>
				                  </span>
				                  <span class="ql-formats">
				                    <button class="ql-bold"></button>
				                    <button class="ql-italic"></button>
				                    <button class="ql-underline"></button>
				                  </span>
				                  <span class="ql-formats">
				                    <select class="ql-color"></select>
				                  </span>
				                  <span class="ql-formats">
				                    <button class="ql-blockquote"></button>
				                  </span>
				                  <span class="ql-formats">
				                    <button class="ql-list" value="ordered"></button>
				                    <button class="ql-list" value="bullet"></button>
				                    <button class="ql-indent" value="-1"></button>
				                    <button class="ql-indent" value="+1"></button>
				                  </span>
				                  <span class="ql-formats">
				                    <button class="ql-direction" value="rtl"></button>
				                    <select class="ql-align"></select>
				                  </span>
				                </div>
				              </div>
				              <div id="editor">${notice.CONTENT}</div>
							</div>
						</div>
						<div class="col-md-12">
							<button type="button" class="btn btn-secondary" id="cancelBt">Cancel</button>
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
<script src="/resources/assets/plugins/prism/prism.js"></script>
<script src="/resources/assets/plugins/owl-carousel/owl.carousel.min.js"></script>

<script src="/resources/assets/js/mono.js"></script>
<script src="/resources/assets/js/custom.js"></script>
	
</body>

</html>

