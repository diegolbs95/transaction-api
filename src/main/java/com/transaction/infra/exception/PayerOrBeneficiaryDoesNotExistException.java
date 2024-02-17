package com.transaction.infra.exception;

public class PayerOrBeneficiaryDoesNotExistException extends TransactionException{

    public PayerOrBeneficiaryDoesNotExistException(String message) {
        super(message);
    }
}
