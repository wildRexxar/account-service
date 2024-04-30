package com.example.accountservice.mapper;

import com.example.accountservice.dto.AccountReadDto;
import com.example.accountservice.dto.PersonReadDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonReadMapper implements Mapper<Person, PersonReadDto> {

    private final AccountReadMapper accountReadMapper;

    @Override
    public PersonReadDto map(Person person) {
        return new PersonReadDto(
                person.getId(),
                person.getEmail(),
                getListAccountReadDto(person.getAccountList()));
    }

    private List<AccountReadDto> getListAccountReadDto(List<Account> accountList) {
        return accountList
                .stream()
                .map(accountReadMapper::map)
                .collect(Collectors.toList());
    }
}
