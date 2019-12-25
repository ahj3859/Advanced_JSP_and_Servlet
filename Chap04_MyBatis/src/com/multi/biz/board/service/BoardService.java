package com.multi.biz.board.service;

import java.util.List;

import com.multi.biz.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	BoardVO getBoard(BoardVO vo);

	int addBoard(BoardVO vo);

	int updateBoard(BoardVO vo);

	int deleteBoard(BoardVO vo);

}