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
<meta name="author" content="Sirimongkol Panwa, RAMA">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/signin.css">
<title>JSOFT DB</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="container">
      <form class="form-signin" role="form" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
        <h2 class="form-signin-heading">กรุณาเข้าสู่ระบบ</h2>
       <p>
			<c:if test="${error == true}">
				<b class="error">เกิดข้อผิดพลาดในการเข้าสู่ระบบ</b>
			</c:if>
		</p>
        <label for="user" class="sr-only">User</label>
        <input type="text" id="user" name="j_username" class="form-control" placeholder="User" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">เข้าสู่ระบบ</button>
      </form>
    </div> <!-- /container -->
   <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>