<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A05 Import</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>

	<div class="card-body">
		<h3>Import</h3>
		
		<c:import url="A04_Catch.jsp">
			<c:param name="x" value="10" />
			<c:param name="y" value="2" />
		</c:import>
		
	</div>
	
	<div class="card-body">
		<h3>URL</h3>
		set과 동일하지만 링크를 저장할 목적으로 사용된다는 점만이 다르다<br>
		<br>
		<c:url var="a02" value="A02_For.jsp" />
		
		<c:import url="${a02 }" />
		<br>
		<br>
		다음과 같이 파라메터까지 포함해서 지정 가능
		<c:url var="a04" value="A04_Catch.jsp">
			<c:param name="x" value="10" />
			<c:param name="y" value="2" />
		</c:url>
		
		<c:import url="${a04 }" />
		
	</div>
	
	
	<div class="card-body">
		<h3>OUT</h3>
		HTML문으로 출력해 준다. 다만 태그 괄호를 어떻게 사용할지 지정 가능<br>
		&lt;h1&gt; ~ &lt;h6&gt;는 Heading Tag입니다<br>
		
		<c:out value="<h1> ~ <h6>는 Heading Tag입니다" /><br>
		<c:out value="<h1>이것은 예제입니다 </h1>" /><br>
		
		<c:out value="<h1>이것은 태그가 적용됩니다 </h1>" escapeXml="false" /><br>
		<br>
		변수의 값이 없으면 기본값 출력도 가능<br>
		<c:out value="${num }" default="값이 없습니다." /><br>
		<br>
	</div>
	
	
	
</body>
</html>