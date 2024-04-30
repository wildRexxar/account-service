package com.example.accountservice.dto;

import com.example.accountservice.entity.Currency;
import com.example.accountservice.entity.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OperationCreateDto {

    private BigDecimal amount;
    private Currency currency;
    private OperationType operationType;
    private String accountNumber;

}
