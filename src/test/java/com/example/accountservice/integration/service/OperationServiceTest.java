package com.example.accountservice.integration.service;

import com.example.accountservice.dto.OperationCreateDto;
import com.example.accountservice.entity.Currency;
import com.example.accountservice.entity.OperationType;
import com.example.accountservice.integration.TestFather;
import com.example.accountservice.service.AccountService;
import com.example.accountservice.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class OperationServiceTest extends TestFather {

    private final OperationService operationService;
    private final AccountService accountService;

    @Test
    void executeAndSaveDepositing(){
        var operation1 = new OperationCreateDto(new BigDecimal("100.00"),
                Currency.USD, OperationType.DEPOSITING, "11111");
        operationService.executeAndSave(operation1);
        var account1 = accountService.findByNumber("11111");
        assertEquals(account1.getOperationList().size(), 3);
        var operation2 = new OperationCreateDto(new BigDecimal("9.00"),
                Currency.USD, OperationType.WITHDRAWAL, "11111");
        operationService.executeAndSave(operation2);
        var account2 = accountService.findByNumber("11111");
        assertEquals(account2.getBalance(), new BigDecimal("91.00"));
    }
}
