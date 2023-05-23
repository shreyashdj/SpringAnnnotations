package com.example.springannotations.controller;

import com.example.springannotations.dto.PersonDTO;
import com.example.springannotations.dto.ResponseDTO;
import com.example.springannotations.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    IPersonService personService;

    @PostMapping("add")
    public ResponseEntity<ResponseDTO> addPerson(@RequestBody PersonDTO personDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Person Added Successfully", personService.addPerson(personDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
