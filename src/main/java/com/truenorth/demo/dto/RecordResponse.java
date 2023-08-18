package com.truenorth.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.truenorth.demo.model.Operation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RecordResponse implements Serializable {
    private Operation operation;
    private BigDecimal amount;
    private BigDecimal userBalance;
    private BigDecimal operationResponse;
    private LocalDateTime date;
    private Boolean deleted;
}
