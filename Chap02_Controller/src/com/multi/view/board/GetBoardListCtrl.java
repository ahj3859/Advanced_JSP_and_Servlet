package com.multi.view.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.board.vo.BoardVO;

public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 자바코드
		// HTML코드는 response.getWrite() 메서드를 통해 스트림을 할당받아 기술

		// 서블릿에서는 session이 내장객체가 아님(서블릿은 내장 객체가 없다)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {

			// 이 메서드에서 공통적으로 참고해야 할 객체
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			// HTML 출력을 위한 스트림 객체를 받아온다.
			// PrintWriter out = response.getWriter();

			// Exception이 내장 객체가 아니므로 try ~ catch 처리를 해야함
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "hr", "hr");

				String sql = "select * from board order by seq desc";
				stmt = conn.prepareStatement(sql);

				rs = stmt.executeQuery();

				ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();

				while (rs.next()) { // 더 이상 가져올 row가 없으면 false
					// DB 스키마를 보고 적절한 타입으로 캐스팅을 해야한다.
					int seq = rs.getInt("seq");
					String title = rs.getString("title");
					String nickname = rs.getString("nickname");
					String content = rs.getString("content");
					Date regdate = rs.getDate("regdate");
					int cnt = rs.getInt("cnt");
					String userid = rs.getString("userid");

					BoardVO vo = new BoardVO();
					vo.setSeq(seq);
					vo.setTitle(title);
					vo.setNickname(nickname);
					vo.setContent(content);
					vo.setRegdate(regdate);
					vo.setCnt(cnt);
					vo.setUserid(userid);

					boardList.add(vo);

					// out.println("<div>" + nickname + "</div>");
				}

				// getBoardList.jsp 파일에서 사용할 테이터를 request에 담는다.
				request.setAttribute("boardList", boardList);

				RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
				view.forward(request, response);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
