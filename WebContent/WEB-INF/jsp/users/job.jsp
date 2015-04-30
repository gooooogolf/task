<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Sirimongkol Panwa, JSOFT">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<title>งานของ  ${user.username}</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>งานของฉันตั้งแต่ต้นปี ${timesheetYear } ถึง ปัจจุบัน</h1>
	</div>
	<form class="form-horizontal"  role="search" action="${pageContext.request.contextPath}/timesheet/user/myjobs" method="post">
	  <div class="form-group">
           <div class="col-sm-3">
           		<select id="select-years" name="timesheetYear" class="form-control">
           		<c:forEach items="${years}" var="year">
           			<option value="${year}" ${year == timesheetYear ? 'selected = "selected"' : ''}>พ.ศ. ${year }</option>
           		</c:forEach>
         		</select>
           </div>
			<div class="col-sm-7">
	     	<button type="submit" class="btn btn-default">ค้นหา</button>
	    	</div>
      </div>
	</form>	
	<c:if test="${!empty organizations || !empty dealers}">
	<div class="table-responsive">
	<table class="table table-hover">
		<thead>
		<tr>
			<th>หน่วยงาน</th>
			<th>ประเภท</th>
			<th>ติดต่อ (ครั้ง)</th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:if test="${!empty organizations}">
			<c:forEach items="${organizations}" var="organization">
				<tr>
					<td>${organization.value.orgName }</td>
					<td>หน่วยงาน</td>
					<td>${countMap[organization.value.orgId] }</td>
					<td>
						<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stocks/organization?orgId=${organization.value.orgId }'">กสทช.</button>
					</td>
					<td>
						<button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheets?orgId=${organization.value.orgId }'">ตามงาน</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${!empty dealers}">
			<c:forEach items="${dealers}" var="dealer">
				<tr>
					<td>${dealer.value.name }</td>
					<td>ดีลเลอร์</td>
					<td>${countMap[dealer.value.name] }</td>
					<td>
						<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stocks/dealer?dealerId=${dealer.value.id }'">กสทช.</button>
					</td>
					<td>
						<button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers/view?id=${dealer.value.id }'">ตามงาน</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
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