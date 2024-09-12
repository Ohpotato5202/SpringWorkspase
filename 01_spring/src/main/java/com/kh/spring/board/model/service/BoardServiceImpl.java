package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.common.Utils;
import com.kh.spring.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardDao boardDao;
	private final ServletContext application;

	@Override
	public List<Board> selectList(PageInfo pi, Map<String, Object> param) {
		return boardDao.selectList(pi, param);
	}

	@Override
	public int selectListCount(Map<String, Object> param) {
		return boardDao.selectListCount(param);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class}) // 어떤 예외든 발생시 rollback처리.(에러가 안나면 커밋, 에러가 나면 롤백)
	public int insertBoard(Board b, BoardImg bi) throws Exception {
		// 0) 게시글 삽입전에 xss공격에 대한 파싱처리, 개행처리 수행
		String boardTitle = b.getBoardTitle();
		String boardContent = b.getBoardContent();
		
		boardTitle = Utils.XSSHandling(boardTitle);
		boardContent = Utils.XSSHandling(boardContent);
		boardContent = Utils.newLineHandling(boardContent);
		
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		
		// 1) INSERT BOARD 후
		int result = boardDao.insertBoard(b); // 수행 완료시 b에는 boardNo값이 저장 -> selectKey에서 저장시켜 줌.
		
		int boardNo = b.getBoardNo();
		
		// 2) INSERT BOARD_IMG 등록 (bi != null 일 때 등록)
		if(bi != null) {
			bi.setRefBno(boardNo);
			result *= boardDao.insertBoardImg(bi);
		}
		
		if(result == 0 ) {
			throw new Exception("예외 발생");
		}
		
		// 1,2의 수행 결과는 항상 동일하게 처리해야 함.
		// 처리 결과값 반환
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		return boardDao.selectBoard(boardNo);
	}

	@Override
	public int increaseCount(int boardNo) {
		return boardDao.increaseCount(boardNo);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public int updateBoard(Board board, MultipartFile upfile, int boardImgNo, String deleteList) {
		// upfile에 전달된 데이터가 있으면 이미지테이블 수정 또는 추가
		// 파일이 없던 곳에서 새롭게 추가된 경우 -> INSERT
		// 파일이 있던 곳에서 새롭게 추가된 경우 -> UPDATE
		// 파일이 있던 곳에서 삭제가 된 경우 -> DELETE
		// 원래 파일이 없었고 추가된 것도 없는 경우 -> 아무것도 안함
		
		// 0) 데이터 파싱. (insert시와 동일 -> 일단 생략)
		
		// 1) BOARD테이블 업데이트
		int result = boardDao.updateBoard(board);
		
		// 2) BOARD_IMG테이블에 INSERT / UPDATE / DELETE
		if(result == 0) {
			throw new RuntimeException("수정 실패...");
		}
		
		BoardImg bi = new BoardImg();
		String webPath = "/resources/images/board/N/";
		String serverFolderPath = application.getRealPath(webPath); // C://...
		// 파일이 없던 곳에서 새롭게 추가된 경우 -> INSERT
		if(boardImgNo == 0 && upfile != null && !upfile.isEmpty()) {
			bi.setRefBno(board.getBoardNo());
			bi.setImgLevel(0);
			
			String changeName = Utils.saveFile(upfile, serverFolderPath);
			
			bi.setChangeName(changeName);
			bi.setOriginName(upfile.getOriginalFilename());
			
			try {
				result *= boardDao.insertBoardImg(bi);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 파일이 있던 곳에서 새롭게 추가된 경우 -> UPDATE
		}else if(boardImgNo != 0 && upfile != null && !upfile.isEmpty()) {
			
			bi.setBoardImgNo(boardImgNo);
			
			String changeName = Utils.saveFile(upfile, serverFolderPath);
			
			bi.setChangeName(changeName);
			bi.setOriginName(upfile.getOriginalFilename());
			
			result *= boardDao.updateBoardImg(bi);
			
			// 파일이 있던 곳에서 삭제가 된 경우 -> DELETE
		}else if(boardImgNo != 0 && upfile.isEmpty() && !deleteList.equals("")) {
			result *= boardDao.deleteBoardImg(deleteList);
			
			// 웹서버의 파일시스템 안에 있는 첨부 파일도 삭제해줘야 함.
		}
		
		
		return result;
	}

	@Override
	public List<String> selectFileList() {
		return boardDao.selectFileList();
	}

	
	
	
}




