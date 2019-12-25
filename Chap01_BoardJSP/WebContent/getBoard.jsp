<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// login check
	String id = (String)session.getAttribute("id");	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}
	
	// 사용자 이름 출력
	String userName = (String)session.getAttribute("name");

	// form 또는 ?name=value 형태로 넘어온 값을 받자
	String num = request.getParameter("seq");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
	
	String sql = "select * from board where seq = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	
	// 4. 쿼리에 ? 값을 셋팅한다.
	// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅 
	stmt.setInt(1, Integer.parseInt(num)); 		// 1번째 ?에 int 타입의 변수 값으로 셋팅
	
	ResultSet rs = stmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<title>글 상세</title>
</head>

<body>
	<div align="center" style="margin: auto auto">
		<h3>글 상세</h3>
		<h3><%=userName %>님 환영합니다...... 
			<a href="logoutCtrl.jsp"> Log-out</a>
		</h3>
		<hr>
		<!-- form은 모든 값을 field를 이용해서 action에 지정한 파일로 전달한다.
		     action="updateBoard.jsp?seq=10"과 같이 기술하면 seq는 무시된다
		-->
		<form action="updateBoard.jsp" method="post">
			<!-- seq는 화면에 표시될 필요가 없으므로 숨긴다. 값 넘기는 목적으로만 사용 -->
			<input name="seq" type="hidden" value="<%=num %>"/>
			<table class="table" style="width: 800px">
<%
	// row가 1개 이므로 존재 여부만 체크
	if (rs.next()) {		// 더 이상 가져올 row가 없으면 false
		// DB 스키마를 보고 적절한 타입으로 캐스팅을 해야한다.
		int seq = rs.getInt("seq");
		String title = rs.getString("title");
		String nickname = rs.getString("nickname");
		String content = rs.getString("content");
		Date regdate = rs.getDate("regdate");
		int cnt = rs.getInt("cnt");
		String userid = rs.getString("userid");
		
%>
				<tr>
					<td>제목</td>
					<td align="left">
						<input name="title" type="text" value="<%=title %>" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left"><%=nickname %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10" class="form-control"><%=content %></textarea>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left"><%=regdate %></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left"><%=cnt %></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정" class="btn btn-primary"/>
					</td>
				</tr>
<%		
	} else {
%>
				<tr>
					<td colspan="2" align="center">
						등록된 글이 없습니다.
					</td>
				</tr>
<%
	}

	rs.close();
	stmt.close();
	conn.close();
%>
			</table>
		</form>
		<hr>
		<a href="addBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteBoard.jsp?seq=<%=num %>">글삭제</a>&nbsp;&nbsp;&nbsp; 
		<a href="getBoardList.jsp">글목록</a>
	</div>
</body>
</html>










