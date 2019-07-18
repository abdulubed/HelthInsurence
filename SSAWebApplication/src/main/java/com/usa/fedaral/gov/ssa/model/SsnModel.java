package com.usa.fedaral.gov.ssa.model;

import java.util.Date;

import lombok.Data;

@Data
public class SsnModel {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private Long phoneNumber;
	private String state;
	private byte[] photo;

}
