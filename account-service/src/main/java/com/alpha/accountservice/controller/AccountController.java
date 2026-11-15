package com.alpha.accountservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.accountservice.requestdto.AccountRequestDto;
import com.alpha.accountservice.requestdto.AccountStatusUpdateRequestDto;
import com.alpha.accountservice.responsedto.AccountDetailsResponseDto;
import com.alpha.accountservice.responsedto.AccountResponseDto;
import com.alpha.accountservice.responsedto.ResponseStructure;
import com.alpha.accountservice.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	
	// constructor DI
	final private AccountService accountService;
	
	public AccountController(AccountService accountService)
	{
		this.accountService = accountService;
	}

	// account creation
	@PostMapping("/create")
	public ResponseStructure<AccountResponseDto> accountCreate(@RequestBody AccountRequestDto accountRequestDto)
	{
		return accountService.accountCreate(accountRequestDto);
	}
	
	// get all accounts
	@GetMapping("/getallaccounts")
	public ResponseStructure<List<AccountDetailsResponseDto>> getAllAccount()
	{
		return accountService.getAllAccounts();
	}
	
	// get account by account ID
	@GetMapping("/getaccountbyid")
	public ResponseStructure<AccountDetailsResponseDto> getAccountById(@RequestParam int accountId)
	{
		return accountService.getAccountById(accountId);
	}
	
	// get accounts by customer ID
	@GetMapping("/getaccountsbycustomerid")
	public ResponseStructure<List<AccountDetailsResponseDto>> getAccountsByCustomerId(@RequestParam int customerId)
	{
		return accountService.getAccountsByCustomerId(customerId);
	} 
	
	// update status
	@PatchMapping("/updatestatus")
	public ResponseStructure<List<AccountDetailsResponseDto>> updateStatus(@RequestBody AccountStatusUpdateRequestDto accountStatusUpdateRequestDto, @RequestParam int customerId)
	{
		return accountService.updateStatus(accountStatusUpdateRequestDto, customerId);
	}
}
