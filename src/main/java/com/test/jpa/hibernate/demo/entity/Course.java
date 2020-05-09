package com.test.jpa.hibernate.demo.entity;

import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@javax.persistence.Entity
@javax.persistence.Table(name = "COURSE")
@org.hibernate.annotations.NamedQueries(
        value = {
                @NamedQuery(name = "first_SQL", query = "select c from Course c"),
                @NamedQuery(name = "second_SQL", query = " select c from Course c where name like '%Java'")
        }
)
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    protected Course(){

    }
    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
