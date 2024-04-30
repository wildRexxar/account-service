package com.example.accountservice.mapper;

import com.example.accountservice.dto.AccountReadDto;
import com.example.accountservice.dto.OperationReadDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountReadMapper implements Mapper<Account, AccountReadDto>{

    private final OperationReadMapper operationReadMapper;

    @Override
    public AccountReadDto map(Account account) {
        return new AccountReadDto(account.getNumber(),
                account.getBalance().setScale(2,  RoundingMode.HALF_UP),
                account.getCurrency(),
                getOperationReadDto(account.getOperationList()));
    }

    private List<OperationReadDto> getOperationReadDto(List<Operation> operationList) {
        return Optional.of(operationList
                .stream()
                .map(operationReadMapper::map)
                .collect(Collectors.toList())).orElse(new ArrayList<>());

    }
}
