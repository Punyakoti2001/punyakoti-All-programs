package com.example.account.customerDetailsService;

import com.example.account.dto.CustomerDetailesDto;

public interface CustomerDetailsService 
{
	 CustomerDetailesDto fetchCustomerDetailes(String mobileNumber);

}
