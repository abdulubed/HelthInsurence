package com.validations.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRegistration {

	private String uniqNumber;
	@NotEmpty
	@Size(min = 6, max = 15, message = "first name contains min 6 & max 15")
	@NotBlank(message = "first name is required")
	private String firstName;
	@NotEmpty
	@Size(min = 6, max = 15, message = "last name contains min 6 & max 15")
	private String lastName;
	@NotEmpty
	@Size(min = 6, max = 15, message = "user name min 6 & max 15")
	private String userName;
	@NotEmpty
	@Size(min = 6, max = 15, message = "password contains min 6 & max 15")
	private String password;

}
