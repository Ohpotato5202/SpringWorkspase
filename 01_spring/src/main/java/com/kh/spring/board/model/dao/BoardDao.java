package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;

public interface BoardDao {

	List<BoardType> selectBoardTypeList();

	List<Board> selectList(PageInfo pi, Map<String, Object> param);

	int selectListCount(Map<String, Object> param);

	int insertBoard(Board b) throws Exception;

	int insertBoardImg(BoardImg bi) throws Exception;

	Board selectBoard(int boardNo);

	int increaseCount(int boardNo);

	int updateBoardImg(BoardImg bi);

	int updateBoard(Board board);

	int deleteBoardImg(String deleteList);

	List<String> selectFileList();

}
