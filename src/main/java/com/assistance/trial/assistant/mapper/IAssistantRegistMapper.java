package com.assistance.trial.assistant.mapper;

import com.assistance.trial.command.AssistantRegistVO;

public interface IAssistantRegistMapper {

	void insert(AssistantRegistVO vo);
	
	void update(AssistantRegistVO vo);
	
	AssistantRegistVO getAll();
	
	AssistantRegistVO selectOne(int assistantId);
	
	AssistantRegistVO selectOneByAccId(int accId);
}
