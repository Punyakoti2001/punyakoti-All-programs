package com.example.account.customizedException;

public class CustomerAlreadyExistsException extends RuntimeException 
{

	public CustomerAlreadyExistsException(String message) {
		super(message);
		
	}
	

}
