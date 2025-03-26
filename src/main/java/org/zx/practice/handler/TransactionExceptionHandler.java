/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.zx.practice.exception.ErrorCode;
import org.zx.practice.exception.ErrorDetail;
import org.zx.practice.exception.TransactionException;

@RestControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handler(Exception e) {
        if (e instanceof TransactionException) {
            return new ResponseEntity<>(new ErrorDetail((TransactionException) e), HttpStatus.BAD_REQUEST);
        }
        if (e instanceof HandlerMethodValidationException) {
            return new ResponseEntity<>(new ErrorDetail(ErrorCode.PARAM_VALID), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ErrorDetail(ErrorCode.SERVER_BUSY), HttpStatus.BAD_REQUEST);
    }
}
