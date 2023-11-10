package com.rest.client.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.UnknownContentTypeException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings("unchecked")
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Map<Object, Object>> exception(HttpClientErrorException ex) {
		return new ResponseEntity<>(ex.getResponseBodyAs(HashMap.class), ex.getStatusCode());
	}
	

	@ExceptionHandler(UnknownContentTypeException.class)
	public ResponseEntity<Map<Object, Object>> exception(UnknownContentTypeException ex) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Message", ex.getMessage());
		return new ResponseEntity<>(map, ex.getStatusCode());
	}

}
