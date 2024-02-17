package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.TransactionController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TransactionControllerImpl implements TransactionController {

    @Override
    @PostMapping("transaction")
    public String CarryOutTransaction(String valor) {
        return null;
    }
}
