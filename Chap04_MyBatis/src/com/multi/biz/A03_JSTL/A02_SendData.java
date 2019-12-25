package com.multi.biz.A03_JSTL;

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

@WebServlet("/jstl/A02_SendData")
public class A02_SendData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Math.abs(10);
		
		String[] name = {"홍길동", "놀부", "흥부"};
		
		ArrayList<String> fruit = new ArrayList<String>();
		fruit.add("바나나");
		fruit.add("포도");
		fruit.add("멜론");
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 10);
		map.put("two", 20);
		
		
		UserVO lee = new UserVO();
		lee.setId("lee");
		lee.setName("이몽룡");
		
		UserVO nolbu = new UserVO();
		nolbu.setId("nolbu");
		nolbu.setName("놀부");
		
		ArrayList<UserVO> user = new ArrayList<UserVO>();
		user.add(lee);
		user.add(nolbu);
		
		
		request.setAttribute("name", name);
		request.setAttribute("fruit", fruit);
		request.setAttribute("map", map);
		request.setAttribute("user", user);
		
		RequestDispatcher view = request.getRequestDispatcher("A02_For.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




