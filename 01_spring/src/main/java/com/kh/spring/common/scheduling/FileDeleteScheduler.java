package com.kh.spring.common.scheduling;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kh.spring.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileDeleteScheduler {

	// 정적 파일들의 경로를 얻어오기 위한 변수
	private final ServletContext application;
	
	private final BoardService boardService;
	
	
	@Scheduled(cron = "1 * * * * *")
	public void deleteFile() {
		log.debug("\n파일 삭제 스케쥴러 시작\n");
		// 1) BOARD_IMG안에 있는 모든 파일목록 조회
		List<String> list = boardService.selectFileList(); // DB상에 존재하는 파일
		log.debug("\n-list {}", list); // /resources/images/.../xxx.xxx
		
		File path = new File(application.getRealPath("/resources/images/board/N"));
		File[] files = path.listFiles(); // 현재 디렉토리 안에 존재하는 모든 파일을 배열 형태로 반환해주는 메서드
		List<File> fileList = Arrays.asList(files); // 실제 경로상에 존재하는 파일
		
		if(!list.isEmpty()) {
			for(File serverFile : fileList) {
				String fileName = serverFile.getName(); // 파일이름 반환 (20240618...)
				fileName = "/resources/images/board/N/" + fileName;
				
				// 실제 웹서버 상에는 존재하나 DB에는 존재하지 않는 파일인 경우
				if(list.indexOf(fileName) == -1) {
					log.debug("\n"+fileName+"을 삭제합니다.\n");
					serverFile.delete();
				}
			}
		}
		
		
		log.debug("\n파일 삭제 스케쥴러 끝!\n");
	}
	
	
	
	
}





