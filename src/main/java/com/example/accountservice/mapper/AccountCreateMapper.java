package com.example.accountservice.mapper;

import com.example.accountservice.dto.AccountCreateDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Person;
import com.example.accountservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountCreateMapper implements Mapper<AccountCreateDto, Account>{

    private final PersonRepository personRepository;
    @Override
    public Account map(AccountCreateDto dto) {
        Account account = new Account();
        account.setCurrency(dto.getCurrency());
        account.setBalance(new BigDecimal("0.00"));
        account.setNumber(UUID.randomUUID().toString());
        account.setPerson(getPerson(dto.getPersonId()));
        account.setOperationList(new ArrayList<>());
        return account;
    }

    private Person getPerson(Long personId) {
        return personRepository.findById(personId).orElse(null);
    }
}
