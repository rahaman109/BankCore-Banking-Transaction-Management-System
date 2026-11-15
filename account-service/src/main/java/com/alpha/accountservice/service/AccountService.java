package com.alpha.accountservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.alpha.accountservice.entity.Account;
import com.alpha.accountservice.exception.AccountNotFoundException;
import com.alpha.accountservice.entity.AccountStatus;
import com.alpha.accountservice.repository.AccountRepository;
import com.alpha.accountservice.requestdto.AccountRequestDto;
import com.alpha.accountservice.requestdto.AccountStatusUpdateRequestDto;
import com.alpha.accountservice.responsedto.AccountDetailsResponseDto;
import com.alpha.accountservice.responsedto.AccountResponseDto;
import com.alpha.accountservice.responsedto.ResponseStructure;

@Service
public class AccountService {

	// constructor DI
	private final AccountRepository accountRepository;
	private final RestClient customerRestClient;

	public AccountService(AccountRepository accountRepository, RestClient customerRestClient) {
		this.accountRepository = accountRepository;
		this.customerRestClient = customerRestClient;
	}

	// generate unique account number using TIMESTAMP
	private String generateAccountNumber() {

		long sequenceNumber = accountRepository.getNextAccountNumber();
		long timeStamp = System.currentTimeMillis();
		
		return "AC" + timeStamp + sequenceNumber;
	}

	// for customerId verification, I used RESTCLIENT spring framework tool
	private void verifyCustomerExists(int customerId) {

		try {
			customerRestClient.get().uri("/customer/getcustomerbyid?customerId={customerId}", customerId).retrieve()
					.toBodilessEntity();

		} catch (HttpClientErrorException.NotFound ex) {
			throw new RuntimeException("Customer not found. Customer ID: " + customerId);
		}
	}

	// account creation
	public ResponseStructure<AccountResponseDto> accountCreate(AccountRequestDto accountRequestDto) {

		verifyCustomerExists(accountRequestDto.getCustomerId());
		
		Account account = new Account();

		account.setCustomerId(accountRequestDto.getCustomerId());
		account.setAccountNumber(generateAccountNumber());
		account.setAccountType(accountRequestDto.getAccountType());
		account.setAccountStatus(AccountStatus.ACTIVE);
		account.setAccountBalance(BigDecimal.ZERO);

		Account saveAccount = accountRepository.save(account);

		AccountResponseDto responseDto = new AccountResponseDto();

		responseDto.setCustomerId(saveAccount.getCustomerId());
		responseDto.setAccountId(saveAccount.getAccountId());
		responseDto.setAccountNumber(saveAccount.getAccountNumber());

		return new ResponseStructure<>(HttpStatus.CREATED.value(), "Account Created", responseDto);
	}

	// get all accounts
	public ResponseStructure<List<AccountDetailsResponseDto>> getAllAccounts() {
		
		List<Account> accounts = accountRepository.findAll();
		List<AccountDetailsResponseDto> responseDtos = new ArrayList<AccountDetailsResponseDto>();
		
		for (Account account : accounts)
		{
			AccountDetailsResponseDto accountDetailsResponseDto = new AccountDetailsResponseDto();
			
			accountDetailsResponseDto.setCustomerId(account.getCustomerId());
			accountDetailsResponseDto.setAccountId(account.getAccountId());
			accountDetailsResponseDto.setAccountNumber(account.getAccountNumber());
			accountDetailsResponseDto.setAccountType(account.getAccountType());
			accountDetailsResponseDto.setAccountStatus(account.getAccountStatus());
			accountDetailsResponseDto.setAccountBalance(account.getAccountBalance());
			
			responseDtos.add(accountDetailsResponseDto);
		}
		
		return new ResponseStructure<>(
				HttpStatus.OK.value(),
				"Here All Customer Accounts",
				responseDtos);
	}

	// get account by using accountId
	public ResponseStructure<AccountDetailsResponseDto> getAccountById(int accountId) {
		
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(
				"Account Not Found, Account ID: " + accountId));
		
		AccountDetailsResponseDto responseDto = new AccountDetailsResponseDto();
		
		responseDto.setAccountId(account.getAccountId());
		responseDto.setCustomerId(account.getCustomerId());
		responseDto.setAccountNumber(account.getAccountNumber());
		responseDto.setAccountStatus(account.getAccountStatus());
		responseDto.setAccountBalance(account.getAccountBalance());
		responseDto.setAccountType(account.getAccountType());
		
		return new ResponseStructure<>(
				HttpStatus.OK.value(),
				"Here Customer Account Details",
				responseDto);
		
	}

	// get accounts by customer ID
	public ResponseStructure<List<AccountDetailsResponseDto>> getAccountsByCustomerId(int customerId) {
		
		verifyCustomerExists(customerId);
		List<Account> accounts = accountRepository.findByCustomerId(customerId);
		
		List<AccountDetailsResponseDto> accountDeatilsResponseDtos = accounts.stream().map(
						account -> 
						{
							AccountDetailsResponseDto responseDto = new AccountDetailsResponseDto();
							responseDto.setAccountId(account.getAccountId());
							responseDto.setCustomerId(account.getCustomerId());
							responseDto.setAccountNumber(account.getAccountNumber());
							responseDto.setAccountType(account.getAccountType());
							responseDto.setAccountStatus(account.getAccountStatus());
							responseDto.setAccountBalance(account.getAccountBalance());
							
							return responseDto;
						}).toList();
		
		return new ResponseStructure<>(
				HttpStatus.OK.value(),
				"Here Account Details Based on customer id: " + customerId,
				accountDeatilsResponseDtos);
	}

	// update account status
	public ResponseStructure<List<AccountDetailsResponseDto>> updateStatus(AccountStatusUpdateRequestDto accountStatusUpdateRequestDto, int customerId) {
		
		verifyCustomerExists(customerId);
		List<Account> accounts = accountRepository.findByCustomerId(customerId);
		
		if(accounts.isEmpty())
		{
			throw new AccountNotFoundException("No Accounts Founded, Based on Customer ID: " + customerId);
		}
		
		List<AccountDetailsResponseDto> accountDetailsResponseDtos = new ArrayList<AccountDetailsResponseDto>();
		
		for (Account account : accounts) {
			
			account.setAccountStatus(accountStatusUpdateRequestDto.getAccountStatus());
			
			accountRepository.save(account);
			
			AccountDetailsResponseDto responseDto = new AccountDetailsResponseDto();
			
			responseDto.setAccountId(account.getAccountId());
			responseDto.setCustomerId(account.getCustomerId());
			responseDto.setAccountNumber(account.getAccountNumber());
			responseDto.setAccountBalance(account.getAccountBalance());
			responseDto.setAccountType(account.getAccountType());
			responseDto.setAccountStatus(account.getAccountStatus());
			
			accountDetailsResponseDtos.add(responseDto);
		}
		
		return new ResponseStructure<>(
				HttpStatus.OK.value(),
				"No Accounts Found for Customer ID: " + customerId,
				accountDetailsResponseDtos);
	}
}
