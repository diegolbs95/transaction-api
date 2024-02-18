package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.TransactionController;
import com.transaction.usercase.dto.TransactionRequest;
import com.transaction.usercase.service.CarryOutTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

    private final CarryOutTransactionService service;

    @Override
    @PostMapping("/transaction")
    public String CarryOutTransaction(TransactionRequest request) {

        log.info("Transaction service initialized.");
        var response = service.carryOutTransaction(request);
        log.info("Transaction service completed.");
        return response;
    }
}
