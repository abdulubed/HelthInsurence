package com.usa.fedaral.gov.ssa.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class SsnModel {

	private Long ssnNumber;
	
	@Size(min = 2 , max = 20, message = "minimum 2 maximum 20 characters are allowed")
	@NotEmpty(message = "please enter first name")
	private String firstName;
	

	@Size(min = 2 , max = 20, message = "minimum 2 maximum 20 characters are allowed")
	@NotEmpty(message = "please enter first name")
	private String lastName;
	
	@NotNull(message = "please enter dateofbirth")
	private Date dateOfBirth;
	
	@NotEmpty(message = "please choos gender")
	private String gender;
	
	@Min(value = 10, message = "phno should be 10 Numbers")
	@NotNull(message = "please enter phno")
	private Long phoneNumber;
	
	@NotEmpty(message = "please select state")
	private String state;
	
	@NotEmpty(message = "please select photo")
	private byte[] photo;

}
