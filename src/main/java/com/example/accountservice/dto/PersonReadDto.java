package com.example.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class PersonReadDto {
    private Long id;
    private String email;
    private List<AccountReadDto> accountList;
}
