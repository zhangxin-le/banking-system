/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.repository;


import org.springframework.stereotype.Repository;
import org.zx.practice.model.Transaction;
import org.zx.practice.model.Transactions;

@Repository
public interface TransactionRepository {
    boolean existsById(Long id);

    void save(Transaction transaction);

    void deleteById(Long id);

    Transactions list(Long cursor);

    Transaction getById(Long id);
}
