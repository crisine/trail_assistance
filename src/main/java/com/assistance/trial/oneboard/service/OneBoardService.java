package com.assistance.trial.oneboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.oneboard.mapper.IOneBoardMapper;

import com.assistance.trial.command.OneBoardVO;
import com.assistance.trial.util.PageVO;

@Service
public class OneBoardService implements IOneBoardService {

	@Autowired
	private IOneBoardMapper mapper;
	
	@Override
	public void regist(OneBoardVO vo) {
		mapper.regist(vo);
		
	}

	@Override
	public List<OneBoardVO> getList(PageVO vo) {
		List<OneBoardVO> list = mapper.getList(vo);
		
		for(OneBoardVO one : list) {
			long now = System.currentTimeMillis();
			long regTime = one.getOne_regdate().getTime();
			
			
			if(now - regTime < 60 * 60 * 24 * 2 * 1000) {
				one.setNewMark(true);
			}
			
		}
		
		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);
	
	}

	@Override
	public OneBoardVO getContent(int one_id) {
		return mapper.getContent(one_id);
		
	}

	@Override
	public void update(OneBoardVO vo) {
		mapper.update(vo);

	}

	@Override
	public void delete(int one_id) {
		mapper.delete(one_id);
	}

}
