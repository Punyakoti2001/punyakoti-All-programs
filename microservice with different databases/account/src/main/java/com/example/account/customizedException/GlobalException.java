package com.example.account.customizedException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import com.example.account.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> responseEntity(CustomerAlreadyExistsException ex,WebRequest webRequest)
	{
		ErrorResponseDto errorResponse = new ErrorResponseDto(webRequest.getDescription(false),
				                                              HttpStatus.BAD_REQUEST
				                                              ,ex.getMessage()
				                                              ,LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> responseEntity1(MethodArgumentNotValidException ex,WebRequest webRequest)
	{
		ErrorResponseDto errorResponse = new ErrorResponseDto(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST
                ,ex.getBindingResult().getFieldError().getField()+":"+ex.getFieldError().getDefaultMessage()
                ,LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(errorResponse,HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> resourceNotFound(ResourceNotFoundException ex, WebRequest webRequest)
	{
		ErrorResponseDto responseDto = new ErrorResponseDto(webRequest.getDescription(false), 
				                                            HttpStatus.NOT_FOUND, 
				                                            ex.getMessage(), 
				                                            LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponseDto>(responseDto,HttpStatus.NOT_FOUND);
		
	}
	
	

}
