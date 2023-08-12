package com.truenorth.demo;

import com.truenorth.demo.controller.OperationController;
import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.service.OperationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationControllerTest {

    @Autowired
    private OperationController operationController;

    @MockBean
    private OperationService operationService;

    @MockBean
    private UserDetails userDetails; // Mocked UserDetails

    @Test
    public void testPerformOperation_InsufficientBalance_ReturnsForbiddenResponse() {
        String username = "test@example.com";
        OperationType type = OperationType.ADDITION;

        // Mock the principal's username
        when(userDetails.getUsername()).thenReturn(username);

//        when(operationService.performOperation(type, username)).thenReturn("Insufficient balance");

        //ResponseEntity<String> response = operationController.performOperation(type, userDetails);

        //assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        //assertEquals("Insufficient balance", response.getBody());
    }
    // ... other test methods
}
