package com.school.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Student {

	@Id
	private int userId;

	private String firstName;
	private String secondName;
	private String emailId;
	private String contactNumber;
	private String country;

}
