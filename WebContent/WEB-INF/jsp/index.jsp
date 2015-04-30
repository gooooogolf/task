<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Sirimongkol Panwa, JSOFT">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<title>JSOFT DB</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>สวัสดี, ${empty pageContext.request.userPrincipal.name ? 'ผู้ใช้ทั่วไป' : pageContext.request.userPrincipal.name}</h1>
<!-- 	   <small>ยินดีต้อรับเข้าสู่ระบบฐานข้อมูล JSOFT</small> -->
<%-- 		<p>${date }&nbsp; เวลา ${time }</p> --%>
	</div>
	<c:if test="${!empty timesheets}"> 
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>#</th>
					<th>หน่วยงาน</th>
					<th>งาน</th>
					<th>สถานะ</th>
					<th>พนักงาน</th>
					<th>วันที่แจ้งเตือน</th>
					<th style="width: 5%;"></th>
				</tr>
				</thead>
				<c:if test="${!empty organizations}"> 
				<c:forEach items="${organizations}" var="organization">
					<c:forEach items="${timesheets}" var="timesheet">
					<c:if test="${timesheet.organization == organization.value}"> 
						<tr>
							<td>${!empty timesheet.uploadFile ? '<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>':''}</td>
							<td>${organization.value.orgName }</td>
							<td>${timesheet.job.name }</td>
							<td>${timesheet.status.name }</td>
							<td>${timesheet.userModify.description }</td>
							<td>
							 	<fmt:setLocale value="th_TH" scope="session"/>
	                			<fmt:formatDate value="${!empty timesheet.effectiveRemindDate ? timesheet.effectiveRemindDate : ''}" pattern="d MMM yyyy" var="effectiveRemind"/>
								${effectiveRemind }
							</td>									
							<td>
								<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/view?id=${timesheet.id }'">ข้อมูล</button>
							</td>
						</tr>
					</c:if>
					</c:forEach>
				</c:forEach>
				</c:if>
				<c:if test="${!empty dealers}"> 
				<c:forEach items="${dealers}" var="dealer">
					<c:forEach items="${timesheets}" var="timesheet">
					<c:if test="${timesheet.dealer == dealer.value}"> 
						<tr>
							<td>${!empty timesheet.uploadFile ? '<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>':''}</td>
							<td>${dealer.value.name }</td>
							<td>${timesheet.job.name }</td>
							<td>${timesheet.status.name }</td>
							<td>${timesheet.userModify.description }</td>
							<td>
							 	<fmt:setLocale value="th_TH" scope="session"/>
	                			<fmt:formatDate value="${!empty timesheet.effectiveRemindDate ? timesheet.effectiveRemindDate : ''}" pattern="d MMM yyyy" var="effectiveRemind"/>
								${effectiveRemind }
							</td>									
							<td>
								<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/dealer/view?id=${timesheet.id }'">ข้อมูล</button>
							</td>
						</tr>
					</c:if>
					</c:forEach>
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