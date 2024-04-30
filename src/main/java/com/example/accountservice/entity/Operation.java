package com.example.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "operation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "opertype")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Column(name = "date_of_creation")
    private Timestamp dateOfCreation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}
