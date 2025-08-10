package com.ebanx.bankingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.bankingSystem.service.AccountService;

@RestController
@RequestMapping("/event")
public class EventController {

  @Autowired
  private AccountService accountService;

}
