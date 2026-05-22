package com.airton.laranja_pay.model;

import com.airton.laranja_pay.model.Enum.TypeTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private LocalDateTime createdAt = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    @JsonIgnore
    private AccountModel senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    @JsonIgnore
    private AccountModel receiverAccount;
}
