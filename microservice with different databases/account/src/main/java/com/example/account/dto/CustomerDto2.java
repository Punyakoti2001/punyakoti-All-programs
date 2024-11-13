package com.example.account.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto2 
{
	@NotNull
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$")
	private String mobileNumber;
	
	private AccountsDto account;
	

}
