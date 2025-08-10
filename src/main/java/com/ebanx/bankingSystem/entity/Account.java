package com.ebanx.bankingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
  @Column(nullable = false, unique = true)
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
