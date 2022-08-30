package com.assistance.trial.faqboard.service;

import java.util.List;

import com.assistance.trial.command.FaqBoardVO;
import com.assistance.trial.util.PageVO;

public interface IFaqBoardService {

		//공고글 등록
		void regist(FaqBoardVO vo);
		
		//공고글 목록
		List<FaqBoardVO> getList(PageVO vo);
		
		//공고글 총 게시물 수
		int getTotal(PageVO vo);
		
		//공고글 상세보기
		FaqBoardVO getContent(int faq_id);
		
		//수정
		void update(FaqBoardVO vo);
		
		//삭제
		void delete(int faq_id);
}
