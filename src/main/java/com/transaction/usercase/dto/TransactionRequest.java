package com.transaction.usercase.dto;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal value,
                                 String payer,
                                 String payee) {
}
