package com.kh.spring.common.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component // bean객체로 등록시키기 위한 어노테이션 (controller, service, repository, component)
@Slf4j
@Aspect // Advice + PointCut -> 실제로 실행시킬 공통코드(advice)와 적용할 위치(pointCut)가 적용된 클래스임을 명시
public class Aop {

	/* @Pointcut(advice가 끼어들어서 수행될 클래스나 메서드의 위치(정규표현식으로 작성))
	 * 
	 * - joinPoint : advice(공통코드)가 적용될 수 있는 모든 지점. 모든 비즈니스 메서드가 여기에 포함된다.
	 * 
	 * - pointCut : joinPoint들 중에서 실제로 advice가 실행될 지점. 
	 */
	
	/* 	=== PointCut 작성방법 ===
	 * @Pointcut( "execution( [접근제한자] 반환형 풀클래스명.메서드명( [매개변수] ) )" )
	 * 
	 * 	--- Pointcut 표현식 ---
	 * - * : 모든 | 아무값
	 * - .. : 하위 | 아래 | 0개 이상의 매개변수
	 */
	
	// com.kh.spring.board패키지 "아래"에서 클래스들 중 "Impl"로 끝나는 클래스 내부에 
	// 존재하는 모든 메서드가 호출되는 시점을 pointCut으로 지정
	//@Before("testPointcut()") // advice적용 위치
	// (접근제한자 생략), "모든" 반환형, board패키지 "아래", Impl로 끝나는 "모든" 클래스, "모든" 메서드, "0개 이상의 매개변수"
	public void start() {
		log.debug("\n================ service start ====================\n");
		
	}
	
	//@After("testPointcut()")
	public void end() {
		log.debug("\n================ service end ====================\n");
	}
	
	// @Pointcut : pointcut을 정의해두는 역할.
	@Pointcut("execution(* com.kh.spring.board..*Impl.*(..))")
	public void testPointcut() {
		
	}
	
	
}

