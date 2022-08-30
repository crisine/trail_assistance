package com.assistance.trial.articleboard.service;

import java.util.List;

import com.assistance.trial.command.ArticleBoardVO;
import com.assistance.trial.util.PageVO;

public interface IArticleBoardService {

	//공고글 등록
	void regist(ArticleBoardVO vo);

	//공고글 목록
	List<ArticleBoardVO> getList(PageVO vo);

	//공고글 총 게시물 수
	int getTotal(PageVO vo);

	//공고글 상세보기
	ArticleBoardVO getContent(int article_id);

	//수정
	void update(ArticleBoardVO vo);

	//삭제
	void delete(int article_id);

	//0825 나경민 코드 수정
	List<ArticleBoardVO> AllList();
	//0828 최필규 추가
	//메인 리스트
	List<ArticleBoardVO> articleMainList();
}
