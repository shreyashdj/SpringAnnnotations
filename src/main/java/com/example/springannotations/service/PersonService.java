package com.example.springannotations.service;

import com.example.springannotations.dto.PersonDTO;
import com.example.springannotations.entity.PersonData;
import com.example.springannotations.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService{
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonData addPerson(PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        return personRepository.save(personData);
    }
}
