package com.multi.biz.board.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.multi.biz.board.impl.MyBatisDAO;
import com.multi.biz.board.vo.BoardVO;

public class MyBatisTest {
	
	// Test가 실행되고 난 후에 항상 실행됨
	@After
	public void getBoardListTest() {
		System.out.println("MyBatisTest getBoardListTest");
		MyBatisDAO dao = MyBatisDAO.getInstance();
		ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)dao.getBoardList();
		
		for(BoardVO board : boardList) {
			System.out.println(board);
		}
	}
	
	@Test
	@Ignore(value = "getBoard()")
	public void getBoard() {
		MyBatisDAO dao = MyBatisDAO.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		BoardVO board = dao.getBoard(vo);
		System.out.println(board);
		System.out.println("");
	}
	
	// 실행하는데 500ms가 지나면 에러로 출력된다.
	@Test(timeout = 500)
	@Ignore
	public void addBoard() {
		MyBatisDAO dao = MyBatisDAO.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("MyBatis Test Title");
		vo.setContent("MyBatis Test Content");
		vo.setNickname("MyBatis Test Nickname");
		
		int cnt = dao.addBoard(vo);
		System.out.println(cnt + "개 입력 완료");
		System.out.println("");
	}
	
	@Test
	@Ignore
	public void updateBoard() {
		MyBatisDAO dao = MyBatisDAO.getInstance();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("New MyBatis Test Title");
		vo.setContent("New MyBatis Test Content");
		vo.setSeq(11);
		
		int cnt = dao.updateBoard(vo);
		System.out.println(cnt + "개 변경 완료");
		System.out.println("");
	}
	
	@Test
	@Ignore
	public void deleteBoard() {
		MyBatisDAO dao = MyBatisDAO.getInstance();
		BoardVO vo = new BoardVO();
		vo.setSeq(22);
		
		int cnt = dao.deleteBoard(vo);
		System.out.println(cnt + "개 삭제 완료");
		System.out.println("");
	}
	
	@Test
	public void jUnitTest() {
		String[] str1 = {"A", "B"};
		String[] str2 = {"A", "B"};
		
		assertArrayEquals(str1, str2);		// 두개의 배열이 같아야 에러가 아니다.
		
		MyBatisDAO dao = MyBatisDAO.getInstance();
		//assertNull(dao.getBoardList());		// 값이 null이어야 에러가 아니다.
		assertNotNull(dao.getBoardList());	// 값이 null이 아니어야 에러가 아니다.
	}
}
