package com.airton.laranja_pay.controller;

import com.airton.laranja_pay.UseCase.DepositUseCase;
import com.airton.laranja_pay.UseCase.PaymentUseCase;
import com.airton.laranja_pay.dto.DepositDto;

import com.airton.laranja_pay.dto.PaymentDto;
import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/v1/laranjapay")
public class PayControler {

    private final AccountRepository accountRepository;
    private final DepositUseCase depositUseCase;
    private final PaymentUseCase paymentUseCase;

    public PayControler(AccountRepository accountRepository, DepositUseCase depositUseCase, PaymentUseCase paymentUseCase) {
        this.accountRepository = accountRepository;
        this.depositUseCase = depositUseCase;
        this.paymentUseCase = paymentUseCase;
    }

    @PatchMapping("/{id}")
    public String deposit(@PathVariable UUID id, @RequestBody DepositDto depositDto) {
        depositUseCase.deposit(id, depositDto.getValue());
        return "Deposito realizado com sucesso";
    }

    @PostMapping("/v2/{idSender}")
    public String payment(@PathVariable UUID idSender, @RequestBody PaymentDto paymentDto) {
        paymentUseCase.payment(idSender, paymentDto.getIdReceiver(), paymentDto);
        return "Pagamento realizado com sucesso";
    }

    @PostMapping("/account")
    public AccountModel createNewAccount(@RequestBody AccountModel account){
        accountRepository.save(account);
        return account;
    }

}
