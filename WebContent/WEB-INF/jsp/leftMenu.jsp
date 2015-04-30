<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Left Menu</title>
</head>
<body>
	<div class="list-group">
		<a href="?mnu" class="list-group-item ${empty param.mnu ? ' active' : ''}">
		    <span class="badge pull-right btn-warning">6</span>
		    <h4 class="list-group-item-heading"><font ${empty param.mnu ? 'color="white"' : 'class="text-primary"'}>ข้อมูลล่าสุด</font></h4>
		    <p class="list-group-item-text"><font color="${empty param.mnu ? '#f7c11d' : '#000000' }">ความเคลื่อนไหวเดือนล่าสุด</font></p> 
		</a>
		<a href="?mnu=request" class="list-group-item ${param.mnu == 'request' ? ' active' : ''}">
		    <span class="badge pull-right btn-warning">0</span>
		    <h4 class="list-group-item-heading"><font ${param.mnu == 'request' ? 'color="white"' : 'class="text-danger"'} >ตั้งเบิกเงิน</font></h4>
		    <p class="list-group-item-text"><font color="${param.mnu == 'request' ? '#f7c11d' : '#000000'}">รออนุมัติเงินสดย่อย</font></p> 
		</a>
		<a href="?mnu=active" class="list-group-item ${param.mnu == 'active' ? ' active' : ''}">
			<span class="badge pull-right btn-warning">49</span>
			<h4 class="list-group-item-heading"><font ${param.mnu == 'active' ? 'color="white"' : 'class="text-info"'}>ดำเนินการ</font></h4>
			<p class="list-group-item-text"><font color="${param.mnu == 'active' ? '#f7c11d' : '#000000'}">อยู่ในกระบวนการทำงาน</font></p>
        </a>
        <a href="?mnu=completed" class="list-group-item ${param.mnu == 'completed' ? ' active' : ''}">
			<span class="badge pull-right btn-warning">239</span>
			<h4 class="list-group-item-heading"><font ${param.mnu == 'completed' ? 'color="white"' : 'class="text-success"'}>เสร็จสิ้น</font></h4>
			<p class="list-group-item-text"><font color="${param.mnu == 'completed' ? '#f7c11d': '#000000'}">เคลียร์เงินสดย่อยเรียบร้อย</font></p>
        </a>
	</div>
</body>
</html>