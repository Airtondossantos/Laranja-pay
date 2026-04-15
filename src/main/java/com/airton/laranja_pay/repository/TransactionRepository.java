package com.airton.laranja_pay.repository;


import com.airton.laranja_pay.model.TransactionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {

    Page<TransactionModel> findDistinctBySenderAccountIdOrReceiverAccountId(
            UUID senderAccount,
            UUID receiverAccount,
            Pageable pageable);
}
