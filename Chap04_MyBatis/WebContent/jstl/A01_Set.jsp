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
            �ܺ� ���̺귯���̹Ƿ� maven���� �ʿ��� ���̺귯���� �ٿ�޾ƾ��Ѵ�.<br>
            �������� ����ϴ� ���������� �����ڷ� tablib���� ������ �ʿ䰡 �ִ�<br>
            ��� ����� �±� ���·� ����Ѵ�.
          <br>
          
          <h3>SET</h3>
          ������ ���� ��� ����Ѵ�. <br>
          set���� ����� ������ �⺻������ pageContext scope�� 
                pageScope.setAttribute("������", "��") ���·� ����ȴ�.<br>
                ���� ������ ����ϴ� ���� Expression Language(EL)�� ���� ����.<br>
          <c:set var="num1" value="10" scope="page"/>
          <c:set var="num2" value="20" />
          <c:set var="result" value="${num1 + num2 }" />
          ${num1 } + ${num2 } = ${result } <br>
          <br>
    </div>
</body>
</html>