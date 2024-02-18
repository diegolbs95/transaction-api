package com.transaction.infra.exception;

public class UnauthorizedNotificationException extends TransactionException{

    public UnauthorizedNotificationException(String message) {
        super(message);
    }
}
