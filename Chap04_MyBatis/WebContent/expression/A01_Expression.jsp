<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("name", "Page Name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A01_Expression.jsp</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="panel-body">
		<h3>Scope</h3>
		Expression Language(EL)는 내장 기능. 다른 라이브러리가 필요 없음<br>
		어디서든지 아래의 객체에 삽입한 커스텀 속성을 $ { } 형식으로 빼서 사용 가능<br> 
		참조 순위는 ServletContext &lt;= HttpSession &lt;= Request &lt;= page<br>
		Name: ${name }<br>
	</div>

	<div class="panel-body">
		<h3>Page Scope</h3>
		Name: ${pageScope.name }<br>
	</div>

	<div class="panel-body">
		<h3>Request Scope</h3>
		Name: ${requestScope.name }<br>
		<br>
		객체는 Getter와 Setter Mothod를 참조한다. <br>
		User: ${user.id } / ${user.name } <!-- 고유한 값이면 user.id와 같이 바로 쓸 수 있음 -->
	</div>
	
	<div class="panel-body">
		<h3>Session Scope</h3>
		Name: ${sessionScope.name }<br>
		ID: ${id }
	</div>

	<div class="panel-body">
		<h3>ServletContext Scope</h3>
		Name: ${applicationScope.name }<br>
		Path: ${path }
	</div>
</body>
</html>