package com.transaction.infra.exception;

public class TransactionException extends RuntimeException {

    public TransactionException(String message) {
        super(message);
    }
}
