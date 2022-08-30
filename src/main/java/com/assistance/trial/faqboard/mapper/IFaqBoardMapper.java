package com.assistance.trial.faqboard.mapper;

import java.util.List;

import com.assistance.trial.command.FaqBoardVO;
import com.assistance.trial.util.PageVO;

public interface IFaqBoardMapper {
	
	//공지사항 글 등록
	void regist(FaqBoardVO vo);
	
	//공지사항 글 목록
	List<FaqBoardVO> getList(PageVO vo);
	
	//공지사항 글 총 게시물 수
	int getTotal(PageVO vo);
	
	//공지사항 글 상세보기
	FaqBoardVO getContent(int notice_id);
	
	//수정
	void update(FaqBoardVO vo);
	
	//삭제
	void delete(int faq_id);
}	
