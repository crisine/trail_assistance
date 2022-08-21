package com.assistance.trial.assistant.service;

import com.assistance.trial.command.AssistantRegistVO;

public interface IAssistantRegistService {
	
	void insert(AssistantRegistVO vo);

	void update(AssistantRegistVO vo);
}
