<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A03_Redirect</title>
</head>
<body>

	<c:redirect url="A04_Catch.jsp">
		<!-- 필요에 따라 파라메터를 전달할 수 있다 -->
		<c:param name="x" value="10" />
		<c:param name="y" value="0" />
	</c:redirect>

</body>
</html>