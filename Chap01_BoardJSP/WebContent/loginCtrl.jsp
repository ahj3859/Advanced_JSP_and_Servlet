<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// JDBC
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
	
	String sql = "select * from users where id=? and password=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	stmt.setString(1, id);
	stmt.setString(2, password);
	
	// sql select 명령의 경우 결과를 ResultSet으로 받아옴
	ResultSet rs = stmt.executeQuery();
	if (rs.next()) {
		// 유저가 있다면 내장 session 객체에 사용자 정의 속성을 추가한다.
		// 다른 페이지에서 session 객체에 사용자 정의 객체가 있다면 이 로그인 페이지를
		// 걸쳐서 이동했다는 증거가 된다.
		String userId = rs.getString("id");
		String name = rs.getString("name");
		
		// session 처리
		//Object id = new Object(userId);
		session.setAttribute("id", userId);
		session.setAttribute("name", name);
		response.sendRedirect("getBoardList.jsp");
	} else {
		// request 처리
		// 사용자가 로그인 시에 기입한 아이디 값을 입력
		request.setAttribute("id", id);
		//response.sendRedirect("login.jsp");
		
		// 여기서 사용한 request와 response를 전달하기 위한 객체
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		
		// 현재 request에는 id라는 속성에 사용자가 입력한 값이 들어가 있음
		view.forward(request, response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCtrl.jsp</title>
</head>
<body>

</body>
</html>