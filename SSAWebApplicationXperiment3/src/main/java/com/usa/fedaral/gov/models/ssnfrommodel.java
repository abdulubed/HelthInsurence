package com.usa.fedaral.gov.models;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class ssnfrommodel {

	private int ssnNo;
	@Size(min = 2, max = 20, message = "min 2 and max 20 chars allowed")
	@NotEmpty(message = "please enter firstname")

	private String firstName;
	@NotEmpty(message = "please enter lastName")
	@Size(min = 2, max = 20, message = "min 2 and max 20 chars allowed")
	private String lastName;
//	@NotNull(message = "please enter dateofbirth")
	private Date dateofbirth;
	@NotEmpty(message = "please choos gender")
	private String gender;
	@Min(value = 10, message = "phno should be 10 Numbers")
	@NotNull(message = "please enter phno")
	private Integer phno;
	@NotEmpty(message = "please select photo")
	private byte[] photo;
	@NotEmpty(message = "please select state")
	private String state;

	public int getSsnNo() {
		return ssnNo;
	}

	public void setSsnNo(int ssnNo) {
		this.ssnNo = ssnNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPhno() {
		return phno;
	}

	public void setPhno(Integer phno) {
		this.phno = phno;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ssnfrommodel [ssnNo=" + ssnNo + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofbirth="
				+ dateofbirth + ", gender=" + gender + ", phno=" + phno + ", photo=" + Arrays.toString(photo)
				+ ", state=" + state + "]";
	}

}
