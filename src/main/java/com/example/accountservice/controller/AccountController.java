package com.example.accountservice.controller;

import com.example.accountservice.dto.AccountCreateDto;
import com.example.accountservice.dto.AccountReadDto;
import com.example.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountReadDto create(@RequestBody AccountCreateDto accountCreateDto){
        return accountService.save(accountCreateDto);
    }

}
