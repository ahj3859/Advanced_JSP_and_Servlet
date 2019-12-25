<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3 align="center">Form</h3>
	</div>

	<div class="card-body">
		<form method="get" action="A05_OperatorExp.jsp" novalidate>
			<table class="table">
				<tr>
					<td>X:</td>
					<td><input type="text" name="x" size="30"></td>
				</tr>
				<tr>
					<td>Y:</td>
					<td><input type="text" name="y" size="30"></td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="submit" value="전송"> 
						<input type="reset" value="리셋">
				</tr>
			</table>

		</form>
	</div>
</body>
</html>