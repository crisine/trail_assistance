package com.assistance.trial.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE company
(
    comNo NUMBER(10),
    comName VARCHAR2(100),
    comPhone VARCHAR2(50),
    comAddress VARCHAR2(500)
);

CREATE SEQUENCE company_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 5000
    NOCYCLE
    NOCACHE;*/

@Getter
@Setter
@ToString
public class AgencyVO {
	private int comNo; //company 테이블의 기본키 
	private String comName;
	private String comPhone;
	private String comAddress;
}
