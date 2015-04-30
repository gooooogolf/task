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
	</div>
	<form class="form-horizontal"  role="search" action="${pageContext.request.contextPath}/stocks" method="post">
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
	     	<button type="button" class="btn btn-warning">PDF</button>
	    	</div>
      </div>
	</form>	
	<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
		<tr>	
			<th style="width: 10%;">รุ่น/แบบ</th>
			<th style="width: 7%;">ลำดับที่</th>
			<th style="width: 15%;">หมายเลขเครื่อง</th>
			<th style="width: 20%;">จำหน่ายให้</th>
			<th style="width: 30%;">หนังสืออนุญาต กสทช.</th>
<!-- 			<th>รายละเอียด</th> -->
			<th style="width: 5%;">พนักงาน</th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${stocks}" var="stock">
			<tr>
				<td>${stock.generation }</td>
				<td>${stock.sequence }</td>					
				<td><a name="${stock.serialNumber }">${stock.serialNumber }</a></td>
				<td>${empty stock.organization ? stock.dealer.name : stock.organization.orgName}</td>
				<c:choose>
					<c:when test="${empty stock.licenseNumber && !empty stock.licenseRequest}">
						<td>${stock.licenseRequest}</td>
					</c:when>
					<c:when test="${empty stock.licenseRequest && !empty stock.licenseNumber}">
						<td>${stock.licenseNumber}</td>
					</c:when>
					<c:otherwise>
					<td>${stock.licenseRequest}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${stock.licenseNumber}</td>
					</c:otherwise>
				</c:choose>
<%-- 				<td>${stock.description }</td> --%>
				<td>${stock.userModify.description }</td>
				<td>
					<c:if test="${!empty stock.organization || !empty stock.dealer}"> 
					<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stock/view?id=${stock.id }&stockYear=${stock.stockYear }'">ข้อมูล</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
<%-- var serialNumber = '<%=request.getParameter("serialNumber")%>'; --%>
// $(document).ready(function() {
// 	if (serialNumber != 'null') {
// 		window.find(stockId);
// 	}	
// });
</script>
</body>
</html>