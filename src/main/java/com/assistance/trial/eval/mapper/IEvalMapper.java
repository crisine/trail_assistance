package com.assistance.trial.eval.mapper;

import com.assistance.trial.command.EvalVO;

public interface IEvalMapper {
	
	// 이미 할당된 평정표가 있나 체크
	// int helperId 의 경우 helper service 측에서 id를 넘겨주는 메서드 필요
	EvalVO selectOne(int assistantId);
	
	int checkEvalId(int assistantId);
	
	// 평정표 VO 넘겨받아 평정표 점수 입력
	void insertScore(EvalVO vo);
	
	// 만약 checkEvalId 해서 이미 평정표가 존재하면 이쪽으로 선회시켜야 함
	void updateScore(EvalVO vo);
}
