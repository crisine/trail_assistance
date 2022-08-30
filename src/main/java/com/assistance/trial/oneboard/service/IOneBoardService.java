package com.assistance.trial.oneboard.service;

import java.util.List;


import com.assistance.trial.command.OneBoardVO;
import com.assistance.trial.util.PageVO;

public interface IOneBoardService {

		//공고글 등록
		void regist(OneBoardVO vo);
		
		//공고글 목록
		List<OneBoardVO> getList(PageVO vo);
		
		//공고글 총 게시물 수
		int getTotal(PageVO vo);
		
		//공고글 상세보기
		OneBoardVO getContent(int one_id);
		
		//수정
		void update(OneBoardVO vo);
		
		//삭제
		void delete(int one_id);
}
