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
<title>แก้ไข Dealer</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>แก้ไข<small>  Dealer</small></h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/dealers/update" modelAttribute="dealer" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${dealer.id}">
		<div class="form-group">
			<label class="control-label col-sm-2">ชื่อ</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="name" id="name" value="${dealer.name}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="address">ที่อยู่</label>
			<div class="col-sm-10">  
				<textarea class="form-control" name="address" id="address" rows="5">${dealer.address}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">เบอร์ติดต่อ</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="phone" id="phone" value="${dealer.phone}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">รายละเอียด </label>
			<div class="col-sm-10">  
				<textarea class="form-control" name="description" id="description" rows="5">${dealer.description}</textarea>
			</div>
		</div>
    	<div class="form-group">        
          <div class="col-sm-offset-2 col-sm-10">
          	<button type="submit" class="btn btn-warning">บันทึก</button>
          	<button type="reset" class="btn btn-info">ยกเลิก</button>
          		<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers?id=${dealer.id}'">ย้อนกลับ</button>
          </div>
        </div>
	</sf:form>	
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>