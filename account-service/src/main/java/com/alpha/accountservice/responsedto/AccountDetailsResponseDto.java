package com.alpha.accountservice.responsedto;

import java.math.BigDecimal;

import com.alpha.accountservice.entity.AccountStatus;
import com.alpha.accountservice.entity.AccountType;

public class AccountDetailsResponseDto {

	private int accountId;
	private int customerId;
	private String accountNumber;
	private AccountType accountType;
	private AccountStatus accountStatus;
	private BigDecimal accountBalance;
	public AccountDetailsResponseDto(int accountId, int customerId, String accountNumber, AccountType accountType,
			AccountStatus accountStatus, BigDecimal accountBalance) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}
	public AccountDetailsResponseDto() {
		super();
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "AccountDetailsResponseDto [accountId=" + accountId + ", customerId=" + customerId + ", accountNumber="
				+ accountNumber + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountBalance=" + accountBalance + "]";
	}

}
