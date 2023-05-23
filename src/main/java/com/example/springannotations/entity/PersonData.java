package com.example.springannotations.entity;

import com.example.springannotations.dto.PersonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_data")
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String name;
    private Integer accountNum;
    private Integer balance;

    public PersonData(PersonData personData) {
        this.name = personData.getName();
        this.accountNum = personData.getAccountNum();
        this.balance = personData.getBalance();
    }

    public PersonData(PersonDTO personDTO) {
        this.name = personDTO.getName();
        this.accountNum = personDTO.getAccountNum();
        this.balance = personDTO.getBalance();
    }
}
