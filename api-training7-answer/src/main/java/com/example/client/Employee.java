package com.example.client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee {
	private int employeeId;

	@NotNull
	@Size(min=1, max=2)
	private String name;
	
	@NotNull
	@Email
	private String mail;
	
	public Employee(){}
	
	// Unitテスト用に作りました
	public Employee(int employeeId, String name, String mail) {
		this.employeeId = employeeId;
		this.name = name;
		this.mail = mail;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	// apache commons lang3を利用
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}