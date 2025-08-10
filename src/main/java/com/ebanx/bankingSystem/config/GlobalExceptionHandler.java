
package com.ebanx.bankingSystem.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ebanx.bankingSystem.exception.NotFoundAccountException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundAccountException.class)
  public ResponseEntity<Long> handleNotFoundAccountException(NotFoundAccountException ex) {
    return new ResponseEntity<>(0L, HttpStatus.NOT_FOUND);
  }
}
