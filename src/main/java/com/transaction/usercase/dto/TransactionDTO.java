package com.transaction.usercase.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value,
                             String payer,
                             String payee) {
}
