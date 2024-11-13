package com.example.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto 
{
	
	@NotNull
	private Long accountNumber;
	
	@NotNull
	@NotBlank
	private String accountType;
	
	@NotBlank
	@NotNull
	private String branchAddress;

}
