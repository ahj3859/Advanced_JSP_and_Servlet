<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A06_FormatDate</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	
	<div class="card-body">
		<h3>Date Format</h3>
		<c:set var="today" value="<%=new Date() %>" />
		날짜: <br>
		<fmt:formatDate value="${today }" 	type="date"		dateStyle="full"/><br>
		<fmt:formatDate value="${today }" 	type="date"		dateStyle="long"/><br>
		<fmt:formatDate value="${today }" 	type="date"		dateStyle="medium"/><br>
		<fmt:formatDate value="${today }" 	type="date"		dateStyle="short"/><br>
		<br>
		<br>
		시간: <br>
		<fmt:formatDate value="${today }" 	type="time"		timeStyle="full"/><br>
		<fmt:formatDate value="${today }" 	type="time"		timeStyle="long"/><br>
		<fmt:formatDate value="${today }" 	type="time"		timeStyle="medium"/><br>
		<fmt:formatDate value="${today }" 	type="time"		timeStyle="short"/><br>
		<br>
		<br>
		날짜 시간: <br>
		<fmt:formatDate value="${today }" 	type="both"		dateStyle="full" timeStyle="full"/><br>
		<fmt:formatDate value="${today }" 	type="both"		dateStyle="long" timeStyle="long"/><br>
		<fmt:formatDate value="${today }" 	type="both"		dateStyle="medium" timeStyle="medium"/><br>
		<fmt:formatDate value="${today }" 	type="both"		dateStyle="medium" timeStyle="short"/><br>
		<br>
		<br>
		패턴: 
		<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd"/><br>
		<fmt:formatDate value="${today }" 	type="both"		pattern="hh:mm:ss"/><br>
		<fmt:formatDate value="${today }" 	type="both"		pattern="yy/M/d EEE a h:m:s"/><br>
	</div>
	<br>
	
	<div class="card-body">
		<h3>TimeZone</h3>
		timeZone으로 지정한 시간을 표시한다.<br>
		<br>
		
		서울: 
		<fmt:timeZone value="Asia/Seoul">
			<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		</fmt:timeZone>
		
		뉴욕: 
		<fmt:timeZone value="America/New_York">
			<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		</fmt:timeZone>
		
		런던:  
		<fmt:timeZone value="Europe/London">
			<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		</fmt:timeZone>
	</div>
	<br>
	
	<div class="card-body">
		<h3>setTimeZone</h3>
		setTimeZone으로 지정하면 그 이후에 시간은 setTimeZone으로 지정한 지역 시간으로 계속 표시한다.<br>
		<br>
		
		뉴욕: 이 이후 시간 출력은 항상 뉴욕 기준으로 출력된다<br>
		<fmt:setTimeZone value="America/New_York"/>

		<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		<fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>

		
		
	</div>
	
</body>
</html>












