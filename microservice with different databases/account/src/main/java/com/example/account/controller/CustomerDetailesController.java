package com.example.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.customerDetailsService.CustomerDetailsService;
import com.example.account.dto.CustomerDetailesDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;



@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerDetailesController 
{
	@Autowired
	private CustomerDetailsService customerDetailsService;

	@GetMapping("/fetchCustomer")
	public ResponseEntity<CustomerDetailesDto> fetchCustomerDetails(@Valid @Pattern(regexp = "^[6-9]{1}[0-9]{9}$") @RequestParam String mobileNuber)
	{
		
		
		return ResponseEntity.ok(customerDetailsService.fetchCustomerDetailes(mobileNuber));
		
	}
}
