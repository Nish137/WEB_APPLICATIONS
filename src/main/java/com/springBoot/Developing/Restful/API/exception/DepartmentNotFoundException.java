package com.springBoot.Developing.Restful.API.exception;

import org.springframework.stereotype.Component;

@Component
public class DepartmentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentNotFoundException() { 
		super();
	}
	
	public DepartmentNotFoundException(String message) { 
		super(message);
	}
	
	public DepartmentNotFoundException(String message, Throwable cause) { 
		super(message,cause);
	}
	
	public DepartmentNotFoundException( Throwable cause) { 
		super(cause);
	}
	
	
	public DepartmentNotFoundException(String message,Throwable cause,boolean enableSupression,boolean writableStackTrace) { 
		super(message,cause,enableSupression,writableStackTrace);
	}
	
	
	
	
	

}
