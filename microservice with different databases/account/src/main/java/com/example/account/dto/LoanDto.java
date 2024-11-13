package com.example.account.dto;

import lombok.Data;

@Data
public class LoanDto {
		
		private String mobileNumber;
		
		private String loanNumber;
		
		private String loanType;
		
		private Double totalLoan;
		
		private Double amountPaid;
		
		private Double outstandingAmount ;


	}



