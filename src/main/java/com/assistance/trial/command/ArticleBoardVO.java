package com.assistance.trial.command;




import java.sql.Timestamp;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*
CREATE TABLE articleboard(
article_id NUMBER, --게시물 번호
article_type VARCHAR(20), --게시물 유형
article_title VARCHAR2(100) NOT NULL, --게시물 제목
article_regdate DATE DEFAULT sysdate, --게시물 생성된 날짜
article_updatedate DATE DEFAULT NULL, --게시물 수정된 날짜
article_content VARCHAR2(2000) NOT NULL, --게시물 내용
article_start_date DATE DEFAULT sysdate, --공고 시작 일자
article_expired_date DATE DEFAULT NULL, --공고 마감 일자
article_status NUMBER(1) NULL --게시물 상태 ???
);

ALTER TABLE articleboard
ADD CONSTRAINT articleboard_pk PRIMARY KEY(article_id);

CREATE SEQUENCE articleboard_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 5000
    NOCYCLE
    NOCACHE;
    
 */
@Getter
@Setter
@ToString
public class ArticleBoardVO {
	
	private int article_id; //articleboard의 기본키 
	private String article_title;
	private String article_content;
	private String article_type;
	private int article_status;
	private Timestamp article_regdate;
	private Timestamp  article_updatedate;
	private Timestamp  article_start_date;
	private Timestamp  article_expired_date;
	private boolean newMark;
	

}
