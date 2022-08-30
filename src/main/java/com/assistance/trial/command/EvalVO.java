package com.assistance.trial.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 시퀀스 적용 
CREATE TABLE EVAL (
	eval_id	NUMBER(10)	PRIMARY KEY ,
	assistant_id	NUMBER(10)	CONSTRAINT assistant_id_fk REFERENCES assistant(assistant_id),
	eval_name	VARCHAR (10)	DEFAULT 0	NOT NULL,
	eval_ssn_number	VARCHAR(15)	DEFAULT 0	NOT NULL,
	eval_total_career	NUMBER(2)	DEFAULT 0	NOT NULL,
	eval_inside_career	NUMBER(2)	DEFAULT 0	NOT NULL,
	eval_office_address	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_personality	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_interview	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_license	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_mid_sum	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_appraiser_score	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_adjustment_rating	NUMBER(1)	DEFAULT 0	NOT NULL,
	eval_total_sum	NUMBER(2)	DEFAULT 0	NOT NULL
);
CREATE SEQUENCE eval_seq
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
public class EvalVO {

	private int evalId; 		// 시퀀스, 기본키
	private int assistantId;		// 조력자 시퀀스, 외래키
	private String evalName;	// 피평가자 이름
	private String ssnNumber;	// 주민번호
	private int totalCareer;	// 통산경력 점수
	private int insideCareer;
	private int officeAddress;
	private int personality;
	private int interview;
	private int license;
	private int midSum;
	private int appraiserScore;
	private int adjustmentRating;	// 추천점수
	private int totalSum;			// 총점
}
