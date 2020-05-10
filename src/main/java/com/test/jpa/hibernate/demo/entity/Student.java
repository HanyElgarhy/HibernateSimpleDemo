package com.test.jpa.hibernate.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@javax.persistence.Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @ManyToMany
    @JoinTable(name="STUDENT_COURSE",joinColumns = @JoinColumn(name = "STUDENT_ID"),inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> courses=new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course courses) {
        this.courses.add(courses);
    }

    protected Student(){

    }
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
