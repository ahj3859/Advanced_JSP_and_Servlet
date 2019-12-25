package com.multi.view.board;

import java.io.IOException;

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

public class DeleteBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Error를 발생시키기 위해 기술, web.xml에 지정한 Error-page로 이동한다.
		//int num = Integer.parseInt(request.getParameter("num"));
		//BoardDAO daoException = null;
		//daoException.addBoard(null);
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");	
		if (id == null) {
			response.sendRedirect("login.jsp");
		} else {
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			
			//BoardDAO dao = new BoardDAO();
//			MyBatisDAO dao = MyBatisDAO.getInstance();
			BoardDAOFactory factory = new BoardDAOFactory();
			BoardService dao = factory.getBoardDAO();
			int cnt = dao.deleteBoard(vo);
			if (cnt != 0) {
				response.sendRedirect("getBoardListCtrl");
			} else {
				response.sendRedirect("getBoardCtrl");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
