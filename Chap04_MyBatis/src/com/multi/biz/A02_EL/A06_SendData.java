package com.multi.biz.A02_EL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.biz.user.vo.UserVO;

/**
 * Servlet implementation class A06_SendData
 */
@WebServlet("/expression/A06_SendData")
public class A06_SendData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] name = {"홍길동", "놀부", "흥부"};
		
		ArrayList<String> fruit = new ArrayList<String>();
		fruit.add("바나나");
		fruit.add("포도");
		fruit.add("멜론");
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 10);
		map.put("two", 20);
		
		UserVO user = new UserVO();
		user.setId("lee");
		user.setName("이몽룡");
		
		request.setAttribute("name", name);
		request.setAttribute("fruit", fruit);
		request.setAttribute("map", map);
		request.setAttribute("user", user);
		
		RequestDispatcher view = request.getRequestDispatcher("A06_SendData.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
