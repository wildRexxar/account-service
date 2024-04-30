package com.example.accountservice.controller;

import com.example.accountservice.dto.OperationCreateDto;
import com.example.accountservice.dto.OperationReadDto;
import com.example.accountservice.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody OperationCreateDto operationCreateDto){
        return operationService.executeAndSave(operationCreateDto);
    }

}
