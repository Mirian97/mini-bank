package com.ebanx.bankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.bankingSystem.repositories.AccountRepository;
import com.ebanx.bankingSystem.repositories.TransactionRepository;

@RestController
@RequestMapping("/reset")
public class ResetController {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private TransactionRepository transactionRepository;

  @PostMapping
  public ResponseEntity<String> reset() {
    accountRepository.deleteAll();
    transactionRepository.deleteAll();
    return ResponseEntity.ok().body("OK");
  }
}
