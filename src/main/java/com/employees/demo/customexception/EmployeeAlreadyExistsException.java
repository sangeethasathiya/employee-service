package com.employees.demo.customexception;

public class EmployeeAlreadyExistsException extends RuntimeException{
	
	private String message;
	
	public EmployeeAlreadyExistsException() {		
	}
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
		this.message = message;		
	}
}
