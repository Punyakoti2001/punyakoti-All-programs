package com.example.account.services;

import com.example.account.dto.CustomerDto;
import com.example.account.dto.CustomerDto2;

public interface IAccountService 
{
	void createAccount(CustomerDto customerDto);
	

	CustomerDto2 fetchCustomer(String mobileNumber);
	
	boolean deleteAccount(String mobileNumber);
	
	boolean updateAccount(CustomerDto2 customerDto);
	
}
