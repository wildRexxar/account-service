package com.example.accountservice.integration.service;

import com.example.accountservice.dto.AccountCreateDto;
import com.example.accountservice.entity.Currency;
import com.example.accountservice.integration.TestFather;
import com.example.accountservice.service.AccountService;
import com.example.accountservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class AccountServiceTest extends TestFather {

    private final AccountService accountService;
    private final PersonService personService;

    @Test
    void findByNumber(){
        var account = Optional.of(accountService.findByNumber("11113"));
        assertTrue(account.isPresent());
        var id = account.orElse(null).getId();
        assertEquals(id, 12L);
    }

    @Test
    void update(){
        var account = Optional.of(accountService.findByNumber("11113"));
        var balanceBeforeUpdate = account.orElse(null).getBalance();
        account.orElse(null).setBalance(new BigDecimal("333.33"));
        accountService.update(account.orElse(null));
        var updateAccount = account.orElse(null);
        assertNotNull(updateAccount);
        var balanceAfterUpdate = account.orElse(null).getBalance();
        assertEquals(balanceAfterUpdate,new BigDecimal("333.33"));
    }

    @Test
    void save(){
        var accountCreateDto = new AccountCreateDto(Currency.RUB, 11L);
        var newAccount = accountService.save(accountCreateDto);
        assertEquals(newAccount.getBalance(), new BigDecimal("0.00"));
        var personAfterAddAccount = Optional.of(personService.findById(11L)).orElse(null);
        assertNotNull(personAfterAddAccount);
        var accountSizeAfterSaveAccount = personAfterAddAccount.getAccountList().size();
        assertEquals(3, accountSizeAfterSaveAccount);
        var findAccRubAfter = personAfterAddAccount.getAccountList().stream().filter(acc -> acc.getCurrency().equals(Currency.RUB)).count();
        assertEquals(findAccRubAfter, 1);
    }
}
