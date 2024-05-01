package com.example.accountservice.dto;

import com.example.accountservice.entity.Currency;
import com.example.accountservice.entity.OperationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Schema(description = "Operation create dto")
@Getter
@AllArgsConstructor
public class OperationCreateDto {

    @Schema(description = "Sum operation.", example = "9.99", minimum = "0.01")
    private BigDecimal amount;
    @Schema(description = "Currency operation must be: USD, BYN, EUR, RUB.", example = "BYN")
    private Currency currency;
    @Schema(description = "Type operation must be DEPOSITING or WITHDRAWAL.", example = "DEPOSITING")
    private OperationType operationType;
    @Schema(description = "Account uniq number. Must exist from current person.", example = "359e8ed0-f5f4-4dd3-acdf-85154da1fff6")
    private String accountNumber;

}
