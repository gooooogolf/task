<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Organizations</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ค้นหา
	      <small>รายชื่อ อปท.</small>
	   </h1>
	</div>
	<p>พิมพ์ชื่อบางส่วนขององค์การปกครองส่วนท้องถิ่นที่ต้องการค้นหาข้อมูลหรือต้องการตามงาน</p>
	<form class="form-horizontal"  role="search" action="${pageContext.request.contextPath}/organizations" method="post">
	  <div class="form-group">
	  	<div class="col-sm-3">
	    <input type="text" name="term" id="term" class="form-control" placeholder="ชื่อ อปท.">
	    </div>
	    <div class="col-sm-7">
	     <button type="submit" class="btn btn-default">ค้นหา</button>
	    </div> 
	  </div>
	</form>
	<c:if test="${!empty organizations}">
	<div class="table-responsive">
	<table class="table table-hover">
		<thead>
		<tr>
<!-- 			<th></th> -->
			<th>ชื่อ อปท.</th>
			<th>อำเภอ</th>
			<th>จังหวัด</th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${organizations}" var="organization">
			<tr>
<%-- 				<td>${organization.orgId }</td> --%>
				<td>${organization.orgName }</td>
				<td>${organization.amphurName }</td>
				<td>${organization.provinceName }</td>
				<td>
					<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stocks/organization?orgId=${organization.orgId }'">กสทช.</button>
				</td>
				<td>
					<button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheets?orgId=${organization.orgId }'">ตามงาน</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>