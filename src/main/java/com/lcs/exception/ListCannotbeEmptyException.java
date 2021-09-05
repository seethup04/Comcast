package com.lcs.exception;

import org.springframework.http.HttpStatus;

public class ListCannotbeEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListCannotbeEmptyException(String message) {
		super(message);
	}

	public ListCannotbeEmptyException() {
		super();
	}
}
