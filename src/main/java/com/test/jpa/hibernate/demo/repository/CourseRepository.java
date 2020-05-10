package com.test.jpa.hibernate.demo.repository;

import com.test.jpa.hibernate.demo.entity.Course;
import com.test.jpa.hibernate.demo.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(int id){
        Course course = findById(id);
        entityManager.remove(course);
    }
    public Course save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
        return course;
    }

    public void addReviewsToCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        for(Review review: reviews){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }

    }
    //Below what will be saved in Tintin 2 because Entity manager will keep track of the transaction @transactional
    public void tracking(){
        Course course =new Course("Tintin");
        entityManager.persist(course);
        course.setName("Tintin 2");
        entityManager.flush();
        course.setName("Tintin 3");
        entityManager.refresh(course);
        entityManager.flush();
        //entityManager.detach(course);
        //course.setName("TinTin 3");
    }

}
