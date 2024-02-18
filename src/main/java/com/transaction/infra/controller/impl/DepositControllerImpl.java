package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.DepositController;
import com.transaction.usercase.dto.TransactionRequest;
import com.transaction.usercase.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class DepositControllerImpl implements DepositController {

    private final DepositService service;

    @Override
    @PostMapping("/deposite")
    public String executeDeposit(@RequestBody TransactionRequest request) {

        log.info("Deposit service started");
        var response = service.deposite(request);
        log.info("Deposit service completed");
        return response;
    }
}
