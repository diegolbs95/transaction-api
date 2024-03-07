package com.transaction.infra.controller;

import com.transaction.usercase.dto.TransactionDTO;

public interface DepositController {

    String executeDeposit(TransactionDTO request);
}
