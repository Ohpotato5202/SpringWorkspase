package com.kh.spring.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class BeforeTest {

	@Before("CommonPointcut.implPointcut()")
	public void beforeService(JoinPoint jp) {
		// joinpoint -> pointcut이 들어갈 수 있는 메서드
		
		// JoinPoint : advice가 실제로 적용되는 TargetObject에 접근할 수 있는 메서드를 제공하는 인터페이스
		// TargetObject의 클래스 정보, 전달되는 매개변수, 메서드명, 반환값, 예외처리 등을 얻어올 수 있다.
		
		// 모든 advice메서드의 첫번째 매개변수는 JoinPoint로 고정
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n============================ service start ===============================\n");
		sb.append("start : " + jp.getTarget().getClass().getSimpleName()+" - "); // 기본클래스명 (타겟 == 클래스(객체))
		sb.append(jp.getSignature().getName()); // 메서드의 이름 (시그니처 == 메서드)
		sb.append("("+Arrays.toString(jp.getArgs())+")\n"); // 전달된 매개변수
		
		log.debug(sb.toString());
	}
	
	
	
	
}






