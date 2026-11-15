package com.alpha.customerservice.requestDto;

import java.time.LocalDate;

public class CustomerDto {

	private String customerName;
	private String email;
	private String mobileNumber;
	private LocalDate registrationDate;
	private String address;

	public CustomerDto(String customerName, String email, String mobileNumber, LocalDate registrationDate,
			String address) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.registrationDate = registrationDate;
		this.address = address;
	}

	public CustomerDto() {
		super();
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

	@Override
	public String toString() {
		return "CustomerDto [customerName=" + customerName + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", registrationDate=" + registrationDate + ", address=" + address + "]";
	}

}
