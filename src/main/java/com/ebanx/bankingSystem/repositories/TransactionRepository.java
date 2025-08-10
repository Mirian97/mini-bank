package com.ebanx.bankingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanx.bankingSystem.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
