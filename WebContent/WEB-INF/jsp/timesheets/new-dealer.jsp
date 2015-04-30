<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"></head>
<title>เพิ่มข้อมูลการตามงาน ${dealer.name }</title>
</head>
<body>
<div class="container">
	<div class="page-header">
	   <h1>เพิ่มข้อมูลการตามงาน
	      <small>${dealer.name }</small>
	   </h1>
	</div>
	<sf:form method="post" action="${pageContext.request.contextPath}/timesheets/dealer/add" commandName="timesheet" class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${timesheet.id}">
		<input type="hidden" name="userModify" id="userModify" value="${pageContext.request.userPrincipal.name}">
		<input type="hidden" name="dealer" id="dealer" value="${dealer.id}">
		<input type="hidden" name="uploadFile" id="uploadFile" value="0">
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
	                    <option value="${job.id}">${job.name}</option>
	                </c:forEach>
          		</select>
            </div>
        </div>
        <div class="form-group">
	         <label class="control-label col-sm-2" for="status-select">สถานะ</label>
	         <div class="col-sm-10">
		         <select id="status-select" name="status" class="form-control">
		         	<c:forEach items="${status}" var="status">
		        		<option value="${status.id}">${status.name}</option>
		            </c:forEach>
		         </select>
	         </div>
     	</div>
    	<div class="form-group">        
          <div class="col-sm-offset-2 col-sm-10">
          	<button type="submit" class="btn btn-primary">บันทึกข้อมูล</button>
          	<button type="reset" class="btn btn-info">ยกเลิก</button>
          	<button type="button" class="btn btn-default" onclick="javascript:window.location.href='${pageContext.request.contextPath}/dealers/view?id=${dealer.id }'">ย้อนกลับ</button>
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