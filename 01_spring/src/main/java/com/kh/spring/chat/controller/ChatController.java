package com.kh.spring.chat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.chat.model.service.ChatService;
import com.kh.spring.chat.model.vo.ChatMessage;
import com.kh.spring.chat.model.vo.ChatRoom;
import com.kh.spring.chat.model.vo.ChatRoomJoin;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/chat")
@SessionAttributes({"loginUser", "chatRoomNo"})
@RequiredArgsConstructor
public class ChatController {

	private final ChatService chatService;
	
	// 채팅방 목록 페이지 이동
	@GetMapping("/chatRoomList")
	public String selectChatRoomList(Model model) {
		
		// 업무 로직
		List<ChatRoom> list = chatService.selectChatRoomList();
		
		model.addAttribute("list", list);
		
		return "chat/chatRoomList";
	}
	
	// 채팅방 만들기
	@PostMapping("/openChatRoom")
	public String openChatRoom(
			ChatRoom room, // 커맨드객체 형태
			RedirectAttributes ra, // 채팅방 개설 성공 (1회성 메세지)
			@ModelAttribute("loginUser") Member loginUser
			) {
		log.debug("Chat Room : {}", room);
		log.debug("loginUser : {}", loginUser);
		
		room.setUserNo(loginUser.getUserNo()); // userNo 넣어주기
		
		int result = chatService.openChatRoom(room);
		
		String url = "redirect:/chat/";
		
		if(result > 0) {
			ra.addFlashAttribute("alertMsg", "채팅방 생성 성공! 채팅방으로 입장합니다.");
			url += "room/"+room.getChatRoomNo(); // chat/room/3
		}else {
			ra.addFlashAttribute("alertMsg", "채팅방 생성 실패...");
			url += "chatRoomList";
		}
		
		return url;
	}
	
	
	// 채티방 참여 기능
	@GetMapping("/room/{chatRoomNo}")
	public String joinChatRoom(
			@PathVariable("chatRoomNo") int chatRoomNo,
			Model model,
			RedirectAttributes ra,
			@ModelAttribute("loginUser") Member loginUser,
			ChatRoomJoin chatRoomJoin
			) {
		log.debug("chatRoomJoin : {}", chatRoomJoin); // chatRoomJoin : ChatRoomJoin(chatRoomNo=2, userNo=0)
		chatRoomJoin.setUserNo(loginUser.getUserNo()); // 초기화 완료
		
		List<ChatMessage> list = chatService.joinChatRoom(chatRoomJoin);
		
		if(list != null) {
			model.addAttribute("list", list);
			model.addAttribute("chatRoomNo", chatRoomNo); // 세션으로 이관하기 위해 SessionAttributes에 추가
			
			return "chat/chatRoom";
		}else {
			ra.addFlashAttribute("alertMsg", "채팅방에 입장할 수 없습니다.");
			return "redirect:/chat/chatRoomList";
		}
	}

	
	// 채팅방 나가기 기능
	@GetMapping("/chatRoom/{chatRoomNo}/exit")
	public String exitChatRoom(
			@PathVariable("chatRoomNo") int chatRoomNo,
			@ModelAttribute("loginUser") Member loginUser,
			ChatRoomJoin join,
			RedirectAttributes ra
			) {
		join.setUserNo(loginUser.getUserNo());
		// 업무로직
		// 1) chatRoomNo로 DELETE실행 (ChatRoomJoin)
		// 2) 현재 채팅방에 참여하고 있는 인원정보 확인 (SELECT)
		// 3) 내가 마지막 인원이라면 채팅방 정보를 DELETE (ChatRoom)
		int result = chatService.exitChatRoom(join);
		
		
		// 응답화면
		// chatRoomList로 redirect
		ra.addFlashAttribute("alertMsg", "채팅방을 나갔습니다.");
		return "redirect:/chat/chatRoomList";
	}
	


}





