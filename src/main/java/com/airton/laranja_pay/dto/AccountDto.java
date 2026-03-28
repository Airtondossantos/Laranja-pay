package com.airton.laranja_pay.dto;

import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.model.TransactionModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AccountDto {
    private UUID id;
    private String userName;
    private BigDecimal balance;
    private List<TransactionModel> receivertransactions;
    private List<TransactionModel> sendertransactions;

    public AccountDto(AccountModel account) {
        this.id = account.getId();
        this.userName = account.getUser().getUsername();
        this.balance = account.getBalance();
    }

}
