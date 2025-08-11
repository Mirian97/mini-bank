package com.ebanx.bankingSystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventResponseDTO(AccountDTO origin, AccountDTO destination) {

}
