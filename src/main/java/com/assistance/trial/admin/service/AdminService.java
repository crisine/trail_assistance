package com.assistance.trial.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.admin.mapper.IAdminMapper;
import com.assistance.trial.command.AgencyVO;
import com.assistance.trial.command.AssistantRegistVO;
import com.assistance.trial.util.PageVO;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private IAdminMapper mapper;
	
	@Override
	public List<AgencyVO> getComList(PageVO vo) {
		return mapper.getComList(vo);
	}

	@Override
	public AgencyVO getComDetail(int comNo) {
		return mapper.getComDetail(comNo);
	}

	@Override
	public int getComTotal(PageVO vo) {
		return mapper.getComTotal(vo);
	}

	@Override
	public int comNameCheck(String comName) {
		return mapper.comNameCheck(comName);
	}
	
	@Override
	public void comRegist(AgencyVO vo) {
		mapper.comRegist(vo);
	}

	@Override
	public void comUpdate(AgencyVO vo) {
		mapper.comUpdate(vo);
	}

	@Override
	public void comDelete(int comNo) {
		mapper.comDelete(comNo);
	}

	@Override
	public int getAssisTotal(PageVO vo) {
		return mapper.getAssisTotal(vo);
	}

	@Override
	public List<AssistantRegistVO> getAssisList(PageVO vo) {
		return mapper.getAssisList(vo);
	}

}









