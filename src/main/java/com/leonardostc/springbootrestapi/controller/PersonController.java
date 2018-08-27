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

    @RequestMapping(path = "/people/{orderingProperty}")
    public List<Person> getAllPeople(@PathVariable String orderingProperty) {
        return service.findAllOrderedBy(orderingProperty);
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public void addPerson(@RequestBody Person person){
        service.save(person);
    }

    @RequestMapping(path = "/person", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person){
        service.save(person);
    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id){
        service.deleteById(id);
    }


    @RequestMapping(path = "/person/{id}")
    public Person getPersonById(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(path = "/peoplebyfirstname/{firstname}")
    public List<Person> getPeopleByFirstName(@PathVariable(name = "firstname") String firstName){
        return service.findByFirstName(firstName);
    }

    @RequestMapping(path = "/peoplebylastname/{lastname}")
    public List<Person> getPeopleByLastName(@PathVariable(value = "lastname") String lastName){
        return service.findByLastName(lastName);
    }

    @RequestMapping(path = "/peoplebygender/{gender}")
    public List<Person> getPeopleByGender(@PathVariable Gender gender){
        return service.findByGender(gender);
    }

    @RequestMapping(path = "/peoplebydayofbirth/{dob}")
    public List<Person> getPeopleByDayOfBirth(@PathVariable(value = "dob") LocalDate dayOfBirth){
        return  service.findByDayOfBirth(dayOfBirth);
    }

    @RequestMapping(path = "/peoplebyfirstnamecontaining/{firstname}")
    public List<Person> getPeopleByFirstNameContaining(@PathVariable(name = "firstname") String firstName){
        return service.findByFirstNameContaining(firstName);
    }

}
