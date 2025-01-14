package com.employees.demo.customexception;

public class NoSuchEmployeeExistsException extends RuntimeException{
	
	private String message;
	
	public NoSuchEmployeeExistsException() {		
	}
	
	public NoSuchEmployeeExistsException(String message) {
		super(message);
		this.message = message;		
	}
}
