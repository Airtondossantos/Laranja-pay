package com.airton.laranja_pay.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DepositDto {

    private BigDecimal value;

    public DepositDto(BigDecimal value) {
        this.value = value;
    }

}
