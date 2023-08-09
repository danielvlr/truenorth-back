package com.truenorth.demo.repository;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.enumeration.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findByType(OperationType type);
}