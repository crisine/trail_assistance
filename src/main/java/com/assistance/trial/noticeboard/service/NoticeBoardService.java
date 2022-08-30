package com.assistance.trial.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.NoticeBoardVO;
import com.assistance.trial.noticeboard.mapper.INoticeBoardMapper;
import com.assistance.trial.util.PageVO;

@Service
public class NoticeBoardService implements INoticeBoardService {

	@Autowired
	private INoticeBoardMapper mapper;

	@Override
	public void regist(NoticeBoardVO vo) {
		mapper.regist(vo);

	}

	@Override
	public List<NoticeBoardVO> getList(PageVO vo) {
		List<NoticeBoardVO> list = mapper.getList(vo);

		for(NoticeBoardVO notice : list) {
			long now = System.currentTimeMillis();
			long regTime = notice.getNotice_regdate().getTime();


			

		}

		return list;
	}

	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);

	}

	@Override
	public NoticeBoardVO getContent(int notice_id) {
		return mapper.getContent(notice_id);

	}

	@Override
	public void update(NoticeBoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int notice_id) {
		mapper.delete(notice_id);
	}
	//0828 최필규 추가
	//메인화면용 리스트
	@Override
	public List<NoticeBoardVO> getMainList() {
		return mapper.getMainList();
	}

}
