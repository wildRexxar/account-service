package com.example.accountservice.dto;

import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonCreateDto {
     private String email;
     private DocumentType documentType;
     private String documentNumber;
     private List<Account> accountList;
}
