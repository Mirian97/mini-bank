package com.ebanx.bankingSystem.dto;

import com.ebanx.bankingSystem.entity.TransferType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TransactionDTO(
    @NotBlank TransferType type,
    @Positive Long amount,
    Long origin,
    Long destination) {
}
