package com.example.business.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;

public class Employee {
	private int employeeId;

	@NotNull
	//@Size(min=1, max=2, message="名前の文字数は{min}から{max}までです")
	@Size(min=1, max=2)
	private String name;
	
	@NotNull
	//@Email(message="メールのフォーマットが違います")
	@Email
	private String mail;

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