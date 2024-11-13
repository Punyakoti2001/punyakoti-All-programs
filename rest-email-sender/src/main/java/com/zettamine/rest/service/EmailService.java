package com.zettamine.rest.service;

public interface EmailService 
{

	public boolean sendEmail(String to,String subject,String body,String path);
}
