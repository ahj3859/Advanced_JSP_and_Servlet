<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// login check
	String id = (String)session.getAttribute("id");	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}

	// 사용해야 할 타입이 int라 String으로 넘어노는 값을 int로 캐스팅해서 받아온다.
	int seq = Integer.parseInt(request.getParameter("seq"));

	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
	
	String sql = "delete from board where seq=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setInt(1, seq);
	
	// 5. 결과를 가져온다.
	int cnt = stmt.executeUpdate();
	if (cnt != 0) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("getBoard.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>