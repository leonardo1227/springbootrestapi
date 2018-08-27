package com.leonardostc.springbootrestapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Person person;

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Boolean mainAddress;

    public Address() {
    }

    public Address(Person person, String line1, String line2, String city, String state, String country, String zipCode, Boolean mainAddress) {
        this.person = person;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.mainAddress = mainAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Boolean mainAddress) {
        this.mainAddress = mainAddress;
    }
}
