/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.exception;

public enum ErrorCode {
    PARAM_VALID("01001", "param valid"),
    TRANSACTION_NOT_EXIST("02001", "transaction not exist"),
    TRANSACTION_EXIST("02002", "transaction exist"),
    SERVER_BUSY("03001", "server is busy");

    private String code;

    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
