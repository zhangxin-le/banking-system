/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private long id;

    private String category;

    private BigDecimal amount;

    private long createTime;

    private long modifyTime;

    private TransactionStatus status;

    private String description;

    private String operateId;

    private String ip;

    public Transaction(){
    }

    public Transaction(long id, String category, BigDecimal amount, long createTime, long modifyTime,
                       TransactionStatus status, String description, String operateId, String ip) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.status = status;
        this.description = description;
        this.operateId = operateId;
        this.ip = ip;
    }
}
