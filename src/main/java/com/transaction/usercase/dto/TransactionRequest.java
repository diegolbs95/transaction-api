package com.transaction.usercase.dto;

public record TransactionRequest(Double value,
                                 String payer,
                                 String payee) {
}
