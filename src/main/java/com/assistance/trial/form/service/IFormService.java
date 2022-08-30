package com.assistance.trial.form.service;

import com.assistance.trial.command.FormVO;

public interface IFormService {
		
		// 중복 신청서 체크 기능
		int checkId(String accId);
		
		// 신청서 등록
		void register(FormVO vo);
		
		// 신청서 정보 갱신 (접수상태, 신청자 상태, 보완 요구사항 3가지만)
		void update(FormVO vo);
		
		// 사용자 accId 기반으로 신청서 찾아오는 기능
		FormVO selectOne(int accId);
}
