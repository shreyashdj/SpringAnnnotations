package com.example.springannotations.service;

import com.example.springannotations.dto.PersonDTO;
import com.example.springannotations.entity.PersonData;

public interface IPersonService {
    PersonData addPerson(PersonDTO personDTO);
}
