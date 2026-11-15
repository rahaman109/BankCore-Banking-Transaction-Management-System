package com.alpha.accountservice.requestdto;

import com.alpha.accountservice.entity.AccountStatus;

public class AccountStatusUpdateRequestDto {

	private AccountStatus accountStatus;

	public AccountStatusUpdateRequestDto(AccountStatus accountStatus) {
		super();
		this.accountStatus = accountStatus;
	}

	public AccountStatusUpdateRequestDto() {
		super();
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "AccountStatusUpdateRequestDto [accountStatus=" + accountStatus + "]";
	}

}
