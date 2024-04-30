package com.example.accountservice.integration.service;

import com.example.accountservice.dto.PersonCreateDto;
import com.example.accountservice.entity.DocumentType;
import com.example.accountservice.integration.TestFather;
import com.example.accountservice.repository.PersonRepository;
import com.example.accountservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class PersonServiceTest extends TestFather {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @Test
    void findById() {
        var person = Optional.of(personService.findById(10L));
        assertTrue(person.isPresent());
        assertEquals(person.orElseThrow().getEmail(), "test1@test.com");
    }

    @Test
    void delete() {
        var sizeBeforeDelete = personRepository.findAll().size();
        personService.delete(10L);
        var sizeAfterDelete = personRepository.findAll().size();
        assertEquals(sizeBeforeDelete, sizeAfterDelete);
        var deletePerson = personService.findById(1L);
        assertNull(deletePerson);
    }

    @Test
    void save() {
        var person = new PersonCreateDto(
                "test41@test.com",
                DocumentType.PASSPORT,
                "0000000",
                null);
        var sizeBeforeAdding = personRepository.findAll().size();
        personService.save(person);
        var sizeAfterAdding = personRepository.findAll().size();
        assertEquals(sizeBeforeAdding + 1, sizeAfterAdding);
    }
}
