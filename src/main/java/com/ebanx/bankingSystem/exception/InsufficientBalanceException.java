package com.ebanx.bankingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends IllegalArgumentException {

  public InsufficientBalanceException(String message) {
    super(message);
  }

  public InsufficientBalanceException(Long accountId) {
    super("Account with id " + accountId + " has insufficient balance");
  }

  public InsufficientBalanceException(String message, Throwable cause) {
    super(message, cause);
  }
}
