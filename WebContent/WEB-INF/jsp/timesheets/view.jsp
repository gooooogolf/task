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
<title>ข้อมูลการตามงาน${timesheet.organization.orgName }</title>
</head>
<body>
<div class="container">
	<div class="page-header">
	   <h1>ข้อมูลการตามงาน
	      <small>${timesheet.organization.orgName }</small>
	   </h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/timesheets/update" modelAttribute="timesheet" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${timesheet.id}">
		<input type="hidden" name="organization" id="organization" value="${timesheet.organization.orgId}">
		<input type="hidden" name="uploadFile" id="uploadFile" value="${!empty timesheet.uploadFile ? timesheet.uploadFile.id : 0}">
<%-- 		<input type="hidden" name="userModify" id="userModify" value="${pageContext.request.userPrincipal.name}"> --%>
		<input type="hidden" name="userModify" id="userModify" value="${timesheet.userModify.username}">
		<div class="form-group">
			<label class="control-label col-sm-2" for="contactName">ชื่อผู้ติดต่อ </label> 
			 <div class="col-sm-10">
					<input class="form-control" name="contactName" id="contactName" value="${timesheet.contactName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="contactPosition">ตำแหน่ง </label> 
			<div class="col-sm-10">
				<input class="form-control" name="contactPosition" id="contactPosition" value="${timesheet.contactPosition}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="contactPhone">เบอร์โทรศัพท์ </label>
			<div class="col-sm-10"> 
				<input class="form-control" name="contactPhone" id="contactPhone" value="${timesheet.contactPhone}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="budgetYear">ตั้งงบปี</label>
			<div class="col-sm-10"> 
				<input class="form-control" name="budgetYear" id="budgetYear" value="${timesheet.budgetYear}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="budget">งบประมาณ</label>
			<div class="col-sm-10"> 
				<input class="form-control" name="budget" id="budget" value="${timesheet.budget}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">รายละเอียด </label>
			<div class="col-sm-10">  
				<textarea class="form-control" name="description" id="description" rows="5">${timesheet.description}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="result">ผลการดำเนินงาน</label>
			<div class="col-sm-10"> 
				<input class="form-control" name="result" id="result" value="${timesheet.result}" />
			</div>
		</div>
		<div class="form-group">
            <label class="control-label col-sm-2" for="job-select">งาน</label>
            <div class="col-sm-10">
            	<select id="select-jobs" name="job" class="form-control">
	                <c:forEach items="${jobs}" var="job">
	                    <option value="${job.id}" ${job.id == timesheet.job.id ? 'selected="selected"' : ''}>${job.name}</option>
	                </c:forEach>
          		</select>
            </div>
        </div>
        <div class="form-group">
	         <label class="control-label col-sm-2" for="status-select">สถานะ</label>
	         <div class="col-sm-10">
		         <select id="status-select" name="status" class="form-control">
		         	<c:forEach items="${status}" var="status">
		        		<option value="${status.id}" ${status.id == timesheet.status.id ? 'selected="selected"' : ''}>${status.name}</option>
		            </c:forEach>
		         </select>
	         </div>
     	</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="files">แนบไฟล์ </label>
			<div class="col-sm-10"> 
				<div>
				    <span class="btn btn-success fileinput-button">
				        <i class="glyphicon glyphicon-plus"></i>
				        <span>Select files...</span>
				        <!-- The file input field used as target for the file upload widget -->
				        <input id="fileupload" type="file" name="file">
				    </span>
				    <br>
				    <br>
				    <!-- The global progress bar -->
				    <div id="progress" class="progress">
				        <div class="progress-bar progress-bar-success"></div>
				    </div>
				    <!-- The container for the uploaded files -->
				    <div id="filefaild"></div>
					<div id="files" class="files">
						<c:if test="${!empty timesheet.uploadFile}">						
						<div id="${timesheet.uploadFile.id }">
							<a href="${pageContext.request.contextPath}/view/upload/${timesheet.uploadFile.id}" target="_blank">${timesheet.uploadFile.name}</a>&nbsp;&nbsp;
							<a href="javascript:deleteFile('${timesheet.uploadFile.id }')">[x]</a>
							<br>
						</div>
						</c:if>
			    	</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="effectiveRemindDate">แจ้งเตือน</label>
			<div class="col-sm-10"> 	
                <div class="input-group date" id="effectiveRemindDatePicker">
                <span class="input-group-addon datepickerbutton"><span class="glyphicon glyphicon-calendar"></span></span>
                <fmt:setLocale value="en_US" scope="session"/>
                <fmt:formatDate value="${!empty timesheet.effectiveRemindDate ? timesheet.effectiveRemindDate : ''}" pattern="dd/MM/yyyy" var="effectiveRemind"/>
                <input class="form-control" name="effectiveRemindDate" id="effectiveRemindDate" value="${effectiveRemind}"/>
<!--                 <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span> -->
                </div>
			</div>
		</div>
    	<div class="form-group">        
          <div class="col-sm-offset-2 col-sm-10">
          	<button type="submit" class="btn btn-warning">บันทึก</button>
          	<button type="reset" class="btn btn-info">ยกเลิก</button>
          	<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/timesheet?orgId=${timesheet.organization.orgId }'">ย้อนกลับ</button>
          </div>
        </div>
	</sf:form>	
</div>
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/locales/bootstrap-datepicker.th.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    'use strict';
    $('#progress').hide();
    $('#fileupload').fileupload({
        url: '${pageContext.request.contextPath}/upload/file?timesheetId=${timesheet.id }',
        dataType: 'json',
        done: function (e, data) {
            $.each(data.result, function (index, file) {
             	$('#files').html('<div id="' + file.id + '"><a href="${pageContext.request.contextPath}/view/upload/' + file.id + '" target="_blank">' + file.name + '</a>&nbsp;&nbsp;<a href="javascript:deleteFile(' + file.id + ')">[x]</a><br></div>');
             	$('#uploadFile').val(file.id);
            });
            $('#progress').hide();
        },
        fail: function (e, data) {
        	 $('#filefaild').html('<p>ไม่สามารถอัพโหลดไฟล์ได้</p>');
        	 $('#progress').hide();
        },
        progressall: function (e, data) {
        	$('#filefaild').html('');
        	$('#progress').show();
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css('width', progress + '%');
        }
    }).prop('disabled', !$.support.fileInput).parent().addClass($.support.fileInput ? undefined : 'disabled');
    
    $('#effectiveRemindDatePicker').datepicker({
	    format: "dd/mm/yyyy", 
	    todayBtn: "linked",
	    todayHighlight: true,
	    language: "th",
	    autoclose: true
	});
    
});

function deleteFile(id){
	$('#'+id).remove();
	$('#uploadFile').val('0');
}
</script>
</body>
</html>