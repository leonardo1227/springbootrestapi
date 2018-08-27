package com.leonardostc.springbootrestapi.repository;

import com.leonardostc.springbootrestapi.domain.Address;
import com.leonardostc.springbootrestapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByPerson(Person person);
    public List<Address> findByCity(String city);
    public List<Address> findByState(String state);
    public List<Address> findByZipCode(String zipCode);
}
