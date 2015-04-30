<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${organization.orgName }</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ข้อมูลการตามงาน
	      <small>${organization.orgName }</small>
	   </h1>
	</div>
	<form class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2" for="orgName">ชื่อ อปท. </label> 
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
	<c:if test="${!empty timesheets}">
	<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
		<tr>
			<th style="width: 2.5%;">#</th>
			<th style="width: 10%;">ชื่อผู้ติดต่อ</th>
			<th style="width: 10%;">ตำแหน่ง</th>
			<th style="width: 10%;">เบอร์โทร</th>
			<th style="width: 12%;">งาน</th>
			<th>ข้อมูลการติดต่อ</th>
			<th style="width: 5%;">พนักงาน</th>
			<th style="width: 5%;">อัพเดต</th>
			<th style="width: 5%;"></th>
			<th style="width: 5%;"></th>
		</tr>
		</thead>
		<c:forEach items="${timesheets}" var="timesheet">
			<tr>
				<td>${!empty timesheet.uploadFile ? '<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>':''}</td>
				<td>${timesheet.contactName }</td>
				<td>${timesheet.contactPosition }</td>
				<td>${timesheet.contactPhone }</td>
				<td>${timesheet.job.name }</td>
				<td>${timesheet.description }</td>
				<td>${timesheet.userModify.description }</td>
				<td>
					<fmt:setLocale value="th_TH" scope="session"/>
	         		<fmt:formatDate value="${!empty timesheet.effectiveDate ? timesheet.effectiveDate : ''}" pattern="d MMM yyyy HH:mm" var="effectiveDate"/>
					${effectiveDate }
				</td>
				<td>
					<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/view?id=${timesheet.id }'">ข้อมูล</button>
				</td>
				<td>	
					<sf:form action="${pageContext.request.contextPath}/timesheet/delete?id=${timesheet.id }" method="delete" cssClass="delete" id="${timesheet.id }">
                        <button type="button" class="btn btn-danger" onclick="javascript:onDelete('${timesheet.id }');">ลบ</button>
                    </sf:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>
			<button type="button" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/new?orgId=${organization.orgId }'">เพิ่มข้อมูลการตามงาน</button>	
			<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/organizations?orgId=${organization.orgId }'">ย้อนกลับ</button>
			<br><br>

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
	
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function onDelete(frmId){
    $('#confirm').modal({ backdrop: 'static', keyboard: false })
    .one('click', '#delete', function (e) {
    	$('#' + frmId).submit();
    });
}
</script>
</body>
</html>