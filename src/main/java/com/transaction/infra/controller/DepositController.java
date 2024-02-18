package com.transaction.infra.controller;

import com.transaction.usercase.dto.TransactionRequest;

public interface DepositController {

    String executeDeposit(TransactionRequest request);
}
