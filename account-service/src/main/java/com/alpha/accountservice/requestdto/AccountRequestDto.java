package com.alpha.accountservice.requestdto;

import com.alpha.accountservice.entity.AccountType;

public class AccountRequestDto {

	private int customerId;
	private AccountType accountType;

	public AccountRequestDto(int customerId, AccountType accountType) {
		super();
		this.customerId = customerId;
		this.accountType = accountType;
	}

	public AccountRequestDto() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "AccountRequestDto [customerId=" + customerId + ", accountType=" + accountType + "]";
	}

}
