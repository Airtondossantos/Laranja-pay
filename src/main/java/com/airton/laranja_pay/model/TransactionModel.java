package com.airton.laranja_pay.model;

import com.airton.laranja_pay.model.Enum.TypeTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "transactions")
@Getter
@Setter
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private BigDecimal value;
    private TypeTransaction typeTransaction;


    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private AccountModel senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private AccountModel receiverAccount;
}
