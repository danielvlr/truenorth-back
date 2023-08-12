package com.truenorth.demo.service;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    private static final int RANDOM_STRING_LENGTH = 10;

    public BigDecimal performActualOperation(OperationType type, BigDecimal amount, BigDecimal lastOperationResponse) {
        switch (type) {
            case ADDITION:
                return lastOperationResponse.add(amount);
            case SUBTRACTION:
                return lastOperationResponse.subtract(amount);
            case MULTIPLICATION:
                return lastOperationResponse.multiply(amount);
            case DIVISION:
                return lastOperationResponse.divide(amount);
            case SQUARE_ROOT:
                return lastOperationResponse.sqrt(MathContext.DECIMAL32);
            case RANDOM_STRING:
                return BigDecimal.ZERO;

            //return generateRandomString();
            default:
                throw new IllegalArgumentException("Invalid operation type");
        }
    }

    public BigDecimal performOperation(OperationType type, BigDecimal amount, String username) {
        User user = userService.findByUsername(username);
        Operation operation = findByType(type);

        BigDecimal operationCost = operation.getCost();
        BigDecimal userBalance = getUserBalance(user);

        if (userBalance.compareTo(operationCost)<0) {
            new RuntimeException("Insufficient balance");
        }

        BigDecimal newUserBalance = userBalance.subtract(operationCost);

        BigDecimal lastOperationResponse = recordService.getLastOperationResponseByUser(user);

        BigDecimal operationResponse = performActualOperation(type, amount, lastOperationResponse);

        recordService.createRecord(user, operation, operationCost, newUserBalance, operationResponse);

        return operationResponse;
    }

    private BigDecimal getUserBalance(User user) {
        return recordService.getLastRecordsByUser(user).map(Record::getUserBalance).orElse(BigDecimal.valueOf(1000));
    }

    public Operation findByType(OperationType type) {
        return operationRepository.findByType(type)
                .orElseThrow(() -> new RuntimeException("Operation not found"));
    }

    private String generateRandomString() {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int index = (int) (Math.random() * allowedChars.length());
            randomString.append(allowedChars.charAt(index));
        }

        return randomString.toString();
    }
}
