package com.ebanx.bankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.bankingSystem.dto.EventResponseDTO;
import com.ebanx.bankingSystem.dto.TransactionDTO;
import com.ebanx.bankingSystem.service.TransactionService;

@RestController
@RequestMapping("/event")
public class EventController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping
  public ResponseEntity<EventResponseDTO> createEvent(@RequestBody TransactionDTO dto) {
    return ResponseEntity.ok().body(transactionService.create(dto));
  }
}
