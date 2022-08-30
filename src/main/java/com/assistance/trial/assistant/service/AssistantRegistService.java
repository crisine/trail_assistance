package com.assistance.trial.assistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.assistant.mapper.IAssistantRegistMapper;
import com.assistance.trial.command.AssistantRegistVO;

@Service
public class AssistantRegistService implements IAssistantRegistService{

	@Autowired
	private IAssistantRegistMapper mapper;

	@Override
	public void insert(AssistantRegistVO vo) {
		System.out.println("서비스 호출");
		mapper.insert(vo);
		System.out.println("서비스 호출완료");
	}

	@Override
	public void update(AssistantRegistVO vo) {
		mapper.update(vo);
		//System.out.println(vo.getMid());
	}

	@Override
	public AssistantRegistVO getAll() {
		return mapper.getAll();
	}
	
	@Override
	public AssistantRegistVO selectOne(int assistantId) {
		return mapper.selectOne(assistantId);
	}
	
	@Override
	public AssistantRegistVO selectOneByAccId(int accId) {
		return mapper.selectOneByAccId(accId);
	}
}
