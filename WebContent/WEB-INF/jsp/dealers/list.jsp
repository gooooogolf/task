<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dealer</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ค้นหา
	      <small>รายชื่อ Dealer</small>
	   </h1>
	</div>
	<p>พิมพ์ชื่อบางส่วนของ Dealer, หน่วยงานที่ต้องการค้นหาข้อมูลหรือต้องการตามงาน</p>
	<form class="form-horizontal" role="search" action="${pageContext.request.contextPath}/dealers" method="post">
	  <div class="form-group">
	  	<div class="col-sm-3">
	    <input type="text" name="term" id="term" class="form-control" placeholder="ชื่อ Dealer">
	    </div>
	    <div class="col-sm-7">
	     <button type="submit" class="btn btn-default">ค้นหา</button>
	    </div> 
	  </div>
	</form>
	<c:if test="${!empty dealers}">
	<div class="table-responsive">
	<table class="table table-hover">
		<thead>
		<tr>
			<th style="width: 15%;">ชื่อ Dealer</th>
			<th>รายละเอียด</th>
			<th style="width: 15%;">เบอร์ติดต่อ</th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${dealers}" var="dealer">
			<tr>
				<td>${dealer.name }</td>
				<td>${dealer.description }</td>
				<td>${dealer.phone }</td>
				<td>
				<button type="button" class="btn btn-warning" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers/edit?id=${dealer.id }'">ข้อมูล</button>
				</td>
				<td>
				<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stocks/dealer?dealerId=${dealer.id }'">กสทช.</button>
				</td>
				<td>
				<button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers/view?id=${dealer.id }'">ตามงาน</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>
	<div>
	<button type="button" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers/new'">เพิ่มข้อมูล Dealer</button>
	<br><br>
	</div>
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>