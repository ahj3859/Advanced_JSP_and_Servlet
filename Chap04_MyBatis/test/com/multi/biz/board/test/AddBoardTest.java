package com.multi.biz.board.test;

import com.multi.biz.board.impl.BoardDAO;
import com.multi.biz.board.service.BoardService;
import com.multi.biz.board.vo.BoardVO;

public class AddBoardTest {
	public static void main(String[] args) {
		BoardService dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		String title = "테스트 타이틀1";
		String content = "테스트 내용물 1";
		String nickname = "테스트 1";
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNickname(nickname);
		int cnt = dao.addBoard(vo);
		System.out.println(cnt + "개 입력 완료");
	}
}
