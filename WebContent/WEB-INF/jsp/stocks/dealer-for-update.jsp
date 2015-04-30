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
	   <h1>กสทช. 
	      <small> ปี  ${stockYear } </small>
	   </h1>
	   <p>${dealer.name }</p>
	</div>
	<form class="form-horizontal"  role="search" action="${pageContext.request.contextPath}/stocks/dealer-for-update?dealerId=${dealer.id }" method="post">
	  <div class="form-group">
           <div class="col-sm-3">
           		<select id="select-years" name="stockYear" class="form-control">
           		<c:forEach items="${years}" var="year">
           			<option value="${year}" ${year == stockYear ? 'selected="selected"' : ''}>พ.ศ. ${year }</option>
           		</c:forEach>
         		</select>
           </div>
			<div class="col-sm-7">
	     	<button type="submit" class="btn btn-default">ค้นหา</button>
	    	</div>
      </div>
	</form>	
<%-- 	<c:if test="${!empty stocks}"> --%>
	<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
		<tr>	
			<th style="width: 3%;">#</th>
			<th style="width: 10%;">รุ่น/แบบ</th>	
			<th style="width: 7%;">ลำดับที่</th>
			<th style="width: 15%;">หมายเลขเครื่อง</th>
			<th style="width: 10%;">RX</th>
			<th style="width: 10%;">AMP</th>
<!-- 			<th style="width: 20%;">*จะจำหน่ายให้</th> -->
<!-- 			<th style="width: 20%;">หนังสืออนุญาต กสทช.</th> -->
<!-- 			<th>รายละเอียด</th> -->
		</tr>
		</thead>
		<c:forEach items="${stocks}" var="stock">
			<tr>
				<td><input name ="id" id="id" type="checkbox" value="${stock.id }"></td>	
				<td>${stock.generation }</td>	
				<td>${stock.sequence }</td>			
				<td>${stock.serialNumber }</td>
				<td>${stock.receiver }</td>
				<td>${stock.amp }</td>
<%-- 				<td>${dealer.name }</td> --%>
<%-- 				<td>${empty stock.licenseNumber ? stock.licenseRequest : stock.licenseRequest + ' ' + stock.licenseNumber}</td> --%>
<%-- 				<td>${stock.description }</td> --%>
			</tr>
		</c:forEach>
	</table>
	</div>
<%-- 	</c:if> --%>
	<form action="${pageContext.request.contextPath}/stocks/dealer-new?dealerId=${dealer.id }" method="post">
		<input name ="ids" id="ids" type="hidden" value="">
		<button type="submit" class="btn btn-danger">ตัด Stock ให้${dealer.name }</button>
		<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stock/dealer?dealerId=${dealer.id }'">ย้อนกลับ</button>
		<br><br>
	</form>	
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	var ids = [];
	
	$('input:checkbox').change(function() {
		var id = $(this).val();
		if ($(this).is(':checked')) {
			ids.push(id);
		}
		else {
			ids = $.grep(ids, function(n) { return ( n != id );}); 
     	}
		ids.sort();
		$('#ids').val(ids.join(","));
	}); 
	
});

</script>
</body>
</html>