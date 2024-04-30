package com.example.accountservice.dto;

import com.example.accountservice.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountCreateDto {

     private Currency currency;
     private Long personId;
}
