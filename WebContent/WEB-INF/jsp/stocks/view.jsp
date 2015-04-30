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
<title>กสทช. ${stock.serialNumber}</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>กสทช. <small> ปี  ${stock.stockYear}</small></h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/stock/update" modelAttribute="stock" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${stock.id}">
		<input type="hidden" name="stockYear" id="stockYear" value="${stock.stockYear}">
		<input type="hidden" name="sequence" id="sequence" value="${stock.sequence}">
		<input type="hidden" name="serialNumber" id="serialNumber" value="${stock.serialNumber}">
		<input type="hidden" name="generation" id="generation" value="${stock.generation}">
		<input type="hidden" name="userModify" id="userModify" value="${pageContext.request.userPrincipal.name}">
		<c:choose>
		<c:when test="${!empty stock.organization}"> 
			<input type="hidden" name="organization" id="organization" value="${stock.organization.orgId}">
		</c:when>
		<c:otherwise>
			<input type="hidden" name="dealer" id="dealer" value="${stock.dealer.id}">
		</c:otherwise>
		</c:choose>
		<div class="form-group">
			<label class="col-sm-2">รุ่น/แบบ</label> 
			 <div class="col-sm-10">
					${stock.generation}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">หมายเลขเครื่อง</label> 
			 <div class="col-sm-10">
					${stock.serialNumber}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">RX</label> 
			 <div class="col-sm-10">
					${stock.receiver}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">AMP</label> 
			 <div class="col-sm-10">
					${stock.amp}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2" for="orgName">จำหน่ายให้</label> 
			 <div class="col-sm-10">
					${!empty stock.organization ? stock.organization.orgName : stock.dealer.name}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">เลขที่รับ กสทช.</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="licenseRequest" id="licenseRequest" value="${stock.licenseRequest}" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">ใบอนุญาตเลขที่</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="licenseNumber" id="licenseNumber" value="${stock.licenseNumber}" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2" for="description">รายละเอียด </label>
			<div class="col-sm-10">  
				<textarea class="form-control" name="description" id="description" rows="5">${stock.description}</textarea>
			</div>
		</div>
    	<div class="form-group">        
          <div class="col-sm-offset-2 col-sm-10">
          	<button type="submit" class="btn btn-warning">บันทึก</button>
          	<button type="reset" class="btn btn-info">ยกเลิก</button>
          		<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stock?stockYear=${stockYear }#${stock.serialNumber}'">ย้อนกลับ</button>
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