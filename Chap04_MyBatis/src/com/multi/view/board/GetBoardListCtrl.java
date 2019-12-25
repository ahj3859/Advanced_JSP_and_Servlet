package com.multi.view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.impl.MyBatisDAO;
import com.multi.biz.board.service.BoardDAOFactory;
import com.multi.biz.board.service.BoardService;
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
			// Model(Java 파일)로부터 필요한 데이터를 받아 View로 넘긴다.
			//BoardDAO dao = new BoardDAO();
			//ArrayList<BoardVO> boardList = dao.getBoardList();
			//MyBatisDAO dao = MyBatisDAO.getInstance();
			BoardDAOFactory factory = new BoardDAOFactory();
			BoardService dao = factory.getBoardDAO();
			ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)dao.getBoardList();

			request.setAttribute("boardList", boardList);

			RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
