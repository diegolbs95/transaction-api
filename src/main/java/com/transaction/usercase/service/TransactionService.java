package com.transaction.usercase.service;

import com.transaction.infra.persistence.domain.Transaction;
import com.transaction.infra.persistence.repository.TransactionRepository;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final UserService userService;
    private final TransactionAndNotificationValidateService validate;

    @Transactional
    public Transaction carryOutTransaction(TransactionDTO request) {

        var payer = userService.findByUserOrCpfCnpj(request.payer());

        validatePayer(payer, request.value());
        validate.validateTransaction(webClientService.authorizer());
        log.info("Authorized transaction.");

        var payee = userService.findByUserOrCpfCnpj(request.payee());

        executeTransaction(payer, payee, request.value());
        repository.saveAll(Arrays.asList(payer, payee));

        log.info(String.format("Successful transaction from Payer: %s, to Beneficiary: %s, in value: %s.",
                payer.getCpfCnpj(), payee.getCpfCnpj(), request.value()));

        validate.validateNotification(webClientService.notification());

        return transactionRepository.save(transactionFactory(payer, payee, request.value()));
    }
}