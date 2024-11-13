package com.zettamine.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.rest.model.Email;
import com.zettamine.rest.service.EmailService;

@RestController
public class EmailController 
{
	private EmailService emailSer;
	
	@Autowired
	public EmailController(EmailService emailSer) {
		super();
		this.emailSer = emailSer;
	}



	@PostMapping("/email")
	public ResponseEntity<?> giveResponse(@RequestBody Email mail)
	{

		
		boolean sendEmail = emailSer.sendEmail(mail.getToMail(), mail.getSubject(), mail.getBody(),"C:\\Users\\Punyakoti Reddy\\Downloads\\02Maven.docx");
		if(sendEmail)
			return new ResponseEntity<String>("Email sent",HttpStatus.OK);
		return  new ResponseEntity<String>("Something Error Found",HttpStatus.BAD_REQUEST);
		
	}
}
