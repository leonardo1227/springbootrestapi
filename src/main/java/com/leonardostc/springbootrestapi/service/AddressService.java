package com.leonardostc.springbootrestapi.service;

import com.leonardostc.springbootrestapi.domain.Address;
import com.leonardostc.springbootrestapi.domain.Person;
import com.leonardostc.springbootrestapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IService<Address> {

    @Autowired
    private AddressRepository repository;

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Address> findAllOrderedBy(String property) {
        return repository.findAll(new Sort(Sort.Direction.ASC, property));
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);
    }

    public List<Address> findByPerson(Person person){
        return repository.findByPerson(person);
    }

    public List<Address> findByCity(String city){
        return repository.findByCity(city);
    }

    public List<Address> findByState(String state){
        return repository.findByState(state);
    }

    public List<Address> findByZipcode(String zipCode){
        return repository.findByZipCode(zipCode);
    }
}
