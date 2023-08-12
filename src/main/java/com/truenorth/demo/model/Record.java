package com.truenorth.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
@Getter @Setter
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal userBalance;

    @Column(nullable = false)
    private BigDecimal operationResponse;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private boolean deleted = false; // Default value is false
}