package com.kh.spring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

@Service // 서비스 클래스
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	
	@Override
	public Member login(Member m) {
		// ===== 기존 방식 =====
		// SqlSession 생성
		// 결과값을 반환받은 후 close, commit/rollback
		// 컨트롤러에게 반환
	
		// SqlSession에 대한 관리를 스프링 컨테이너가 주관하므로 직접 생성하지 않아도 된다.
		return dao.login(m);
	}

	@Override
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	@Override
	public int updateMember(Member m) {
		return dao.updateMember(m);
	}

	@Override
	public int idCheck(String userId) {
		return dao.idCheck(userId);
	}

}
