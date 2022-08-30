package com.assistance.trial.command;



import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 CREATE TABLE noticeboard(
notice_id NUBMER, //게시물 번호
notice_type VARCHAR2(20), // 게시물 유형 
notice_title VARCHAR2(100) NOT NULL, // 게시된 제목
notice_writer VARCHAR2(100)NOT NULL, // 작성자
notice_regdate DATE DEFAULT sysdate, // 게시된 날짜 
notice_updatedate DATE DEFAULT NULL, // 수정된 날짜
notice_content VARCHAR2(2000) NOT NULL, // 게시판 내용
notice_start_date DATE DEFAULT sysdate,  // 게시물 시작 일자
notice_expired_date DATE DEFAULT NULL, // 게시물 끝 일자 
notice_status NUMBER(1) NULL
);


ALTER TABLE noticeboard
ADD CONSTRAINT noticeboard_pk PRIMARY KEY(notice_id);

CREATE SEQUENCE noticeboard_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 5000
    NOCYCLE
    NOCACHE;
    
 */

@Getter
@Setter
@ToString
public class NoticeBoardVO {
	
	private int notice_id;
	private String notice_title;
	private String notice_content;
	private String notice_writer;
	private String notice_type;
	private int notice_status;
	private Timestamp notice_regdate;
	private Timestamp notice_updatedate;

	private boolean newMark;
	

	

}
