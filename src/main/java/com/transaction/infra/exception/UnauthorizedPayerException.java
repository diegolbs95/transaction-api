package com.transaction.infra.exception;

public class UnauthorizedPayerException extends TransactionException{

    public UnauthorizedPayerException(String message) {
        super(message);
    }
}
