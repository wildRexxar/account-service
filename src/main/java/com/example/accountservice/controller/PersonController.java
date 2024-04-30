package com.example.accountservice.controller;


import com.example.accountservice.dto.PersonCreateDto;
import com.example.accountservice.dto.PersonReadDto;
import com.example.accountservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonReadDto create(@RequestBody PersonCreateDto person){
        return personService.save(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return personService.delete(id)
                ? noContent().build()
                : notFound().build();
    }

}
