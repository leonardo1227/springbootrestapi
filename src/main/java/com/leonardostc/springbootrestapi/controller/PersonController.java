package com.leonardostc.springbootrestapi.controller;

import com.leonardostc.springbootrestapi.domain.Gender;
import com.leonardostc.springbootrestapi.domain.Person;
import com.leonardostc.springbootrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;


    @RequestMapping(path = "/people")
    public List<Person> getAllPeople() {
        return service.findAll();
    }

    @GetMapping(path = "/people/{orderingproperty}")
    public List<Person> getAllPeople(@PathVariable(name = "orderingproperty") String orderingProperty) {
        return service.findAllOrderedBy(orderingProperty);
    }

    @PostMapping(path = "/person")
    public void addPerson(@RequestBody Person person){
        service.save(person);
    }

    @PutMapping(path = "/person")
    public void updatePerson(@RequestBody Person person){
        service.save(person);
    }

    @DeleteMapping(path = "/person/{id}")
    public void deletePerson(@PathVariable Long id){
        service.deleteById(id);
    }


    @GetMapping(path = "/person/{id}")
    public Person getPersonById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(path = "/peoplebyfirstname/{firstname}")
    public List<Person> getPeopleByFirstName(@PathVariable(name = "firstname") String firstName){
        return service.findByFirstName(firstName);
    }

    @GetMapping(path = "/peoplebylastname/{lastname}")
    public List<Person> getPeopleByLastName(@PathVariable(value = "lastname") String lastName){
        return service.findByLastName(lastName);
    }

    @GetMapping(path = "/peoplebygender/{gender}")
    public List<Person> getPeopleByGender(@PathVariable Gender gender){
        return service.findByGender(gender);
    }

    @GetMapping(path = "/peoplebydayofbirth/{dob}")
    public List<Person> getPeopleByDayOfBirth(@PathVariable(value = "dob") LocalDate dayOfBirth){
        return  service.findByDayOfBirth(dayOfBirth);
    }

    @GetMapping(path = "/peoplebyfirstnamecontaining/{firstname}")
    public List<Person> getPeopleByFirstNameContaining(@PathVariable(name = "firstname") String firstName){
        return service.findByFirstNameContaining(firstName);
    }

}
