package com.multi.biz.board.test;

import java.util.ArrayList;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.vo.BoardVO;

public class GetBoardListTest {
	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.getBoardList();
		
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
	}
}
