package com.ebanx.bankingSystem.mapper;

import com.ebanx.bankingSystem.dto.AccountDTO;
import com.ebanx.bankingSystem.entity.Account;

public class AccountMapper {
  public static AccountDTO toDto(Account account) {
    return new AccountDTO(account.getId(), account.getBalance());
  }
}
