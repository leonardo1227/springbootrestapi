package com.leonardostc.springbootrestapi.repository;

import com.leonardostc.springbootrestapi.domain.Gender;
import com.leonardostc.springbootrestapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByGender(Gender gender);
    public List<Person> findByDayOfBirth(LocalDate dayOfBirth);
    public List<Person> findByFirstName(String firstName);
    public List<Person>  findByLastName(String lastName);

    public List<Person> findByFirstNameContaining(String firstName);

}
