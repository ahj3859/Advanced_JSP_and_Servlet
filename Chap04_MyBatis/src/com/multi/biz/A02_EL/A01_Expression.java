package com.multi.biz.A02_EL;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.biz.user.vo.UserVO;

/**
 * Servlet implementation class A02_Expression
 */
@WebServlet("/expression/A01_Expression")
public class A01_Expression extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "Session Name");
		session.setAttribute("id", "abc123");
		
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setName("홍길동");
		
		request.setAttribute("name", "Request Name");
		request.setAttribute("user", vo);
		
		ServletContext context = getServletContext();
		context.setAttribute("name", "ServletContext Name");
		context.setAttribute("path", "WEB-INF/config/setting.xml");
		
		RequestDispatcher view = request.getRequestDispatcher("A01_Expression.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
