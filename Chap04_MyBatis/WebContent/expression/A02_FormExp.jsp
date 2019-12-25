<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A02_FormExp</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="panel-body">
		<h3>Form Result</h3>
		Name: ${param.name }<br>
		Id: ${param.id }<br>
		Password: ${param.password }<br>
		Address: ${param.address }<br>
		Qty: ${param.qty }<br>
		Date: ${param.date }<br>
		Four: ${param.four }<br>
		Five: ${param.five }<br>
		<br>
		Four: ${paramValues.four[0] } / ${paramValues.four[1] } / ${paramValues.four[2] } / ${paramValues.four[3] }<br>
		Five: ${paramValues["five"][0] } / ${paramValues["five"][1] } / ${paramValues["five"][2] } / ${paramValues["five"][3] }<br>
	</div>
</body>
</html>