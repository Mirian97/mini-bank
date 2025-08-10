package com.ebanx.bankingSystem.mapper;

import com.ebanx.bankingSystem.entity.Account;
import com.ebanx.bankingSystem.entity.Transaction;
import com.ebanx.bankingSystem.entity.TransferType;

public class TransactionMapper {
  public static Transaction toEntity(TransferType type, Long amount, Account origin, Account destination) {
    Transaction transaction = new Transaction();
    transaction.setType(type);
    transaction.setAmount(amount);
    transaction.setOrigin(origin);
    transaction.setDestination(destination);
    return transaction;
  }
}
