package com.transaction.infra.exception;

public class UnauthorizedTransactionException extends TransactionException{

    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}
