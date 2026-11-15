package com.alpha.customerservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "customers")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotBlank
	private String customerName;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String mobileNumber;
	@NotNull
	private LocalDate registrationDate;
	@NotBlank
	private String address;

	public Customer(@NotBlank String customerName, @NotBlank @Email String email, @NotBlank String mobileNumber,
			@NotNull LocalDate registrationDate, @NotBlank String address) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.registrationDate = registrationDate;
		this.address = address;
	}

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
