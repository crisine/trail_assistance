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
		mapper.insert(vo);
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


	//0830 최필규 추가
	@Override
	public void upload1(String saveFileName) {
		mapper.upload1(saveFileName);
	}

	//0830 최필규 추가
	@Override
	public void upload2(String saveFileName) {
		mapper.upload2(saveFileName);
	}

	//0830 최필규 추가
	@Override
	public void upload3(String saveFileName) {
		mapper.upload3(saveFileName);
	}

	// 0831 성민호 추가
	@Override
	public void updateEduFileId(AssistantRegistVO vo) {
		mapper.updateEduFileId(vo);
	}

	@Override
	public void updateCareerFileId(AssistantRegistVO vo) {
		mapper.updateCareerFileId(vo);
	}

	@Override
	public void updateLicenseFileId(AssistantRegistVO vo) {
		mapper.updateLicenseFileId(vo);
	}
}
