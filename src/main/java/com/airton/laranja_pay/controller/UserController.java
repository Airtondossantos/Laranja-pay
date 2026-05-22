package com.airton.laranja_pay.controller;

import com.airton.laranja_pay.dto.AccountDto;
import com.airton.laranja_pay.dto.UserDto;
import com.airton.laranja_pay.model.UserModel;
import com.airton.laranja_pay.repository.AccountRepository;
import com.airton.laranja_pay.repository.UserRepository;
import com.airton.laranja_pay.useCase.CreateUserUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    private final UserRepository repository;
    private final AccountRepository accountrepository;
    private final CreateUserUseCase createUserUseCase;

    public UserController(UserRepository repository, AccountRepository accountrepository, CreateUserUseCase createUserUseCase) {
        this.repository = repository;
        this.accountrepository = accountrepository;
        this.createUserUseCase = createUserUseCase;
    }

    @GetMapping("{id}")
    public Optional<UserModel> GetUser(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto user) {
        createUserUseCase.createuser(user);
        return user;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    @GetMapping("/account/{id}")
    public AccountDto get(@PathVariable UUID id) {
        return new AccountDto(accountrepository.findById(id).orElseThrow());
    }
}
