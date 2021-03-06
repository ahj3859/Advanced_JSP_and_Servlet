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

public class UpdateBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {

			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				request.setCharacterEncoding("UTF-8");

				String title = request.getParameter("title");
				String content = request.getParameter("content");

				// 사용해야 할 타입이 int라 String으로 넘어노는 값을 int로 캐스팅해서 받아온다.
				int seq = Integer.parseInt(request.getParameter("seq"));

				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "hr", "hr");

				String sql = "update board set title=?, content=? where seq=?";
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, title);
				stmt.setString(2, content);
				stmt.setInt(3, seq);

				// 5. 결과를 가져온다.
				int cnt = stmt.executeUpdate();
				if (cnt != 0) {
					response.sendRedirect("getBoardListCtrl");
				} else {
					response.sendRedirect("getBoardCtrl");
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
