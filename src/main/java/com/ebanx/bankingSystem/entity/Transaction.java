package com.ebanx.bankingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private TransferType type;

  @Column(nullable = false)
  private Long amount;

  @ManyToOne
  @JoinColumn(name = "origin_account_id")
  private Account origin;

  @ManyToOne
  @JoinColumn(name = "destination_account_id")
  private Account destination;

  public Transaction(TransferType type, Long amount, Account origin, Account destination) {
    this.type = type;
    this.amount = amount;
    this.origin = origin;
    this.destination = destination;
  }
}
