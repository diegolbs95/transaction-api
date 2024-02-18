package com.transaction.infra.exception;

public class WebClientException extends TransactionException{

    public WebClientException(String message) {
        super(message);
    }
}
