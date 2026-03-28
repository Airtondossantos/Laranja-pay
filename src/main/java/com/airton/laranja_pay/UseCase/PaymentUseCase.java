package com.airton.laranja_pay.UseCase;

import com.airton.laranja_pay.dto.PaymentDto;
import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class PaymentUseCase {

    private final AccountRepository accountRepository;

    public PaymentUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void payment(UUID id, PaymentDto paymentDto) {
        AccountModel account = accountRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado"));
        account.setBalance(account.getBalance().subtract(paymentDto.getValue()));
        accountRepository.save(account);

    }


}
