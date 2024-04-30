package com.example.accountservice.mapper;

import com.example.accountservice.dto.PersonCreateDto;
import com.example.accountservice.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class PersonCreateMapper implements Mapper<PersonCreateDto, Person>{

    @Override
    public Person map(PersonCreateDto dto) {
        Person person = new Person();
        person.setEmail(dto.getEmail());
        person.setDocumentType(dto.getDocumentType());
        person.setDocumentNumber(dto.getDocumentNumber());
        person.setActive(true);
        person.setAccountList(new ArrayList<>());
        return person;
    }
}
