package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.TransactionController;
import com.transaction.usercase.dto.TransactionDTO;
import com.transaction.usercase.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

    private final TransactionService service;

    @Override
    @PostMapping("/transaction")
    public String carryOutTransaction(@RequestBody TransactionDTO request) {

        log.info("Transaction service initialized.");
        var response = service.carryOutTransaction(request);
        log.info("Transaction service completed.");
        return response;
    }
}
