<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL For</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3>For</h3>
		
		<c:set var="result" value="0" />
		<c:forEach var="i" begin="0" end="10" step="1">	<!-- 0부터 10까지 11번 반복 -->
			<c:set var="result" value="${result + i }" />
		</c:forEach>
		0부터 10까지의 합은: ${result }<br>
		<br>
		
		<c:set var="result" value="0" />
		<c:forEach var="i" begin="0" end="10" step="2">		<!-- i에는 2씩 증가되는 값 대입 -->
			<c:set var="result" value="${result + i }" />
		</c:forEach>
		0부터 10까지의 짝수의 합은: ${result }<br>
		<br>
		
		<c:set var="result" value="0" />
		<c:forEach var="i" begin="1" end="10" step="2">		<!-- i에는 2씩 증가되는 값 대입 -->
			<c:set var="result" value="${result + i }" />
		</c:forEach>
		0부터 10까지의 홀수의 합은: ${result }<br>
		<br>
		
		
		<h3>배열. Scope에 담긴 데이터 추출</h3>
		<c:forEach items="${name }" var="n">
			${n }
		</c:forEach>
		<br>
		<br>
		
		<h3>ArrayList. 문자열 출력</h3>
		<c:forEach items="${fruit }" var="n">
			${n }
		</c:forEach>
		<br>
		<br>
		
		<h3>Map. 문자열 출력</h3>
		<c:forEach items="${map }" var="n">
			${n }
		</c:forEach>
		<br>
		<br>
		
		<h3>ArrayList. 객체 출력</h3>
		순환하면서 꺼내오는 값이 UserVO 객체이다<br>
		<br>
		<c:forEach items="${user }" var="n">
			${n.id } / ${n.name }<br>
		</c:forEach>
		<br>
		<br>
		
		<h3>For 내장 변수 사용</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Value</th>
					<th>Current</th>
					<th>Index</th>
					<th>Count</th>
					<th>First</th>
					<th>Last</th>
				</tr>
			</thead>
			<tbody>
<c:forEach items="${name }" var="person" varStatus="status">
				<tr>
					<td>${person }</td>
					<td>${status.current }</td>
					<td>${status.index }</td>
					<td>${status.count }</td>
					<td>${status.first }</td>
					<td>${status.last }</td>
				</tr>
</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
		
		<h3>배열. Scope에 담긴 데이터 추출</h3>
		<c:forEach items="${name }" var="n" varStatus="status">
			${n }
			<c:if test="${status.last != true }"> / </c:if>
		</c:forEach>
		<br>
		<br>
		
		<h3>문자열 분리</h3>
		<c:set var="str" value="레몬-사과-바나나"/>
		
		<c:forTokens items="${str }" delims="-" var="n">
			${n }
		</c:forTokens>
		<br>
		
		<c:set var="str" value="레몬-사과-바나나*딸기 수박"/>
		
		<c:forTokens items="${str }" delims="-* " var="n">
			${n }
		</c:forTokens>
		
	</div>
</body>
</html>








