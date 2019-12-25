package com.multi.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.vo.BoardVO;

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
			request.setCharacterEncoding("UTF-8");

			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
					
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			int cnt = dao.updateBoard(vo);
			
			if (cnt != 0) {
				response.sendRedirect("getBoardListCtrl");
			} else {
				response.sendRedirect("getBoardCtrl");
			}
		}
	}

}
