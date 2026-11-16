package com.alpha.accountservice.responsedto;

import com.alpha.accountservice.entity.AccountStatus;

public class CheckAccountStatusResponseDto {

	private int accountId;
	private AccountStatus accountStatus;

	public CheckAccountStatusResponseDto(int accountId, AccountStatus accountStatus) {
		super();
		this.accountId = accountId;
		this.accountStatus = accountStatus;
	}

	public CheckAccountStatusResponseDto() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "CheckAccountStatusResponseDto [accountId=" + accountId + ", accountStatus=" + accountStatus + "]";
	}

}
