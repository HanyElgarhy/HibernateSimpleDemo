package com.test.jpa.hibernate.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {


    private String city;
    private String street;
    private String buildingNumber;

    protected Address(){}

    public Address(String city, String street, String buildingNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}
