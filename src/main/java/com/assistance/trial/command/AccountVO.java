package com.assistance.trial.command;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	CREATE TABLE  account (
	acc_id	NUMBER(10) PRIMARY KEY	NOT NULL,
	account	VARCHAR(50)	NOT NULL,
	password	VARCHAR(50)	NOT NULL,
	email	VARCHAR(100)	NOT NULL,
	reg_date	DATE	DEFAULT SYSDATE	NOT NULL,
	last_login	DATE	DEFAULT SYSDATE	NOT NULL,
	type	NUMBER(1)	DEFAULT 0	NOT NULL
);
CREATE SEQUENCE account_seq
    MINVALUE 1
    MAXVALUE 100000
    INCREMENT BY 1
    START WITH 1
    NOCACHE
    NOCYCLE;
    
    
    
select * FROM account;
DROP TABLE account;
DROP SEQUENCE account_seq;
DROP TABLE account CASCADE CONSTRAINTS;    
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {
	
	private int accId;// account테이블의 기본키 
	private String account;
	private String password;
	private String email;
	private Timestamp regDate;
	private Timestamp lastLogin;
	private int type;
	
	//조력자 신청한 데이터 객체의 모음
	private List<AssistantRegistVO> assistantRegist;

}
