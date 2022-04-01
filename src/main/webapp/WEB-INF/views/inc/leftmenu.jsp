<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<aside class="left-sidebar sidebar-dark" id="left-sidebar">
  <div id="sidebar" class="sidebar sidebar-with-footer">
    <!-- Aplication Brand -->
    <div class="app-brand">
      <a href="/">
        <img src="/resources/assets/img/logo.png" alt="Mono">
        <span class="brand-name">DMC 방송 제작 관리 </span>
      </a>
    </div>
    <!-- begin sidebar scrollbar -->
    <div class="sidebar-scrollbar">

      <!-- sidebar menu -->
      <ul class="nav sidebar-inner" id="sidebar-menu">
      
      <c:choose>
          <c:when test="${USER ne null and USER.USERNAME ne null}">
			<!-- API -->
	        <li class="has-sub " >
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#prdt"
	            aria-expanded="false" aria-controls="prdt">
	            <i class="mdi mdi-image-filter-none"></i>
	            <span class="nav-text">기준 정보 관리 </span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="prdt" >
	            <div class="sub-menu ">
	              <li class="">
	                <a class="sidenav-item-link" href="/prdt/cost/list">
	                  <span class="nav-text">제작비 항목 관리 </span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/prdt/cust/list">
	                  <span class="nav-text">거래선 관리 </span>
	                </a>
	              </li>
	               <li class="">
	                <a class="sidenav-item-link" href="/prdt/appr/list">
	                  <span class="nav-text">결제선 관리 </span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>  
	        <li class="has-sub ">
	          <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#prps"
	            aria-expanded="false" aria-controls="prps">
	            <i class="mdi mdi-image-filter-none"></i>
	            <span class="nav-text">기획서 관리 </span> <b class="caret"></b>
	          </a>
	          <ul class="collapse " id="prps">
	            <div class="sub-menu ">
	              <li class="">
	                <a class="sidenav-item-link" href="/prps/reg/list">
	                  <span class="nav-text">기획서 등록 </span>
	                </a>
	              </li>
	              <li class="">
	                <a class="sidenav-item-link" href="/prps/def/list">
	                  <span class="nav-text">기획서 관리 </span>
	                </a>
	              </li>
	            </div>
	          </ul>
	        </li>      
	        
			             
	        </c:when>
	         <c:otherwise>
	         </c:otherwise>
         </c:choose>
	        
      </ul>
    </div>
  </div>
</aside>
