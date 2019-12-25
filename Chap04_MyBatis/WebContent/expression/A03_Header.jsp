<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A03_Header</title>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="panel-body">
		<h3>Header 정보</h3>

		<%
			Enumeration<String> headers = request.getHeaderNames();
			while (headers.hasMoreElements()) {
				String name = headers.nextElement();

				// HTML 문서로 파싱해서 출력해준다. Java코드 내부에서 간단한 출력용으로 사용
				out.println(name + "=> " + request.getHeader(name) + "<br>");
			}
		%>
		<br> <br>
		<h3>EL 표현식</h3>
		Host: ${header.host }<br> connection: ${header.connection }<br>
		<br> 이름에 "-"가 포함되면 반드시 문자열 참조 방식인 ["이름"]형태로 사용해야 함. <br>
		cache-control: ${header["Cache-Control"] }<br>
		upgrade-insecure-requests: ${header["upgrade-insecure-requests"] }<br>
		user-agent: ${header["user-agent"] }<br>
	</div>
</body>
</html>