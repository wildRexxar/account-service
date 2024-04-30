package com.example.accountservice.mapper;

import com.example.accountservice.dto.OperationReadDto;
import com.example.accountservice.entity.Operation;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;

@Component
public class OperationReadMapper implements Mapper<Operation, OperationReadDto>{
    @Override
    public OperationReadDto map(Operation operation) {
        return new OperationReadDto(operation.getAmount().setScale(2, RoundingMode.HALF_UP),
                operation.getOperationType(),
                operation.getDateOfCreation());
    }
}
