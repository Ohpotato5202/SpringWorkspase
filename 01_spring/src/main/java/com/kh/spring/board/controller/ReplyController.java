package com.kh.spring.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.board.model.service.ReplyService;
import com.kh.spring.board.model.vo.Reply;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
/*	=== @RestController ===
 * (@ResponseBody + @Controller)
 * : 요청에 대한 응답값이 모두 값 그 자체인 컨트롤러
 * 	-> 메서드들 내부에는 비동기 방식으로 통신하는 메서들로만 구현될 예정
 * 
 * === Rest(Representational state Transfer) === 
 * : 자원을 url이름으로 구분하여 자원의 상태(state)를 주고받는 것
 */
public class ReplyController {
	
	private final ReplyService service;
	
	// 댓글 목록 조회 (비동기)
	@GetMapping("/selectReplyList")
	public List<Reply> selectReplyList(int boardNo){
		List<Reply> rList = service.selectReplyList(boardNo);
		
		return rList;
	}
	
	// 댓글 등록 (비동기)
	@PostMapping("/insertReply")
	public int insertReply(Reply r) { // 커맨드객체 방식
		return service.insertReply(r);
	}
	
	// 댓글 삭제/수정 (비동기)
	@PostMapping("/update")
	public int updateReply(Reply r) {
		return service.updateReply(r);
	}
	
	
	
	
	
	

}











