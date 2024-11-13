package com.example.account.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Accounts extends BaseEntity 
{
	@Id
	private Long accountNumber;
	private Long customerId;
	private String accountType;
	private String branchAddress;

}
