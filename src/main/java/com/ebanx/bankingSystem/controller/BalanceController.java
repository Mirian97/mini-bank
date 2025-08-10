package com.ebanx.bankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.bankingSystem.service.AccountService;

@RestController
@RequestMapping("/balance")
public class BalanceController {

  @Autowired
  private AccountService accountService;

  @GetMapping
  public ResponseEntity<Long> getBalance(@RequestParam Long accountId) {
    return ResponseEntity.ok().body(accountService.getBalance(accountId));
  }
}
