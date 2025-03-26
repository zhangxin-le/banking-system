/*
 * Copyright (c) zx 2025 - 2025, All Rights Reserved.
 *
 */

package org.zx.practice.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionRequest {
    @NotBlank(message = "test")
    private String category;

    private BigDecimal amount;

    private String description;

    private String operateId;

    private String ip;
}
