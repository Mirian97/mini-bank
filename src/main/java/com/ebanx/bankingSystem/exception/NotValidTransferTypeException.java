package com.ebanx.bankingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotValidTransferTypeException extends IllegalArgumentException {

  public NotValidTransferTypeException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotValidTransferTypeException(String value) {
    super("Invalid value for transfer type: " + value);
  }
}
