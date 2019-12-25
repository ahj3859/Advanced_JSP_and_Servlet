package com.multi.biz.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.multi.biz.user.vo.UserVO;
import com.multi.biz.utils.JdbcConnection;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private BasicDataSource dataSource = null;
	
	public UserVO login(UserVO vo) {
		UserVO resultVo = null;
		try {

			/*
			// JDBC
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			*/
			
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();

			String sql = "select * from users where id=? and password=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());

			// sql select 명령의 경우 결과를 ResultSet으로 받아옴
			rs = stmt.executeQuery();
			if (rs.next()) {
				resultVo = new UserVO();
				resultVo.setId(rs.getString("id"));
				resultVo.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultVo;
	}
}
