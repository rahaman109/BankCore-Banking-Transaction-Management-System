package com.alpha.accountservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "accounts")
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column(nullable = false)
	private int customerId;
	@Column(unique = true, nullable = false)
	private String accountNumber;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountType accountType;
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal accountBalance;

	public Account(int customerId, String accountNumber, AccountType accountType, AccountStatus accountStatus,
			BigDecimal accountBalance) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}

	public Account() {
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

}
