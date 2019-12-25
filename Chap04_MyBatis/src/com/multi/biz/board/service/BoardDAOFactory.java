package com.multi.biz.board.service;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.impl.MyBatisDAO;

public class BoardDAOFactory {
	public BoardService getBoardDAO() {
		//BoardService dao = new BoardDAO();
		BoardService dao = MyBatisDAO.getInstance();
		
		return dao;
	}
}
