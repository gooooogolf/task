<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>รายชื่อพนักงาน</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ข้อมูล
	      <small>รายชื่อพนักงาน</small>
	   </h1>
	</div>
	<div class="table-responsive">
	<table class="table table-hover">
		<thead>
		<tr>	
			<th>User</th>
			<th>ชื่อพนักงาน</th>
			<th></th>
		</tr>
		</thead>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.description }</td>
				<td>
					<button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/users/view?name=${user.username }'">ข้อมูล</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button type="button" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/users/new'">เพิ่มพนักงาน</button>
	<br><br>	
	</div>
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>