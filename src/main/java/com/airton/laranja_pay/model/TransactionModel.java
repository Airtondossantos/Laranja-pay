package com.airton.laranja_pay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "transactions")
@Getter
@Setter
public class TransactionModel {

    @Id
    private UUID id;
    private BigDecimal value;


    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private AccountModel senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private AccountModel receiverAccount;
}
