package com.transaction.infra.exception;

import com.transaction.usercase.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PayerOrBeneficiaryDoesNotExistException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(PayerOrBeneficiaryDoesNotExistException ex) {

        ErrorResponse errorResponse = new ErrorResponse(NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedPayerException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(UnauthorizedPayerException ex) {

        ErrorResponse errorResponse = new ErrorResponse(FORBIDDEN, ex.getMessage());
        return new ResponseEntity<>(errorResponse, FORBIDDEN);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(TransactionException ex) {

        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(UnauthorizedTransactionException ex) {

        ErrorResponse errorResponse = new ErrorResponse(UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<>(errorResponse, UNAUTHORIZED);
    }
}
