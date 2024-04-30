package com.example.accountservice.dto;

import com.example.accountservice.entity.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class OperationReadDto {
    private BigDecimal amount;
    private OperationType operationType;
    private Timestamp dateOfCreation;
}
