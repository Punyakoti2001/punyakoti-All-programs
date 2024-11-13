package com.example.account.servicesImpl;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.account.Repository.AccountsRepository;
import com.example.account.Repository.CustomerRepository;
import com.example.account.customizedException.CustomerAlreadyExistsException;
import com.example.account.customizedException.ResourceNotFoundException;
import com.example.account.dto.AccountsDto;
import com.example.account.dto.CustomerDto;
import com.example.account.dto.CustomerDto2;
import com.example.account.entities.Accounts;
import com.example.account.entities.Customer;
import com.example.account.mapper.Mapper;
import com.example.account.services.IAccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

	private CustomerRepository customerRepo;
	private AccountsRepository accountsRepo;
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> byMobileNumber = customerRepo.findByMobileNumber(customerDto.getMobileNumber());
		
		if(byMobileNumber.isPresent())
		{
			throw new CustomerAlreadyExistsException("Customer Is Already Exist with these Mobile Number."+customerDto.getMobileNumber());
		}
		
		Customer customer = Mapper.mapToCustomer(customerDto,new Customer());
		Customer savedCustomer = customerRepo.save(customer);
		

		Accounts account  = Mapper.mapToAccounts(savedCustomer);
		Accounts save = accountsRepo.save(account);
		
	}

	@Override
	public CustomerDto2 fetchCustomer(String mobileNumber) {
		
		Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Customer","MobileNumber",mobileNumber));
		
		Accounts account = accountsRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Account", "CustomerId",""+customer.getCustomerId()));
		
	 CustomerDto2 customerDto2	= Mapper.mapToCustomerDto2(customer,new CustomerDto2());
	 
	 AccountsDto account1 = Mapper.mapToAccountDto(account,new AccountsDto());
	 
	 customerDto2.setAccount(account1);
	 
		return customerDto2;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) 
	{
		
		Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		
		customerRepo.deleteById(customer.getCustomerId());
		
		accountsRepo.deleteByCustomerId(customer.getCustomerId());
		
		return true;
		
	}
	
	@Override
	public boolean updateAccount(CustomerDto2 customerDto)
	{
		
		Customer customer = customerRepo.findByMobileNumber(customerDto.getMobileNumber())
				                                            .orElseThrow(()->new ResourceNotFoundException("Customer", "Mobile Number", customerDto.getMobileNumber()));
		
		Customer updateCustomer = Mapper.mapToCustomer(customerDto, customer);
		Customer save = customerRepo.save(updateCustomer);
		
		Accounts account = accountsRepo.findById(customerDto.getAccount().getAccountNumber())
				                                 .orElseThrow(()->new ResourceNotFoundException("Account", "Account Number",""+customerDto.getAccount().getAccountNumber()));
		
		Accounts updateAccount = Mapper.mapToAccounts(customerDto.getAccount(),account);
		Accounts save2 = accountsRepo.save(updateAccount);
		
		return true;
	}
	

}
