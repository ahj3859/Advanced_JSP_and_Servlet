package com.multi.view.board;

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

import com.multi.biz.board.vo.BoardVO;

public class GetBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {

			String num = request.getParameter("seq");

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "hr", "hr");

				String sql = "select * from board where seq = ?";
				stmt = conn.prepareStatement(sql);

				// 4. 쿼리에 ? 값을 셋팅한다.
				// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅
				stmt.setInt(1, Integer.parseInt(num)); // 1번째 ?에 int 타입의 변수 값으로 셋팅

				rs = stmt.executeQuery();

				BoardVO board = null;
				// row가 1개 이므로 존재 여부만 체크
				if (rs.next()) { // 더 이상 가져올 row가 없으면 false
					board = new BoardVO();

					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setNickname(rs.getString("nickname"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getDate("regdate"));
					board.setCnt(rs.getInt("cnt"));
					board.setUserid(rs.getString("userid"));
				}

				request.setAttribute("board", board);
				RequestDispatcher view = request.getRequestDispatcher("getBoard.jsp");
				view.forward(request, response);

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
