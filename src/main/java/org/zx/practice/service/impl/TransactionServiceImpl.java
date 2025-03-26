/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.service.impl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zx.practice.exception.ErrorCode;
import org.zx.practice.exception.TransactionException;
import org.zx.practice.model.Transaction;
import org.zx.practice.model.TransactionStatus;
import org.zx.practice.model.Transactions;
import org.zx.practice.repository.TransactionRepository;
import org.zx.practice.service.TransactionService;
import org.zx.practice.vo.CreateTransactionRequest;
import org.zx.practice.vo.UpdateTransactionRequest;

import java.util.Objects;
import java.util.Random;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository repository;

    static Random random = new Random();

    @Override
    public Transaction createTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setCategory(request.getCategory());
        transaction.setAmount(request.getAmount());
        transaction.setIp(request.getIp());
        transaction.setOperateId(request.getOperateId());
        transaction.setDescription(request.getDescription());
        long time = System.currentTimeMillis();
        transaction.setCreateTime(time);
        transaction.setModifyTime(time);
        transaction.setStatus(TransactionStatus.PROCESS);
        transaction.setId(time + random.nextInt(90000) + 10000);
        repository.save(transaction);
        return transaction;
    }

    @Override
    public void deleteTransaction(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new TransactionException(ErrorCode.TRANSACTION_NOT_EXIST);
    }

    @Override
    public Transaction updateTransaction(Long id, UpdateTransactionRequest request) {
        if (!repository.existsById(id)) {
            throw new TransactionException(ErrorCode.TRANSACTION_NOT_EXIST);
        }
        Transaction transaction = repository.getById(id);
        if (Strings.isNotBlank(request.getCategory())) {
            transaction.setCategory(request.getCategory());
        }
        if (Objects.nonNull(request.getAmount())) {
            transaction.setAmount(request.getAmount());
        }
        if (Strings.isNotBlank(request.getIp())) {
            transaction.setIp(request.getIp());
        }
        if (Strings.isNotBlank(request.getOperateId())) {
            transaction.setOperateId(request.getOperateId());
        }
        if (Strings.isNotBlank(request.getDescription())) {
            transaction.setDescription(request.getDescription());
        }
        if (Objects.nonNull(request.getStatus())) {
            transaction.setStatus(request.getStatus());
        }
        long time = System.currentTimeMillis();
        transaction.setModifyTime(time);
        repository.save(transaction);
        return transaction;
    }

    @Override
    public Transactions listTransactions(Long cursor) {
        return repository.list(cursor);
    }
}
