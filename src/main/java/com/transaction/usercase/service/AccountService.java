package com.transaction.usercase.service;

import com.transaction.infra.persistence.domain.Account;
import com.transaction.infra.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.transaction.infra.util.GenerateAccountNumber.generateAccountNumber;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account created(String cpfCnpj) {

        var account =  Account.builder()
                .accountNumber(generateAccountNumber())
                .balance(new BigDecimal("100.0"))
                .cpfCnpjHolder(cpfCnpj)
                .openDate(LocalDateTime.now().toString())
                .build();
        return repository.save(account);
    }
}
