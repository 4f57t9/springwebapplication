package com.mycompany.springwebapp.exception;

public class Ch15NotFoundAccountException extends RuntimeException {
	public Ch15NotFoundAccountException() {
		
	}
	
	public Ch15NotFoundAccountException(String message) {
		super(message);
	}
}
