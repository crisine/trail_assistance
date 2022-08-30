package com.assistance.trial.mypage.mapper;

import java.util.List;

import com.assistance.trial.command.AccountVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.command.MyPageVO;
import com.assistance.trial.util.PageVO;

public interface IMyPageMapper {
	
	/*-------------최필규 작성 시작---------------*/
	//접수내역 조회
//	public List<AccountVO> getList(PageVO vo);
	
	//접수내역 조회
	public AccountVO getList(int loginAcc);

	//접수내역 상세 조회
	public AssistantRegistVO getApplyDetail(int assistant_id);

	//총 게시물 수
//	public int getTotal(PageVO vo);
	

	
	
	//모달 상세
	
	/*-------------최필규 작성 끝---------------*/

	/*-------------천용혁 작성 시작---------------*/

	// 회원 정보 얻어오기
	AccountVO getHelperInfo(int loginAcc);
	
	//0825 최필규 추가
	AssistantRegistVO getAstInfo(int assistant_id);

	// 회원 정보 수정
	void updateInfo(AssistantRegistVO vo);

	/*-------------천용혁 작성 끝---------------*/

}
