package com.example.accountservice.repository;

import com.example.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {

    @Query(value  = "SELECT a.* FROM account a WHERE a.number = :number",
    nativeQuery = true)
    Account findByNumber(String number);
}
