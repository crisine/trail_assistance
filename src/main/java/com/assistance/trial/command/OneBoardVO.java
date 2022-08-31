package com.assistance.trial.command;



import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
CREATE TABLE oneboard(
one_id NUMBER, --1:1 게시판 번호 
one_type VARCHAR2(20), --1:1 문의 유형 
one_title VARCHAR2(100) NOT NULL, --1:1 문의 제목 
one_writer VARCHAR2(20) NOT NULL, --1:1 작성자
one_file VARCHAR2(100),  --1:1 문의 고객 파일 
one_cate_one VARCHAR2(20) NOT NULL,  --1:1 문의 고객 문의 유형1 
one_cate_two VARCHAR2(20) NOT NULL,  --1:1 문의 고객 문의 유형 2
one_regdate DATE DEFAULT sysdate, --게시판 생성된날짜
one_updatedate DATE DEFAULT NULL, --게시판 수정된 날짜 
one_content VARCHAR2(2000) NOT NULL, --게시판 내용
one_status NUMBER(1) NULL
);


ALTER TABLE oneboard
ADD CONSTRAINT oneboard_pk PRIMARY KEY(one_id);

CREATE SEQUENCE oneboard_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 5000
    NOCYCLE
    NOCACHE;
 */

@Getter
@Setter
@ToString
public class OneBoardVO {
	
	private int one_id;
	private String one_title;
	private String one_content;
	private String one_writer;
	private String one_type;
	private String one_cate_one;
	private String one_file;
	private int one_status;
	private Timestamp one_regdate;
	private Timestamp one_updatedate;
	private boolean newMark;
	

	

}
