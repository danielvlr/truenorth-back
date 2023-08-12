package com.truenorth.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class OperationRequest {
    private String operationType;
    private BigDecimal amount;
}