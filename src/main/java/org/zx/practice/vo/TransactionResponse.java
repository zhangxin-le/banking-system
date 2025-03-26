/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponse {
    private long id;

    private String category;

    private BigDecimal amount;

    private String sendAccountId;

    private String receiverAccountId;

    private BigDecimal transactionFee;

    private String description;

    private String operateId;

    private String ip;

    private String channel;
}
