package com.alpha.accountservice.responsedto;

import java.math.BigDecimal;

public class GetAccountBalanceResponseDto {

	private int accountId;
	private String accountNumber;
	private BigDecimal accountBalance;

	public GetAccountBalanceResponseDto(int accountId, String accountNumber, BigDecimal accountBalance) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public GetAccountBalanceResponseDto() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "GetAccountBalanceResponseDto [accountId=" + accountId + ", accountNumber=" + accountNumber
				+ ", accountBalance=" + accountBalance + "]";
	}

}
