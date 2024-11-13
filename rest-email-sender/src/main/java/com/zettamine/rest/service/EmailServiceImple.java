package com.zettamine.rest.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImple implements EmailService 
{
	private JavaMailSender emailSender;
	
	@Autowired
	public EmailServiceImple(JavaMailSender emailSender) {
		super();
		this.emailSender = emailSender;
	}

	@Override
	public boolean sendEmail(String to, String subject, String body,String path) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		String body1 = "<p style=color:red;text-align:centre;>"+body+"</p>";
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setText(body1,true);
			helper.setSubject(subject);
			helper.setTo(to);
			File file = new File(path);
			FileSystemResource fileSource = new FileSystemResource(file);
			helper.addAttachment("word.pdf", fileSource);
			emailSender.send(message);
			return true;
		} catch (MessagingException e) {
			System.out.println(e);
			return false;
		}
		
		
	}



//	@Override
//	public boolean sendEmail(String to, String subject, String body) {
//		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("Punyakoti");
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(body);
//		
//
//		try
//		{
//			emailSender.send(message);
//			return true;
//		}
//		catch(Exception ex)
//		{
//			System.err.println(ex);
//			return false;
//		}
//		
//		
//	}
	
	

}
