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
<title>Dealer</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="page-header">
	   <h1>ตามงาน<small> Dealer</small></h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/dealers/update" modelAttribute="dealer" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${dealer.id}">
		<div class="form-group">
			<label class="col-sm-2">ชื่อ</label> 
			 <div class="col-sm-10">
			 	${dealer.name}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2" for="address">ที่อยู่</label>
			<div class="col-sm-10">  
				${dealer.address}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2">เบอร์ติดต่อ</label> 
			 <div class="col-sm-10">
			 	${dealer.phone}
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2" for="description">รายละเอียด </label>
			<div class="col-sm-10">  
				${dealer.description}
			</div>
		</div>
	</sf:form>	
		<c:if test="${!empty timesheets}">
	<div class="table-responsive">
	<table class="table table-hover">
		<thead>
		<tr>
			<th></th>
			<th>ชื่อผู้ติดต่อ</th>
			<th>ตำแหน่ง</th>
			<th>เบอร์โทร</th>
			<th>ข้อมูลการติดต่อ</th>
			<th>พนักงาน</th>
			<th style="width: 10%;">อัพเดต</th>
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
				<td>${timesheet.description }</td>
				<td>${timesheet.userModify.description }</td>
				<td>
					<fmt:setLocale value="th_TH" scope="session"/>
	         		<fmt:formatDate value="${!empty timesheet.effectiveDate ? timesheet.effectiveDate : ''}" pattern="d MMM yyyy HH:mm" var="effectiveDate"/>
					${effectiveDate }
				</td>
				<td>
					<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/dealer/view?id=${timesheet.id }'">ข้อมูล</button>
				</td>
				<td>	
					<sf:form action="${pageContext.request.contextPath}/timesheet/dealer/delete?id=${timesheet.id }" method="delete" cssClass="delete" id="${timesheet.id }">
                        <button type="button" class="btn btn-danger" onclick="javascript:onDelete('${timesheet.id }');">ลบ</button>
                    </sf:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>
			<button type="button" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet/dealer/new?dealerId=${dealer.id }'">เพิ่มข้อมูลการตามงาน</button>	
			<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers?id=${dealer.id}'">ย้อนกลับ</button>
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
// 	if(confirm('ต้องการลบข้อมูล ?')){
// 		$('#' + frmId).submit();
// 	}
// 	return false;	
    $('#confirm').modal({ backdrop: 'static', keyboard: false })
    .one('click', '#delete', function (e) {
    	$('#' + frmId).submit();
    });
}
</script>
</body>
</html>