<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A06_SendData</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3>Data 출력</h3>
		
		배열: ${name[0] } / ${name[1] } / ${name[2] } <br>
		ArrayList: ${fruit[0] } / ${fruit[1] } / ${fruit[2] } <br>
		Map: ${map.one } / ${map["two"] }<br>
		UserVO: ${user.id } / ${user.name }<br>
	</div>
</body>
</html>