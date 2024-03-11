package com.transaction.infra.controller;

import com.transaction.infra.persistence.domain.Transaction;
import com.transaction.usercase.dto.TransactionDTO;

public interface TransactionController {

    Transaction carryOutTransaction(TransactionDTO request);
}
