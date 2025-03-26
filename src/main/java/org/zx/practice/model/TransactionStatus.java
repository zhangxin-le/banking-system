/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.model;

public enum TransactionStatus {
    FAILED(0),

    SUCCESS(1),

    CANCEL(2),

    PROCESS(3);

    private final int code;

    TransactionStatus(int code) {
        this.code = code;
    }
}
