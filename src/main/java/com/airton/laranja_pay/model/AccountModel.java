package com.airton.laranja_pay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "accounts")
@Getter
@Setter
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiverAccount")
    private List<TransactionModel> receivertransactions;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "senderAccount")
    private List<TransactionModel> sendertransactions;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
