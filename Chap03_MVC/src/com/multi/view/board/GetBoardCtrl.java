package com.multi.view.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.board.impl.BoardDAO;
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
			// 전달된 값을 받는다.
			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardDAO dao = new BoardDAO();
			// 받은 파라메터 값을 매개변수로 전달한다.
			BoardVO board = dao.getBoard(seq);

			request.setAttribute("board", board);
			RequestDispatcher view = request.getRequestDispatcher("getBoard.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
