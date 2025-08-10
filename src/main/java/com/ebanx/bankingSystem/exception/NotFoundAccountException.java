package com.ebanx.bankingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundAccountException extends RuntimeException {

  public NotFoundAccountException(String message) {
    super(message);
  }

  public NotFoundAccountException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundAccountException(Long id) {
    super("Account with id " + id + " not found");
  }
}
