package com.example.accountservice.service;

import com.example.accountservice.dto.OperationCreateDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.entity.Operation;
import com.example.accountservice.entity.OperationType;
import com.example.accountservice.mapper.OperationCreateMapper;
import com.example.accountservice.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OperationService {

    private final AccountService accountService;
    private final OperationRepository operationRepository;
    private final OperationCreateMapper operationCreateMapper;

    public ResponseEntity<?> executeAndSave(OperationCreateDto dto) {
        Account account = getAccountByNumber(dto.getAccountNumber());
        if(!account.getCurrency().equals(dto.getCurrency())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(dto.getOperationType().equals(OperationType.DEPOSITING)){
            return depositing(account, dto);
        }
        if(dto.getOperationType().equals(OperationType.WITHDRAWAL)) {
            return withdrawal(account, dto);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> withdrawal(Account account, OperationCreateDto dto) {
        if(account.getBalance().compareTo(dto.getAmount()) < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            BigDecimal newBalance =
                    account.getBalance().subtract(dto.getAmount()).setScale(2,  RoundingMode.HALF_UP);
            account.setBalance(newBalance);
            updateAccountAndSaveOperation(account, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    private ResponseEntity<?> depositing(Account account, OperationCreateDto dto) {
        BigDecimal newBalance =
                account.getBalance().add(dto.getAmount()).setScale(2,  RoundingMode.HALF_UP);
        account.setBalance(newBalance);
        updateAccountAndSaveOperation(account, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Account getAccountByNumber(String number) {
        return Optional.of(accountService.findByNumber(number)).orElseThrow();
    }

    private void updateAccountAndSaveOperation(Account account, OperationCreateDto operationCreateDto){
        Operation operation = operationCreateMapper.map(operationCreateDto);
        operation.setAccount(account);
        operationRepository.save(operation);
        accountService.update(account);
    }
}
