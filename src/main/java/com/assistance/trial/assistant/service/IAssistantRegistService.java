package com.assistance.trial.assistant.service;

import com.assistance.trial.command.AssistantRegistVO;

public interface IAssistantRegistService {
	
	void insert(AssistantRegistVO vo);

	void update(AssistantRegistVO vo);
	
	AssistantRegistVO getAll();
	
	AssistantRegistVO selectOne(int assistantId);
	
	AssistantRegistVO selectOneByAccId(int accId);
	

	//0830 최필규 추가
	void upload1(String saveFileName);

	//0830 최필규 추가
	void upload2(String saveFileName);

	//0830 최필규 추가
	void upload3(String saveFileName);
}
