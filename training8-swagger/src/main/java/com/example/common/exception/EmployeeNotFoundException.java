package com.example.common.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
}