package com.book.store.exception.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.book.store.response.BookResponse;
import com.book.store.response.StatusType;
/**
 * The BookExceptionHandler class is a controller advice class that handles exceptions
 * 
 */
@ControllerAdvice
public class BookExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	/**
	 * Handles the MethodArgumentNotValidException that occurs when request payload validation fails.
	 * 
	 * @param e of MethodArgumentNotValidException
	 * @return A ResponseEntity containing a custom error response for the validation errors.
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<BookResponse<ValidationErrorResponse>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException e) {
		logger.debug("handleMethodArgumentNotValidException :exception={}", e.getMessage());
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		BookResponse<ValidationErrorResponse> response = BookResponse.builResponse(error, StatusType.ERROR,
				HttpStatus.BAD_REQUEST.value(), null);
		logger.debug("handleMethodArgumentNotValidException :BAD_REQUEST={}", response);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
