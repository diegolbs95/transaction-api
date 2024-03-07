package com.transaction.infra.util;

import com.transaction.infra.exception.TransactionException;
import com.transaction.infra.exception.UnauthorizedPayerException;
import com.transaction.infra.persistence.domain.User;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
@UtilityClass
public class TransactionUtils {

    public static void validatePayer(User user, BigDecimal value){

        log.info("Validation if the user is a legal entity.");
        if (user.getUserType().getCode().equals(1)) {
            log.error("User with CNPJ: " + user.getCpfCnpj() + " not authorized");
            throw new UnauthorizedPayerException("Retailer type users cannot make transfers, only receive.");
        }

        log.info("Validation if transaction value is greater than available balance.");
        if (user.getAccount().getBalance().compareTo(value) < 0) {
            throw new TransactionException("Transaction value is greater than available balance. Balance: "
                    + user.getAccount().getBalance() + " Transaction: " + value.toString());
        }
    }

    public static void executeTransaction(User payer, User payee, BigDecimal value){
        log.info("Carrying out the subtraction of the payer’s value");
        payer.getAccount().setBalance(payer.getAccount().getBalance().subtract(value));
        log.info("Execute transaction");
        payee.getAccount().setBalance(payee.getAccount().getBalance().add(value));
    }
}