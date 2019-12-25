<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL SET / IF</title>
</head>
<body>
    <div class="card-body">
            외부 라이브러리이므로 maven으로 필요한 라이브러리를 다운받아야한다.<br>
            다음으로 사용하는 페이지에서 지시자로 tablib부터 정의할 필요가 있다<br>
            모든 명령은 태그 형태로 사용한다.
          <br>
          
          <h3>SET</h3>
          변수를 만들 경우 사용한다. <br>
          set으로 선언된 변수는 기본적으로 pageContext scope에 
                pageScope.setAttribute("변수명", "값") 형태로 저장된다.<br>
                따라서 꺼내서 사용하는 경우는 Expression Language(EL)로 꺼내 쓴다.<br>
          <c:set var="num1" value="10" scope="page"/>
          <c:set var="num2" value="20" />
          <c:set var="result" value="${num1 + num2 }" />
          ${num1 } + ${num2 } = ${result } <br>
          <br>
    </div>
</body>
</html>