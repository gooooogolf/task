<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>กสทช. ${organization.orgName }</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>กสทช. 
	      <small> ${organization.orgName }</small>
	   </h1>
	</div>
	<form class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2" for="orgName">หน่วยงาน</label> 
		 <div class="col-sm-10">
				${organization.orgName}
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2" for="amphurName">อำเภอ </label> 
		<div class="col-sm-10">
			${organization.amphurName}
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2" for="provinceName">จังหวัด </label>
		<div class="col-sm-10"> 
			${organization.provinceName}
		</div>
	</div>
	</form>
<%-- 	<c:if test="${!empty stocks}"> --%>
	<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
		<tr>	
			<th style="width: 5%;">ปี</th>
			<th style="width: 10%;">รุ่น/แบบ</th>
			<th style="width: 7%;">ลำดับที่</th>
			<th style="width: 15%;">หมายเลขเครื่อง</th>
			<th style="width: 10%;">RX</th>
			<th style="width: 10%;">AMP</th>
			<th style="width: 20%;">หนังสืออนุญาต กสทช.</th>
			<th style="width: 5%;">พนักงาน</th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${stocks}" var="stock">
			<tr>	
				<td>${stock.stockYear }</td>
				<td>${stock.generation }</td>	
				<td>${stock.sequence }</td>				
				<td>${stock.serialNumber }</td>
				<td>${stock.receiver }</td>
				<td>${stock.amp }</td>
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
				<td>${stock.userModify.description }</td>
				<td>
					<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stock/view?id=${stock.id }&stockYear=${stock.stockYear }'">ข้อมูล</button>					
				</td>
				<td>
					<sf:form action="${pageContext.request.contextPath}/stock/organization/delete?orgId=${organization.orgId}&stockId=${stock.id }" method="delete" cssClass="delete" id="${organization.orgId}_${stock.id }">
                        <button type="button" class="btn btn-danger" onclick="javascript:onDelete('${organization.orgId}', '${stock.id}');">ลบ</button>
                    </sf:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
<%-- 	</c:if> --%>
	<button type="button" class="btn btn-danger" onclick="javascript:window.location.href='${pageContext.request.contextPath}/stock/organization-for-update?orgId=${organization.orgId }'">ตัด Stock</button>
	<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/organizations?orgId=${organization.orgId }'">ย้อนกลับ</button>
	<br><br>	
</div>
<!-- Modal -->
<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-body">ต้องการลบข้อมูล ?</div>
         <div class="modal-footer">
          	<button type="button" id="delete" class="btn btn-primary">ตกลง</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">ยกเลิก </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function onDelete(orgId, stockId){
    $('#confirm').modal({ backdrop: 'static', keyboard: false })
    .one('click', '#delete', function (e) {
    	$('#' + orgId + '_' + stockId).submit();
    });
}
</script>
</body>
</html>