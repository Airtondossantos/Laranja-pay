package com.airton.laranja_pay.repository;

import com.airton.laranja_pay.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountModel, UUID> {
}
