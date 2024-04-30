package com.example.accountservice.dto;

import com.example.accountservice.entity.Currency;
import com.example.accountservice.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class AccountReadDto {

    private String number;
    private BigDecimal balance;
    private Currency currency;
    private List<OperationReadDto> accountList;

}
