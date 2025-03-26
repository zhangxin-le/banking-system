/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.model;

import lombok.Data;

import java.util.List;

@Data
public class Transactions {
    List<Transaction> transactions;

    // 实际项目需加密使用
    Long cursor;
}
