/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.repository;

import org.springframework.stereotype.Repository;
import org.zx.practice.model.Transaction;
import org.zx.practice.model.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    private final Map<Long, Transaction> map = new ConcurrentHashMap<>(10000);

    private final int PAGE_SIZE = 2;

    @Override
    public boolean existsById(Long id) {
        return map.containsKey(id);
    }

    @Override
    public void save(Transaction transaction) {
        map.put(transaction.getId(), transaction);
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public Transactions list(Long cursor) {
        Transactions transactions = new Transactions();
        List<Transaction> result = new ArrayList<>();
        transactions.setTransactions(result);
        for (Map.Entry<Long, Transaction> entry : map.entrySet()) {
            if (cursor == null || entry.getValue().getCreateTime() > cursor) {
                result.add(entry.getValue());
            }
            if (result.size() == PAGE_SIZE) {
                transactions.setCursor(entry.getValue().getCreateTime());
                return transactions;
            }
        }
        return transactions;
    }

    @Override
    public Transaction getById(Long id) {
        return map.get(id);
    }
}
