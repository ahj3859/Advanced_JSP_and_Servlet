package com.multi.view.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "hr", "hr");
				
				String sql = "insert into board(seq, title, nickname, content) "
						+ "values( (select nvl( max(seq), 0) + 1 from board), ?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				
				// 4. 쿼리에 ? 값을 셋팅한다.
				// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅
				stmt.setString(1, title); 			// 1번째 ?에 String 타입의 String 변수 값으로 셋팅
				stmt.setString(2, nickname); 		// 2번째 ?에 String 타입의 String 변수 값으로 셋팅
				stmt.setString(3, content); 		// 3번째 ?에 String 타입의 String 변수 값으로 셋팅
						
				int cnt = stmt.executeUpdate();
				if (cnt != 0) {
					response.sendRedirect("getBoardListCtrl");
				} else {
					response.sendRedirect("addBoard.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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

}
