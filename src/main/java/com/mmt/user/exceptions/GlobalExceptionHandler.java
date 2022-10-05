package com.mmt.user.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mmt.user.exceptions.EmptyInputException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException) {
		return new ResponseEntity<String>("Requested product doesn't exist : ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>("EmptyInputException" + emptyInputException.getErrorCode() + " "
				+ emptyInputException.getErrorMessage(), HttpStatus.NOT_FOUND);
	}
}