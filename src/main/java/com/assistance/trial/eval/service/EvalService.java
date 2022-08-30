package com.assistance.trial.eval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.EvalVO;
import com.assistance.trial.eval.mapper.IEvalMapper;

@Service
public class EvalService implements IEvalService {

	@Autowired
	private IEvalMapper mapper;
	
	@Override
	public EvalVO selectOne(int assistantId) {
		return mapper.selectOne(assistantId);
	}
	
	@Override
	public int checkEvalId(int assistantId) {
		return mapper.checkEvalId(assistantId);
	}

	@Override
	public void insertScore(EvalVO vo) {
		mapper.insertScore(vo);
	}

	@Override
	public void updateScore(EvalVO vo) {
		mapper.updateScore(vo);
	}
}
