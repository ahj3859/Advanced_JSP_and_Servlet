package com.multi.biz.user.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.multi.biz.user.vo.UserVO;
import com.multi.biz.utils.MyBatisConnection;

public class MyBatisDAO {
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
	
	private SqlSessionFactory factory = MyBatisConnection.getSqlSession();
	
	public UserVO login(UserVO vo) {
		System.out.println("MyBatis login()");
		SqlSession session = factory.openSession();
		UserVO user = session.selectOne("login", vo);
		session.close();
		return user;
	}
}
