package com.airton.laranja_pay.useCase;

import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.model.Enum.TypeTransaction;
import com.airton.laranja_pay.model.TransactionModel;
import com.airton.laranja_pay.repository.AccountRepository;
import com.airton.laranja_pay.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class DepositUseCase {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public DepositUseCase(AccountRepository accountrRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountrRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void deposit(UUID id, BigDecimal value) {
        AccountModel account = accountRepository.findById(id).orElseThrow();
        account.setBalance(account.getBalance().add(value));
        accountRepository.save(account);

        TransactionModel transaction = new TransactionModel();
        transaction.setTypeTransaction(TypeTransaction.DEPOSIT);
        transaction.setValue(value);
        transaction.setReceiverAccount(account);
        transactionRepository.save(transaction);


    }
}
