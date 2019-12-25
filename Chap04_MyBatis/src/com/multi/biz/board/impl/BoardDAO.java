package com.multi.biz.board.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.multi.biz.board.service.BoardService;
import com.multi.biz.board.vo.BoardVO;
import com.multi.biz.utils.JdbcConnection;

public class BoardDAO implements BoardService {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private BasicDataSource dataSource = null;
	
	@Override
	public List<BoardVO> getBoardList() {		
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			//conn = JdbcConnection.getConnection();
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();

			String sql = "select * from board order by seq desc";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) { // 더 이상 가져올 row가 없으면 false
				// DB 스키마를 보고 적절한 타입으로 캐스팅을 해야한다.
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String nickname = rs.getString("nickname");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int cnt = rs.getInt("cnt");
				String userid = rs.getString("userid");

				BoardVO vo = new BoardVO();
				vo.setSeq(seq);
				vo.setTitle(title);
				vo.setNickname(nickname);
				vo.setContent(content);
				vo.setRegdate(regdate);
				vo.setCnt(cnt);
				vo.setUserid(userid);

				boardList.add(vo);

				// out.println("<div>" + nickname + "</div>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.close(rs, stmt, conn);
		}
		
		return boardList;
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			//conn = JdbcConnection.getConnection();
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();

			String sql = "select * from board where seq = ?";
			stmt = conn.prepareStatement(sql);

			// 4. 쿼리에 ? 값을 셋팅한다.
			// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅
			stmt.setInt(1, vo.getSeq()); // 1번째 ?에 int 타입의 변수 값으로 셋팅

			rs = stmt.executeQuery();

			// row가 1개 이므로 존재 여부만 체크
			if (rs.next()) { // 더 이상 가져올 row가 없으면 false
				board = new BoardVO();

				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(rs, stmt, conn);
		}
		
		return board;
	}
	
	//public int addBoard(String title, String nickname, String content) {
	@Override
	public int addBoard(BoardVO vo) {
		int cnt = 0;
		try {
			//conn = JdbcConnection.getConnection();
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();
			
			String sql = "insert into board(seq, title, nickname, content) "
					+ "values( (select nvl( max(seq), 0) + 1 from board), ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			// 4. 쿼리에 ? 값을 셋팅한다.
			// 첫번째 ?에 값을 셋팅, 넘어온 값이 문자열이므로 int 팁입으로 캐스팅
			stmt.setString(1, vo.getTitle()); 			// 1번째 ?에 String 타입의 String 변수 값으로 셋팅
			stmt.setString(2, vo.getNickname()); 		// 2번째 ?에 String 타입의 String 변수 값으로 셋팅
			stmt.setString(3, vo.getContent()); 		// 3번째 ?에 String 타입의 String 변수 값으로 셋팅
					
			cnt = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}
		
		return cnt;
	}
	
	//public int updateBoard(int seq, String title, String content) {
	@Override
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		try {
			//conn = JdbcConnection.getConnection();
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();

			String sql = "update board set title=?, content=? where seq=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			// 5. 결과를 가져온다.
			cnt = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}
		
		return cnt;
	}
	
	@Override
	public int deleteBoard(BoardVO vo) {		
		int cnt = 0;
		try {
			//conn = JdbcConnection.getConnection();
			dataSource = JdbcConnection.getDataSource();
			conn = dataSource.getConnection();
			
			String sql = "delete from board where seq=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, vo.getSeq());
			
			// 5. 결과를 가져온다.
			cnt = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}
		return cnt;
	}
}
