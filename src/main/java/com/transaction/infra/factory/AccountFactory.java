package com.transaction.infra.factory;

import com.transaction.infra.persistence.domain.Account;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.transaction.infra.util.GenerateAccountNumber.generateAccountNumber;

@UtilityClass
public class AccountFactory {

    public static Account accountFactory(String cpfCnpj, DateTimeFormatter formatter) {
        return Account.builder()
                .accountNumber(generateAccountNumber())
                .balance(new BigDecimal("100.0"))
                .cpfCnpjHolder(cpfCnpj)
                .openDate(LocalDateTime.now().format(formatter))
                .build();
    }
}
