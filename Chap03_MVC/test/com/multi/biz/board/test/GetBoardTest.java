package com.multi.biz.board.test;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.vo.BoardVO;

public class GetBoardTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		
		int seq = 2;
		BoardVO board = dao.getBoard(seq);
		System.out.println(board);
	}
}
