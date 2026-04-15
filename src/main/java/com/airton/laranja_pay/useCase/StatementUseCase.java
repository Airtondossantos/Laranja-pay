package com.airton.laranja_pay.useCase;

import com.airton.laranja_pay.model.TransactionModel;
import com.airton.laranja_pay.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatementUseCase {
    private final TransactionRepository TransactionRepository;

    public StatementUseCase(TransactionRepository transactionRepository) {
        TransactionRepository = transactionRepository;
    }

    public Page<TransactionModel> getStatement(UUID id, Pageable pageable) {
        return TransactionRepository.findDistinctBySenderAccountIdOrReceiverAccountId(id,id,pageable);
    }
}

