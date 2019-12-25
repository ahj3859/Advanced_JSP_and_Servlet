<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// login check
	String id = (String)session.getAttribute("id");	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}

	// post로 값을 받는 경우는 먼저 언어코딩 값을 세팅 후 받아야 한글이 안깨진다.
	// 넘기는 쪽에서 UTF-8로 넘기면 여기서도 UTF-8로 받는다.
	// get으로 넘길때는 서버에서 설정한다.
	request.setCharacterEncoding("UTF-8");
	
	String title = request.getParameter("title");
	String nickname = request.getParameter("nickname");
	String content = request.getParameter("content");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
	
	String sql = "insert into board(seq, title, nickname, content) "
			+ "values( (select nvl( max(seq), 0) + 1 from board), ?, ?, ?)";
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	// 4. 쿼리에 ? 값을 셋팅한다.
	// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅
	stmt.setString(1, title); 			// 1번째 ?에 String 타입의 String 변수 값으로 셋팅
	stmt.setString(2, nickname); 		// 2번째 ?에 String 타입의 String 변수 값으로 셋팅
	stmt.setString(3, content); 		// 3번째 ?에 String 타입의 String 변수 값으로 셋팅
			
	int cnt = stmt.executeUpdate();
	
	if (cnt != 0) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("addBoard.jsp");
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