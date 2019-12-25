<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A05_OperatorExp</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3>EL Operator</h3>
		
		X: ${param.x }, Y: ${param.y }<br>
		X + Y: ${param.x + param.y }<br>
		X - Y: ${param.x - param.y }<br>
		X * Y: ${param.x * param.y }<br>
		X / Y: ${param.x / param.y } / ${param.x div param.y }<br>
		X % Y: ${param.x % param.y } / ${param.x mod param.y }<br>
		<br>
		X &gt; Y: ${param.x > param.y } / ${param.x gt param.y }<br>
		X &lt; Y: ${param.x < param.y } / ${param.x lt param.y }<br>
		X == Y: ${param.x == param.y } / ${param.x eq param.y }<br>
		X != Y: ${param.x != param.y } / ${param.x ne param.y }<br>
		<br>
		X, Y 모두 양수: ${(param.x > 0) && (param.y > 0) } / ${(param.x > 0) and (param.y > 0) }<br>
		X, Y 한쪽 양수: ${(param.x > 0) || (param.y > 0) } / ${(param.x > 0) or (param.y > 0) }<br>
		X, Y NOT: ${!(param.x > 0) } / ${ not(param.x > 0) }<br>
		<br>
		
		3항 연산자: ${ (param.x == param.y) ? "YES" : "NO" }<br>
		<br>
		
		출력하는 값이 null인지를 체크<br>
		Empty: ${empty param.z }<br> <!-- empty를 제일 많이 씀 -->
		Empty: ${empty param.z ? "Guest" : param.z }<br>
		
	</div>

</body>
</html>