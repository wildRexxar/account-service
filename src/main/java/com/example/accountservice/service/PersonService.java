package com.example.accountservice.service;

import com.example.accountservice.dto.PersonCreateDto;
import com.example.accountservice.dto.PersonReadDto;
import com.example.accountservice.mapper.PersonCreateMapper;
import com.example.accountservice.mapper.PersonReadMapper;
import com.example.accountservice.entity.Person;
import com.example.accountservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonCreateMapper personCreateMapper;
    private final PersonReadMapper personReadMapper;

    @Transactional
    public PersonReadDto save(PersonCreateDto personCreateDto) {
        return Optional.of(personCreateDto)
                .map(personCreateMapper::map)
                .map(personRepository::save)
                .map(personReadMapper::map)
                .orElseThrow();

    }

    public PersonReadDto findById(Long id) {
        return personRepository.findById(id)
                .filter(Person::getActive)
                .map(personReadMapper::map
                ).orElse(null);
    }

    @Transactional
    public boolean delete(Long id) {
        return personRepository.findById(id)
                .map(entity -> {
                    entity.setActive(false);
                    personRepository.saveAndFlush(entity);
                    return true;
                }).orElse(false);
    }
}