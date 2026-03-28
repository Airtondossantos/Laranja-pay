package com.airton.laranja_pay.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    private BigDecimal value;

    public PaymentDto(BigDecimal value) {
        this.value = value;
    }
}
