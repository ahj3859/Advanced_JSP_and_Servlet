package com.multi.biz.board.test;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.service.BoardService;
import com.multi.biz.board.vo.BoardVO;

public class GetBoardTest {
	public static void main(String[] args) {
		BoardService dao = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		BoardVO board = dao.getBoard(vo);
		System.out.println(board);
	}
}
