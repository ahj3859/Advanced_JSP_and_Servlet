<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="m" uri="http://com.multi.view.customLib" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A07_CustomLib</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3>Static Method의 이용</h3>
		선언문에 사용할 라이브러리부터 정의해야 한다.<br>
		<br>
		
		ABS: ${m:abs(-100) }<br>
		Random: ${m:random() * 46 }<br>
		Ceil: ${m:ceil( m:random() * 50) }<br>
		<br>
		GetNumber: ${m:getNumber(10.25) }<br>
		GetGreet: ${m:getGreet("홍길동") }<br>
		
	</div>

</body>
</html>