package com.assistance.trial.admin.mapper;

import java.util.List;

import com.assistance.trial.command.AgencyVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.util.PageVO;

public interface IAdminMapper {

	//기관 내역 조회
	List<AgencyVO> getComList(PageVO vo);

	//기관 내역 상세 조회
	AgencyVO getComDetail(int comNo);

	//총 기관 수
	int getComTotal(PageVO vo);
	
	//기관 이름 중복확인
	int comNameCheck(String comName);

	//기관 등록
	void comRegist(AgencyVO vo);

	//기관 내역 수정
	void comUpdate(AgencyVO vo);

	//기관 내역 삭제
	void comDelete(int comNo);
	
	//조력자 신청자 총 수
	int getAssisTotal(PageVO vo);

		//조력자 신청자 내역 조회
	List<AssistantRegistVO> getAssisList(PageVO vo);

}
