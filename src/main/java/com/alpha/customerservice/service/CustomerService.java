package com.alpha.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.customerservice.entity.Customer;
import com.alpha.customerservice.exception.CustomerEmailAlreadyExistExcepion;
import com.alpha.customerservice.exception.CustomerNotFoundException;
import com.alpha.customerservice.exception.CustomerNumberAlreadyExistException;
import com.alpha.customerservice.repository.CustomerRepository;
import com.alpha.customerservice.requestDto.CustomerDto;
import com.alpha.customerservice.responseDto.CustomerResponseDto;
import com.alpha.customerservice.responseDto.ResponseStructure;

@Service
public class CustomerService {

	// Constructor DI
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	// customer registration
	public ResponseStructure<CustomerResponseDto> customerRegistration(CustomerDto customerDto) {

		if (customerRepository.existsByEmail(customerDto.getEmail())) {
			throw new CustomerEmailAlreadyExistExcepion("Email already exists: " + customerDto.getEmail());
		}

		if (customerRepository.existsByMobileNumber(customerDto.getMobileNumber())) {
			throw new CustomerNumberAlreadyExistException("Mobile number exists: " + customerDto.getMobileNumber());
		}

		Customer customer = new Customer();

		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setAddress(customerDto.getAddress());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setRegistrationDate(customerDto.getRegistrationDate());

		Customer saveCustomer = customerRepository.save(customer);

		CustomerResponseDto responseDto = new CustomerResponseDto();

		responseDto.setCustomerId(saveCustomer.getCustomerId());
		responseDto.setCustomerName(saveCustomer.getCustomerName());

		return new ResponseStructure<>(HttpStatus.CREATED.value(), "Customer Registered Successfully", responseDto);
	}

	// get all customers
	public ResponseStructure<List<CustomerResponseDto>> getAllCustomers() {

		List<Customer> customers = customerRepository.findAll();

		List<CustomerResponseDto> responseDto = new ArrayList<CustomerResponseDto>();

		for (Customer customer : customers) {

			CustomerResponseDto response = new CustomerResponseDto();
			response.setCustomerId(customer.getCustomerId());
			response.setCustomerName(customer.getCustomerName());
			responseDto.add(response);
		}

		return new ResponseStructure<>(HttpStatus.OK.value(), "Here All customers", responseDto);
	}

	// get customer by id
	public ResponseStructure<CustomerResponseDto> getCustomerById(int customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not exist, Customer ID: " + customerId));

		CustomerResponseDto responseDto = new CustomerResponseDto();

		responseDto.setCustomerId(customer.getCustomerId());
		responseDto.setCustomerName(customer.getCustomerName());

		return new ResponseStructure<>(HttpStatus.OK.value(), "Here Customer Details", responseDto);
	}

	// update customer
	public ResponseStructure<CustomerResponseDto> updateCustomer(int customerId, CustomerDto customerDto) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not exist, Customer ID: " + customerId));

		if (customerRepository.existsByEmailAndCustomerIdNot(customerDto.getEmail(), customerId)) {

			throw new CustomerEmailAlreadyExistExcepion("Email already exists: " + customerDto.getEmail());
		}

		if (customerRepository.existsByMobileNumberAndCustomerIdNot(customerDto.getMobileNumber(), customerId)) {

			throw new CustomerNumberAlreadyExistException("Mobile number exists: " + customerDto.getMobileNumber());
		}
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setAddress(customerDto.getAddress());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setRegistrationDate(customerDto.getRegistrationDate());

		Customer saveCustomer = customerRepository.save(customer);

		CustomerResponseDto responseDto = new CustomerResponseDto();

		responseDto.setCustomerId(saveCustomer.getCustomerId());
		responseDto.setCustomerName(saveCustomer.getCustomerName());

		return new ResponseStructure<>(HttpStatus.OK.value(), "Customer Details Updated", responseDto);

	}

	// delete customer
	public ResponseStructure<CustomerResponseDto> deleteCustomer(int customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not exist, Customer ID: " + customerId));

		CustomerResponseDto responseDto = new CustomerResponseDto();

		responseDto.setCustomerId(customer.getCustomerId());
		responseDto.setCustomerName(customer.getCustomerName());
		customerRepository.delete(customer);

		return new ResponseStructure<>(HttpStatus.OK.value(), "Customer Deleted Successfully", responseDto);
	}
}
