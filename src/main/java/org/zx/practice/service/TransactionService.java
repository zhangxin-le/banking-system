/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.service;

import org.zx.practice.model.Transaction;
import org.zx.practice.model.Transactions;
import org.zx.practice.vo.CreateTransactionRequest;
import org.zx.practice.vo.UpdateTransactionRequest;

public interface TransactionService {
    Transaction createTransaction(CreateTransactionRequest request);

    void deleteTransaction(Long id);

    Transaction updateTransaction(Long id, UpdateTransactionRequest request);

    Transactions listTransactions(Long cursor);
}
