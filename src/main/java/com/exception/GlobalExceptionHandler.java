package com.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.record.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	// @Valid failures: missing, empty, blank, too long, bad format
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, String> fields = new LinkedHashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(fe -> {
			fields.put(fe.getField(), fe.getDefaultMessage());
		});
		ErrorResponse errorResponse = new ErrorResponse("validation_failed", fields);
		return ResponseEntity.badRequest().body(errorResponse);
	}

	// Malformed JSON, missing body, wrong field type
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleMalformedJson(HttpMessageNotReadableException ex) {
		ErrorResponse errorResponse = new ErrorResponse("invalid_request_body", null);
		return ResponseEntity.badRequest().body(errorResponse);
	}

	// Anything unexpected: generic 500, no internals
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse("internal_server_error", null);
		return ResponseEntity.internalServerError().body(errorResponse);
	}
}
