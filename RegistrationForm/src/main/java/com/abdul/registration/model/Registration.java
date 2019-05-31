package com.abdul.registration.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Registration {
	
	@NotEmpty(message = "First name cannot be empty")
	@Size(min=1 , max =5 , message = "size should be 1 to 6")
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String gender;
	private String role;
		

}
