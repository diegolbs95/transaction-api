package com.transaction.usercase.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.infra.exception.UnauthorizedNotificationException;
import com.transaction.infra.exception.UnauthorizedTransactionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionAndNotificationValidateService {

    private final ObjectMapper objectMapper;

    public void validateTransaction(String request) {
        try {
            var rootNode = objectMapper.readTree(request);
            if (!"Autorizado".equalsIgnoreCase(rootNode.get("message").asText())){
                log.error("Unauthorized transaction.");
                throw new UnauthorizedTransactionException("Request Unauthorized transaction");
            }
        } catch (JsonProcessingException e) {
            throw new UnauthorizedTransactionException("Unauthorized transaction.");
        }
    }

    public void validateNotification(String request) {
        try {
            var rootNode = objectMapper.readTree(request);
            if (!"true".equalsIgnoreCase(rootNode.get("message").asText())){
                log.error("Unauthorized notification.");
                throw new UnauthorizedNotificationException("Unauthorized notification.");
            }
        } catch (JsonProcessingException e) {
            throw new UnauthorizedNotificationException("Request Unauthorized notification.");
        }
    }
}
