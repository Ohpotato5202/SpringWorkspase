package com.kh.spring.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor // final이 붙은 필드를 필수 매개변수로 하는 생성자를 생성해 줌
public class BoardDaoImpl implements BoardDao{

	//@Autowired
	private final SqlSession sqlSession;
	
	// @RequiredArgsConstructor로 아래의 코드를 대체.(자동으로 생성해줌)
//	public BoardDaoImpl(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}
	
	@Override
	public List<BoardType> selectBoardTypeList() {
		return sqlSession.selectList("board.selectBoardTypeList");
	}

	// rowNum방식 페이징 처리
//	@Override
//	public List<Board> selectList(PageInfo pi) {
//		// rowNum방식 페이징 처리
//		// startRow : (currentPage -1) * pageLimit +1
//		// endRow : startRow + pageLimit -1
//		int startRow = (pi.getCurrentPage() -1) * pi.getPageLimit() +1;
//		int endRow = startRow + pi.getPageLimit() -1;
//		
//		Map<String, Object> param = new HashMap<>();
//		param.put("startRow", startRow);
//		param.put("endRow", endRow);
//		
//		return sqlSession.selectList("board.selectList", param);
//	}
	
	// MyBatis의 RowBounds객체를 이용한 페이징 처리
	@Override
	public List<Board> selectList(PageInfo pi, Map<String, Object> param) {
		// MyBatis의 RowBounds객체를 이용한 페이징 처리
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("board.selectList", param, rowBounds); // 3번째 매개변수에 넣어줘야 함
	}
	
	@Override
	public int selectListCount(Map<String, Object> param) {
		return sqlSession.selectOne("board.selectListCount", param);
	}

	@Override
	public int insertBoard(Board b) throws Exception {
		return sqlSession.insert("board.insertBoard", b);
	}

	@Override
	public int insertBoardImg(BoardImg bi) throws Exception {
		return sqlSession.insert("board.insertBoardImg", bi);
	}

	@Override
	public Board selectBoard(int boardNo) {
		return sqlSession.selectOne("board.selectBoard", boardNo);
	}

	@Override
	public int increaseCount(int boardNo) {
		return sqlSession.update("board.increaseCount", boardNo);
	}

	@Override
	public int updateBoardImg(BoardImg bi) {
		return sqlSession.update("board.updateBoardImg", bi);
	}

	@Override
	public int updateBoard(Board board) {
		return sqlSession.update("board.updateBoard", board);
	}

	@Override
	public int deleteBoardImg(String deleteList) {
		return sqlSession.delete("board.deleteBoardImg", deleteList);
	}

	@Override
	public List<String> selectFileList() {
		return sqlSession.selectList("board.selectFileList");
	}
	
	
	
}



