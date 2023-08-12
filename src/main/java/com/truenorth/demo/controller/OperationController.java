package com.truenorth.demo.controller;

import com.truenorth.demo.dto.OperationRequest;
import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping("/")
    public ResponseEntity performOperation(@RequestBody OperationRequest operationRequest, Principal principal) {
        try {
            String username = principal.getName();
            BigDecimal operationResponse = operationService
                    .performOperation(OperationType.valueOf(operationRequest.getOperationType()),
                            operationRequest.getAmount(),
                            username);
            return ResponseEntity.ok(operationResponse);
        }catch (Throwable e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getCause());
        }
    }
}