package com.airton.laranja_pay.UseCase;

import com.airton.laranja_pay.dto.PaymentDto;
import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.model.TransactionModel;
import com.airton.laranja_pay.repository.AccountRepository;
import com.airton.laranja_pay.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentUseCase {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public PaymentUseCase(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void payment(UUID idSender,UUID idReceiver, PaymentDto paymentDto) {
        AccountModel accountSender = accountRepository.findById(idSender).orElseThrow();
        AccountModel accountReceiver = accountRepository.findById(idReceiver).orElseThrow();

        accountSender.setBalance(accountSender.getBalance().subtract(paymentDto.getValue()));
        accountReceiver.setBalance(accountReceiver.getBalance().add(paymentDto.getValue()));
        accountRepository.save(accountSender);
        accountRepository.save(accountReceiver);

        TransactionModel transaction = new TransactionModel();
        transaction.setValue(paymentDto.getValue());
        transaction.setSenderAccount(accountSender);
        transaction.setReceiverAccount(accountReceiver);
        transactionRepository.save(transaction);
    }


}
