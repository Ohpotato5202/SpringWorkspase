package com.kh.spring.common.aop;

import org.aspectj.lang.annotation.Pointcut;

// pointcut모아둔 클래스
public class CommonPointcut {

	// 게시판 서비스용 포인트컷
	@Pointcut("execution(* com.kh.spring.board..*Impl.*(..))")
	public void boardPointcut() {}
	
	// 모든 서비스용 포인트컷
	@Pointcut("execution(* com.kh.spring..*Impl.*(..))")
	public void implPointcut() {}
	
}
