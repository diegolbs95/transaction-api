package com.transaction.usercase.service;

import com.transaction.infra.exception.PayerOrBeneficiaryDoesNotExistException;
import com.transaction.infra.persistence.domain.User;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.transaction.infra.util.TransactionValidation.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class CarryOutTransactionService {

    private final UserRepository repository;
    private final WebClientService webClientService;

    public String carryOutTransaction(TransactionRequest request){

        var payer = findByUserOrCpfCnpj(request.payer());
        var payee = findByUserOrCpfCnpj(request.payee());

        validatePayer(payer);
        validateBalance(payer.getAccount().getBalance(), request.value());

         validadeTransaction(webClientService.authorizer());
         log.info("Authorized transaction.");

         executeTransaction(payer, payee, request.value());
         log.info(String.format("Successful transaction from Payer: %s, to Beneficiary: %s, in value: %s.",
                 payer, payee, request.value()));

         if (!webClientService.notification()) {
             log.error("Notification service unavailable.");
         }

        return "Transaction completed successfully.";
    }

    private User findByUserOrCpfCnpj(String cpfCnpj){
        return repository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new PayerOrBeneficiaryDoesNotExistException("User not found with CPF or CNPJ."));
    }

    private void executeTransaction(User payer, User payee, BigDecimal value){
        log.info("Carrying out the subtraction of the payer’s value");
        payer.getAccount().setBalance(payer.getAccount().getBalance().subtract(value));
        log.info("Execute transaction");
        payee.getAccount().setBalance(payee.getAccount().getBalance().add(value));
    }
}
