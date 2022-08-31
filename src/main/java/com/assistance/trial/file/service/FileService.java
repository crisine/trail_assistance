package com.assistance.trial.file.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.trial.command.FileVO;
import com.assistance.trial.file.mapper.IFileMapper;

@Service
public class FileService implements IFileService {

	@Autowired
	private IFileMapper mapper;
	
	@Override
	public void insertFile(FileVO vo) {
		System.out.println("insertFile 매퍼 호출 전 체크 : " + vo);
		mapper.insertFile(vo);
	}
	
	@Override
	public FileVO selectOne(int fileId) {
		return mapper.selectOne(fileId);
	}

	@Override
	public FileVO selectOneBySaveName(String saveName) {
		return mapper.selectOneBySaveName(saveName);
	}

}
