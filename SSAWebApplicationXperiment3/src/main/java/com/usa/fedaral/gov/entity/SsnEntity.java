package com.usa.fedaral.gov.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "ssn_master_table")
public class SsnEntity {
	@Id
	@SequenceGenerator(sequenceName = "ssn_seq", initialValue = 8675941, allocationSize = 1, name = "ssn_seq_gen")
	@GeneratedValue(generator = "ssn_seq_gen", strategy = GenerationType.SEQUENCE)
	private int ssnNo;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DATE_OF_BIRTH")
	//@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PhNO")
	private int phno;
	@Column(name = "PHOTO")
	@Lob
	private byte[] photo;
	@Column(name = "STATE")
	private String state;
	@Column(name = "CREATED_BY")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso=ISO.DATE)

	@Column(name = "UPDATED_BY")
	private java.util.Date updatedBy;

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

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
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
		return "SsnEntity [ssnNo=" + ssnNo + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofbirth="
				+ dateofbirth + ", gender=" + gender + ", phno=" + phno + ", photo=" + Arrays.toString(photo)
				+ ", state=" + state + "]";
	}

}
