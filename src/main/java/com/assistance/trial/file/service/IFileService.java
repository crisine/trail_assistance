package com.assistance.trial.file.service;

import com.assistance.trial.command.FileVO;

public interface IFileService {

	// 파일 업로드
	void insertFile(FileVO vo);
		
	// 파일 id를 기반으로 파일 찾아오기
	FileVO selectOne(int fileId);
	
	// 파일 저장이름(uuid) 기반으로 파일 찾아오기
	FileVO selectOneBySaveName(String saveName);
}
