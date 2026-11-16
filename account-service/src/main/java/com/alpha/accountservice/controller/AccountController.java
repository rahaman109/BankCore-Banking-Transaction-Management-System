package com.alpha.accountservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.accountservice.entity.AccountStatus;
import com.alpha.accountservice.entity.AccountType;
import com.alpha.accountservice.requestdto.AccountRequestDto;
import com.alpha.accountservice.requestdto.AccountStatusUpdateRequestDto;
import com.alpha.accountservice.responsedto.AccountDetailsResponseDto;
import com.alpha.accountservice.responsedto.AccountResponseDto;
import com.alpha.accountservice.responsedto.CheckAccountStatusResponseDto;
import com.alpha.accountservice.responsedto.GetAccountBalanceResponseDto;
import com.alpha.accountservice.responsedto.ResponseStructure;
import com.alpha.accountservice.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	// constructor DI
	final private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	// account creation
	@PostMapping("/create")
	public ResponseStructure<AccountResponseDto> accountCreate(@RequestBody AccountRequestDto accountRequestDto) {
		return accountService.accountCreate(accountRequestDto);
	}

	// get all accounts
	@GetMapping("/getallaccounts")
	public ResponseStructure<List<AccountDetailsResponseDto>> getAllAccount() {
		return accountService.getAllAccounts();
	}

	// get account by account ID
	@GetMapping("/getaccountbyid")
	public ResponseStructure<AccountDetailsResponseDto> getAccountById(@RequestParam int accountId) {
		return accountService.getAccountById(accountId);
	}

	// get accounts by customer ID
	@GetMapping("/getaccountsbycustomerid")
	public ResponseStructure<List<AccountDetailsResponseDto>> getAccountsByCustomerId(@RequestParam int customerId) {
		return accountService.getAccountsByCustomerId(customerId);
	}

	// update status
	@PatchMapping("/updatestatus")
	public ResponseStructure<List<AccountDetailsResponseDto>> updateStatus(
			@RequestBody AccountStatusUpdateRequestDto accountStatusUpdateRequestDto, @RequestParam int customerId) {
		return accountService.updateStatus(accountStatusUpdateRequestDto, customerId);
	}

	// close bank account
	@PatchMapping("/closebankaccount")
	public ResponseStructure<AccountDetailsResponseDto> closeBankAccoount(@RequestParam int accountId) {
		return accountService.closeBankAccount(accountId);
	}

	// get account balance
	@GetMapping("/getaccountbalance")
	public ResponseStructure<GetAccountBalanceResponseDto> getAccountBalance(@RequestParam int accountId) {
		return accountService.getAccountBalance(accountId);
	}

	// check account status
	@GetMapping("/checkaccountstatus")
	public ResponseStructure<CheckAccountStatusResponseDto> checkAccountStatus(@RequestParam int accountId) {
		return accountService.checkAccountStatus(accountId);
	}

	// account exist
	@GetMapping("/accountexist")
	public ResponseStructure<Boolean> accountExists(@RequestParam int accountId) {
		return accountService.accountExists(accountId);
	}

	// Get Accounts By AccountType
	@GetMapping("/accountsbyaccounttype")
	public ResponseStructure<List<AccountDetailsResponseDto>> getAccountsByAccountType(
			@RequestParam AccountType accountType) {
		return accountService.getAccountsByAccountType(accountType);
	}
	
	// get active accounts
	@GetMapping("/activeaccounts")
	public ResponseStructure<List<AccountDetailsResponseDto>> activeAccounts(@RequestParam AccountStatus accountStatus)
	{
		return accountService.getActiveAccounts(accountStatus);
	}
}
