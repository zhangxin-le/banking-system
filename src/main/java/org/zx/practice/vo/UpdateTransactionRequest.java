/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.zx.practice.model.TransactionStatus;

import java.math.BigDecimal;

@Data
public class UpdateTransactionRequest {
    @NotBlank
    private String category;

    private BigDecimal amount;

    private TransactionStatus status;

    private String description;

    private String operateId;

    private String ip;
}
