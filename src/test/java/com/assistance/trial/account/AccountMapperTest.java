package com.assistance.trial.account;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assistance.trial.account.mapper.IAccountMapper;
import com.assistance.trial.command.AccountVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AccountMapperTest {

	// IMemberMapper 자동 주입
	@Autowired
	private IAccountMapper mapper;
	
	// 회원 가입 테스트 진행
	@Test
	public void registerTest() {
		AccountVO vo = new AccountVO();
		vo.setAccId(1);
		vo.setAccount("aaa1234");
		vo.setPassword("12341234");
		vo.setEmail("aaa1234@abc.com");
		mapper.register(vo);
	}
	
	 
	
	// 아이디 중복 생성방지 체크
	@Test
	public void checkIdTest() {
		int result = mapper.checkId("aaa1234");
		System.out.println("계정 개수 : " + result);
		if (result == 1)
			System.out.println("기존 아이디가 존재합니다.");
		else
			System.out.println("아이디를 생성할 수 있습니다.");
	}
	
	// 계정 탈퇴 테스트
	@Test
	public void deleteTest() {
		mapper.delete("aaa1234");
		if(mapper.selectOne("aaa1234") == null) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패!");
		}
	}
}
