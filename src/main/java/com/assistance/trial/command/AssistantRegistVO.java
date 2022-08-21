package com.assistance.trial.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AssistantRegistVO {

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
}
