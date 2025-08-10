package com.ebanx.bankingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanx.bankingSystem.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
