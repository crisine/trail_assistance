package com.assistance.trial.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.command.MyPageVO;
import com.assistance.trial.mypage.mapper.IMyPageMapper;
import com.assistance.trial.util.PageVO;

@Service
public class MyPageService implements IMyPageService {

	/*-------------최필규 작성 시작------------------*/
	@Autowired
	private IMyPageMapper mapper;

	//	@Override
	//	public List<AccountVO> getList(PageVO vo) {
	//		return mapper.getList(vo);
	//	}

	//접수 내역 조회
	@Override
	public AccountVO getList(int loginAcc) {
		return mapper.getList(loginAcc);
	}

	@Override
	public AssistantRegistVO getApplyDetail(int assistant_id) {
		return mapper.getApplyDetail(assistant_id);
	}

	//	@Override
	//	public int getTotal(PageVO vo) {
	//
	//		System.out.println("서비스 gettotal호출");
	//
	//		return mapper.getTotal(vo);
	//	}


	/*-------------최필규 작성 끝------------------*/

	/*-------------천용혁 작성 시작------------------*/

	@Override
	public AccountVO getHelperInfo(int loginAcc) {
		return mapper.getHelperInfo(loginAcc);
	}
	
	@Override
	public AssistantRegistVO getAstInfo(int assistant_id) {
		return mapper.getAstInfo(assistant_id);
	}
	
	// 회원 정보 수정하기
	public void updateInfo(AssistantRegistVO vo) {
		mapper.updateInfo(vo);
	}

	/*-------------천용혁 작성 끝------------------*/

}
























