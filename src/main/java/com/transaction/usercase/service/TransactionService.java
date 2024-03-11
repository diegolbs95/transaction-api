package com.transaction.usercase.service;

import com.transaction.infra.exception.PayerOrBeneficiaryDoesNotExistException;
import com.transaction.infra.persistence.domain.Transaction;
import com.transaction.infra.persistence.domain.User;
import com.transaction.infra.persistence.repository.TransactionRepository;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.transaction.infra.factory.TransactionFactory.transactionFactory;
import static com.transaction.infra.util.TransactionUtils.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserRepository repository;
    private final TransactionRepository transactionRepository;
    private final WebClientService webClientService;
    private final TransactionAndNotificationValidateService validate;

    public Transaction carryOutTransaction(TransactionDTO request) {

        var payer = findByUserOrCpfCnpj(request.payer());

        validatePayer(payer, request.value());
        validate.validateTransaction(webClientService.authorizer());
        log.info("Authorized transaction.");

        var payee = findByUserOrCpfCnpj(request.payee());

        executeTransaction(payer, payee, request.value());
        repository.saveAll(Arrays.asList(payer, payee));

        log.info(String.format("Successful transaction from Payer: %s, to Beneficiary: %s, in value: %s.",
                payer.getCpfCnpj(), payee.getCpfCnpj(), request.value()));

        validate.validateNotification(webClientService.notification());

        return transactionRepository.save(transactionFactory(payer, payee, request.value()));
    }

    private User findByUserOrCpfCnpj(String cpfCnpj){
        return repository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new PayerOrBeneficiaryDoesNotExistException("User not found with CPF or CNPJ."));
    }
}