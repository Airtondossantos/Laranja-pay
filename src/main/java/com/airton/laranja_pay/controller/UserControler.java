package com.airton.laranja_pay.controller;

import com.airton.laranja_pay.dto.AccountDto;
import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.model.UserModel;
import com.airton.laranja_pay.repository.AccountRepository;
import com.airton.laranja_pay.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserControler {


    private final UserRepository repository;
    private final AccountRepository accountrepository;

    public UserControler(UserRepository repository, AccountRepository accountrepository) {
        this.repository = repository;
        this.accountrepository = accountrepository;
    }

    @GetMapping("{id}")
    public Optional<UserModel> GetUser(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @PostMapping
    public UserModel create(@RequestBody UserModel user) {
       repository.save(user);
       return user;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    @GetMapping("/account/{id}")
    public AccountDto get(@PathVariable UUID id){
        return new AccountDto(accountrepository.findById(id).orElseThrow());
    }
}
