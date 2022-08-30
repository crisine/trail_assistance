package com.assistance.trial.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.FormVO;
import com.assistance.trial.form.mapper.IFormMapper;

@Service
public class FormService implements IFormService {
	
	@Autowired
	private IFormMapper mapper;

	@Override
	public int checkId(String accId) {
		return mapper.checkId(accId);
	}

	@Override
	public void register(FormVO vo) {
		mapper.register(vo);
	}

	@Override
	public void update(FormVO vo) {
		mapper.update(vo);
	}

	@Override
	public FormVO selectOne(int accId) {
		return mapper.selectOne(accId);
	}

}
