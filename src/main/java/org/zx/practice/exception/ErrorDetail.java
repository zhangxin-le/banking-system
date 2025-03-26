/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.exception;

import lombok.Data;

@Data
public class ErrorDetail {
    String code;

    String msg;

    public ErrorDetail(TransactionException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public ErrorDetail(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
