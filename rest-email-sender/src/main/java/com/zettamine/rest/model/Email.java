package com.zettamine.rest.model;

import lombok.Data;

@Data
public class Email 
{
	private String toMail;
	private String body;
	private String subject;

}
