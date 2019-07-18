package com.usa.fedaral.gov.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SSN_MASTER")
public class SsnMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssn_seq")
	@SequenceGenerator(sequenceName = "ssn_seq_gen", allocationSize = 1, name = "ssn_seq")
	private Long SsnNumber;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PHOTO")
	@Lob
	private byte[] photo;

}
