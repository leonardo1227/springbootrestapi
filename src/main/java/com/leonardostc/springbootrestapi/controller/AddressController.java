package com.leonardostc.springbootrestapi.controller;

import com.leonardostc.springbootrestapi.domain.Address;
import com.leonardostc.springbootrestapi.domain.Person;
import com.leonardostc.springbootrestapi.service.AddressService;
import com.leonardostc.springbootrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService service;

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/addresses")
    public List<Address> getAllAddresses() {
        return service.findAll();
    }

    @GetMapping(path = "/addresses/{orderingproperty}")
    public List<Address> getAllAddresses(@PathVariable(name = "orderingproperty") String orderingProperty) {
        return service.findAllOrderedBy(orderingProperty);
    }


    @PostMapping(path = "/person/{personId}/address")
    public Address addNewAddress(@RequestBody Address address, @PathVariable(name = "personId") Long personId) {
        address.setPerson(personService.findById(personId));
        return service.save(address);
    }

    @PutMapping(path = "/person/{personId}/address")
    public Address updateAddress(@RequestBody Address address, @PathVariable(name = "personId") Long personId) {
        Person person = personService.findById(personId);
        address.setPerson(person);
        return service.save(address);
    }

    @DeleteMapping(path = "/address/{addressid}")
    public void deleteAddressById(@PathVariable(name = "addressid") Long addressId) {
        service.deleteById(addressId);
    }

    @GetMapping(path = "/addressesByPerson/{personid}")
    public List<Address> getAddressesByPerson(@PathVariable(name = "personid") Long personId){
        return service.findByPerson(personService.findById(personId));
    }

    @GetMapping(path = "/addressesByCity/{city}")
    public List<Address> getAddressesByCity(@PathVariable(name = "city") String city){
        return service.findByCity(city);
    }

    @GetMapping(path = "/addressesByState/{state}")
    public List<Address> getAddressesByState(@PathVariable(name = "state") String state){
        return service.findByState(state);
    }

    @GetMapping(path = "/addressesByZipcode/{zipcode}")
    public List<Address> getAddressesByZipCode(@PathVariable(name = "zipcode") String zipCode){
        return service.findByZipcode(zipCode);
    }
}
