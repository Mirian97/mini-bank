package com.ebanx.bankingSystem.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import jakarta.validation.constraints.Positive;

public record AccountDTO(
    @JsonSerialize(using = ToStringSerializer.class) Long id,
    @Positive Long balance) {
}
