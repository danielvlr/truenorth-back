package com.truenorth.demo.service;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    private static final int RANDOM_STRING_LENGTH = 10;

    public String performActualOperation(OperationType type) {
        switch (type) {
            case ADDITION:
                return "Result of addition";
            case SUBTRACTION:
                return "Result of subtraction";
            case MULTIPLICATION:
                return "Result of multiplication";
            case DIVISION:
                return "Result of division";
            case SQUARE_ROOT:
                return "Result of square root";
            case RANDOM_STRING:
                return generateRandomString();
            default:
                throw new IllegalArgumentException("Invalid operation type");
        }
    }

    public String performOperation(OperationType type, String username) {
        User user = userService.findByUsername(username);
        Operation operation = findByType(type);

        double operationCost = operation.getCost();
        double userBalance = getUserBalance(user);

        if (userBalance < operationCost) {
            return "Insufficient balance";
        }

        double newUserBalance = userBalance - operationCost;

        String operationResponse = performActualOperation(type);

        recordService.createRecord(user, operation, operationCost, newUserBalance, operationResponse);

        return operationResponse;
    }

    private double getUserBalance(User user) {
        Record record = recordService.getLastRecordsByUser(user);
        return record.getUserBalance();
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
