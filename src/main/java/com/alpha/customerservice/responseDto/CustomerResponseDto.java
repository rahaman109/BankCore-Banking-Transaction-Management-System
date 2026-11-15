package com.alpha.customerservice.responseDto;

public class CustomerResponseDto {

	private int customerId;
	private String customerName;

	public CustomerResponseDto(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public CustomerResponseDto() {
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

	@Override
	public String toString() {
		return "CustomerResponseDto [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

}
