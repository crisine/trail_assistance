package com.assistance.trial.eval.service;

import com.assistance.trial.command.EvalVO;

public interface IEvalService {

	// assistantId(조력자 ID) 기준으로 평정표를 찾음
	// 예상되는 문제 : 여러 평정표를 갖는 경우 이렇게 전달받을 수는 없음.
	// 			     나중에 여러개를 받아야하면 List<EvalVO>로 받아야 함
	EvalVO selectOne(int assistantId);
	
	// assistantId 기준으로 몇 개의 평정표가 존재하나 검사
	int checkEvalId(int assistantId);
	
	// 평정표 VO 넘겨받아 평정표 점수 입력
	void insertScore(EvalVO vo);
	
	// 만약 checkEvalId 해서 이미 평정표가 존재하면 이쪽으로 선회시켜야 함
	void updateScore(EvalVO vo);
	
	
}
