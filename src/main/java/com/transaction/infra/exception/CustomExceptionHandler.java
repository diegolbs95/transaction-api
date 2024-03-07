package com.transaction.infra.exception;

import com.transaction.usercase.dto.ErrorResponseDTO;
import org.hibernate.JDBCException;
import org.postgresql.util.PSQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PayerOrBeneficiaryDoesNotExistException.class)
    public ResponseEntity<ErrorResponseDTO> handlePayerOrBeneficiaryDoesNotExistException(PayerOrBeneficiaryDoesNotExistException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedPayerException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorizedPayerException(UnauthorizedPayerException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(FORBIDDEN, ex.getMessage());
        return new ResponseEntity<>(errorResponse, FORBIDDEN);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorResponseDTO> handleTransactionException(TransactionException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorizedTransactionException(UnauthorizedTransactionException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<>(errorResponse, UNAUTHORIZED);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorResponseDTO> handlePSQLException(PSQLException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(CONFLICT, ex.getMessage());
        return new ResponseEntity<>(errorResponse, CONFLICT);
    }

    @ExceptionHandler(JDBCException.class)
    public ResponseEntity<ErrorResponseDTO> handleJdbc(JDBCException ex) {

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(CONFLICT,
                ex.getMessage().contains("CONSTRAINT_INDEX_8") ? "Conflict when adding user, CPF/CNPJ already exists in the database" :
                "Conflict when adding user, EMAIL already exists in the database");
        return new ResponseEntity<>(errorResponse, CONFLICT);
    }
}
