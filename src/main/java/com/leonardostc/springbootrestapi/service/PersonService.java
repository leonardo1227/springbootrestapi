package com.leonardostc.springbootrestapi.service;

import com.leonardostc.springbootrestapi.domain.Gender;
import com.leonardostc.springbootrestapi.domain.Person;
import com.leonardostc.springbootrestapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IService<Person> {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Person> findAllOrderedBy(String property) {
        return repository.findAll(new Sort(Sort.Direction.ASC, property));
    }

    @Override
    public Person findById(Long id) {
        Optional<Person> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Person> findByGender(Gender gender){
        return repository.findByGender(gender);
    }

    public List<Person> findByDayOfBirth(LocalDate dayOfBirth){
        return repository.findByDayOfBirth(dayOfBirth);
    }

    public List<Person> findByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    public List<Person> findByLastName(String lastName){
        return repository.findByLastName(lastName);
    }

    public List<Person> findByFirstNameContaining(String firstName){
        return repository.findByFirstNameContaining(firstName);
    }
}
