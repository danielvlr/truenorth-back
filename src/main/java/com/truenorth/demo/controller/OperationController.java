package com.truenorth.demo.controller;

import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @GetMapping("/{type}")
    public ResponseEntity<String> performOperation(@PathVariable OperationType type, Principal principal) {
        String username = principal.getName();
        String operationResponse = operationService.performOperation(type, username);

        if ("Insufficient balance".equals(operationResponse)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(operationResponse);
        }

        return ResponseEntity.ok(operationResponse);
    }
}