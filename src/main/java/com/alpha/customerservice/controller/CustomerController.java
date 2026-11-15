package com.alpha.customerservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.customerservice.requestDto.CustomerDto;
import com.alpha.customerservice.responseDto.CustomerResponseDto;
import com.alpha.customerservice.responseDto.ResponseStructure;
import com.alpha.customerservice.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	// constructor DI
	final private CustomerService customerService;
	
	public CustomerController(CustomerService customerService)
	{
		this.customerService = customerService;
	}
	
	
	// registration
	@PostMapping("/registration")
	public ResponseStructure<CustomerResponseDto> customerRegistration(@Valid @RequestBody CustomerDto customerDto)
	{
		return customerService.customerRegistration(customerDto);
	}
	
	// get all customers
	@GetMapping("/getallcustomers")
	public ResponseStructure<List<CustomerResponseDto>> getAllCustomers()
	{
		 return customerService.getAllCustomers();
	}
	
	// get customer by id
	@GetMapping("/getcustomerbyid")
	public ResponseStructure<CustomerResponseDto> getCustomerById(@RequestParam int customerId)
	{
		return customerService.getCustomerById(customerId);
	}
	
	// update customer 
	@PutMapping("/update")
	public ResponseStructure<CustomerResponseDto> updateCustomer(@Valid @RequestParam int customerId, @RequestBody CustomerDto customerDto)
	{ 
		return customerService.updateCustomer(customerId, customerDto);
	}
	
	// delete customer 
	@DeleteMapping("/delete")
	public ResponseStructure<CustomerResponseDto> deleteCustomer(@RequestParam int customerId)
	{
		return customerService.deleteCustomer(customerId);
	}
}
