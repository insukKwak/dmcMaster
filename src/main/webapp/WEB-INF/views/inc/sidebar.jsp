<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<aside class="left-sidebar sidebar-dark" id="left-sidebar">
  <div id="sidebar" class="sidebar sidebar-with-footer">
    <!-- Aplication Brand -->
    <div class="app-brand">
      <a href="/">
        <img src="/resources/assets/img/logo.png" alt="Mono">
        <span class="brand-name">OurProject</span>
      </a>
    </div>
    <!-- begin sidebar scrollbar -->
    <div class="sidebar-scrollbar">

      <!-- sidebar menu -->
      <ul class="nav sidebar-inner" id="sidebar-menu">
      
      <c:choose>
          <c:when test="${USER ne null and USER.USER_NO ne null}">
			<!-- API -->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#apiMng"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-cloud-outline"></i>
	            <span class="nav-text">API Manage</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="apiMng" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	              <li class="">
	                <a class="sidenav-item-link" href="/config/api/list">
	                  <span class="nav-text">API List(kwak)</span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/api/config/list">
	                  <span class="nav-text">API List(bhin)</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        
			<!-- Notice-->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#noticeExample"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-clipboard-text-outline"></i>
	            <span class="nav-text">Notice Example</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="noticeExample" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/bbs/notice/list">
	                  <span class="nav-text">Notice</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        
			<!-- Map-->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#kakaoMapExample"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-map-marker"></i>
	            <span class="nav-text">KakaoMap Example</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="kakaoMapExample" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/kakao/map/list">
	                  <span class="nav-text">Kakao Map</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        
			<!-- File-->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#fileUploadExample"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-file-upload"></i>
	            <span class="nav-text">File Example</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="fileUploadExample" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/file/example/list">
	                  <span class="nav-text">File Upload</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#myFitness"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-run-fast"></i>
	            <span class="nav-text">My Fitness</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="myFitness" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/myFitness/list">
	                  <span class="nav-text">My Fitness</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>  
	        	        
			<!-- Excel-->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#excelExample"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-file-excel"></i>
	            <span class="nav-text">Excel Example</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="excelExample" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/excel/example/upload">
	                  <span class="nav-text">Excel Upload</span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/excel/example/download">
	                  <span class="nav-text">Excel Download</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        
			<!-- chart-->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#chartExample"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-chart-bar"></i>
	            <span class="nav-text">Chart Example</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="chartExample" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	             <li class="">
	                <a class="sidenav-item-link" href="/chart/example/chart">
	                  <span class="nav-text">Chart Example</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>               
	                
			<!-- 샘플페이지 -->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#samples"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-image-filter-none"></i>
	            <span class="nav-text">Sample Page</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="samples" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	              <li class="">
	                <a class="sidenav-item-link" href="/sample/board">
	                  <span class="nav-text">Sample Board</span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/sample/blank">
	                  <span class="nav-text">Sample Blank</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>
	        </c:when>
	         <c:otherwise>
			<!-- 샘플페이지 -->
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#samples"
	            aria-expanded="false" aria-controls="users">
	            <i class="mdi mdi-image-filter-none"></i>
	            <span class="nav-text">Sample Page</span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="samples" data-parent="#sidebar-menu">
	            <div class="sub-menu ">
	              <li class="">
	                <a class="sidenav-item-link" href="/sample/board">
	                  <span class="nav-text">Sample Board</span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/sample/blank">
	                  <span class="nav-text">Sample Blank</span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>	         
	         </c:otherwise>
         </c:choose>
	        
        <!-- 
        <li class="">
          <a class="sidenav-item-link" href="index.html">
            <i class="mdi mdi-briefcase-account-outline"></i>
            <span class="nav-text">Business Dashboard</span>
          </a>
        </li>
        <li class="">
          <a class="sidenav-item-link" href="analytics.html">
            <i class="mdi mdi-chart-line"></i>
            <span class="nav-text">Analytics Dashboard</span>
          </a>
        </li>
        <li class="section-title">
          UI Elements
        </li>
        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#ui-components"
            aria-expanded="false" aria-controls="ui-components">
            <i class="mdi mdi-folder-outline"></i>
            <span class="nav-text">UI Components</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="ui-components" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li class="">
                <a class="sidenav-item-link" href="alert.html">
                  <span class="nav-text">Alert</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="badge.html">
                  <span class="nav-text">Badge</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="breadcrumb.html">
                  <span class="nav-text">Breadcrumb</span>

                </a>
              </li>
              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#buttons"
                  aria-expanded="false" aria-controls="buttons">
                  <span class="nav-text">Buttons</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="buttons">
                  <div class="sub-menu">
                    <li class="">
                      <a href="button-default.html">Button Default</a>
                    </li>
                   <li class="">
                      <a href="button-dropdown.html">Button Dropdown</a>
                    </li>
                   <li class="">
                      <a href="button-group.html">Button Group</a>
                    </li>
                   <li class="">
                      <a href="button-social.html">Button Social</a>
                    </li>
                   <li class="">
                      <a href="button-loading.html">Button Loading</a>
                    </li>
                  </div>
                </ul>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="card.html">
                  <span class="nav-text">Card</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="carousel.html">
                  <span class="nav-text">Carousel</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="collapse.html">
                  <span class="nav-text">Collapse</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="editor.html">
                  <span class="nav-text">Editor</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="list-group.html">
                  <span class="nav-text">List Group</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="modal.html">
                  <span class="nav-text">Modal</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="pagination.html">
                  <span class="nav-text">Pagination</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="popover-tooltip.html">
                  <span class="nav-text">Popover & Tooltip</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="progress-bar.html">
                  <span class="nav-text">Progress Bar</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="spinner.html">
                  <span class="nav-text">Spinner</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="switches.html">
                  <span class="nav-text">Switches</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="tab.html">
                  <span class="nav-text">Tab</span>
                </a>
              </li>
              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#tables"
                  aria-expanded="false" aria-controls="tables">
                  <span class="nav-text">Tables</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="tables">
                  <div class="sub-menu">
                    <li class="">
                      <a href="bootstarp-tables.html">Bootstrap Tables</a>
                    </li>
                    <li class="">
                      <a href="data-tables.html">Data Tables</a>
                    </li>
                  </div>
                </ul>
              </li>

              <li class="">
                <a class="sidenav-item-link" href="toaster.html">
                  <span class="nav-text">Toaster</span>
                </a>
              </li>

              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#icons"
                  aria-expanded="false" aria-controls="icons">
                  <span class="nav-text">Icons</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="icons">
                  <div class="sub-menu">
                    <li class="">
                      <a href="material-icons.html">Material Icon</a>
                    </li>
                    <li class="">
                      <a href="flag-icons.html">Flag Icon</a>
                    </li>
                  </div>
                </ul>
              </li>
              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#forms"
                  aria-expanded="false" aria-controls="forms">
                  <span class="nav-text">Forms</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="forms">
                  <div class="sub-menu">
                    <li class="">
                      <a href="basic-input.html">Basic Input</a>
                    </li>

                    <li class="">
                      <a href="input-group.html">Input Group</a>
                    </li>

                    <li class="">
                      <a href="checkbox-radio.html">Checkbox & Radio</a>
                    </li>

                    <li class="">
                      <a href="form-validation.html">Form Validation</a>
                    </li>

                    <li class="">
                      <a href="form-advance.html">Form Advance</a>
                    </li>

                  </div>
                </ul>
              </li>

              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#maps"
                  aria-expanded="false" aria-controls="maps">
                  <span class="nav-text">Maps</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="maps">
                  <div class="sub-menu">

                    <li class="">
                      <a href="google-maps.html">Google Map</a>
                    </li>

                    <li class="">
                      <a href="vector-maps.html">Vector Map</a>
                    </li>

                  </div>
                </ul>
              </li>

              <li class="has-sub ">
                <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#widgets"
                  aria-expanded="false" aria-controls="widgets">
                  <span class="nav-text">Widgets</span> <b class="caret"></b>
                </a>
                <ul class="collapse " id="widgets">
                  <div class="sub-menu">

                    <li class="">
                      <a href="widgets-general.html">General Widget</a>
                    </li>

                    <li class="">
                      <a href="widgets-chart.html">Chart Widget</a>
                    </li>

                  </div>
                </ul>
              </li>

            </div>
          </ul>
        </li>

        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#charts"
            aria-expanded="false" aria-controls="charts">
            <i class="mdi mdi-chart-pie"></i>
            <span class="nav-text">Charts</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="charts" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li class="">
                <a class="sidenav-item-link" href="apex-chart-js.html">
                  <span class="nav-text">Apex ChartJS</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
        <li class="section-title">
          Pages
        </li>
        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#users"
            aria-expanded="false" aria-controls="users">
            <i class="mdi mdi-image-filter-none"></i>
            <span class="nav-text">User</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="users" data-parent="#sidebar-menu">
            <div class="sub-menu ">
              <li class="">
                <a class="sidenav-item-link" href="user-profile.html">
                  <span class="nav-text">User Profile</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-activities.html">
                  <span class="nav-text">User Activities</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-profile-settings.html">
                  <span class="nav-text">User Profile Settings</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-account-settings.html">
                  <span class="nav-text">User Account Settings</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-planing-settings.html">
                  <span class="nav-text">User Planing Settings</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-billing.html">
                  <span class="nav-text">User billing</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="user-notify-settings.html">
                  <span class="nav-text">User Notify Settings</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
        <li class="has-sub">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#authentication"
            aria-expanded="false" aria-controls="authentication">
            <i class="mdi mdi-account"></i>
            <span class="nav-text">Authentication</span> <b class="caret"></b>
          </a>
          <ul class="collapse" id="authentication" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li>
                <a class="sidenav-item-link" href="sign-in.html">
                  <span class="nav-text">Sign In</span>
                </a>
              </li>
              <li>
                <a class="sidenav-item-link" href="sign-up.html">
                  <span class="nav-text">Sign Up</span>
                </a>
              </li>
              <li>
                <a class="sidenav-item-link" href="reset-password.html">
                  <span class="nav-text">Reset Password</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#email"
            aria-expanded="false" aria-controls="email">
            <i class="mdi mdi-email"></i>
            <span class="nav-text">email</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="email" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li class="">
                <a class="sidenav-item-link" href="email-inbox.html">
                  <span class="nav-text">Email Inbox</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="email-details.html">
                  <span class="nav-text">Email Details</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="email-compose.html">
                  <span class="nav-text">Email Compose</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#other-page"
            aria-expanded="false" aria-controls="other-page">
            <i class="mdi mdi-file-multiple"></i>
            <span class="nav-text">Other pages</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="other-page" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li>
                <a class="sidenav-item-link" href="404.html">
                  <span class="nav-text">404 page</span>
                </a>
              </li>
              <li>
                <a class="sidenav-item-link" href="page-comingsoon.html">
                  <span class="nav-text">Coming Soon</span>
                </a>
              </li>
              <li>
                <a class="sidenav-item-link" href="page-maintenance.html">
                  <span class="nav-text">Maintenance</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="invoice.html">
                  <span class="nav-text">invoice</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
        <li class="section-title">
          Documentation
        </li>
        <li class="">
          <a class="sidenav-item-link" href="getting-started.html">
            <i class="mdi mdi-airplane"></i>
            <span class="nav-text">Getting Started</span>
          </a>
        </li>
        <li class="has-sub ">
          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#customization"
            aria-expanded="false" aria-controls="customization">
            <i class="mdi mdi-square-edit-outline"></i>
            <span class="nav-text">Customization</span> <b class="caret"></b>
          </a>
          <ul class="collapse " id="customization" data-parent="#sidebar-menu">
            <div class="sub-menu">
              <li class="">
                <a class="sidenav-item-link" href="navbar-customization.html">
                  <span class="nav-text">Navbar</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="sidebar-customization.html">
                  <span class="nav-text">Sidebar</span>
                </a>
              </li>
              <li class="">
                <a class="sidenav-item-link" href="styling.html">
                  <span class="nav-text">Styling</span>
                </a>
              </li>
            </div>
          </ul>
        </li>
 -->
      </ul>
    </div>
    <!-- <div class="sidebar-footer">
      <div class="sidebar-footer-content">
        <ul class="d-flex">
          <li>
            <a href="user-account-settings.html" data-toggle="tooltip" title="Profile settings"><i
                class="mdi mdi-settings"></i></a></li>
          <li>
            <a href="#" data-toggle="tooltip" title="No chat messages"><i class="mdi mdi-chat-processing"></i></a>
          </li>
        </ul>
      </div>
    </div> -->
  </div>
</aside>
