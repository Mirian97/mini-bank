package com.ebanx.bankingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.bankingSystem.entity.Account;
import com.ebanx.bankingSystem.exception.NotFoundAccountException;
import com.ebanx.bankingSystem.repositories.AccountRepository;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public Account getOne(Long accountId) {
    return accountRepository
        .findById(accountId)
        .orElseThrow(() -> new NotFoundAccountException(accountId));
  }

  public Long getBalance(Long accountId) {
    return accountRepository
        .findById(accountId)
        .map(Account::getBalance).orElse(0L);
  }

  public Account findOrCreate(Long accountId) {
    return accountRepository
        .findById(accountId)
        .orElseGet(() -> accountRepository.save(new Account(accountId, 0L)));
  }

}
