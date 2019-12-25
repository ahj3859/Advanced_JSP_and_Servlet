<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A07_FormatNumber</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="card-body">
		<h3>Number Format</h3>
		
		<c:set var="num" value="123456.9876543" />
		
		,구분: <fmt:formatNumber	value="${num }" groupingUsed="true" /><br>
		#구분: <fmt:formatNumber	value="${num }" pattern="#.####" /><br>
		<!-- 패턴만 만들어주면 알아서 분리한다 -->
		#구분: <fmt:formatNumber	value="${num }" pattern="#,###.####" /><br>
		0구분: <fmt:formatNumber	value="${num }" pattern="0.00" /><br>
		0구분: <fmt:formatNumber	value="${num }" pattern="0,000.00" /><br>
		
		<!-- #은 남은 자리수를 표시하지 않음. 0을 빈 자리를 0으로 다 채운다 -->
		#구분: <fmt:formatNumber	value="${num }" pattern="###,###,###,###.####" /><br>
		0구분: <fmt:formatNumber	value="${num }" pattern="000,000,000,000.00" /><br>
		<br>
		<br>
		
		<h3>통화 표시</h3>
		기본값: <fmt:formatNumber value="${num }" type="currency" /><br>
		symbol: <fmt:formatNumber value="${num }" type="currency" currencySymbol="$"/><br>
		code: <fmt:formatNumber value="${num }" type="currency" currencyCode="CNY"/><br>
		<br>
		<br>
		
		<h3>퍼센트 표시</h3>
		% 표시: <fmt:formatNumber value="${num }" type="percent" /><br>
		% 표시: <fmt:formatNumber value="0.5" type="percent" /><br>
		<br>
		<br>
		
		<h3>setLocal</h3>
		지정한 값으로 시간과 통화 표시, 다국어 처리까지 모두 변경한다<br>
		시간은 현재 시간을 그대로 지정한 나라 언어로 변경만 한다<br>
		<br>
		
		<c:set var="today" value="<%=new Date() %>" />
		
		미국: <br>
		<fmt:setLocale value="en_us"/>
		시간: <fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		기본값: <fmt:formatNumber value="${num }" type="currency" /><br>
		<br>
		
		대한민국: <br>
		<fmt:setLocale value="ko_kr"/>
		시간: <fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		기본값: <fmt:formatNumber value="${num }" type="currency" /><br>
		<br>
		
		대만: <br>
		<fmt:setLocale value="zh_tw"/>
		시간: <fmt:formatDate value="${today }" 	type="both"		pattern="yyyy/MM/dd EEEE a hh:mm:ss"/><br>
		기본값: <fmt:formatNumber value="${num }" type="currency" /><br>
		<br>
		
	
	</div>
</body>
</html>












