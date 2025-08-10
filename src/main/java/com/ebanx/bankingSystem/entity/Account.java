package com.ebanx.bankingSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long balance;

  public boolean hasSufficientBalance(Long amount) {
    return this.getBalance() >= amount;
  }

  public Account deposit(Long amount) {
    this.setBalance(this.getBalance() + amount);
    return this;
  }

  public Account withdraw(Long amount) {
    this.setBalance(this.getBalance() - amount);
    return this;
  }

  public Account transfer(Account destination, Long amount) {
    this.setBalance(this.getBalance() - amount);
    destination.setBalance(this.getBalance() + amount);
    return this;
  }
}
