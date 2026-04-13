package com.airton.laranja_pay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String username;
    private String password;

    private AccountDto account;
}
