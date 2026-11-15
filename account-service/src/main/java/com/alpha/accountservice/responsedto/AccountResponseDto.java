package com.alpha.accountservice.responsedto;

public class AccountResponseDto {

	private int accountId;
	private int customerId;
	private String accountNumber;

	public AccountResponseDto(int accountId, String accountNumber, int customerId) {
		super();
		this.accountId = accountId;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public AccountResponseDto() {
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

	@Override
	public String toString() {
		return "AccountResponseDto [accountId=" + accountId + ", customerId=" + customerId + ", accountNumber="
				+ accountNumber + "]";
	}

}
