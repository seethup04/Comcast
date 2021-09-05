package com.lcs.exception;

public class NotUniqueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotUniqueException(String message) {
		super(message);
	}
	
	public NotUniqueException() {
		super();
	}
}
