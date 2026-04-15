package com.airton.laranja_pay.controller;

import com.airton.laranja_pay.model.TransactionModel;
import com.airton.laranja_pay.useCase.DepositUseCase;
import com.airton.laranja_pay.useCase.PaymentUseCase;
import com.airton.laranja_pay.dto.DepositDto;

import com.airton.laranja_pay.dto.PaymentDto;
import com.airton.laranja_pay.useCase.StatementUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/v1/laranjapay")
public class PayControler {

    private final DepositUseCase depositUseCase;
    private final PaymentUseCase paymentUseCase;
    private final StatementUseCase StatementUseCase;

    public PayControler(DepositUseCase depositUseCase, PaymentUseCase paymentUseCase, StatementUseCase statementUseCase) {
        this.depositUseCase = depositUseCase;
        this.paymentUseCase = paymentUseCase;
        StatementUseCase = statementUseCase;
    }

    @PostMapping("/{id}")
    public String deposit(@PathVariable UUID id, @RequestBody DepositDto depositDto) {
        depositUseCase.deposit(id, depositDto.getValue());
        return "Deposito realizado com sucesso";
    }

    @PostMapping("/v1/{idSender}")
    public String payment(@PathVariable UUID idSender, @RequestBody PaymentDto paymentDto) {
        paymentUseCase.payment(idSender, paymentDto.getIdReceiver(), paymentDto);
        return "Pagamento realizado com sucesso";
    }

    @GetMapping("/{id}/statement")
    public Page<TransactionModel> statement(@PathVariable UUID id, Pageable pageable){
        return StatementUseCase.getStatement(id ,pageable);
    }
}
