<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%

	// login check
	String id = (String)session.getAttribute("id");
	//System.out.println(id);
	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}
	
	// 사용자 이름 출력
	String userName = (String)session.getAttribute("name");
	
	// 스크립트릿 => HTML 코드 내부에 JAVA 코드를 삽입할 목적으로 이용
	// 스크립트릿 내부는 자바 영역임
	// JSP 파일은 Exception 객체가 내장되어있으므로 에러 처리(try ~ catch)처리를
	// 하지 않아도 된다
	
	// JDBC 7단계
	
	// 1. 사용할 JDBC(DB) 드라이버를 로드한다. 각 DB 회사마다 이름이 다르다.
	Class.forName("oracle.jdbc.driver.OracleDriver");
			
	// 2. DB와 연결한다. 연결 관리는 Connection 객체 담당
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
			
	// 3. 쿼리를 준비한다. ※쿼리 끝에 ; 있으면 에러 발생
	String sql = "select * from board order by seq desc";
	PreparedStatement stmt = conn.prepareStatement(sql);
			
	// 4. 쿼리에 ? 값을 셋팅한다. 여기선 없음
			
	// 5. 결과를 가져온다. 결과 처리 객체는 ResultSet이 담당한다.
	// select => stmt.executeQuery(); 					리턴값이 쿼리 결과
	// update, insert, delete => stmt.executeUpdate();	리턴 값이 int(쿼리 실행 갯수)
	ResultSet rs = stmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<title>글 목록</title>
</head>

<body>
	<div align="center" style="margin: auto auto">
		<h1>글 목록</h1>
		<h3>
			<%=userName %>님 환영합니다...... <a href="logoutCtrl.jsp">Log-out</a>
		</h3>

		<!-- 검색 시작 -->
		<form method="post">
			<table class="table" style="width: 800px">
				<tr>
					<td align="right">
					<select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->

		<table class="table" style="width: 800px">
			<tr>
				<th width="100">번호</th>
				<th width="200">제목</th>
				<th width="150">작성자</th>
				<th width="150">등록일</th>
				<th width="100">조회수</th>
			</tr>
<%	
	// 6. 가져온 데이터를 적절히 처리
	while(rs.next()) {		// 더 이상 가져올 row가 없으면 false
		// DB 스키마를 보고 적절한 타입으로 캐스팅을 해야한다.
		int seq = rs.getInt("seq");
		String title = rs.getString("title");
		String nickname = rs.getString("nickname");
		String content = rs.getString("content");
		Date regdate = rs.getDate("regdate");
		int cnt = rs.getInt("cnt");
		String userid = rs.getString("userid");
		
		// 도스창에 출력
		//System.out.println(seq + " / " + title + " / " + nickname);
%>
			<tr>
				<td><%=seq %></td>
				<td><a href="getBoard.jsp?seq=<%=seq%>"><%=title %></a></td>
				<td><%=nickname %></td>
				<td><%=regdate %></td>
				<td><%=cnt %></td>
			</tr>
<%
	}
	
	// 7. 사용한 자원을 나중에 사용한 것부터 닫는다.
	rs.close();
	stmt.close();
	conn.close();
%>
		</table>
		<br> <a href="addBoard.jsp">새글 등록</a>
	</div>
</body>
</html>



