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
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="ค่าใช้จ่ายในการทำงาน, เงินสดย่อย">
<meta name="author" content="Sirimongkol Panwa, JSOFT">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<title>เบิกเงิน</title>
</head>
<body role="document">
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/petty-cash/new" commandName="pettyCash" class="form-horizontal">
<div class="panel panel-default">
	<div class="panel-heading" align="right">
        <h1 class="panel-title">
       		 เลขที่ |<font color="blue"> <b>580001</b></font>
        </h1>
    </div>
    <div class="panel-body">
		<div class="form-group">
			<label class="control-label col-sm-2">ชื่อ/สถานที่ทำงาน</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="name" id="name"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">วันที่เบิก</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="phone" id="phone"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="address">เพื่อ</label>
			<div class="col-sm-10">  
				<textarea class="form-control" name="address" id="address" rows="5"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">ผู้ปฏิบัติงาน</label> 
			 <div class="col-sm-10">
			 	<input class="form-control" type="text" name="name" id="name"/>
			</div>
		</div>	
		<div class="panel-heading" align="right">
                <h4 class="panel-title">
                <a id="addPettyCashDetails" href="javascript:void(0);">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" href="#"></span>
               	 เพิ่มข้อมูล 
               	 </a>
                </h4>
		</div> 
		<div class="table-responsive">
		<table class="table table-bordered table-striped">
         <thead>
             <tr bgcolor="#adc4d2">
                 <th>วันที่</th>
                 <th>รายละเอียด</th>
                 <th>รับเงิน</th>
                 <th>ใช้ไป</th>
                 <th>คงเหลือ</th>
                 <th></th>
             </tr>
         </thead>
         <tbody id="pettyCashDetails">
         	<tr id="pettyCashDetail_row_0">
         		<td><input class="form-control" type="text" id="cashDate_row_0"/></td>
         		<td><input class="form-control" type="text" id="description_row_0"/></td>
         		<td><input class="form-control" type="text" id="cashWithdraw_row_0"/></td>
         		<td><input class="form-control" type="text" id="cashUsed_row_0"/></td>
         		<td><input class="form-control" type="text" id="cashBalance_row_0"/></td>
         		<td><button type="button" id="btnPettyCashDetail_row_0" onclick="deleteRow('0')" class="btn btn-danger">ยกเลิก</button></td>
         	</tr>
         </tbody>
		</table>
		</div> 			
    </div>
    <div class="panel-footer clearfix">
        <div class="pull-right">
            <a href="#" class="btn btn-primary">บันทึก</a>
            <a href="#" class="btn btn-default">Go Back</a>
        </div>
    </div>
</div>
</sf:form>
</div>
 <!-- /container -->
<!-- Bootstrap core JavaScript ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
var __rowCount = 0; 
$(document).ready(function() {
	
	var rowTemplate = '<tr id="pettyCashDetail_row_{rowId}">';
	rowTemplate += '<td><input class="form-control" type="text" id="cashDate_row_{rowId}"/></td>';
	rowTemplate += '<td><input class="form-control" type="text" id="description_row_{rowId}"/></td>';
	rowTemplate += '<td><input class="form-control" type="text" id="cashWithdraw_row_{rowId}"/></td>';
	rowTemplate += '<td><input class="form-control" type="text" id="cashUsed_row_{rowId}"/></td>';
	rowTemplate += '<td><input class="form-control" type="text" id="cashBalance_row_{rowId}"/></td>';
	rowTemplate += '<td><button id="btnPettyCashDetail_row_{rowId}" onClick="deleteRow(\'{rowId}\')" type="button" class="btn btn-danger">ยกเลิก</button></td>';
	
	$('#addPettyCashDetails').click(function() {
		__rowCount = __rowCount + 1;
		var rowId = new RegExp('{rowId}', 'g');
		var __rowTemplate = rowTemplate;
		__rowTemplate = rowTemplate.replace(rowId, __rowCount);
		$('#pettyCashDetails').append(__rowTemplate);
	});
	
});
function deleteRow(rowId) {
	$('#pettyCashDetail_row_' + rowId).remove();
}	
</script>
</body>
</html>