package com.test.jpa.hibernate.demo.entity;

import javax.persistence.*;

@javax.persistence.Entity
@javax.persistence.Table(name = "PASSPORT")

public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    public Student getStudent() {
        return student;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

    protected Passport(){

    }
    public Passport(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Passport(String number) {
        this.number = number;
    }
    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", name='" + number + '\'' +
                '}';
    }
}
