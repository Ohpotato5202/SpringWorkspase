package com.kh.spring.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		System.out.println("3. ControllerAdvice에서 예외처리");
		e.printStackTrace();
		
		model.addAttribute("errorMsg", "서비스 이용중 문제가 발생했습니다. 관리자에게 문의해주세요.");
		
		return "common/errorPage";
	}

}
