package com.kh.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@Controller // 컨트롤러 클래스 (servlet-context.xml에서 빈스캐너(context:component-scan)에 의해 빈객체로 등록됨)
@RequestMapping("/member") // 하위 메서드의 공통 주소.
@SessionAttributes({"loginUser", "ddd", "eee"}) // Model에 추가된 key값과 일치하는 값이 나오도록 설정.
										// => Model의 기본 request scope를 session scope로 변경해 줌.									
public class MemberController {

	/*	=== 기존 객체 생성 방식 ===
	 * private MemberService mService = new MemberServiceImpl();
	 * 
	 * 	=== Spring의 DI(Dependency Injection : 의존성 주입) === 
	 * : 객체를 개발자가 생성하는 게 아니라 스프링이 생성한 객체(bean객체)를 주입받아서 사용하는 방식
	 * (필드 주입 방식, 생성자 주입 방식)
	 */
	
	//@Autowired 어노테이션 사용 -> 필드 주입 방식.(권장X)
	private MemberService mService;
	private BCryptPasswordEncoder encoder; // 비밀번호 암호화용 클래스
	
	// 생성자 주입 방식.(권장O)
	public MemberController(MemberService mService, BCryptPasswordEncoder encoder) {
		this.mService = mService;
		this.encoder = encoder;
	}
	
	
// ======================== url패턴을 받아줄 수 있는 어댑터 메서드들 ==============================
	
	/*	=== @RequestMapping ===
	 * - 클라이언트 요청 url에 맞는 클래스/메서드를 연결해주는 어노테이션
	 * 	=> 해당 어노테이션이 붙은 클래스/메서드는 HandlerMapping으로 자동 등록된다.
	 * 		cf) HandlerMapping : 사용자가 지정한 url정보들을 보관하는 저장소.
	 */
	
// ===== 스프링에서 클라이언트의 요청값들을 뽑아내는 방법 =====
	
	// 1. HttpServletRequest로 뽑아내기
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpServletRequest req) {
//		System.out.println("userId : " + req.getParameter("userId"));
//		
//		return "main";
//	}
	
	// 2. @RequestParam어노테이션 사용
	//	-> 넘어온 값이 없다면 기본값 설정이 가능.
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(
//			@RequestParam(value = "userId", defaultValue = "mmm") String userId,
//			@RequestParam(value = "userPwd") String userPwd
//			) {
//		System.out.println(userId + " |||| " + userPwd);
//		return "main";
//	}
	
	// 3. @RequestParam제거 가능.( => 변수명과 동일한 key값으로 넘어온 parameter를 넣어줌)
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(String userId, String userPwd) {
//		System.out.println(userId + " |||| " + userPwd);
//		return "main";
//	}
	
	// 4. 커맨드 객체 방식
	/* 	1) 스프링컨테이너에서 매개변수로 지정한 vo클래스의 기본생성자를 호출하여 객체를 생성.
	 * 	2) request로 전달받은 파라미터의 key값과 일치하는 필드의 setter메서드를 찾아서 호출
	 */
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(Member m) { // Member m 앞에 @ModelAttribute 어노테이션 생략 가능
//		System.out.println(m.getUserId() + " |||| " + m.getUserPwd());
//		return "main";
//	}
	
//----------------------------요청값 뽑아오기 끝-----------------------------
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(
//			@ModelAttribute Member m, 
//			HttpSession session,
//			Model model, 
//			ModelAndView mv) {
//		System.out.println(m.getUserId() + " |||| " + m.getUserPwd());
//		
//		/* 로그인 요청처리 완료후(비즈니스로직 완료 후) "응답데이터"를 담아서 응답 페이지로 url 재요청을 할 때
//		 * 
//		 * 1) Model객체를 이용
//		 * : 포워딩 할 응답뷰 페이지로 전달하고자 하는 데이터를 "맵형식"으로 담아준다.
//		 * 	-> request, session 스코프 두개를 가지고 있음.(기본 scope == request 스코프)
//		 * 		=> session scope로 저장하고자 한다면 클래스 위쪽에 @SessionAttribute를 추가해야 한다.
//		 * 
//		 * 2) ModelAndView객체를 이용
//		 * : ModelAndView에서 model은 데이터를 key-value형태로 담을 수 있는 Model객체와 동일.
//		 *	-> View는 응답뷰에 대한 정보를 담을 수 있다.(단, 반환형을 ModelAndView로 변경해줘야 한다.)
//		 */
//		model.addAttribute("errorMsg", "오류 발생..."); // request.setAttribute("errorMsg", "오류 발생...");
//		
//		mv.addObject("errorMsg", "로그인 실패..."); // key-value형식으로 담기.
//		mv.setViewName("common/errorPage"); // 응답받을 뷰네임 지정.
//		
//		return mv;
//	}
	
	
// ---------------------------사용하는 메서드-----------------------------------------	
	
	@PostMapping("/login") // @RequestMapping과 method를 합쳐놓은 어노테이션
	public String login(
			Member m, // 커맨드 객체 방식으로 클라이언트가 요청한 값 뽑아오기
			Model model, // 응답데이터 담아줄 객체.(로그인한 회원 정보(session scope에 담기), 로그인 성공/실패 메세지)
			RedirectAttributes ra,
			HttpSession session
			) {
		
	// ========== 비밀번호 암호화 전 로그인 요청 처리 작업(업무 로직) ==========
//		Member loginUser = mService.login(m);
//		String viewName = "";
//		
//		if(loginUser == null) {
//			model.addAttribute("errorMsg", "로그인 실패..."); 
//			// SessionAttributes와 일치하는 값이 없으므로 기본값인 request scope에 담김
//			
//			viewName = "common/errorPage";
//		}else {
//			ra.addFlashAttribute("alertMsg", "로그인 성공!!!");
//			model.addAttribute("loginUser", loginUser); // session scope로 이관
//			viewName = "redirect:/";
//		}
//		
//		return viewName;
		
	// ========== 비밀번호 암호화 후 로그인 업무 로직 ==========
		Member loginUser = mService.login(m); // 아이디 기준으로 사용자 정보 조회.
		// loginUser의 비밀번호에는 암호화된 비밀번호가 담겨있음.
		// m(클라이언트가 요청시 전달한 값)에는 암호화 되지 않은 평문 형태의 비밀번호가 담겨있음.
		
		String viewName = "";
		
		// matches(평뮨형태의 비밀번호, 암호화된 비밀번호) : boolean
		//	=> 내부적으로 두 값이 일치하는 지를 검사한 후 true/false 반환
		if(loginUser != null && encoder.matches(m.getUserPwd(), loginUser.getUserPwd())) {
			ra.addFlashAttribute("alertMsg", "로그인 성공!!!");
			model.addAttribute("loginUser", loginUser); // session scope로 이관
			
			String nextUrl = (String) session.getAttribute("nextUrl");
			
			viewName = "redirect:" + (nextUrl != null ? nextUrl : "/");
			session.removeAttribute("nextUrl");
		}else {
			model.addAttribute("errorMsg", "로그인 실패..."); 
			// SessionAttributes와 일치하는 값이 없으므로 기본값인 request scope에 담김
			
			viewName = "common/errorPage";
		}
		
		return viewName;
	}
	
	
	
	@GetMapping("/insert") // => /member/insert(GET) : 회원가입 페이지로 이동
	public String enrollForm() {
		return "member/memberEnrollForm"; // => /WEB-INF/views/member/memberEnrollForm.jsp
	}
	
	@PostMapping("/insert") // => /member/insert(POST) : 회원가입 요청
	public String insertMember(
			Member m, // 사용자가 입력한 값들이 담겨있는 Member객체 (커맨드 객체 방식)
			RedirectAttributes ra, // sessionScope에 담아놨다가 redirect가 완료된 후 requestScope로 이관
			Model model // request scope가 기본
			) {
		// 회원가입 요청 업무 로직
		/*	===== 암호화 작업 =====
		 * 1) spring-security관련 의존성 추가(web, core, config)
		 * 2) 인코딩 클래스 bean객체로 등록
		 * 3) web.xml에 생성한 xml파일을 로딩할 수 있도록 추가.
		 * 	=> *-context.xml을 web.xml에 등록해서 ContextLoaderListener에 의해 읽히도록 자동화 시켜놓음
		 */
		String encPwd = encoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd); // 암호화된 pwd로 변경
		
		int result = mService.insertMember(m);
		
		// 응답메세지 반환
		String url = "";
		if(result>0) {
			/*	 === RedirectAttributes === 
			 * : 처음 데이터를 담을 때는 sessionScope에 데이터를 저장
			 * 	-> redirect가 완료된 후 sessionScope에 저장된 데이터를 requestScope로 이관
			 * 	=> 다른 페이지로 이동(다른 요청)할 때 requestScope에 클라이언트의 새로운 요청이 담기기 때문에 기존 데이터는 사라짐.
			 * 
			 * redirect시 1회성 메세지를 보관하는 용도로 사용
			 */
			ra.addFlashAttribute("alertMsg", "회원가입 성공!!!");
			url = "redirect:/";
		}else {
			model.addAttribute("errorMsg", "회원가입 실패...");
			url = "common/errorPage";
		}
		
		return url;
	}
	
	// 마이페이지로 이동
	@GetMapping("/myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	// 내정보 수정
	@PostMapping("/update")
	public String updateMember(
			Member m, // 사용자 입력값(업데이트 시킬 내용) 뽑아오기용
			Model model, // 에러페이지용
			RedirectAttributes ra // 성공후 리다이렉트시 이용
			) {
		// 업무로직
		int result = mService.updateMember(m);
		String url = "";
		
		if(result>0) { // 업데이트 성공시
			// DB에 저장된 수정된 회원정보를 다시 불러와서 저장. -> 로그인 메서드 재호출
			Member loginUser = mService.login(m);
			model.addAttribute("loginUser", loginUser);
			ra.addFlashAttribute("alertMsg", "내정보 수정 성공!");
			
			url = "redirect:/member/myPage";
		}else { // 실패시 에러페이지로 이동
			model.addAttribute("erorMsg", "내정보 수정 실패...");
			url = "common/errorPage";
		}
		
		return url;
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(
			//HttpSession session,
			SessionStatus status,
			RedirectAttributes ra
			) {
		// 기존 방식 (세션에 담긴 데이터를 지워버림)
		// 현재는 로그인한 정보를 Model안에 넣어놨기 때문에 작동 안함
//		session.removeAttribute("loginUser");
//		session.invalidate();
//		return "redirect:/";
		
	// @SessionAttributes어노테이션을 통해 model에서 session으로 이관된 데이터는 
	// 스프링 프레임워크가 관리하는 SessionStatus객체를 통해 비워줘야 한다.
		status.setComplete(); 
		
		ra.addFlashAttribute("alertMsg", "로그아웃합니다.");
		
		return "redirect:/";
	}
	
	// 아이디 중복 체크
	@GetMapping("/idCheck")
	@ResponseBody // 비동기 요청시 필요한 어노테이션 ( => 응답데이터의 바디에 담을 데이터라는 것을 알려줌)
	public String idCheck(String userId) {
		
		int result = mService.idCheck(userId); // 아이디가 존재한다면 1, 없다면 0
		
		/* 컨트롤러에서 반환되는 값은 항상 forward하고자 하는 응답페이지 혹은 redirect를 위한 경로로 해석한다.
		 * 	=> /WEB-INF/view/1.jsp
		 * 
		 * 따라서 "값 자체"를 반환시키기 위해서는 @ResponseBody어노테이션이 필요함.
		 * 	=> result
		 */
		return result+"";
	}
	
	// ===== @ResponseBody 어노테이션 사용 =====
	// 순수 문자열로 json형태 만들어 반환
//	@PostMapping("/selectOne")
//	@ResponseBody
//	public String selectOne(Member m) {
//		
//		Member selectedUser = mService.login(m);
//		
//		if(selectedUser != null) {
//			return "{\"userId\":\""+selectedUser.getUserId()+"\", \"userName\":\""+selectedUser.getUserName()+"\"}";
//		}else {
//			return "{}";
//		}
//		
//	}
	
	// jackson-databind 의존성 사용
//	@PostMapping("/selectOne")
//	@ResponseBody
//	public HashMap<String, Object> selectOne(Member m) {
//		
//		Member selectedUser = mService.login(m);
//		
//		HashMap<String, Object> map = new HashMap<>();
//		if(selectedUser != null) {
//			map.put("userId", selectedUser.getUserId());
//			map.put("userName", selectedUser.getUserName());
//		}else {
//			
//		}
//		
//		// HashMap -> JSON 자동 형변환 (jackson-databind라는 의존성이 해줌)
//		return map;
//	}
	
	
	// jsonView 빈을 통한 데이터 처리
//	@PostMapping("/selectOne")
//	public String selectOne(Member m, Model model) {
//		
//		Member selectedUser = mService.login(m);
//		
//		HashMap<String, Object> map = new HashMap<>();
//		if(selectedUser != null) {
//			map.put("userId", selectedUser.getUserId());
//			map.put("userName", selectedUser.getUserName());
//		}
//		model.addAttribute("userInfo", map);
//		
//		return "jsonView";
//	}
	
	// jackson-databind 의존성 사용
	@PostMapping("/selectOne")
	public ResponseEntity<Map<String, Object>> selectOne(Member m) {
//		try {
//			throw new RuntimeException();
//		}catch(Exception e) {
//			System.out.println("1. try-catch블럭에서 예외처리");
//			e.printStackTrace();
//			if(true) throw new RuntimeException();
//		}
		
		
		Member selectedUser = mService.login(m);
		
		HashMap<String, Object> userInfo = new HashMap<>();
		
		ResponseEntity<Map<String, Object>> res = null;
		
		if(selectedUser == null) {
			res = ResponseEntity.notFound().build(); // 에러발생
		}else {
			userInfo.put("userId", selectedUser.getUserId());
			userInfo.put("userName", selectedUser.getUserName());
			
			res = ResponseEntity
					.ok() // 응답상태 200 (정상)
					// response.setContentType("application/json; charset=utf-8")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(userInfo);
		}
		
		return res;
	}
	
	
	
	/*	===== 스프링의 예외처리 방법 =====
	 * 1. try~catch / throws : 메서드별로 예외처리가 가능하며 항상 1순위로 예외처리를 함.
	 * 
	 * 2. 하나의 컨트롤러에서 발생하는 예외를 모아서 처리하는 방법 
	 * 	-> @ExceptionHandler어노테이션 사용.(2순위로 작동)
	 * 3. 어플리케이션 전역에서 발생하는 예외를 모아서 처리하는 방법 
	 * 
	 * 	-> @ControllerAdvice어노테이션 사용.(3순위로 작동)
	 */
	@ExceptionHandler
	public String exceptionHandler(Exception e, Model model) {
		System.out.println("2. ExceptionHandler에서 예외처리");
		e.printStackTrace();
		
		model.addAttribute("errorMsg", "서비스 이용중 문제가 발생했습니다.");
		
		return "common/errorPage";
	}
	
}
