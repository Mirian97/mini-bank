package com.ebanx.bankingSystem.dto;

import com.ebanx.bankingSystem.entity.Account;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventResponseDTO(Account origin, Account destination) {

}
