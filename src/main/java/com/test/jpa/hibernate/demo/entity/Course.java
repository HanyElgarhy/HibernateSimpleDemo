package com.test.jpa.hibernate.demo.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "course")
    private List<Review> review=new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    private List<Student> students=new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public void addReview(Review review) {
        this.review.add(review);
    }

    public void removeReview(Review review) {
        this.review.remove(review);
    }

    public List<Review> getReview() {
        return review;
    }

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
