<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"></head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/datepicker3.css"></head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.fileupload.css">
<title>ข้อมูลพนักงาน : ${user.username}</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>เปลี่ยน Password</h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/user/update-admin" modelAttribute="user" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${user.id}">
		<input type="hidden" name="username" id="username" value="${user.username}"/>
		<div class="form-group">
			<label class="control-label col-sm-2">User name </label> 
			 <div class="col-sm-10">
			 	<p class="form-control-static">${user.username}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="password">Password </label> 
			<div class="col-sm-10">
				<input class="form-control" type="password" name="password" id="password" value="${user.password}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">ชื่อพนักงาน </label> 
			 <div class="col-sm-10">
					<input class="form-control" name="description" id="description" value="${user.description}"/>
			</div>
		</div>
		<div class="form-group">
            <label class="control-label col-sm-2" for="select-roles">สิทธิ์เข้าใช้งาน</label>
            <div class="col-sm-10">
            	<select id="select-roles" name="roleId" class="form-control">
	           		<option value="1">Admin</option>
	           		<option value="2">พนักงาน</option>
          		</select>
            </div>
        </div>
    	<div class="form-group">        
          <div class="col-sm-offset-2 col-sm-10">
          	<button type="submit" class="btn btn-warning">บันทึก</button>
          	<button type="reset" class="btn btn-info">ยกเลิก</button>
          	<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/users'">ย้อนกลับ</button>
          </div>
        </div>
	</sf:form>	
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#select-roles').val('${user.roleId}');
});
</script>
</body>
</html>