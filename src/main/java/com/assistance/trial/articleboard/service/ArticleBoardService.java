package com.assistance.trial.articleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.ArticleBoardVO;
import com.assistance.trial.articleboard.mapper.IArticleBoardMapper;
import com.assistance.trial.util.PageVO;

@Service
public class ArticleBoardService implements IArticleBoardService {

	@Autowired
	private IArticleBoardMapper mapper;

	@Override
	public void regist(ArticleBoardVO vo) {
		mapper.regist(vo);

	}

	@Override
	public List<ArticleBoardVO> getList(PageVO vo) {
		List<ArticleBoardVO> list = mapper.getList(vo);

		for(ArticleBoardVO article : list) {
			long now = System.currentTimeMillis();
			long regTime = article.getArticle_regdate().getTime();


		}

		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);

	}

	@Override
	public ArticleBoardVO getContent(int article_id) {
		return mapper.getContent(article_id);

	}

	@Override
	public void update(ArticleBoardVO vo) {
		mapper.update(vo);

	}

	@Override
	public void delete(int article_id) {
		mapper.delete(article_id);
	}


	//0825 나경민 코드 수정
	@Override
	public List<ArticleBoardVO> AllList() {

		return mapper.AllList();
	}

	//0828 최필규 작성
	//메인 리스트
	@Override
	public List<ArticleBoardVO> articleMainList() {
		return mapper.articleMainList();
	}
}
