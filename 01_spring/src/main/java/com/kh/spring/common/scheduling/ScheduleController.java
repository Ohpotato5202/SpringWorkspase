package com.kh.spring.common.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduleController {

	//@Scheduled(fixedDelay = 1000)
	public void test() {
		log.debug("1초마다 출력");
	}
	
	//@Scheduled(cron = "0/1 * * * * * ") // 0/1 * * * * * : 1초마다 실행 (초 분 시 일 월 요일)
	public void testCron() {
		log.debug("크론탭 방식 스케쥴링");
	}
	
	
	
	
}


