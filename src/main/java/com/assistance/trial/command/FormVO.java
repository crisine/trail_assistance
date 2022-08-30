package com.assistance.trial.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 	CREATE TABLE FORM (
	form_id	NUMBER(10)		NOT NULL,
	acc_id	NUMBER(10)		NOT NULL,
	assistant_id NUMBER(10) NOT NULL,
	title	VARCHAR(100)	DEFAULT ''	NOT NULL,
	status	VARCHAR(20)	DEFAULT ''	NOT NULL,
	type	VARCHAR(20)	DEFAULT 0	NOT NULL,
	office_name	VARCHAR(50)	DEFAULT ''	NOT NULL,
	start_date	DATE	DEFAULT SYSDATE	NOT NULL,
	end_date	DATE	DEFAULT SYSDATE	NOT NULL,
	requirements	VARCHAR(500)	DEFAULT ''	NOT NULL,
	assistant_status	NUMBER(1)	DEFAULT 0	NOT NULL
);
CREATE SEQUENCE form_seq
    MINVALUE 1
    MAXVALUE 100000
    INCREMENT BY 1
    START WITH 1
    NOCACHE
    NOCYCLE;
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FormVO {
	
	private int formId;
	private int accId;
	private int assistantId;
	private String title;		// 신청 공고명
	private String status;		// 신청 접수 상태 (접수, 승인 두 가지만 있습니다)
	private String type;		// 조력자 타입 - 아마 안 쓸 확률 높습니다.
	private String officeName;	// 사무소명
	private Date startDate;
	private Date endDate;
	private String requirements;	// 보완 사항 입력란 텍스트
	private String assistantStatus;	// 신청자 상태 (적격, 부적격, 보완필요)
	
}
