package com.transaction.infra.factory;

import com.transaction.infra.persistence.domain.Transaction;
import com.transaction.infra.persistence.domain.User;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class TransactionFactory {

    public static Transaction transactionFactory(User sender, User receiver, BigDecimal value){
        var dateTimeFormate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Transaction.builder()
                .sender(sender)
                .receiver(receiver)
                .value(value)
                .transactionDateTime(LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormate)))
                .build();
    }
}