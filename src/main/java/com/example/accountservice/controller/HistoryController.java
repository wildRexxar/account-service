package com.example.accountservice.controller;

import com.example.accountservice.dto.PersonReadDto;
import com.example.accountservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/history")
@RequiredArgsConstructor
public class HistoryController {

    private final PersonService personService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonReadDto getUserHistoryById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

}
