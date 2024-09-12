package com.kh.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {
	/*	===== Logging Level =====
	 * - fatal : 아주 심각한 에러.(지금은 존재하지 않음)
	 * - error : 요청 처리중 발생하는 오류에 사용.(Exception클래스에서 사용)
	 * - warn : 경고성 메세지.(실행에는 문제없지만 향후 오류가 발생할 경우가 있을 때 사용) 
	 * - info : 요청 처리중 발생하는 정보성 메세지 출력시 사용.
	 * - debug : 개발중 필요한 로그가 있을 경우 사용.
	 * - trace : 개발용 debug범위를 한정해서 출력시 사용.
	 */
	
	// === Logger객체 생성 방법 === 
	// 1) LoggerFactory로 Logger객체 생성1
//	Logger log = LoggerFactory.getLogger(LogTest.class);
	
	// 2) LoggerFactory로 Logger객체 생성2
//	Logger log = LoggerFactory.getLogger(this.getClass());

	// 3) lombok으로 로거객체 얻어오기.( @Slf4j어노테이션 사용 )
	public static void main(String[] args) {
		// log4j.xml에서 Application Loggers의 레벨을 낮춰줘야 그 이상 레벨의 로그도 출력됨
		log.error("error - {}", "에러메세지");
		log.warn("warn - {}", "경고메세지");
		log.info("info - {}", "이포메세지");
		log.debug("debug - {}", "디버그");
		log.trace("trace - {}", "트레이스");
	}
	
	

}




