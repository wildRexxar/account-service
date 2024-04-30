package com.example.accountservice.mapper;

import com.example.accountservice.dto.OperationCreateDto;
import com.example.accountservice.entity.Operation;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class OperationCreateMapper implements Mapper<OperationCreateDto, Operation>{
    @Override
    public Operation map(OperationCreateDto dto) {
        Operation operation = new Operation();
        operation.setCurrency(dto.getCurrency());
        operation.setAmount(dto.getAmount().setScale(2, RoundingMode.HALF_UP));
        operation.setOperationType(dto.getOperationType());
        operation.setDateOfCreation(new Timestamp(new Date().getTime()));
        return operation;
    }
}
