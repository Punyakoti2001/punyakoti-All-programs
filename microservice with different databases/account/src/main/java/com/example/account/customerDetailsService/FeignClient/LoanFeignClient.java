package com.example.account.customerDetailsService.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.account.dto.LoanDto;

import jakarta.websocket.server.PathParam;


@FeignClient("loan")
public interface LoanFeignClient 
{
	@GetMapping(path = {"/loan/fetch/{mobileNumber}"},consumes = "application/json")
	public ResponseEntity<List<LoanDto>> getLoanByMobile(@PathVariable String mobileNumber );
	

}
