package com.example.account.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.constants.AccountsConstants;
import com.example.account.dto.AccountsContactInfoDto;
import com.example.account.dto.CustomerDto;
import com.example.account.dto.CustomerDto2;
import com.example.account.dto.ResponseDto;
import com.example.account.services.IAccountService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RefreshScope
@NoArgsConstructor
public class CustomerController 
{
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private AccountsContactInfoDto contactInfoDto;
	
	@PostMapping("/new")
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto)
	{
		accountService.createAccount(customerDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.MESSAGE_200,AccountsConstants.STATUS_200));
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<?> fetching(@Valid @RequestParam String mobileNo)
	{
		CustomerDto2 fetchCustomer = accountService.fetchCustomer(mobileNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(fetchCustomer);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto>delect(@RequestParam String mobileNumber)
	{
		boolean result = accountService.deleteAccount(mobileNumber);

		return new ResponseEntity<ResponseDto>(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200),HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDto>updateAccount(@RequestBody CustomerDto2 customerDto)
	{
		boolean updateAccount = accountService.updateAccount(customerDto);
		
		return new ResponseEntity<ResponseDto>(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200),HttpStatus.OK);
		
	}
	
	@Value("${build.version}")
	private Double build;
	
	@GetMapping("/contact-info")
	public ResponseEntity<?> getContactInfo()
	{
		return ResponseEntity.ok(contactInfoDto);
	}
	
	@GetMapping("/build")
	public ResponseEntity<?> getbuild()
	{
		return ResponseEntity.ok(build);
	}

}
