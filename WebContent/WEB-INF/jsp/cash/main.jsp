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
	<div class="col-sm-3">
		<jsp:include page="../leftMenu.jsp"></jsp:include>
	</div>
	<div class="col-sm-9">
		<div class="panel panel-danger">
	       <div class="panel-heading" align="right">
                <h3 class="panel-title">
                <a href="${pageContext.request.contextPath}/petty-cash/new"><span class="glyphicon glyphicon-plus" aria-hidden="true" href="#"></span></a> ข้อมูล |<font color="green"> ${empty param.mnu ? 'ตั้งเบิกเงินและรออนุมัติเงินสดย่อย' : param.mnu == 'request' ? 'รออนุมัติเงินสดย่อย' : param.mnu == 'active' ? 'อยู่ในกระบวนการทำงาน' : param.mnu == 'completed' ? 'เคลียร์เงินสดย่อยเรียบร้อย' : ''}</font></h3>
            </div>  
           <table class="table table-bordered table-striped">
               <thead>
                   <tr bgcolor="#adc4d2">
                       <th>
<!--                        <span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>   -->
                       	ชื่องาน | สถานที่ทำงาน 
                       	</th>
                       <th>วันที่เบิก</th>
                       <th>เพื่อ</th>
                       <th>จำนวนขอเบิก</th>
                       <th>ผู้ปฏิบัติงาน</th>
                       <th></th>
                   </tr>
               </thead>
               <tbody>
               <tr>
                	<th>
                   <p class="text-primary">เสียงแบบไร้สาย อบต.คลองสาม</p>
                   </th>
                   <td class="text-success">
<!--                        <span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>  -->
                       26 เมษายน 2558 
                   </td>
                   <td class="text-primary">
                       	<p>งานซ่อม เหมาซ่อม อบต. คลองสาม ทำใบเสนอราคาให้แล้ว 22,000 บาท</p>
                   </td>
                   <td class="text-success">
                       <b>2,500.00</b>
                   </td>
                   <td class="text-success">
                      	 กอล์ฟ
                   </td>
                   <td class="text-success">
                       <a type="button" class="btn btn-primary btn-sm" href="#">ข้อมูล</a>
                   </td>
                   </tr>
               </tbody>
               </table>
	  	</div> 	
	</div>
</div>
 <!-- /container -->
<!-- Bootstrap core JavaScript ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>