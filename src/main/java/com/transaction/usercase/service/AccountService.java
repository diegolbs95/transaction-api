package com.transaction.usercase.service;

import com.transaction.infra.persistence.domain.Account;
import com.transaction.infra.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.transaction.infra.factory.AccountFactory.accountFactory;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    @Transactional
    public Account createAccount(String cpfCnpj) {

        var account =  accountFactory(cpfCnpj);
        return repository.save(account);
    }
}
