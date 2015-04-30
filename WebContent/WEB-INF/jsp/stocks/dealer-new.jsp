<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>กสทช. ปี  ${stockYear }</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ตัด Stock กสทช. 
	      <small> ปี  ${stockYear } </small>
	   </h1>
	</div>
	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/stock/dealer-save">
	<input type="hidden" id="ids" name="ids" value="${ids }">
	<input type="hidden" id="dealerId" name="dealerId" value="${dealer.id}">
	<input type="hidden" name="userModify" id="userModify" value="${pageContext.request.userPrincipal.name}">
	<div class="form-group">
		<label class="col-sm-2" for="orgName">จำหน่ายให้</label> 
		 <div class="col-sm-10">
				${dealer.name}
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2" for="licenseRequest">เลขที่รับ กสทช.</label> 
		<div class="col-sm-10">
			<input class="form-control" name="licenseRequest" id="licenseRequest"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2" for="licenseNumber">ใบอนุญาตเลขที่</label> 
		<div class="col-sm-10">
			<input class="form-control" name="licenseNumber" id="licenseNumber"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2" for="description">รายละเอียด </label>
		<div class="col-sm-10"> 
			<textarea class="form-control" name="description" id="description" rows="5"></textarea>
		</div>
	</div>
	<div class="form-group">
	<label class="col-sm-2"> </label>
		<div class="col-sm-10"> 
			<button type="submit" class="btn btn-primary">บันทึกข้อมูล</button>
			<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stocks/dealer-for-update?dealerId=${dealer.id }&stockYear=${stockYear }'">ย้อนกลับ</button>
		</div>
	</div>	
	
	<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
		<tr>	
			<th style="width: 10%;">รุ่น/แบบ</th>
			<th>ลำดับที่</th>
			<th>หมายเลขเครื่อง</th>
			<th>RX</th>
			<th>AMP</th>
			<th style="width:5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${stocks}" var="stock">
			<tr id="stockId_${stock.id }">
				<td>${stock.generation }</td>	
				<td>${stock.sequence }</td>				
				<td>${stock.serialNumber }</td>
<%-- 				<td>${stock.receiver }</td> --%>
<%-- 				<td>${stock.amp }</td>				 --%>
				<td><input type="text" id="receiver_${stock.id }" name="receiver_${stock.id }"/></td>
				<td><input type="text" id="amp_${stock.id }" name="amp_${stock.id }"/></td>
				<td>
					<button type="button" class="btn btn-danger" onclick="onDelete('${stock.id }')">ยกเลิก</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</form>
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

function onDelete(id) {
	var ids = $('#ids').val();
	ids = ids.split(",");
	$('#stockId_' + id).remove();
	ids = $.grep(ids, function(n) { return ( n != id );}); 
	$('#ids').val(ids);
}
</script>
</body>
</html>