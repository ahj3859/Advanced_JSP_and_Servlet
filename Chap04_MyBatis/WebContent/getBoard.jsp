<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="ErrorPage/JSPError.jsp"%>
<%
	// login check
	String id = (String)session.getAttribute("id");	
	if (id == null) {
		response.sendRedirect("login.jsp");
	}
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
		<h3>${name }님 환영합니다...... 
			<a href="logoutCtrl"> Log-out</a>
		</h3>
		<hr>
		<!-- form은 모든 값을 field를 이용해서 action에 지정한 파일로 전달한다.
		     action="updateBoard.jsp?seq=10"과 같이 기술하면 seq는 무시된다
		-->
		<form action="updateBoardCtrl" method="post">
			<!-- seq는 화면에 표시될 필요가 없으므로 숨긴다. 값 넘기는 목적으로만 사용 -->
			<input name="seq" type="hidden" value="${board.seq } %>"/>
			<table class="table" style="width: 800px">

				<tr>
					<td>제목</td>
					<td align="left">
						<input name="title" type="text" value="${board.title }" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left">${board.nickname }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10" class="form-control">${board.content }</textarea>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left">${board.regdate }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정" class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="addBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteBoardCtrl?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp; 
		<a href="getBoardListCtrl">글목록</a>
	</div>
</body>
</html>










