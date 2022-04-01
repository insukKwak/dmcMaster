<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <head>
<%@include file="/WEB-INF/views/inc/head.jsp"%>	

<script type="text/javascript">

	var SaveAjax = true;
	var login = function() {
		
		if (!$("#refer").val()) {
			var refer = "";
			if (window.location.pathname != "/member/login") {
				refer = location.href;
			} else if (!window.location.origin) {
			  	refer = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port: '');
			} else {
				refer = window.location.origin;
			}

			$("#refer").val(refer);
		}
		var options = {
			url : "/member/loginCms",
			dataType : "json",
			type : "post",
			async : false,
			data : $("form[name='frm']").serialize(),
			beforeSend : function() {
				SaveAjax = false;
			},
			success : function(result) {
				if (result != null) {
					if (result.codeValue == 200) {
						if ((!result.refer || result.refer == "/member/login") && window.location.pathname == "/member/login") {
							window.location.replace("/prps/reg/list");
						} else if (result.refer) {
							window.location.replace(result.refer);
						} else {
							window.location.replace(window.location.pathname + window.location.search);
						}
					} else {
						alert(result.message__NOTXSS);
					}
				} else {
					alert("[402]로그인에 실패하였습니다.");
				}
			},
			error : function() {
				//alert(options.url);
				alert("[401]서버와 통신에 실패하였습니다.");
			},
			complete : function(data) {
				SaveAjax = true;
			}
		};

		$.ajax(options);

		return false;
	};
	</script>
</head>

  <body class="bg-light-gray" id="body">
          <div class="container d-flex align-items-center justify-content-center" style="min-height: 100vh">
          <div class="d-flex flex-column justify-content-between">
            <div class="row justify-content-center mt-5">
              <div class="col-lg-6 col-md-10">
                <div class="card card-default">
                  <div class="card-header pb-0">
                    <div class="app-brand w-100 d-flex justify-content-center border-bottom-0">
                      <a class="w-auto pl-0" href="/">
                       <!--  <img src="/resoouces/assets/img/logo.png" alt="Mono"> -->
                        <span class="brand-name text-dark">DMC 방송제작비관리  </span>
                      </a>
                    </div>
                  </div>
                  <div class="card-body px-5 pb-5 pt-0">

                    <h4 class="text-dark mb-6 text-center"> 로그인</h4>

                    <form  name="frm" method="post" action="/member/loginCms" onsubmit="return login();">
					<input type="hidden" id="refer" name="refer" value="${param.refer}" />
                      <div class="row">
                        <div class="form-group col-md-12 mb-4">
                          <input type="text" class="form-control input-lg" id="id"  name="id" required="" placeholder="Enter your ID">
                        </div>
                        <div class="form-group col-md-12 ">
                          <input type="password" class="form-control input-lg" id="password" name="password" required=""  placeholder="Enter your password">
                        </div>
                        <div class="col-md-12">

                          <div class="d-flex justify-content-between mb-3">



                          </div>

                          <button type="submit" class="btn btn-primary btn-pill mb-4"  a href="#goLogin" onclick="login(); return false;">로그인</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <div class="copyright pl-0">
              <p class="text-center">&copy; Copyright by Our Project.
               <!--  <a class="text-primary" href="http://www.iamabdus.com/" target="_blank">Abdus</a>. -->
              </p>
            </div>
          </div>
        </div>
        
<script src="/resources/assets/plugins/jquery/jquery.min.js"></script>
<script src="/resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
