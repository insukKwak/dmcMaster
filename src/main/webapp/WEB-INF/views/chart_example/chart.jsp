<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <!DOCTYPE html>
<html lang="en" dir="ltr">

<%@include file="/WEB-INF/views/inc/head.jsp"%>

  <body class="navbar-fixed sidebar-fixed" id="body">
    <script>
    /*======== 6. RADIAL BAR CHART 01 ========*/
    var radialBarChart1 = document.querySelector("#radial-bar-chart-1");
    if (radialBarChart1 !== null){
      var radialBarOptions1 = {
        chart: {
          width: '100%',
          type: 'radialBar',
          height: 345
        },
        plotOptions: {
          radialBar: {
            size: 100,
            hollow: {
              size: '60%'
            },
            dataLabels: {
              show: true,
              name: {
                show: true,
                fontSize: '14px',
                fontFamily: undefined,
                color: '#222'
              },
              value: {
                show: true,
                fontSize: '16px',
                fontFamily: undefined,
                color: undefined,
                offsetY: 16,
                formatter: function () {
                  return ''
                }
              },
            }
          },
        },
        fill: {
          type: 'solid',
          colors: '#9e6de0'
        },
        series: [70],
        labels: ['Yearly Revenue'],
      }

      var randerRadialBar1 = new ApexCharts(radialBarChart1, radialBarOptions1);
      randerRadialBar1.render();
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
              <div class="col-xl-8">
                <!-- Income and Express -->
                <div class="card card-default">
                  <div class="card-header">
                    <h2>Income And Expenses</h2>
                    <div class="dropdown">
                      <a class="dropdown-toggle icon-burger-mini" href="#" role="button" id="dropdownMenuLink"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                      </a>

                      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                      </div>
                    </div>

                  </div>
                  <div class="card-body">
                    <div class="chart-wrapper">
                      <div id="mixed-chart-1"></div>
                    </div>
                  </div>

                </div>
              </div>
              <div class="col-xl-4">
                <!-- Revenue -->
                <div class="card card-default">
                  <div class="card-header justify-content-center">
                    <h2>Progress Donut Chart</h2>
                  </div>
                  <div class="card-body pt-0">
                    <div class="chart-wrapper">
                      <div id="radial-bar-chart-1"></div>
                    </div>
                    <div class="radial-bar-chart-footer">
                      <div class="title-large">$25,350 <i class="mdi mdi-arrow-up text-success"></i></div>
                      <div class="title-small">vs $12,600 (prev)</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-lg-6">
                <!-- Pie Chart  -->
                <div class="card card-default">
                  <div class="card-header">
                    <h2>Pie Chart</h2>
                  </div>
                  <div class="card-body p-xl-7">
                    <div id="simple-pie-chart" class="d-flex justify-content-center"></div>
                  </div>

                </div>
              </div>

              <!-- Sessions by Device -->
              <div class="col-lg-6">
                <!-- Sessions By Device -->
                <div class="card card-default">
                  <div class="card-header border-bottom">
                    <h2 class="mdi mdi-desktop-mac">Sessions by Device</h2>
                  </div>
                  <div class="card-body pt-6">
                    <div class="row">
                      <div class="col-lg-6">
                        <div id="donut-chart-1"></div>
                      </div>
                      <div class="col-lg-6">
                        <div class="media mb-4">
                          <i class="display-4 mdi mdi-remote-desktop text-primary mr-3"></i>
                          <div class="media-body">
                            <p>Desktop</p>
                            <p class="h4 my-1 text-dark">45% <span class="text-success">23.5% <i
                                  class="mdi mdi-arrow-up-bold small"></i></span>
                            </p>
                            <p>vs 155,900 (prev)</p>
                          </div>
                        </div>

                        <div class="media mb-4">
                          <i class="display-4 mdi mdi-tablet-android text-primary mr-3"></i>
                          <div class="media-body">
                            <p>Tablet</p>
                            <p class="h4 my-1 text-dark">30% <span class="text-success">13.5% <i
                                  class="mdi mdi-arrow-up-bold small"></i></span>
                            </p>
                            <p>vs 187,900 (prev)</p>
                          </div>
                        </div>

                        <div class="media mb-4">
                          <i class="display-4 mdi mdi-cellphone-iphone text-primary mr-3"></i>
                          <div class="media-body">
                            <p>Mobile</p>
                            <p class="h4 my-1 text-dark">25% <span class="text-success">35.5% <i
                                  class="mdi mdi-arrow-up-bold small"></i></span>
                            </p>
                            <p>vs 309,900 (prev)</p>
                          </div>
                        </div>
                      </div>
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
<!-- <script src="/resources/assets/js/chart.js"></script> -->
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
      name: 'Income',
      type: 'column',
      data: [44, 55, 57, 56, 61, 58, 63, 60, 66, 55, 47, 67]
    }, {
      name: 'Expenses',
      type: 'column',
      data: [76, 85, 101, 98, 87, 100, 91, 40, 94, 50, 47, 55]
    },
    {
      name: 'profit',
      data: [50, 40, 64, 87, -15, 104, 63, 42, 32, 60, 78, 25],
      type: 'line'
    }],

    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],

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

var radialBarChart1 = document.querySelector("#radial-bar-chart-1");
if (radialBarChart1 !== null){
  var radialBarOptions1 = {
    chart: {
      width: '100%',
      type: 'radialBar',
      height: 345
    },
    plotOptions: {
      radialBar: {
        size: 100,
        hollow: {
          size: '60%'
        },
        dataLabels: {
          show: true,
          name: {
            show: true,
            fontSize: '14px',
            fontFamily: undefined,
            color: '#222'
          },
          value: {
            show: true,
            fontSize: '16px',
            fontFamily: undefined,
            color: undefined,
            offsetY: 16,
            formatter: function () {
              return ''
            }
          },
        }
      },
    },
    fill: {
      type: 'solid',
      colors: '#9e6de0'
    },
    series: [70],
    labels: ['Yearly Revenue'],
  }

  var randerRadialBar1 = new ApexCharts(radialBarChart1, radialBarOptions1);
  randerRadialBar1.render();
}

var donutChart1 = document.querySelector("#donut-chart-1");
if (donutChart1 !== null){
  var donutChartOptions1 = {
    chart: {
      type: 'donut',
      height: 270
    },

    colors: ['#bb91f2', '#af81eb', '#9e6de0'],
    labels: ['Desktop', 'Tablet', 'Mobile'],
    series: [45, 30, 25],
    legend: {
      show: false
    },
    dataLabels: {
      enabled: false,
    },
    tooltip: {
      y: {
        formatter: function (val) {
          return + val + "%"
        }
      }
    }

  }

  var randerDonutchart1 = new ApexCharts(donutChart1, donutChartOptions1 );

  randerDonutchart1.render();
}

var SimplePieChart = document.querySelector("#simple-pie-chart");
if (SimplePieChart !== null) {
  var simplePieChartOptions = {
    chart: {
      width: 350,
      type: 'pie',
    },
    colors: ['#9e6de0', '#46c79e', '#fd5190'],
    labels: ['First Data', 'Second Data', 'Third Data'],
    legend: {
      position: 'top',
      horizontalAlign: 'left',
      markers: {
        radius: 0,
      }
    },
    series: [65, 25, 10],

  }

  var simpleplePieChartRander = new ApexCharts(SimplePieChart, simplePieChartOptions);

  simpleplePieChartRander.render();

}
</script>
</body>

</html>

