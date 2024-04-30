package com.example.accountservice.service;

import com.example.accountservice.dto.AccountCreateDto;
import com.example.accountservice.dto.AccountReadDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.mapper.AccountCreateMapper;
import com.example.accountservice.mapper.AccountReadMapper;
import com.example.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountCreateMapper accountCreateMapper;
    private final AccountReadMapper accountReadMapper;

    @Transactional
    public AccountReadDto save(AccountCreateDto accountCreateDto) {
        return Optional.of(accountCreateDto)
                .map(accountCreateMapper::map)
                .map(accountRepository::save)
                .map(accountReadMapper::map)
                .orElseThrow();
    }

    public Account findByNumber(String number) {
       return accountRepository.findByNumber(number);
    }

    @Transactional
    public void update(Account account) {
        accountRepository.save(account);
    }
}
