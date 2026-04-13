package com.airton.laranja_pay.useCase;

import com.airton.laranja_pay.dto.UserDto;
import com.airton.laranja_pay.model.AccountModel;
import com.airton.laranja_pay.model.UserModel;
import com.airton.laranja_pay.repository.AccountRepository;
import com.airton.laranja_pay.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Getter
@Setter
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public CreateUserUseCase(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void creatUser(UserDto user){

        UserModel userModel = new UserModel();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());
        userRepository.save(userModel);

        AccountModel account = new AccountModel();
        account.setUser(userModel);
        account.setBalance(BigDecimal.valueOf(0));
        accountRepository.save(account);
    }
}
