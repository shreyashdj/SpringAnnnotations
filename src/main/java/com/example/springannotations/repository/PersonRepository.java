package com.example.springannotations.repository;

import com.example.springannotations.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonData, Integer> {
    @Query(value = "select * from person_data where account_num = :acc", nativeQuery = true)
    PersonData findByAcc(Integer acc);
}
