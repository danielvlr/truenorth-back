package com.truenorth.demo;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.enumeration.OperationType;
import com.truenorth.demo.repository.OperationRepository;
import com.truenorth.demo.service.OperationService;
import com.truenorth.demo.service.RecordService;
import com.truenorth.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class OperationServiceTest {

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private UserService userService;

    @Mock
    private RecordService recordService;

    @InjectMocks
    private OperationService operationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByType_TypeExists_ReturnsOperation() {
        OperationType type = OperationType.ADDITION;
        Operation operation = new Operation();
        operation.setType(type);

        when(operationRepository.findByType(type)).thenReturn(java.util.Optional.of(operation));

        Operation foundOperation = operationService.findByType(type);

        assertEquals(type, foundOperation.getType());
    }
}
