package com.multi.view.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.user.impl.MyBatisDAO;
import com.multi.biz.user.impl.UserDAO;
import com.multi.biz.user.vo.UserVO;

public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		//UserDAO dao = new UserDAO();
		// MyBatis
		MyBatisDAO dao = MyBatisDAO.getInstance();
		UserVO resultVo = dao.login(vo);

		if (resultVo != null) {
			// session 처리
			// Object id = new Object(userId);
			HttpSession session = request.getSession();
			session.setAttribute("id", resultVo.getId());
			session.setAttribute("name", resultVo.getName());
			response.sendRedirect("getBoardListCtrl");
		} else {
			// request 처리
			// 사용자가 로그인 시에 기입한 아이디 값을 입력
			request.setAttribute("id", id);
			// response.sendRedirect("login.jsp");

			// 여기서 사용한 request와 response를 전달하기 위한 객체
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");

			// 현재 request에는 id라는 속성에 사용자가 입력한 값이 들어가 있음
			view.forward(request, response);
		}
	}

}
