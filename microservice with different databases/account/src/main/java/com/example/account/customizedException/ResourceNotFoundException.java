package com.example.account.customizedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException 
{


	public ResourceNotFoundException(String resource, String id, String mobileNumber) {
		super(resource +" Not Found "+id +" : "+mobileNumber);
	}

}
