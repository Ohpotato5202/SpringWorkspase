package com.kh.spring.board.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardExt;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.common.Utils;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SessionAttributes({"loginUser"})
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	private final ServletContext application;
	private final ResourceLoader resourceLoader;
	// spring framework에서 제공하는 자원을 로드(입력)하는데 사용되는 인터페이스
	// resourceLoader를 통해 파일 시스템, 클래스 패스, URL자원 등을 모두 하나의 클래스로 로드가 가능하다.
	// classpath:/mapper/**/..xml
	
	
	@GetMapping("/list/{boardCode}") // 동적 파라미터 설정 : {변수명}
	// 정규표현식 {} : 하나의 문자열을 의미 -> {}안에 들어오는 문자열을 boardCode에 담겠다.
	public String selectList(
			@PathVariable("boardCode") String boardCode, // @PathVariable : url패턴에 들어온 값을 꺼내쓸 때 사용.
			// PathVariable로 등록된 변수는 request scope에 자동 저장.
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			Model model,
			@RequestParam Map<String, Object> paramMap
			) {
		
		log.info("paramMap안의 데이터 : {}", paramMap);
		paramMap.put("boardCode", boardCode);
		
		// 페이징 작업 처리
		// 1) 게시글 갯수 카운팅
		int listCount = boardService.selectListCount(paramMap);
		int pageLimit = 10;
		int boardLimit = 10;
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
		
		
		// 게시글 데이터 조회
		List<Board> list = boardService.selectList(pi, paramMap);
		
		// 응답View페이지에 게시글 데이터 삽입
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		// viewName반환
		return "board/boardListView";
	}
	
	@GetMapping("/insert/{boardCode}")
	public String enrollBoard(@PathVariable("boardCode") String boardCode) {
		return "board/boardEnrollForm";
	}
	
	@PostMapping("/insert/{boardCode}")
	public String isertBoard(
			@PathVariable("boardCode") String boardCode,
			Board b,
			@ModelAttribute("loginUser") Member loginUser,
			Model model, // errorMsg 저장용
			RedirectAttributes ra, // alertMsg 저장용
			// 첨부파일
			@RequestParam(value = "upfile", required = false) MultipartFile upfile // 항상 객체 생성
			) {
		
		//		===== 업무 로직 =====
		// 1. 웹서버에 클라이언트가 전달한 file 저장
		BoardImg bi = null;

		if(upfile != null && !upfile.isEmpty()) {
			// 첨부파일, 이미지 등을 저장할 저장 경로 얻어오기.
			String webPath = "/resources/images/board/"+boardCode+"/";
			String serverFolderPath = application.getRealPath(webPath);
			
			// 디렉토리가 존재하지 않는다면 생성하는 코드 추가.
			File dir = new File(serverFolderPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			// 사용자가 등록한 첨부파일의 이름을 수정.
			String changeName = Utils.saveFile(upfile, serverFolderPath);
			
			bi = new BoardImg();
			bi.setChangeName(changeName);
			bi.setOriginName(upfile.getOriginalFilename());
			bi.setImgLevel(0); // 0은 첨부파일, 1은 썸네일, 그외는 상세보기용 이미지
			
		}
		 
		// 2. 저장 완료시 파일이 저장된 경로를 BOARD_IMG에 등록 후 테이블에 추가
		// 	1) Board INSERT
		// 	2) BOARD_IMG INSERT (클라이언트가 upfile에 데이터를 올렸을 때만)
		log.debug("board : {}", b); // boardWriter=null, boardCd=null
		b.setBoardCd(boardCode); // pathvariable 추가
		b.setBoardWriter(String.valueOf(loginUser.getUserNo()));
		
		int result = 0;
		try {
			result = boardService.insertBoard(b, bi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. 반환값을 통해 메세지 등록
		String url = "";
		if(result>0) {
			ra.addFlashAttribute("alertMsg", "게시글 작성 성공!");
			url = "redirect:/board/detail/"+boardCode+"/"+b.getBoardNo();
		}else {
			model.addAttribute("errorMsg", "게시글 작성 실패...");
			url = "common/errorPage";
		}
		
		// 4. 응답페이지 설정
		return url;
	}
	
	@GetMapping("/detail/{boardCode}/{boardNo}")
	public String selectBoard(
			@PathVariable("boardCode") String boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model,
			@ModelAttribute("loginUser") Member loginUser,
			HttpServletRequest req,
			HttpServletResponse res
			) {
		// 업무로직
		// boardCode랑 boardNo를 이용하여 게시글 정보를 조회
		Board b = boardService.selectBoard(boardNo);
		
		// (조회수 증가 서비스 생성 예정)
		// 1) 조회수 중복 증가 방지 -> 쿠키를 이용
		//	=> 쿠키 안에 클라이언트의 유저번호와 게시글 번호 목록을 함께 저장
		if(b != null) {
			Cookie cookie = null;
			
			Cookie[] cookies = req.getCookies(); // 사용자의 쿠키 정보들
			
			if(cookies != null && cookies.length > 0) {
				for(Cookie c : cookies) {
					// (임의의 이름)readBoardNo라는 이름의 쿠키를 찾기
					if("readBoardNo".equals(c.getName())) {
						cookie = c;
						break;
					}
				}
			}
			
			int result = 0; // 조회수 증가 서비스 호출 후 결과값을 담아줄 변수
			
			if(cookie == null) {
				// readBoardNo쿠키 생성
				cookie = new Cookie("readBoardNo", boardNo+"");
				// 조회수 증가 서비스 호출
				result = boardService.increaseCount(boardNo);
			}else {
				// 기존 쿠키값 중에 중복되는 게시글 번호가 없는 경우 조회수 증가 서비스 호출
				// readBoardNo에 현재 게시글 번호 추가
				String[] arr = cookie.getValue().split("/");
				List<String> list = Arrays.asList(arr); // 메서드 사용을 위한 변환
				
				if(list.indexOf(boardNo+"") == -1) { // 조회 결과가 없다면
					// 조회수 증가 서비스 호출
					result = boardService.increaseCount(boardNo);
					
					// 쿠키값에 현재 게시글 번호 추가
					cookie.setValue(cookie.getValue()+"/"+boardNo);
				}
				// 중복되는 게시글 번호가 이미 존재하는 경우 종료
			}
			
			if(result > 0) {
				b.setCount(b.getCount()+1);
				
				cookie.setPath(req.getContextPath());
				cookie.setMaxAge(1*60*60); // 1시간
				res.addCookie(cookie);
			}
		}else { // 조회된 데이터가 null인 경우
			model.addAttribute("errorMsg", "존재하지 않는 게시글입니다.");
			return "common/errorPage";
		}
		
		
		// 조회된 데이터를 model에 담아서 view로 이동
		model.addAttribute("board", b);
		
		return "board/boardDetailView";
	}
	
	@GetMapping("/fileDownload/{boardNo}")
	public ResponseEntity<Resource> fileDownload(
			@PathVariable("boardNo") int boardNo
			){
		ResponseEntity<Resource> responseEntity = null;
		 
		// DB에서 첨부파일의 정보를 조회
		BoardExt b = (BoardExt)boardService.selectBoard(boardNo);
		
		if(!(b.getAttachment() != null && b.getAttachment().getChangeName() != null)) {
			return ResponseEntity.notFound().build(); // 404에러를 응답값으로 사용
		}
		
		// Resource객체로 파일 얻어오기
		String saveDir = application.getRealPath("/resources/images/board/"+b.getBoardCd()+"/");
		File downFile = new File(saveDir, b.getAttachment().getChangeName());
		Resource resource = resourceLoader.getResource("file:"+downFile);
		
		try {
			String filename = new String(b.getAttachment().getOriginName().getBytes("utf-8"), "iso-8859-1");
			
			responseEntity = ResponseEntity.ok()
										   .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
										   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+filename)
										   .body(resource);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return responseEntity;
	}
	
	
	@GetMapping("/update/{boardCode}/{boardNo}")
	public String updateBoard(
			@PathVariable("boardCode") String boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model
			) {
		// 작성했던 게시글 정보가 보이게한 후 모델에 담아서 포워딩
		BoardExt board = (BoardExt) boardService.selectBoard(boardNo);
		
		// 게시글 본문내용 변경 ( <br> -> \n 되돌리기 )
		board.setBoardContent(Utils.newLineClear(board.getBoardContent()));
		
		model.addAttribute("board", board);
		
		return "board/boardUpdateForm";
	}
	
	@PostMapping("/update/{boardCode}/{boardNo}")
	public String updateBoard2(
			@PathVariable("boardCode") String boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model,
			Board board, // 저장할 게시판 데이터
			RedirectAttributes ra,
			@RequestParam(value="upfile", required = false) MultipartFile upfile, // 첨부파일
			int boardImgNo,
			String deleteList // 일반게시판 1, 사진게시판 1,2,3
			) {
		// 업무로직
		// BOARD테이블 수정
		log.debug("board ? {}, boardImgNo ? {}", board, boardImgNo);
		
		int result = 0;
		
		result = boardService.updateBoard(board, upfile, boardImgNo, deleteList);
		
		if(result > 0) {
			// 작업 성공시 리다이렉트
			ra.addFlashAttribute("alertMsg", "게시글 수정 성공!");
			return "redirect:/board/detail/"+boardCode+"/"+boardNo;
		}else {
			model.addAttribute("errorMsg", "게시글 수정 실패...");
			return "common/errorPage";
		}
	}
	
	
	
	
	
	
	
}













