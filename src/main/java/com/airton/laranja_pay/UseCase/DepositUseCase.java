package com.airton.laranja_pay.UseCase;

import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class DepositUseCase {

    private final AccountRepository accountRepository;

    public DepositUseCase(AccountRepository accountrRepository) {
        this.accountRepository = accountrRepository;
    }

    public void deposit(UUID id, BigDecimal value) {
        AccountModel account = accountRepository.findById(id).orElseThrow();
        account.setBalance(account.getBalance().add(value));
        accountRepository.save(account);
    }
}
