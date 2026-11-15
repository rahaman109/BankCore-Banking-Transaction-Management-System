package com.alpha.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.customerservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// for registration
	boolean existsByEmail(String email);
	boolean  existsByMobileNumber(String mobileNumber);
	
	// for update customer
    boolean existsByEmailAndCustomerIdNot(String email, int customerId);
    boolean existsByMobileNumberAndCustomerIdNot(String mobileNumber, int customerId);
}
