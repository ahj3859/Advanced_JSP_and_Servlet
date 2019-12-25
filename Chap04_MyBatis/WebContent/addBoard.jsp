<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="ErrorPage/JSPError.jsp"%>
<%
	// 에러를 일부러 발생시키려고 적은 코드. 에러가 발생하면 위의 errorPage로 이동한다.
	//int num = Integer.parseInt(request.getParameter("num"));

	// login check
	String id = (String)session.getAttribute("id");	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<title>새글등록</title>
</head>
<body>
	<div align="center" style="margin: auto auto">
		<h3>
			새글 등록하기............<a href="logoutCtrl">LOG-OUT</a>
		</h3>
		<hr>
		<form action="addBoardCtrl" method="post">
			<table class="table" style="width: 800px">
				<tr>
					<td>제목</td>
					<td align="left">
						<input type="text" name="title" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left">
						<input type="text" name="nickname" size="10" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value=" 새글 등록 " class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
	</div>
</body>
</html>