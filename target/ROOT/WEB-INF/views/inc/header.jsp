<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="main-header" id="header">
  <nav class="navbar navbar-expand-lg navbar-light" id="navbar">
    <!-- Sidebar toggle button -->
    <button id="sidebar-toggler" class="sidebar-toggle">
      <span class="sr-only">Toggle navigation</span>
    </button>

    <span class="page-title">DMC 방송제작관리 </span>

    <div class="navbar-right ">

      <!-- search form -->
      <!-- <div class="search-form">
        <form action="index.html" method="get">
          <div class="input-group input-group-sm" id="input-group-search">
            <input type="text" name="query" id="search-input" class="form-control" placeholder="Search..." />
            <div class="input-group-append">
              <button class="btn" type="button">/</button>
            </div>
          </div>
        </form>
        <ul class="dropdown-menu dropdown-menu-search">

          <li class="nav-item">
            <a class="nav-link" href="index.html">Morbi leo risus</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.html">Dapibus ac facilisis in</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.html">Porta ac consectetur ac</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.html">Vestibulum at eros</a>
          </li>

        </ul>

      </div> -->

      <ul class="nav navbar-nav">
        <!-- User Account --> 
        <li class="dropdown user-menu">
            <c:choose>
                <c:when test="${USER ne null and USER.USERNAME ne null}">
		          <button href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
		            <img src="/resources/assets/img/user/user-xs-01.jpg" class="user-image rounded-circle" alt="User Image" />
		            
		            <span class="d-none d-lg-inline-block">${USER.USER_NM}</span>
		          </button>
		            <!-- User image -->
		
		            <li>
		              <a class="dropdown-link-item" href="user-profile.html">
		                <i class="mdi mdi-account-outline"></i>
		                <span class="nav-text">${USER.USERNAME } 님 </span>
		              </a>
		            </li>
		
		            <li class="dropdown-footer">
		              <a class="dropdown-link-item" href="/member/logout"> <i class="mdi mdi-logout"></i> Log Out </a>
		            </li>
		          </ul>
                </c:when>
                <c:otherwise>
		          <button href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
		            <i class="mdi mdi-ninja"></i> 
		            <span class="d-none d-lg-inline-block">Guest</span>
		          </button>
		          <ul class="dropdown-menu dropdown-menu-right">
		            <li>
		              <a class="dropdown-link-item" href="/member/login"> <i class="mdi mdi-login"></i> Log In </a>
		            </li>
		          </ul>  
                </c:otherwise>              
            </c:choose>
        </li>
      </ul>
    </div>
  </nav>
</header>
