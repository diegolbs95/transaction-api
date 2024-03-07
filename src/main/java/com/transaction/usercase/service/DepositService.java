package com.transaction.usercase.service;

import com.transaction.infra.exception.PayerOrBeneficiaryDoesNotExistException;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DepositService {

    private final UserRepository repository;

    public String deposite(TransactionDTO request) {

        var payee = repository.findByCpfCnpj(request.payee())
                .orElseThrow(() -> new PayerOrBeneficiaryDoesNotExistException("User not found with CPF or CNPJ."));

        log.info("Making deposit to Beneficiary: " + request.payee() + "in value: " + request.value());
        payee.getAccount().setBalance(payee.getAccount().getBalance().add(request.value()));
        repository.save(payee);
        log.info("Deposite completed successfully.");

        return "Deposite completed successfully.";
    }
}
