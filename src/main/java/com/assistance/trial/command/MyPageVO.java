package com.assistance.trial.command;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE applydetail(
		helper_detail_no NUMBER(10),
	    helper_name VARCHAR2(10) NOT NULL,
	    helper_ssn_number VARCHAR(15) NOT NULL,
	    article_title VARCHAR2(100) NOT NULL,
	    helper_phone_tel VARCHAR2(20) NOT NULL,
	    helper_type VARCHAR(20) NOT NULL,
	    helper_job VARCHAR2(20),
	    article_start_date DATE DEFAULT NULL,
	    article_expired_date DATE DEFAULT NULL,
	    helper_designated_court VARCHAR2(50),
	    helper_is_ineligible NUMBER(1) NOT NULL,
	    helper_active_area VARCHAR2(100),
	    helper_address2 VARCHAR2(50) NOT NULL,
	    file_name VARCHAR2(100) NOT NULL,
	    eval_id NUMBER(10) NOT NULL,
	    helper_status NUMBER(1) NOT NULL,
	    eval_coment VARCHAR2(2000),
	    name VARCHAR2(100) NOT NULL,
	    phone VARCHAR2(100) NOT NULL,
	    job VARCHAR2(100) NOT NULL,
	    password VARCHAR2(100) NOT NULL,
	    email VARCHAR2(100) NOT NULL,
	    officename VARCHAR2(100),
	    businessregnum VARCHAR2(100),
	    officetel VARCHAR2(50),
	    officefax VARCHAR2(50),
	    officeaddr VARCHAR2(50),
	    zipcode VARCHAR2(50),
	    officeaddrdetail VARCHAR2(50)
		);

		CREATE SEQUENCE applydetail_seq
		    START WITH 1
		    INCREMENT BY 1
		    MAXVALUE 5000
		    NOCYCLE
		    NOCACHE;*/


@Getter
@Setter
@ToString
public class MyPageVO {
	//최필규 작성 시작
	private int helperDetailNo;
	private String helperName;
	private String helperSsnNumber;
	private String articleTitle;
	private String helperPhoneTel;
	private String helperType;
	private String helperJob;
	private Timestamp articleStartDate;
	private Timestamp articleExpiredDate;
	private String helperDesignatedCourt;
	private int helperIsIneligible;
	private String helperActiveArea;
	private String helperAddress2;
	private String fileName;
	private int evalId;
	private int helperStatus;
	private String evalComent;
	//최필규 작성 끝
	
	//천용혁 작성 시작
	private String name;
	private String phone;
	private String job;
	private String password;
	private String email;
	
	private String officename;
	private String businessregnum;
	private String officetel;
	private String officefax;
	private String zipcode;
	private String officeaddr;
	private String officeaddrdetail;
	//천용혁 작성 끝

}





























