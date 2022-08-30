package com.assistance.trial.noticeboard.mapper;

import java.util.List;

import com.assistance.trial.command.NoticeBoardVO;
import com.assistance.trial.util.PageVO;

public interface INoticeBoardMapper {

	//공지사항 글 등록
	void regist(NoticeBoardVO vo);

	//공지사항 글 목록
	List<NoticeBoardVO> getList(PageVO vo);

	//공지사항 글 총 게시물 수
	int getTotal(PageVO vo);

	//공지사항 글 상세보기
	NoticeBoardVO getContent(int notice_id);

	//수정
	void update(NoticeBoardVO vo);

	//삭제
	void delete(int notice_id);
	//0828 최필규 추가
	//메인화면 용 리스트
	List<NoticeBoardVO> getMainList();
}	
