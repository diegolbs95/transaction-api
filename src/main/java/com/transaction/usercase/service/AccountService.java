package com.transaction.usercase.service;

import com.transaction.infra.persistence.domain.Account;
import com.transaction.infra.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

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

    private static String generateAccountNumber() {
        var random = new Random();
        var numberAccount = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            numberAccount.append(random.nextInt(10));
        }
        return numberAccount.toString();
    }
}
