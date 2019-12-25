package com.multi.biz.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.multi.biz.user.vo.UserVO;

public class UserDAO {
	public UserVO login(UserVO vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		UserVO resultVo = null;
		try {

			// JDBC
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

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
