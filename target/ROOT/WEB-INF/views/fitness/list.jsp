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
                    <h2>Fitness List</h2>
                  </div>
                  <div class="card-body">
                    <table id="productsTable" class="table table-hover table-product" style="width:100%">
                      <thead>
                        <tr>
	                      <th></th>
	                      <th>SEQ</th>
	                      <th>아이디</th>
	                      <th>유저명</th>
	                      <th>목표 칼로리</th>
	                      <th>칼로리</th>
	                      <th>목표 운동시간</th>
	                      <th>운동시간</th>
	                      <th>목표 걸음</th>
	                      <th>걸음</th>
	                      <th>목표 거리</th>
	                      <th>거리</th>
	                      <th>등록일</th>
	                      <th></th>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="fitness" items="${userList}" varStatus="idx">
	                        <tr>
								<td></td>
								<td>${fitness.SEQ}</td>
								<td>${fitness.USER_NO}</td>
								<td>${fitness.USER_NM}</td>
								<td>${fitness.T_CAL}</td>
								<td>${fitness.CAL}</td>
								<td>${fitness.T_TIME}</td>
								<td>${fitness.TIME}</td>
								<td>${fitness.T_STEP}</td>
								<td>${fitness.STEP}</td>
								<td>${fitness.T_DISTANCE}</td>
								<td>${fitness.DISTANCE}</td>
								<td>${fitness.CRE_DT}</td>
								<td>
		                            <div class="dropdown">
		                              <a class="dropdown-toggle icon-burger-mini" href="#" role="button" id="dropdownMenuLink"
		                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                              </a>
		
		                              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
		                                <a class="dropdown-item" href="/myFitness/view?seq=${fitness.SEQ}">View</a>
		                              </div>
		                            </div>
		                          </td>
	                        </tr>
					  </c:forEach>  
                      </tbody>
                    </table>
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
	var mixedChart1 = document.querySelector("#mixed-chart-1");
	if (mixedChart1 !== null){
	  var mixedOptions1 = {
	    chart: {
	      height: 370,
	      type: 'bar',
	      toolbar: {
	        show: false,
	      }
	    },
	    colors: ['#9e6de0', '#faafca', '#f2e052'],
	    legend: {
	      show: true,
	      position: 'top',
	      horizontalAlign: 'right',
	      markers: {
	        width: 20,
	        height: 5,
	        radius: 0,
	      },
	    },
	    plotOptions: {
	      bar: {
	        horizontal: false,
	        columnWidth: '50%',
	        barHeight: '10%',
	        distributed: false,
	      }
	    },
	    dataLabels: {
	      enabled: false
	    },
	
	    stroke: {
	      show: true,
	      width: 2,
	      curve: 'smooth'
	    },
	
	    series: [{
	      name: '목표',
	      type: 'column',

	  	<c:forEach var="f" items="${userList}" varStatus="idx">
	  		data: [${f.T_CAL}, ${f.T_TIME}, ${f.T_STEP},${f.T_DISTANCE}]
	  	</c:forEach>
	      //data: [${gData}, 55, 57, 56, 61, 58, 63, 60, 66, 55, 47, 67]
	    }, {
	      name: '수행',
	      type: 'column',
		<c:forEach var="f" items="${userList}" varStatus="idx">
  			data: [${f.CAL}, ${f.TIME}, ${f.STEP},${f.DISTANCE}]
  		</c:forEach>
	    }],
	
	    xaxis: {
	      categories: ['칼로리', '운동시간', '걸음수', '거리'],
	
	      axisBorder: {
	        show: false,
	      },
	      axisTicks: {
	        show: false
	      },
	      crosshairs: {
	        width: 40,
	      }
	    },
	
	    fill: {
	      opacity: 1
	
	    },
	
	    tooltip: {
	      shared: true,
	      intersect: false,
	      followCursor: true,
	      fixed: {
	        enabled: false
	      },
	      x: {
	        show: false
	      },
	      y: {
	        title: {
	          formatter: function (seriesName) {
	            return seriesName
	          }
	        },
	      },
	    }
	
	  }
	
	  var randerMixedChart1 = new ApexCharts(mixedChart1, mixedOptions1);
	  randerMixedChart1.render();
}
</script>
						
</body>

</html>

