package com.example.account.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.account.entities.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> 
  {

	Optional<Accounts> findByCustomerId(Long customerId);

	void deleteByCustomerId(Long customerId);
	
  }
