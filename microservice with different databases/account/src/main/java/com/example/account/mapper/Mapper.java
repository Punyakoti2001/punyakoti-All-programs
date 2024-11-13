package com.example.account.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;

import com.example.account.constants.AccountsConstants;
import com.example.account.dto.AccountsDto;
import com.example.account.dto.CustomerDto;
import com.example.account.dto.CustomerDto2;
import com.example.account.dto.LoanDto;
import com.example.account.entities.Accounts;
import com.example.account.entities.Customer;

public class Mapper {

	public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
		
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("jagadheesh");
		return customer;
	}

	public static Accounts mapToAccounts(Customer savedCustomer) {
		
		Accounts account = new Accounts();
		account.setAccountNumber(1000000000L+new Random().nextInt(900000000));
		account.setCustomerId(savedCustomer.getCustomerId());
		account.setAccountType(AccountsConstants.SAVINGS);
		account.setBranchAddress(AccountsConstants.ADDRESS);
		account.setCreatedAt(LocalDateTime.now());
		account.setCreatedBy("jagadheesh");
		return account;
	}

	public static CustomerDto2 mapToCustomerDto2(Customer customer, CustomerDto2 customerDto2) {
		
		customerDto2.setName(customer.getName());
		customerDto2.setEmail(customer.getEmail());
		customerDto2.setMobileNumber(customer.getMobileNumber());
		
		return customerDto2;
	}

	public static AccountsDto mapToAccountDto(Accounts account, AccountsDto accountsDto) {
		
		accountsDto.setAccountNumber(account.getAccountNumber());
		accountsDto.setAccountType(account.getAccountType());
		accountsDto.setBranchAddress(account.getBranchAddress());
		return accountsDto;
	}

	public static Customer mapToCustomer(CustomerDto2 customerDto, Customer customer) {
		
		
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setUpdatedAt(LocalDateTime.now());
		customer.setUpdatedBy("Akash");
		
		return customer;
	}

	public static Accounts mapToAccounts(AccountsDto account, Accounts accounts) {
		
		accounts.setAccountNumber(account.getAccountNumber());
		accounts.setAccountType(account.getAccountType());
		accounts.setBranchAddress(account.getBranchAddress());
		accounts.setUpdatedAt(LocalDateTime.now());
		accounts.setUpdatedBy("Akash");
		return accounts;
	}


	
}
