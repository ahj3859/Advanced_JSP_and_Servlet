package com.multi.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.vo.BoardVO;

public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
			
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {
			String title = request.getParameter("title");
			String nickname = request.getParameter("nickname");
			String content = request.getParameter("content");
			
			// 여러 이름으로 파라메터를 전달하지 말고 하나의 이름으로 묶어서 전달한다.
			// 어짜피 컬럼에 들어갈 값이고 그 값은 BoardVO가 모든 컬럼을 가지고 있다.
			BoardVO vo = new BoardVO(); // 위에서 받은 값을 저장해 Model에 전달할 변수를 BoardVO로 저장한다.
			vo.setTitle(title);
			vo.setNickname(nickname);
			vo.setContent(content);

			// 디비 입력은 Model(DAO)가 하므로 위에서 받는 값을 해당 메서드의 파라메터로 전달
			BoardDAO dao = new BoardDAO();
			// 받은 파라메터 값을 매개변수로 전달한다.
			int cnt = dao.addBoard(vo);
			
			if (cnt != 0) {
				response.sendRedirect("getBoardListCtrl");
			} else {
				response.sendRedirect("addBoard.jsp");
			}
		}
	}

}
