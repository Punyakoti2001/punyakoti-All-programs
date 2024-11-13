package com.example.account.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDetailesDto 
{
	private CustomerDto2 customerDto2;
	private List<LoanDto> loanDto;

}
