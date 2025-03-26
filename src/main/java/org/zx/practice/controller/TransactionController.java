/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zx.practice.model.Transaction;
import org.zx.practice.model.Transactions;
import org.zx.practice.service.TransactionService;
import org.zx.practice.vo.CreateTransactionRequest;
import org.zx.practice.vo.UpdateTransactionRequest;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<Transaction> createTransaction(@RequestBody @NotNull @Valid CreateTransactionRequest request){
        return new ResponseEntity<>(transactionService.createTransaction(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable @NotNull Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody @NotNull UpdateTransactionRequest request,
        @PathVariable @NotNull Long id) {
        return new ResponseEntity<>(transactionService.updateTransaction(id, request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Transactions> listTransactions(@RequestParam(required = false) Long cursor){
        return new ResponseEntity<>(transactionService.listTransactions(cursor), HttpStatus.OK);
    }
}
