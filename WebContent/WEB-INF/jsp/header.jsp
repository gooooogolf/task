<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sticky-footer-navbar.css">
<style>
/* navbar */
.navbar-default {
     background-color: #e74c3c; 
/*  	background-color: #FF0000; */
    border-color: #c0392b;
}
/* title */
.navbar-default .navbar-brand {
    color: #ecf0f1;
}
.navbar-default .navbar-brand:hover,
.navbar-default .navbar-brand:focus {
    color: #ffbbbc;
}
/* link */
.navbar-default .navbar-nav > li > a {
    color: #ecf0f1;
}
.navbar-default .navbar-nav > li > a:hover,
.navbar-default .navbar-nav > li > a:focus {
    color: #333;
}
.navbar-default .navbar-nav > .active > a, 
.navbar-default .navbar-nav > .active > a:hover, 
.navbar-default .navbar-nav > .active > a:focus {
    color: #555;
    background-color: #c0392b;
}
.navbar-default .navbar-nav > .open > a, 
.navbar-default .navbar-nav > .open > a:hover, 
.navbar-default .navbar-nav > .open > a:focus {
    color: #555;
    background-color: #D5D5D5;
}
/* caret */
.navbar-default .navbar-nav > .dropdown > a .caret {
    border-top-color: #ecf0f1;
    border-bottom-color: #ecf0f1;
}
.navbar-default .navbar-nav > .dropdown > a:hover .caret,
.navbar-default .navbar-nav > .dropdown > a:focus .caret {
    border-top-color: #333;
    border-bottom-color: #333;
}
.navbar-default .navbar-nav > .open > a .caret, 
.navbar-default .navbar-nav > .open > a:hover .caret, 
.navbar-default .navbar-nav > .open > a:focus .caret {
    border-top-color: #555;
    border-bottom-color: #555;
}
/* mobile version */
.navbar-default .navbar-toggle {
    border-color: #DDD;
}
.navbar-default .navbar-toggle:hover,
.navbar-default .navbar-toggle:focus {
    background-color: #DDD;
}
.navbar-default .navbar-toggle .icon-bar {
    background-color: #CCC;
}
@media (max-width: 767px) {
    .navbar-default .navbar-nav .open .dropdown-menu > li > a {
        color: #ecf0f1;
    }
    .navbar-default .navbar-nav .open .dropdown-menu > li > a:hover,
    .navbar-default .navbar-nav .open .dropdown-menu > li > a:focus {
        color: #333;
    }
}
</style>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
<div class="container">
   <div class="navbar-header">
   		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
      	</button>
      	<a class="navbar-brand" href="${pageContext.request.contextPath}"><font color="white">เจ ซอฟท์</font></a>
   </div>
   <div>
   <div id="navbar" class="collapse navbar-collapse">
	<ul class="nav navbar-nav">
<%-- 		<li class="active"><a href="${pageContext.request.contextPath}">แจ้งเตือน</a></li> --%>
		<li><a href="${pageContext.request.contextPath}/organizations">หน่วยงาน</a></li>
		<li><a href="${pageContext.request.contextPath}/dealers">ดีลเลอร์</a></li>
		<li><a href="${pageContext.request.contextPath}/stocks">กสทช.</a></li>
<!-- 		<li><a href="#">Stock</a></li> -->
<!-- 		<li><a href="#">รายงาน</a></li> -->
		<li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">ข้อมูลหลัก <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/jobs">งาน</a></li>
                <li><a href="${pageContext.request.contextPath}/status">สถานะ</a></li>
				<li><a href="${pageContext.request.contextPath}/users">พนักงาน</a></li>
            </ul>
	    </li>
	    <li><a href="${pageContext.request.contextPath}/petty-cash">เบิกเงิน</a></li>
	</ul>
	<c:choose>
	<c:when  test="${empty pageContext.request.userPrincipal.name}"> 
		<p class="navbar-text navbar-right">
			<a href="${pageContext.request.contextPath}/login" class="navbar-link">กรุณาเข้าสู่ระบบ</a>
		</p>
	</c:when >
	<c:otherwise>
		<ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	            <a href="#" data-toggle="dropdown" class="dropdown-toggle">${pageContext.request.userPrincipal.name} <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/timesheet/user/myjobs">งานของฉัน</a></li>
	                <li><a href="${pageContext.request.contextPath}/user/get?name=${pageContext.request.userPrincipal.name}">เปลี่ยน Password</a></li>
	                <li class="divider"></li> 
	                <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">ออกจากระบบ</a></li>
<!-- 					<li><a href="#">Settings</a></li> -->
	            </ul>
	        </li>
		</ul>
	</c:otherwise>
	</c:choose>
	</div>
   </div>
</div>
</nav>