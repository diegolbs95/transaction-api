package com.transaction.infra.exception;

import com.transaction.usercase.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PayerOrBeneficiaryDoesNotExistException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(PayerOrBeneficiaryDoesNotExistException ex) {

        ErrorResponse errorResponse = new ErrorResponse(NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }
}
