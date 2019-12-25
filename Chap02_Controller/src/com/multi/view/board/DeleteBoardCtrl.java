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

public class DeleteBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");	
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				int seq = Integer.parseInt(request.getParameter("seq"));

				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "hr", "hr");
				
				String sql = "delete from board where seq=?";
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, seq);
				
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
