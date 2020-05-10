package com.test.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@javax.persistence.Entity
@javax.persistence.Table(name = "REVIEW")

public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    private String rating;

    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    protected Review(){

    }
    public Review(Long id,String rating, String description) {
        this.id=id;
        this.rating = rating;
        this.description = description;
    }

    public Review(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", name='" + description + '\'' +
                '}';
    }
}
