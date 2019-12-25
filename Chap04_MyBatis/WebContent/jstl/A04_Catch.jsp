<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Catch</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>

	<div class="card-body">
		<h3>Param</h3>
		EL문은 문자열을 리턴하고 에러를 발생시키지 않는다. 따라서 if문 출력 안됨<br>
		<br>
		
		<c:catch var="e">
			X: ${param.x }<br>
			Y: ${param.y }<br>
			${param.x } / ${param.y } = ${param.x / param.y }<br>
		</c:catch>
		
		<c:if test="${e != null }">
			Error Message: ${err.message }
		</c:if>
	</div>
	<br>

	<div class="card-body">
		<h3>Catch</h3>
		이 페이지에서 발생할 에러를 잡아 처리 할 목적으로 기술<br>
		<br>
		일부러 에러를 발생시킬 목적으로 기술. 에러가 발생하면 err 변수에 Exception 객체가 주입됨<br>
		<c:catch var="err">
			<%
				int x = Integer.parseInt( request.getParameter("x") );
				int y = Integer.parseInt( request.getParameter("y") );
				int result = x / y;
				
				out.print(x + " / " + y + " = " + result);
			%>
		</c:catch>
		
		<c:if test="${err != null }">
			Error Message: ${err.message }
		</c:if>
		
	</div>

</body>
</html>



