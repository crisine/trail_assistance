package com.assistance.trial.command;



import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE faqboard(
faq_id NUMBER, --faq 번호 
faq_type VARCHAR(20), --faq 유형 
faq_title VARCHAR(100) NOT NULL, --faq 제목 
faq_regdate DATE DEFAULT sysdate, --faq 등록된 날짜
faq_updatedate DATE DEFAULT NULL, --faq 수정된 날자 
faq_content VARCHAR2(2000) NOT NULL, --faq 내용
faq_status NUMBER(1) NULL --faq 상태 
);


ALTER TABLE faqboard
ADD CONSTRAINT faqboard_pk PRIMARY KEY(faq_id);

CREATE SEQUENCE faqboard_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 5000
    NOCYCLE
    NOCACHE;
    
 */
@Getter
@Setter
@ToString
public class FaqBoardVO {
	
	private int faq_id;
	private String faq_title;
	private String faq_content;
	private String faq_type;
	private int faq_status;
	private Timestamp faq_regdate;
	private Timestamp faq_updatedate;
	private boolean newMark;
	

	

}
