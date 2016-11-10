package com.example.business.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee {
	private int employeeId;

	// 演習3 TODO: 必要なアノテーションを記述しなさい
	private String name;
	
	// 演習3 TODO: 必要なアノテーションを記述しなさい
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