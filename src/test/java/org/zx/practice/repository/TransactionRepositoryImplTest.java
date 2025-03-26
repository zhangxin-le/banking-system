/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.repository;

import org.junit.jupiter.api.*;
import org.zx.practice.model.Transaction;
import org.zx.practice.model.TransactionStatus;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionRepositoryImplTest {
    static TransactionRepositoryImpl repository = new TransactionRepositoryImpl();
    static Transaction transaction;
    @BeforeAll
    static void setUp() {
        transaction = new Transaction();
        transaction.setId(123123123L);
        transaction.setStatus(TransactionStatus.CANCEL);
        transaction.setIp("10.0.0.1");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void save() {
        repository.save(transaction);
        Assertions.assertEquals(1, repository.list(null).getTransactions().size());
    }

    @Test
    @Order(2)
    void existsById() {
        Assertions.assertTrue(repository.existsById(transaction.getId()));
    }


    @Test
    @Order(3)
    void list() {
        Assertions.assertEquals(1, repository.list(null).getTransactions().size());
    }

    @Test
    @Order(4)
    void getById() {
        Assertions.assertEquals(transaction.getId(), repository.getById(transaction.getId()).getId());
    }

    @Test
    @Order(5)
    void deleteById() {
        repository.deleteById(transaction.getId());
        Assertions.assertEquals(0, repository.list(null).getTransactions().size());
    }
}