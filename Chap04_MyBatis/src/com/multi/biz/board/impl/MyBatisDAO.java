package com.multi.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.multi.biz.board.service.BoardService;
import com.multi.biz.board.vo.BoardVO;
import com.multi.biz.utils.MyBatisConnection;

public class MyBatisDAO implements BoardService {
	// 싱글턴 객체 생성
	private static MyBatisDAO dao;
	
	// 생성자로는 객체 생성이 안되게 막는다.
	private MyBatisDAO() {}
	
	public static MyBatisDAO getInstance( ) {
		if  (dao == null) {
			dao = new MyBatisDAO();
		}
		return dao;
	}
	
	// MyBatis 연결을 위한 설정
	private SqlSessionFactory factory = MyBatisConnection.getSqlSession();
	
	// 전체 리스트
	public List<BoardVO> getBoardList() {
		System.out.println("MyBatisDAO getBoardList()");
		// 연결 객체를 얻어온다.
		SqlSession session = factory.openSession();
		
		// boardMapper에 있는 id 이름을 호출한다.
		List<BoardVO> boardList = session.selectList("getBoardList");
		session.close();
		
		return boardList;
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("MyBatisDAO getBoard()");
		
		SqlSession session = factory.openSession();
		BoardVO board = session.selectOne("getBoard", vo);
		session.close();
		
		return board;
	}
	
	public int addBoard(BoardVO vo) {
		System.out.println("MyBatisDAO addBoard()");
		
		SqlSession session = factory.openSession();
		int cnt = session.insert("addBoard", vo);
		session.commit();	// 결과를 디비에 반영
		//session.rollback();	// 결과를 반영하지 않고 이전 상태로 돌림
		session.close();
		
		return cnt;
	}
	
	public int updateBoard(BoardVO vo) {
		System.out.println("MyBatisDAO updateBoard()");
		
		SqlSession session = factory.openSession();
		int cnt = session.update("updateBoard", vo);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	public int deleteBoard(BoardVO vo) {
		System.out.println("MyBatisDAO deleteBoard()");
		
		SqlSession session = factory.openSession();
		int cnt = session.delete("deleteBoard", vo);
		session.commit();
		session.close();
		
		return cnt;
	}
}
