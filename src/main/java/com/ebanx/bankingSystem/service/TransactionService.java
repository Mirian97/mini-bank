package com.ebanx.bankingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.bankingSystem.dto.EventResponseDTO;
import com.ebanx.bankingSystem.dto.TransactionDTO;
import com.ebanx.bankingSystem.entity.Account;
import com.ebanx.bankingSystem.entity.Transaction;
import com.ebanx.bankingSystem.exception.InsufficientBalanceException;
import com.ebanx.bankingSystem.repositories.AccountRepository;
import com.ebanx.bankingSystem.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private AccountService accountService;

  @Transactional()
  public EventResponseDTO create(TransactionDTO dto) {
    return switch (dto.type()) {
      case deposit -> processDeposit(dto);
      case withdraw -> processWithdraw(dto);
      case transfer -> processTransfer(dto);
    };
  }

  private EventResponseDTO processDeposit(TransactionDTO dto) {
    Account destination = accountService.findOrCreate(dto.destination());
    destination.deposit(dto.amount());
    transactionRepository
        .save(new Transaction(dto.type(), dto.amount(), null, destination));

    return new EventResponseDTO(
        null,
        accountRepository.save(destination));
  }

  private EventResponseDTO processWithdraw(TransactionDTO dto) {
    Account origin = accountService.getOne(dto.origin());

    if (!origin.hasSufficientBalance(dto.amount())) {
      throw new InsufficientBalanceException(origin.getId());
    }

    origin.withdraw(dto.amount());
    transactionRepository
        .save(new Transaction(dto.type(), dto.amount(), origin, null));

    return new EventResponseDTO(
        accountRepository.save(origin),
        null);
  }

  private EventResponseDTO processTransfer(TransactionDTO dto) {
    Account destination = accountService.getOne(dto.origin());
    Account origin = accountService.getOne(dto.origin());

    if (!origin.hasSufficientBalance(dto.amount())) {
      throw new InsufficientBalanceException(origin.getId());
    }
    origin.transfer(destination, dto.amount());
    transactionRepository
        .save(new Transaction(dto.type(), dto.amount(), origin, destination));

    return new EventResponseDTO(
        accountRepository.save(origin),
        accountRepository.save(destination));
  }
}
