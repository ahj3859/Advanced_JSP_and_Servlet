<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A04_Cookie</title>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
	<%
		// 실습을 위해 간단한 쿠키 생성
		response.addCookie(new Cookie("name", "NolBu"));
		
		Cookie ck = new Cookie("age", "20");
		ck.setMaxAge(60*60*24);
		ck.setPath("/");
		response.addCookie(ck);
	%>
	
	<div class="panel-body">
		<h3>Cookie</h3>
		
		Name: ${cookie.name.value }<br>
		Age: ${cookie.age.value }
	</div>
	
	<div class="panel-body">
		<h3>ServletContext Init Value</h3>
		web.xml에 이 프로젝트에서 공통적으로 사용할 값(상수)을 지정하면 그 값을 참조<br>
				
		Name: ${initParam.contextConfigLocation }<br>
		Age: ${initParam.projectName }
	</div>
	
	<div class="panel-body">
		<h3>PageContext</h3>
		pageContext는 현재 페이지(jsp, servlet)의 참조 객체<br>
		<br>
				
		URI: ${pageContext.request.requestURI }<br>
		RemoteAddr: ${pageContext.request.remoteAddr }
	</div>

</body>
</html>