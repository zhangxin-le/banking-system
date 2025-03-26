/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.exception;

public class TransactionException extends RuntimeException {
    private String code;

    public TransactionException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public TransactionException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public String getCode() {
        return code;
    }
}
