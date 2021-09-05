package com.lcs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	String unsupportedErrorMsg;
	
	String notUniqueErrMsg;
	
	String listEmptyErrMsg;
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage= new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE,"The accepted format is JSON only. Send the Request in the specified format",LocalDateTime.now());
		return new ResponseEntity<Object>(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	
	@ExceptionHandler(ListCannotbeEmptyException.class)
	public ResponseEntity<Object> handleListEmptyException(ListCannotbeEmptyException ex){
		ErrorMessage errorMessage= new ErrorMessage(HttpStatus.BAD_REQUEST,"Please enter the strings for which Longest Common substring is to be found. The list cannot be empty",LocalDateTime.now());
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotUniqueException.class)
	public ResponseEntity<Object> handleNotUniqueException(NotUniqueException ex){
		ErrorMessage errorMessage= new ErrorMessage(HttpStatus.BAD_REQUEST,"The entered strings must be unique. Repetition of entries not allowed",LocalDateTime.now());
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
