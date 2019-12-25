package com.multi.biz.board.test;

import java.util.ArrayList;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.service.BoardService;
import com.multi.biz.board.vo.BoardVO;

public class GetBoardListTest {
	public static void main(String[] args) {
		
		BoardService dao = new BoardDAO();
		ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)dao.getBoardList();
		
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
	}
}
