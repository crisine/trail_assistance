package com.assistance.trial.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/*
CREATE  TABLE assistant(
assistant_id NUMBER(10) PRIMARY KEY ,
acc_id NUMBER(10) CONSTRAINT acc_id_fk REFERENCES account(acc_id),
helepr_articleboard VARCHAR2(100),
mid VARCHAR2(100),
small VARCHAR2(100),
law2 VARCHAR2(100),
helper_name VARCHAR2(100),             
helper_ssn_number VARCHAR2(100),	    
helper_phone_tel VARCHAR2(100),        
helper_home_tel VARCHAR2(100),         
helper_email_address VARCHAR2(100),    
helper_job VARCHAR2(100),              
helper_zipcode VARCHAR2(100),         
helper_address1 VARCHAR2(100),        
helper_address2 VARCHAR2(100),        
helper_office_name VARCHAR2(100),      
helper_bussiness_reg_num VARCHAR2(100),
helper_offic_tel VARCHAR2(100),        
helper_offic_fax_tel VARCHAR2(100),    
helper_office_zipcode VARCHAR2(100), 
helper_office_address1 VARCHAR2(100), 
helper_office_address2 VARCHAR2(100),  
helper_sosong VARCHAR2(100),           
helper_sosong_content VARCHAR2(100),   
helper_bohum VARCHAR2(100),            
helper_bohum_content VARCHAR2(100),    
helper_hyungsa VARCHAR2(100),          
helper_hyungsa_content VARCHAR2(100),
helper_school_name VARCHAR2(100),
helper_school_major VARCHAR2(100),
helper_education VARCHAR2(100),        
helper_school_admission VARCHAR2(100),
helper_school_graduate VARCHAR2(100),  
final_edu VARCHAR2(100),               
hepler_edu_file VARCHAR2(100),                            
helper_career_name VARCHAR2(100),      
helper_career_period VARCHAR2(100), 
helper_career_wrok VARCHAR2(100),     
helper_career_department VARCHAR2(100),
helper_career_position VARCHAR2(100),  
hepler_career_file VARCHAR2(100),                         
helper_license_name VARCHAR2(100),     
helper_license_agency VARCHAR2(100),  
helper_license_num VARCHAR2(100),      
helper_license_date VARCHAR2(100),     
hepler_license_file VARCHAR2(100),
helper_regdate DATE DEFAULT sysdate,
helper_apply_status VARCHAR2(100), --신청 접수 상태(접수, 승인, 보완 ,부적격)
helper_status VARCHAR2(100) DEFAULT '　',  -- 평정기준표 밑에 있는 코멘트 저장
 helper_cateogry_select NUMBER(1) NOT NULl); //개인 1 / 기관2 구분 하는 값 
 
 
CREATE SEQUENCE assistant_seq
    MINVALUE 1
    MAXVALUE 100000
    INCREMENT BY 1
    START WITH 1
    NOCACHE
    NOCYCLE;


SELECT * FROM assistant;
DROP TABLE assistant;
DROP SEQUENCE assistant_seq;  
 */


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AssistantRegistVO {
	//account테이블의 기본키  -> 외래키로 쓸 예정
	private int acc_id;
	
	//assistant 테이블의 기본키 ->시퀀스로 자동 증가
	private int assistant_id;

	//조력자 공고 제목
	private String helepr_articleboard;
	
	
	private String mid; 
	private String small;
	private String law2; 
	private String helper_name; 
	private String helper_ssn_number; 
	private String helper_phone_tel; 
	private String helper_home_tel; 
	private String helper_email_address;
	private String helper_job; 
	private String helper_zipcode; 
	private String helper_address1;
	private String helper_address2; 
	private String helper_office_name; 
	private String helper_bussiness_reg_num;
	private String helper_offic_tel; 
	private String helper_offic_fax_tel; 
	private String helper_office_zipcode; 
	private String helper_office_address1;
	private String helper_office_address2;
	private String helper_sosong; 
	private String helper_sosong_content; 
	private String helper_bohum;
	private String helper_bohum_content; 
	private String helper_hyungsa;
	private String helper_hyungsa_content;



	private String helper_school_name;
	private String helper_school_major;
	private String helper_education;
	private String helper_school_admission;
	private String helper_school_graduate; 
	private String final_edu; 
	private String hepler_edu_file;

	private String helper_career_name; 
	private String helper_career_period;
	private String helper_career_wrok;
	private String helper_career_department;
	private String helper_career_position;
	private String hepler_career_file;

	private String helper_license_name;
	private String helper_license_agency;
	private String helper_license_num;
	private String helper_license_date;
	private String hepler_license_file;

	private Timestamp helper_regdate;
	private String helper_apply_status; //신청자 상태 ( 접수  ,심사중  ,승인 , 보완)
	private String helper_status; // 평정기준표 밑에 있는 코멘트 저장 용 
	
	
	private int helper_cateogry_select; //조력자 신청 맨 처음시 개인/기관 구분하는데 그 값을 저장하는 컬럼 

}
