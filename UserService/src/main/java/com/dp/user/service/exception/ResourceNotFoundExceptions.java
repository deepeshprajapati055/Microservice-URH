package com.dp.user.service.exception;

public class ResourceNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptions() {
		super("Resource not found on server !!");
	}
	
	public ResourceNotFoundExceptions(String message) {
		super(message);
	}
	
}
