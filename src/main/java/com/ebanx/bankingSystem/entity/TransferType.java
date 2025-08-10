package com.ebanx.bankingSystem.entity;

import com.ebanx.bankingSystem.exception.NotValidTransferTypeException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransferType {
  deposit("DEPOSIT"),
  withdraw("WITHDRAW"),
  transfer("TRANSFER");

  private final String value;

  public static TransferType fromValue(String value) {
    for (TransferType group : TransferType.values()) {
      if (group.value.equalsIgnoreCase(value)) {
        return group;
      }
    }
    throw new NotValidTransferTypeException(value);
  }
}
