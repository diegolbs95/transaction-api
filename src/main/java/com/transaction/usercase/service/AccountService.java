package com.transaction.usercase.service;

import com.transaction.infra.persistence.domain.Account;
import com.transaction.infra.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.transaction.infra.util.GenerateAccountNumber.generateAccountNumber;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    @Transactional
    public Account created(String cpfCnpj) {

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        var account =  Account.builder()
                .accountNumber(generateAccountNumber())
                .balance(new BigDecimal("100.0"))
                .cpfCnpjHolder(cpfCnpj)
                .openDate(LocalDateTime.now().format(formatter))
                .build();
        return repository.save(account);
    }
}
