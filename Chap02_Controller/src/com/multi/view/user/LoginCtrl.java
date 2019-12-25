package com.multi.view.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			// JDBC
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			String sql = "select * from users where id=? and password=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, password);

			// sql select 명령의 경우 결과를 ResultSet으로 받아옴
			rs = stmt.executeQuery();
			if (rs.next()) {
				// 유저가 있다면 내장 session 객체에 사용자 정의 속성을 추가한다.
				// 다른 페이지에서 session 객체에 사용자 정의 객체가 있다면 이 로그인 페이지를
				// 걸쳐서 이동했다는 증거가 된다.
				String userId = rs.getString("id");
				String name = rs.getString("name");

				// session 처리
				// Object id = new Object(userId);
				HttpSession session = request.getSession();
				session.setAttribute("id", userId);
				session.setAttribute("name", name);
				response.sendRedirect("getBoardListCtrl");
			} else {
				// request 처리
				// 사용자가 로그인 시에 기입한 아이디 값을 입력
				request.setAttribute("id", id);
				// response.sendRedirect("login.jsp");

				// 여기서 사용한 request와 response를 전달하기 위한 객체
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");

				// 현재 request에는 id라는 속성에 사용자가 입력한 값이 들어가 있음
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
