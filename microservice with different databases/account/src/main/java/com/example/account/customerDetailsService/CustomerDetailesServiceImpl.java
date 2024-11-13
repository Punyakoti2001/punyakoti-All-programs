package com.example.account.customerDetailsService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.account.Repository.AccountsRepository;
import com.example.account.Repository.CustomerRepository;
import com.example.account.customerDetailsService.FeignClient.LoanFeignClient;
import com.example.account.customizedException.ResourceNotFoundException;
import com.example.account.dto.AccountsDto;
import com.example.account.dto.CustomerDetailesDto;
import com.example.account.dto.CustomerDto2;
import com.example.account.dto.LoanDto;
import com.example.account.entities.Accounts;
import com.example.account.entities.Customer;
import com.example.account.mapper.Mapper;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CustomerDetailesServiceImpl implements CustomerDetailsService {

	private CustomerRepository customerRepository;
	private AccountsRepository accountsRepository;
	private LoanFeignClient loanFeignClient;
	
	@Override
	public CustomerDetailesDto fetchCustomerDetailes(String mobileNumber) {
		
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account", "CustomerID",""+customer.getCustomerId()));
		
		ResponseEntity<List<LoanDto>> loans = loanFeignClient.getLoanByMobile(mobileNumber);
		List<LoanDto> body = loans.getBody();
		
		CustomerDto2 customerDto2 = Mapper.mapToCustomerDto2(customer, new CustomerDto2());
		AccountsDto accountDto = Mapper.mapToAccountDto(account, new AccountsDto());
		customerDto2.setAccount(accountDto);
		
		
		CustomerDetailesDto customerDetailesDto = new CustomerDetailesDto();
		customerDetailesDto.setCustomerDto2(customerDto2);
		customerDetailesDto.setLoanDto(body);
		
		return customerDetailesDto;
		
	}

}
