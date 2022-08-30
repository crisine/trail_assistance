package com.assistance.trial.faqboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.FaqBoardVO;
import com.assistance.trial.faqboard.mapper.IFaqBoardMapper;
import com.assistance.trial.util.PageVO;

@Service
public class FaqBoardService implements IFaqBoardService {

	@Autowired
	private IFaqBoardMapper mapper;
	
	@Override
	public void regist(FaqBoardVO vo) {
		mapper.regist(vo);
		
	}

	@Override
	public List<FaqBoardVO> getList(PageVO vo) {
		List<FaqBoardVO> list = mapper.getList(vo);
		
		for(FaqBoardVO faq : list) {
			long now = System.currentTimeMillis();
			long regTime = faq.getFaq_regdate().getTime();
			
			
			if(now - regTime < 60 * 60 * 24 * 2 * 1000) {
				faq.setNewMark(true);
			}
			
		}
		
		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);
	
	}

	@Override
	public FaqBoardVO getContent(int faq_id) {
		return mapper.getContent(faq_id);
		
	}

	@Override
	public void update(FaqBoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int faq_id) {
		mapper.delete(faq_id);
	}

}
