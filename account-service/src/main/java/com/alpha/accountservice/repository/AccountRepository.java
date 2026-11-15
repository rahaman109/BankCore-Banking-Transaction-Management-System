package com.alpha.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.accountservice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	
	boolean existsByAccountNumber(String accountNumber);
	boolean existsByCustomerId(int customerId);
	List<Account> findByCustomerId(int customerId);
	
    @Query(value = "SELECT nextval('account_number_seq')", nativeQuery = true)
    long getNextAccountNumber();
}
