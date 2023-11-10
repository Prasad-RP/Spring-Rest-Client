package com.rest.client.dto;

import lombok.Data;

@Data
public class Employee {

	private Integer employeeId;

	private String employeeName;

	private String emailId;

	private Boolean isActive;

	private String password;

	private String roles;

}
